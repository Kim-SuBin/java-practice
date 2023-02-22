package practice.java8.section06;

public class ConcurrentPractice {
    public static void main(String[] args) throws InterruptedException {
        // 자바 멀티스레드 프로그래밍 방법 1 - Thread 상속
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        System.out.println("hello : " + Thread.currentThread().getName());

        // 자바 멀티스레드 프로그래밍 방법 2 - Runnable
        Thread threadRunnable = new Thread(() -> System.out.println("world runnable : " + Thread.currentThread().getName()));
        threadRunnable.start();
        System.out.println("hello runnable : " + Thread.currentThread().getName());

        // 스레드 주요 기능
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L); // 스레드 멈추기
                } catch (InterruptedException e) {
                    System.out.println("interrupted!");
                    return; // return 을 추가해야 멈춤
                }
            }
        });
        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
        Thread.sleep(3000L);
        thread.interrupt(); // 스레드 깨우기
        thread.join();
        System.out.println(thread + "is finished"); // 다른 스레드가 끝날 때까지 기다림
    }

    static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("world : " + Thread.currentThread().getName());
        }
    }
}
