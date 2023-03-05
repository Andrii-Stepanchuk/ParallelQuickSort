package sorts;

import java.util.concurrent.*;

public class ParallelQuickSort extends QuickSort {

    @Override
    protected void quickSort(int[] arr, int left, int right) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        QuickSortTask task = new QuickSortTask(arr, 0, arr.length - 1);
        pool.invoke(task);
        pool.shutdown();
    }

    private class QuickSortTask extends RecursiveAction {
        private final int[] arr;
        private final int left;
        private final int right;

        public QuickSortTask(int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (left >= right) {
                return;
            }
            int pivotIndex = partition(arr, left, right);
            QuickSortTask leftTask = new QuickSortTask(arr, left, pivotIndex - 1);
            QuickSortTask rightTask = new QuickSortTask(arr, pivotIndex + 1, right);
            invokeAll(leftTask, rightTask);
        }
    }
}