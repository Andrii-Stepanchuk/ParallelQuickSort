package utils;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomArrayGenerator {
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        return IntStream
                .range(0, size)
                .map(i -> random.nextInt())
                .toArray();
    }
}
