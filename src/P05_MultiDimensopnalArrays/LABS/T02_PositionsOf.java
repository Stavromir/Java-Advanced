package P05_MultiDimensopnalArrays.LABS;

import java.util.Arrays;
import java.util.Scanner;

public class T02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = matrixRead(scanner);

        int number = Integer.parseInt(scanner.nextLine());

        boolean isPresent = false;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    isPresent = true;
                    print(i, j);
                }
            }
        }
        if (!isPresent) {
            System.out.println("not found");
        }
    }

    public static void print(int row, int column) {
        System.out.println(row + " " + column);
    }

    public static int[][] matrixRead(Scanner scanner) {

        int[] matrixDim = arrRead(scanner);

        int matrixRows = matrixDim[0];
        int matrixColumns = matrixDim[1];

        int[][] matrix = new int[matrixRows][matrixColumns];
        for (int i = 0; i < matrixRows; i++) {
            matrix[i] = arrRead(scanner);
        }
        return matrix;
    }

    public static int[] arrRead(Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
