package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputCommand = scanner.nextLine().replace(")", "")
                .split("\\(");

        int rotationDeg = Integer.parseInt(inputCommand[1]);
        rotationDeg = rotationDeg % 360;
        List<String> rowsString = new ArrayList<>();
        String inputRow = scanner.nextLine();
        int maxLength = Integer.MIN_VALUE;

        while (!inputRow.equals("END")) {
            rowsString.add(inputRow);
            if (inputRow.length() > maxLength) {
                maxLength = inputRow.length();
            }
            inputRow = scanner.nextLine();
        }
        int row = rowsString.size();
        int column = maxLength;
        char[][] matrix = new char[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (c < rowsString.get(r).length()) {
                    char current = rowsString.get(r).charAt(c);
                    matrix[r][c] = current;
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }
        char[][] newMatrix = new char[column][row];
        switch (rotationDeg) {
            case 90:
                for (int c = 0; c < column; c++) {
                    int count = 0;
                    for (int r = row - 1; r >= 0 ; r--) {
                        char currentElement = matrix[r][c];
                        newMatrix[c][count] = currentElement;
                        count++;
                    }
                }
                print(newMatrix);
                break;
            case 180:
                newMatrix = new char[row][column];
                int rowCount = 0;
                for (int r = row - 1; r >= 0; r--) {
                    int columnCount = column - 1;
                    for (int c = 0; c < column; c++) {
                        newMatrix[rowCount][columnCount] = matrix[r][c];
                        columnCount--;
                    }
                    rowCount++;
                }
                print(newMatrix);
                break;
            case 270:
                rowCount = 0;
                for (int c = column - 1; c >= 0 ; c--) {
                    for (int r = 0; r < row; r++) {
                        newMatrix[rowCount][r] = matrix[r][c];
                    }
                    rowCount++;
                }
                print(newMatrix);
                break;
            case 0:
                print(matrix);
                break;
        }
    }

    public static void print (char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
