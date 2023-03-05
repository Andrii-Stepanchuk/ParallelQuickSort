package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

public class ArrayFileReader {

    public static int[] readArrayFromFile(String fileName) {
        fileName = fileName + ".txt";
        int[] array;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String[] values = reader.readLine().split(", ");
            int length = values.length;
            array = new int[length];
            IntStream
                    .range(0, length)
                    .forEach(i -> array[i] = Integer.parseInt(values[i]));
            System.out.println("\n Результат було зчитано з файлу " + fileName + "\n");
        } catch (IOException e) {
            System.out.println("\n Сталася помилка під час читання файлу " + fileName + "\n");
            return new int[0];
        }
        return array;
    }
}
