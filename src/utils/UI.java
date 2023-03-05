package utils;

import sorts.MeasureTimeQuickSort;
import sorts.ParallelQuickSort;
import sorts.QuickSort;

import java.util.Scanner;

public class UI {
    public static void printMenu() {
        enterTheData("\n" +
                " ������ ���� �� �� (1-4)\n" +
                " (1) - ���������� ����� ����� ���������� ����� �������� ������\n" +
                " (2) - �����������\n" +
                " (3) - ���������� ������������ ����� � ���� �� ������� ������\n" +
                " (4) - ���������� ������� ����� �� �������� �����\n" +
                " (5) - ������� ����� �� �����");
    }

    public static void rangeError(int start, int end) {
        System.out.printf("\n ���������� ���. ������ ����� � �������� %d - %d \n", start, end);
    }

    private static void enterTheData(String text) {
        System.out.println(text);
        System.out.print(" ��� ���� -> ");
    }

    public static int readNumberFromConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\n ���������� ���\n");
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
                System.out.println("\n ���������� ���\n");
            }
        }
    }

    public static int[] generateNewArrayData() {
        enterTheData("\n ������ ������� ������� ��� ����������� ������");
        int number = readNumberFromConsole();
        return RandomArrayGenerator.generateRandomArray(number);
    }

    public static void selectSortMethod(int[] arr) {
        enterTheData("\n" +
                " ������ ����� ����������\n" +
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
        enterTheData("\n ������ ����� ����� ��� ����������");
        ArrayFileWriter.writeArrayToFile(arr, readStringFromConsole());
    }

    public static int[] getArrayFromFile() {
        enterTheData("\n ������ ����� ����� ��� ������� �����");
        return ArrayFileReader.readArrayFromFile(readStringFromConsole());
    }
}
