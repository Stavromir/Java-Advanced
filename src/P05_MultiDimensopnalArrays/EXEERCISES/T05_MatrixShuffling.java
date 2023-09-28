package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.Scanner;

public class T05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = readMatrix(scanner);

        String[] inputCommandArray = scanner.nextLine().split("\\s+");

        while (!inputCommandArray[0].equals("END")) {

            if (inputCommandArray[0].equals("swap") && inputCommandArray.length == 5) {

                int rowOneIndex = Integer.parseInt(inputCommandArray[1]);
                int colOneIndex = Integer.parseInt(inputCommandArray[2]);
                int rowTwoIndex = Integer.parseInt(inputCommandArray[3]);
                int colTwoIndex = Integer.parseInt(inputCommandArray[4]);

                if (rowOneIndex >= matrix.length || rowTwoIndex >= matrix.length
                || colOneIndex >= matrix[0].length || colTwoIndex >= matrix[0].length) {
                    printInvalidCommand();
                    inputCommandArray = scanner.nextLine().split("\\s+");
                    continue;
                }

                String firstElement = matrix[rowOneIndex][colOneIndex];
                String secondElement = matrix[rowTwoIndex][colTwoIndex];

                matrix[rowOneIndex][colOneIndex] = secondElement;
                matrix[rowTwoIndex][colTwoIndex] = firstElement;

                print(matrix);
            } else {
                printInvalidCommand();
        }
            inputCommandArray = scanner.nextLine().split("\\s+");
        }
    }

    public static String[][] readMatrix(Scanner scanner) {
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int columns = Integer.parseInt(input.split("\\s+")[1]);
        String[][] matrix = new String[rows][columns];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    public static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
    public  static void printInvalidCommand () {
        System.out.println("Invalid input!");
    }
}
