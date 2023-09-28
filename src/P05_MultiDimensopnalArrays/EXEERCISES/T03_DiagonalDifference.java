package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.Arrays;
import java.util.Scanner;

public class T03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int firstDiagonalSum = firstDiagonal(matrix);
        int secondDiagonalSum = secondDiagonal(matrix);

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));

    }

    public static int[][] readMatrix(Scanner scanner) {
        int matrixDim = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixDim][matrixDim];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    public static int firstDiagonal(int[][] matrix) {
        int firstDiagonalSum = 0;
        for (int rc = 0; rc < matrix.length; rc++) {
            firstDiagonalSum += matrix[rc][rc];
        }
        return firstDiagonalSum;
    }

    public static int secondDiagonal (int[][] matrix) {
        int secondDiagonalSum = 0;
        for (int rc = 0; rc < matrix.length; rc++) {
            secondDiagonalSum += matrix[(matrix.length - 1) - rc][rc];
        }
        return secondDiagonalSum;
    }
}
