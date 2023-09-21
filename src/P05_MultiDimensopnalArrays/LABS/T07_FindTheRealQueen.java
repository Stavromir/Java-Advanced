package P05_MultiDimensopnalArrays.LABS;

import java.util.Scanner;

public class T07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int r = 0; r < 8; r++) {
            matrix[r] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char currentChar = matrix[r][c];

                if (currentChar == 'q') {
                    if (validPosition(matrix, r, c)) {
                        System.out.println(r + " " + c);
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

        return r - 1 >= 0 && r + 1 < matrix.length;
    }

    public static boolean columnIndexIsLegit(char[][] matrix, int c) {
        return c + 1 < matrix[0].length && c - 1 >= 0;
    }

}
