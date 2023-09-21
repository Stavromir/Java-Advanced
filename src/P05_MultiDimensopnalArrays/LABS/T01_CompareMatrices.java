package P05_MultiDimensopnalArrays.LABS;

import java.util.Arrays;
import java.util.Scanner;

public class T01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEquals = true;

        if (firstMatrix.length == secondMatrix.length) {
            for (int i = 0; i < firstMatrix.length; i++) {
                int [] firstMatrixRow = firstMatrix[i];
                int [] secondMatrixRow = secondMatrix[i];

                if (firstMatrixRow.length != secondMatrixRow.length) {
                    areEquals = false;
                } else {
                    for (int j = 0; j < firstMatrix[i].length; j++) {
                        if (firstMatrix[i][j] != secondMatrix[i][j]) {
                            areEquals = false;
                            break;
                        }
                    }
                }
            }
        } else {
            areEquals = false;
        }

        print(areEquals);
    }

    private static void print(boolean areEquals) {
        String print = areEquals ? "equal" : "not equal";
        System.out.println(print);
    }

    public static int[] readArr(Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    public static int[][] readMatrix(Scanner scanner) {
        //Reading the matrix dimensions from the console

        int[] dim = readArr(scanner);

        int rows = dim[0];
        int columns = dim[1];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            int[] readRow = readArr(scanner);
            matrix[i] = readRow;
        }
        return matrix;
    }
}
