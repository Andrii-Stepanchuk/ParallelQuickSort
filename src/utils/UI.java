package utils;

import sorts.MeasureTimeQuickSort;
import sorts.ParallelQuickSort;
import sorts.QuickSort;

import java.util.Scanner;

public class UI {
    public static void printMenu() {
        enterTheData("\n" +
                " Оберіть одну із дій (1-4)\n" +
                " (1) - Сформувати новий масив випадкових даних заданого розміру\n" +
                " (2) - Посортувати\n" +
                " (3) - Збереження посортованих даних у файлі із заданою назвою\n" +
                " (4) - Зчитування вхідних даних із заданого файлу\n" +
                " (5) - Вивести масив на екран");
    }

    public static void rangeError(int start, int end) {
        System.out.printf("\n Неправильні дані. Введіть число і діапазону %d - %d \n", start, end);
    }

    private static void enterTheData(String text) {
        System.out.println(text);
        System.out.print(" Ваш вибір -> ");
    }

    public static int readNumberFromConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\n Неправильні дані\n");
            }
        }
    }

    public static String readStringFromConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                return String.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("\n Неправильні дані\n");
            }
        }
    }

    public static int[] generateNewArrayData() {
        enterTheData("\n Оберіть кількість значень для генерування масиву");
        int number = readNumberFromConsole();
        return RandomArrayGenerator.generateRandomArray(number);
    }

    public static void selectSortMethod(int[] arr) {
        enterTheData("\n" +
                " Оберіть метод сортування\n" +
                " (1) - QuickSort\n" +
                " (2) - ParallelQuickSort ");

        MeasureTimeQuickSort quickSortStarter;

        switch (readNumberFromConsole()) {
            case 1:
                quickSortStarter = new MeasureTimeQuickSort(new QuickSort());
                break;
            case 2:
                quickSortStarter = new MeasureTimeQuickSort(new ParallelQuickSort());
                break;
            default:
                UI.rangeError(1, 2);
                return;
        }

        quickSortStarter.sort(arr);
    }

    public static void saveResultToFile(int[] arr) {
        enterTheData("\n Оберіть назву файлу для збереження");
        ArrayFileWriter.writeArrayToFile(arr, readStringFromConsole());
    }

    public static int[] getArrayFromFile() {
        enterTheData("\n Оберіть назву файлу для читання даних");
        return ArrayFileReader.readArrayFromFile(readStringFromConsole());
    }
}
