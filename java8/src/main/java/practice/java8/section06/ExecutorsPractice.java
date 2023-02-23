package practice.java8.section06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsPractice {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Executor 실행 1 - 가장 고전적인 방법
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName());
            }
        });

        // Executor 실행 2
        executorService.submit(() -> System.out.println("Thread " + Thread.currentThread().getName()));

        // 처리 중인 작업을 기다렸다가 종료 => Graceful Shutdown
        executorService.shutdown();

        // 당장 종료
        executorService.shutdownNow();

        // ShceduledExecutorService
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS); // 2초마다 출력
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
