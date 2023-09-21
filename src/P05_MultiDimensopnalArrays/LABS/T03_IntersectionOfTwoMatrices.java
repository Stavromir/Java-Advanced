package P05_MultiDimensopnalArrays.LABS;

import java.util.Scanner;

public class T03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = Integer.parseInt(scanner.nextLine());
        int matrixColumns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, matrixRows, matrixColumns);
        char[][] secondMatrix = readMatrix(scanner, matrixRows, matrixColumns);

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    System.out.print(firstMatrix[i][j] + " ");
                } else {
                    System.out.print('*' + " ");
                }
            }
            System.out.println();
        }
    }

    public static char[] readArr(Scanner scanner) {
        return scanner.nextLine().replace(" ", "")
                .toCharArray();

    }

    public static char[][] readMatrix (Scanner scanner, int rows, int columns) {

        char[][] matrix  = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArr(scanner);
        }
        return matrix;
    }
}
