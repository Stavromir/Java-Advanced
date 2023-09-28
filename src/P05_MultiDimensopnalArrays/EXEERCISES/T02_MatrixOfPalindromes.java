package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.Scanner;

public class T02_MatrixOfPalindromes {
    public static void main(String[] args) {

        // Задачата може да се реши и със StringBuilder!!!
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int columns = Integer.parseInt(input.split("\\s++")[1]);
//        int a = 97;
        char firstLetter = 'a';

        String[][] matrix = new String[rows][columns];

        for (int r = 0; r < matrix.length; r++) {
            char secondLetter = (char) (firstLetter + 1);
            System.out.print(firstLetter + "" + firstLetter + firstLetter + " ");
            for (int c = 1; c < matrix[0].length; c++) {
                System.out.print(firstLetter + "" + (secondLetter) + firstLetter + " ");
                secondLetter += 1;
            }
            System.out.println();
            firstLetter += 1;
        }
    }
}
