package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.Scanner;

public class T01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int matrixDim = Integer.parseInt(input.split(", ")[0]);
        String matrixType = input.split(", ")[1];
        int[][] matrix = new int[matrixDim][matrixDim];

        if (matrixType.equals("A")) {
            printPatternA(matrix);
        } else {
            printPatternB(matrix);
        }
    }

    public static void printPatternA (int[][] matrix) {

        int count = 1;
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = count;
                count++;
            }
        }
        print(matrix);
    }

    public static void printPatternB (int[][] matrix) {

        int count = 1;
        int column = 0;

        while (matrix[matrix.length - 1][matrix.length - 1] == 0) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][column] = count;
                count++;
            }
            if (matrix[matrix.length - 1][matrix.length - 1] != 0) {
                break;
            }
            column++;
            for (int r = matrix.length - 1; r >= 0 ; r--) {
                matrix[r][column] = count;
                count++;
            }
            column++;
        }
        print(matrix);
    }
    private static void print(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
