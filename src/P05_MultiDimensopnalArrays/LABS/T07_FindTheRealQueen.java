package P05_MultiDimensopnalArrays.LABS;

import java.util.Scanner;

public class T07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int r = 0; r < 8; r++) {
            matrix[r] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        int rowIndex = 0;
        int columnIndex = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {

                if (matrix[r][c] == 'q') {
                    rowIndex = r;
                    columnIndex = c;
                    if (validPosition(matrix, rowIndex, columnIndex)) {
                        System.out.println(rowIndex + " " + columnIndex);
                    }
                }
            }
        }


    }

    public static boolean validPosition(char[][] matrix, int rowIndex, int columnIndex) {

        int newRowIndex = rowIndex;
        int newColumnIndex = columnIndex;

        while (rowIndexIsLegit(matrix, newRowIndex - 1)) {

            if (matrix[newRowIndex - 1][columnIndex] == 'q') {
                return false;
            } else {
                newRowIndex--;
            }
        }
        newRowIndex = rowIndex;
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
        while (columnIndexIsLegit(matrix, newColumnIndex + 1)) {
            if (matrix[rowIndex][newColumnIndex + 1] == 'q') {
                return false;
            } else {
                newColumnIndex++;
            }
        }
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
        while (rowIndexIsLegit(matrix, newRowIndex + 1)) {
            if (matrix[newRowIndex + 1][columnIndex] == 'q') {
                return false;
            } else {
                newRowIndex++;
            }
        }
        newRowIndex = rowIndex;
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
        while (columnIndexIsLegit(matrix, newColumnIndex - 1)) {
            if (matrix[rowIndex][newColumnIndex - 1] == 'q') {
                return false;
            } else {
                newColumnIndex--;
            }
        }
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
