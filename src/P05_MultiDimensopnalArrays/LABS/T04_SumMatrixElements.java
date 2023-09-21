package P05_MultiDimensopnalArrays.LABS;

import java.util.Arrays;
import java.util.Scanner;

public class T04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDim = readArray(scanner);
        int row = matrixDim[0];
        int column = matrixDim[1];

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            matrix[i] = readArray(scanner);
        }

        int sumOfMatrixContent = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumOfMatrixContent += matrix[i][j];
            }
        }

        System.out.println(row);
        System.out.println(column);
        System.out.println(sumOfMatrixContent);


    }

    public static int[] readArray (Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
