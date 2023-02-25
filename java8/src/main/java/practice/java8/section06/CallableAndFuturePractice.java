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
        future.cancel(false);
        future.get(); // get은 결과값이 오기를 기다림
        System.out.println(future.isDone()); // 작업 상태 확인 (완료 true, 실패 false)
        System.out.println("End"); // get에서 결과를 보낸 후 출력됨

        executorService.shutdown();
    }
}
