package practice.java8.section06;

import java.util.concurrent.*;

public class CallableAndFuturePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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

        executorService.shutdown();
    }
}
