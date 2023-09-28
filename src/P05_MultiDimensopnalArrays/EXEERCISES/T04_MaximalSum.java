package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.Arrays;
import java.util.Scanner;

public class T04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int maxSubMatrixSum = 0;
        int newMatrixRowIndex = 0;
        int newMatrixColumnIndex = 0;

        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[0].length - 2; c++) {

                int currentSubMatrixSum = subMatrixSum(matrix,r,c);

                if (currentSubMatrixSum > maxSubMatrixSum) {
                    maxSubMatrixSum = currentSubMatrixSum;
                    newMatrixRowIndex = r;
                    newMatrixColumnIndex = c;
                }
            }
        }
        System.out.println("Sum = " + maxSubMatrixSum);
        print(matrix, newMatrixRowIndex, newMatrixColumnIndex);
    }

    public static int[][] readMatrix (Scanner scanner) {
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int columns = Integer.parseInt(input.split("\\s+")[1]);

        int[][] matrix = new int[rows][columns];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    public static int subMatrixSum (int[][] matrix, int row, int column) {

        int subMatrixSum = 0;

        for (int r = row; r < row + 3 ; r++) {
            for (int c = column; c < column + 3 ; c++) {
                subMatrixSum += matrix[r][c];
            }
        }
        return subMatrixSum;
    }

    public static void print (int[][] matrix, int row, int column) {
        for (int r = row; r < row + 3; r++) {
            for (int c = column; c < column + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
