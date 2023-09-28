package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimension[0];
        int cols = dimension[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillTheMatrix(matrix, rows, cols);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            int[] bombArg = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int targetRow = bombArg[0];
            int targetCol = bombArg[1];
            int radius = bombArg[2];

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isInside(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isInside(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }

            for (int row = 0; row < matrix.size(); row++) {
                List<Integer> currentRow = matrix.get(row);
                currentRow.removeAll(List.of(0));

                if (currentRow.isEmpty()) {
                    matrix.remove(row);
                    row--;
                }
            }
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInside(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void fillTheMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int count = 1;
        for (int rol = 0; rol < rows; rol++) {
            List<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(count);
                count++;
            }
            matrix.add(numbers);
        }
    }
}
