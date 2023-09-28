package P05_MultiDimensopnalArrays.LABS;

import java.util.Arrays;
import java.util.Scanner;

public class T07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int r = 0; r < 8; r++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int c = 0; c < arr.length; c++) {
                char current = arr[c].charAt(0);
                matrix[r][c] = current;
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char currentChar = matrix[r][c];

                if (currentChar == 'q') {
                    if (validPosition(matrix, r, c)) {
                        System.out.print(r + " " + c);
                    }
                }
            }
        }
    }

    public static boolean validPosition(char[][] matrix, int rowIndex, int columnIndex) {

        int newRowIndex = rowIndex;
        int newColumnIndex = columnIndex;

        int count = 0;
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][columnIndex] == 'q') {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        count = 0;

        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[rowIndex][c] == 'q') {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }

        while (rowIndexIsLegit(matrix, newRowIndex - 1) && columnIndexIsLegit(matrix, newColumnIndex + 1)) {
            if (matrix[newRowIndex - 1][newColumnIndex + 1] == 'q') {
                return false;
            } else {
                newRowIndex--;
                newColumnIndex++;
            }
        }
        newRowIndex = rowIndex;
        newColumnIndex = columnIndex;

        while (rowIndexIsLegit(matrix, newRowIndex + 1) && columnIndexIsLegit(matrix, newColumnIndex + 1)) {
            if (matrix[newRowIndex + 1][newColumnIndex + 1] == 'q') {
                return false;
            } else {
                newRowIndex++;
                newColumnIndex++;
            }
        }
        newRowIndex = rowIndex;
        newColumnIndex = columnIndex;

        while (rowIndexIsLegit(matrix, newRowIndex + 1) && columnIndexIsLegit(matrix, newColumnIndex - 1)) {
            if (matrix[newRowIndex + 1][newColumnIndex - 1] == 'q') {
                return false;
            } else {
                newRowIndex++;
                newColumnIndex--;
            }
        }
        newRowIndex = rowIndex;
        newColumnIndex = columnIndex;

        while (rowIndexIsLegit(matrix, newRowIndex - 1) && columnIndexIsLegit(matrix, newColumnIndex - 1)) {
            if (matrix[newRowIndex - 1][newColumnIndex - 1] == 'q') {
                return false;
            } else {
                newRowIndex--;
                newColumnIndex--;
            }
        }
        return true;
    }

    public static boolean rowIndexIsLegit(char[][] matrix, int r) {

        return r >= 0 && r < matrix.length;
    }

    public static boolean columnIndexIsLegit(char[][] matrix, int c) {
        return c < matrix[0].length && c >= 0;
    }

}
