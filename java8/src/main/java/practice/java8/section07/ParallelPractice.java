package practice.java8.section07;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelPractice {
    public static void main(String[] args) {
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        // 랜덤한 값으로 채움
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        // 자바에서 사용하는 sort : Dual-Pivot QuickSort -> O(n logN)
        Arrays.sort(numbers);
        System.out.println("serial sorting took " + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        // Merge Sort -> O(n logN)
        Arrays.parallelSort(numbers);
        System.out.println("parallel sorting took " + (System.nanoTime() - start));
    }
}
