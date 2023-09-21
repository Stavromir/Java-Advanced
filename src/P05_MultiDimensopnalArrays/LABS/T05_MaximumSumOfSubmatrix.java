package P05_MultiDimensopnalArrays.LABS;

import java.util.Arrays;
import java.util.Scanner;

public class T05_MaximumSumOfSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDim = readArray(scanner);
        int matrixRows = matrixDim[0];
        int matrixColumns = matrixDim[1];

        int[][] matrix = new int[matrixRows][matrixColumns];

        for (int i = 0; i < matrixRows; i++) {
            matrix[i] = readArray(scanner);
        }

        int maxSubMatrixSum = 0;
        int rowIndex = 0;
        int columnIndex = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int firstNumber = matrix[i][j];
                int secondNumber = matrix[i][j + 1];
                int thirdNumber = matrix[i + 1][j];
                int fourthNumber = matrix[i + 1][j + 1];
                int currentSubMatrixSum = firstNumber + secondNumber + thirdNumber + fourthNumber;
                if (currentSubMatrixSum > maxSubMatrixSum) {
                    maxSubMatrixSum = currentSubMatrixSum;
                    rowIndex = i;
                    columnIndex = j;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[rowIndex + i][columnIndex + j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSubMatrixSum);


    }

    public static int[] readArray(Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
