package practice.java8.section06;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuturePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> futureHello = new CompletableFuture<>();
        futureHello.complete("hello"); // 기본 값 선언
        System.out.println(futureHello.get()); // 값 반환

        CompletableFuture<String> futureHi = CompletableFuture.completedFuture("hi"); // 선언하면서 만들 수 있음
        System.out.println(futureHi.get());

        // 리턴 값이 없는 경우
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("not return");
        });
        runAsync.get();

        // 리턴 값이 있는 경우
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("return");
            return "Return";
        });
        System.out.println(supplyAsync.get());

        // 리턴 값이 있는 콜백
        CompletableFuture<String> thenApply = CompletableFuture.supplyAsync(() -> {
            return "callback";
        }).thenApply((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        });
        System.out.println(thenApply.get());

        // 리턴 값이 없는 콜백
        CompletableFuture<Void> thenAccept = CompletableFuture.supplyAsync(() -> {
            return "callback accept";
        }).thenAccept(System.out::println);
        thenAccept.get();

        // 리턴 값을 받지 않고 다른 작업을 처리하는 콜백
        CompletableFuture<Void> thenRun = CompletableFuture.supplyAsync(() -> {
            return "callback accept";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thenRun.get();

        // ==========

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        // 두 작업이 순서대로 이어서 실행하도록 조합
        CompletableFuture<String> thenCompose = hello.thenCompose(CompletableFuturePractice::getWorld);
        System.out.println(thenCompose.get()); // Hello World

        // ==========

        CompletableFuture<String> java = CompletableFuture.supplyAsync(() -> {
            System.out.println("Java " + Thread.currentThread().getName());
            return "Java";
        });

        CompletableFuture<String> spring = CompletableFuture.supplyAsync(() -> {
            System.out.println("Spring " + Thread.currentThread().getName());
            return "Spring";
        });

        // 두 작업이 독립적으로 실행하고 둘 다 종료했을 때 콜백 실행
        CompletableFuture<String> thenCombine = java.thenCombine(spring, (j, s) -> j + " " + s);
        System.out.println(thenCombine.get()); // Java Spring

        // ==========

        CompletableFuture<String> javascript = CompletableFuture.supplyAsync(() -> {
            System.out.println("javascript " + Thread.currentThread().getName());
            return "javascript";
        });

        CompletableFuture<String> react = CompletableFuture.supplyAsync(() -> {
            System.out.println("react " + Thread.currentThread().getName());
            return "react";
        });

        //  allOf : 모든 작업 결과에 콜백 실행
        List<CompletableFuture> futures = Arrays.asList(javascript, react);
        CompletableFuture[] completableFutures = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<Object>> listCompletableFuture = CompletableFuture.allOf(completableFutures)
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });
        System.out.println(listCompletableFuture.get());

        // ==========

        CompletableFuture<String> python = CompletableFuture.supplyAsync(() -> {
            System.out.println("python " + Thread.currentThread().getName());
            return "python";
        });

        CompletableFuture<String> django = CompletableFuture.supplyAsync(() -> {
            System.out.println("django " + Thread.currentThread().getName());
            return "django";
        });

        // anyOf : 가장 빨리 끝난 하나의 결과에 콜백 실행
        CompletableFuture<Void> future = CompletableFuture.anyOf(python, django).thenAccept(System.out::println);
        future.get();

        // ==========

        boolean throwError = true;

        // 예외처리
        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Error Practice " + Thread.currentThread().getName());
            return "error practice";
        }).exceptionally(ex -> { // 예외 발생 시 수행
            System.out.println(ex);
            return "error!";
        });
        exceptionally.get();

        CompletableFuture<String> handle = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Error Practice " + Thread.currentThread().getName());
            return "error practice";
        }).handle((result, ex) -> { // result : 정상 종료, ex : exception
            if (ex != null) {
                System.out.println("error!");
                return "error!";
            }
            return result;
        });
        handle.get();
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + "World";
        });
    }
}
