package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.Arrays;
import java.util.Scanner;

public class T11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        int[][] matrix = new int[rows][cols];


        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner);
        }

        int lastRow = matrix.length - 1;
        for (int c = matrix[0].length - 1; c >= 0 ; c--) {
            System.out.print(matrix[lastRow][c] + " ");
            int rowCount = 1;
            int colCount = 1;
            while (isInside(matrix,lastRow - rowCount,c + colCount )) {
                System.out.print(matrix[lastRow - rowCount][c + colCount] + " ");
                rowCount++;
                colCount++;
            }
            System.out.println();
        }

        if (matrix.length > 1) {
            int firstCol = 0;
            for (int r = matrix.length - 2; r >= 0 ; r--) {
                System.out.print(matrix[r][firstCol] + " ");
                int rolCount = 1;
                int colCount = 1;
                while (isInside(matrix, r - rolCount, firstCol + colCount)) {
                    System.out.print(matrix[r - rolCount][firstCol + colCount] + " ");
                    rolCount++;
                    colCount++;
                }
                if (r > 0) {
                    System.out.println();
                }
            }
        }

    }

    public static int[] readArray (Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static boolean isInside (int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
