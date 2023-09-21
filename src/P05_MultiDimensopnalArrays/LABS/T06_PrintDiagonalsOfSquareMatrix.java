package P05_MultiDimensopnalArrays.LABS;

import java.util.Arrays;
import java.util.Scanner;

public class T06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            matrix[i] = readArray(scanner);
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[(matrix.length - 1) - i][i] + " ");
        }


    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
