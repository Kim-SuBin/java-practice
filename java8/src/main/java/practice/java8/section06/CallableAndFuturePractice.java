package practice.java8.section06;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuturePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Runnable과 유사, Runnable과 다르게 작업의 결과를 받을 수 있음
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> future = executorService.submit(hello);
        System.out.println("Started!");
        future.cancel(false); // true - 현재 진행 중인 작업 interrupt, false - 현재 진행 중인 작업 기다림
//        future.get(); // get은 결과값이 오기를 기다림. 앞에 cancel이 있으면 exception 반환
        System.out.println(future.isDone()); // 위에 cancel()이 수행되어도 종료된 것이기에 true 반환
        System.out.println("End"); // get에서 결과를 보낸 후 출력됨

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> spring = () -> {
            Thread.sleep(1000L);
            return "Spring";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(java, spring));// 여러 작업 동시 실행
        for (Future<String> f : futures) { // 모든 작업이 끝난 후 순서대로 출력한다.
            System.out.println(f.get());
        }

        String s = executorService.invokeAny(Arrays.asList(java, spring));// 여러 작업 동시 실행 -> 가장 먼저 끝나는 작업 반환
        System.out.println(s); // Spring 출력

        executorService.shutdown();
    }
}
