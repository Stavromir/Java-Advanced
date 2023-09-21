package P05_MultiDimensopnalArrays.LABS;

import java.util.Arrays;
import java.util.Scanner;

public class T08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner);
        }

        int[][] newMatrix = new int[rows][matrix[0].length];

        int[] position = readArray(scanner);

        int rowIndex = position[0];
        int columnIndex = position[1];
        int wrongValue = matrix[rowIndex][columnIndex];
        int newValue = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {

                if (matrix[r][c] == wrongValue) {
                    if (r - 1 >= 0 && matrix[r - 1][c] != wrongValue) {
                        newValue += matrix[r - 1][c];
                    }
                    if (c + 1 < matrix[r].length && matrix[r][c + 1] != wrongValue) {
                        newValue += matrix[r][c + 1];
                    }
                    if (r + 1 < matrix.length && matrix[r + 1][c] != wrongValue) {
                        newValue += matrix[r + 1][c];
                    }
                    if (c - 1 >= 0 && matrix[r][c - 1] != wrongValue){
                        newValue += matrix[r][c - 1];
                    }
                    newMatrix[r][c] = newValue;
                    newValue = 0;
                } else {
                    newMatrix[r][c] = matrix[r][c];
                }
            }
        }

        for (int[] row : newMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray (Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
