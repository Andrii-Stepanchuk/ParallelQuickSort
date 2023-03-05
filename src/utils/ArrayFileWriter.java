package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class ArrayFileWriter {
    public static void writeArrayToFile(int[] arr, String fileName) {
        fileName = fileName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(Arrays.toString(arr).replace("[","").replace("]",""));
            System.out.println("\n Результат було збережено y файл " + fileName + "\n");
        } catch (IOException e) {
            System.out.println("\n Сталася помилка під час збереження файлу " + fileName + "\n");
            throw new RuntimeException(e);
        }
    }
}
