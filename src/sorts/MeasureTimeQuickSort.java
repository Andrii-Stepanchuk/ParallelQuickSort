package sorts;

import sorts.QuickSort;

public class MeasureTimeQuickSort {

    private final QuickSort quickSort;

    public MeasureTimeQuickSort(QuickSort quickSort) {
        this.quickSort = quickSort;
    }

    public void sort(int[] arr) {
        long startTime = System.nanoTime();
        quickSort.sort(arr);
        long endTime = System.nanoTime();
        double duration = (double) (endTime - startTime) / 1000000;
        System.out.println("\n Час виконання: " + duration + " мс \n");
    }

}
