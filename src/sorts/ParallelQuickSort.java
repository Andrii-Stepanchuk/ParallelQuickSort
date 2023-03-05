package sorts;

import java.util.concurrent.*;

public class ParallelQuickSort extends QuickSort {
    @Override
    protected void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            try {
                ExecutorService executor = Executors.newCachedThreadPool();
                executor.submit(() -> quickSort(arr, left, pivotIndex - 1)).get();
                executor.submit(() -> quickSort(arr, pivotIndex + 1, right)).get();
                executor.shutdown();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}