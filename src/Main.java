import utils.UI;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {};

        while (true) {
            UI.printMenu();
            switch (UI.readNumberFromConsole()) {
                case 1:
                    arr = UI.generateNewArrayData();
                    break;
                case 2:
                    UI.selectSortMethod(arr);
                    break;
                case 3:
                    UI.saveResultToFile(arr);
                    break;
                case 4:
                    arr = UI.getArrayFromFile();
                    break;
                case 5:
                    System.out.println("\n Масив - > " + Arrays.toString(arr));
                    break;
                default:
                    UI.rangeError(1,5);
                    break;
            }
        }
    }
}