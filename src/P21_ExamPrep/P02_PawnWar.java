package P21_ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class P02_PawnWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessBoard = readMatrix(scanner);

        int whitePawRowPos = rowPosition(chessBoard, "w");
        int whitePawColPos = colPosition(chessBoard, "w");
        int blackPawRolPos = rowPosition(chessBoard, "b");
        int blackPawColPos = colPosition(chessBoard, "b");

        if (Math.abs(whitePawColPos - blackPawColPos) > 1) {
            firstPromotedToQueen(whitePawColPos, blackPawColPos, whitePawRowPos, blackPawRolPos);
        } else {
            while (whitePawRowPos > 0 && blackPawRolPos < 8) {
                if (inRange(chessBoard, whitePawColPos - 1)) {
                    if (chessBoard[whitePawRowPos - 1][whitePawColPos - 1].equals("b")) {
                        blackPawRolPos = chessDeskRow(blackPawRolPos);
                        print(blackPawRolPos, blackPawColPos, "White");
                        break;
                    }
                }
                if (inRange(chessBoard, whitePawColPos + 1)) {
                    if (chessBoard[whitePawRowPos - 1][whitePawColPos + 1].equals("b")) {
                        blackPawRolPos = chessDeskRow(blackPawRolPos);
                        print(blackPawRolPos, blackPawColPos, "White");
                        break;
                    }
                }

                chessBoard[whitePawRowPos][whitePawColPos] = "-";
                chessBoard[whitePawRowPos - 1][whitePawColPos] = "w";
                whitePawRowPos--;


                if (inRange(chessBoard, blackPawColPos - 1)) {
                    if (chessBoard[blackPawRolPos + 1][blackPawColPos - 1].equals("w")) {
                        whitePawRowPos = chessDeskRow(whitePawRowPos);
                        print(whitePawRowPos, whitePawColPos, "Black");
                        break;
                    }
                }
                if (inRange(chessBoard, blackPawColPos + 1)) {
                    if (chessBoard[blackPawRolPos + 1][blackPawColPos + 1].equals("w")) {
                        whitePawRowPos = chessDeskRow(whitePawRowPos);
                        print(whitePawRowPos, whitePawColPos, "Black");
                        break;
                    }
                }

                chessBoard[blackPawRolPos][blackPawColPos] = "-";
                chessBoard[blackPawRolPos + 1][blackPawColPos] = "b";
                blackPawRolPos++;

                if (whitePawRowPos == 0) {
                    char letter = (char) (97 + whitePawColPos);
                    System.out.printf("Game over! White pawn is promoted to a queen at %s8.", letter);
                    break;
                } else if (blackPawRolPos == 7) {
                    char letter = (char) (97 + blackPawColPos);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s1.", letter);
                    break;
                }

            }
        }
    }

    private static void print(int rowPos, int colPos, String paw) {
        char alphabetic = (char) (97 + colPos);
        System.out.printf("Game over! %s capture on %s%d.", paw, alphabetic, rowPos);
    }

    private static boolean inRange(String[][] matrix, int index) {
        return index >= 0 && index < matrix[0].length;
    }

    private static void firstPromotedToQueen(int whitePawColPos, int blackPawColPos, int whitePawRowPos
            , int blackPowRolPos) {

        int whitePowMoves = 8 - chessDeskRow(whitePawRowPos);
        int blackPowMoves = chessDeskRow(blackPowRolPos) - 1;
        if (whitePowMoves <= blackPowMoves) {
            char letter = (char) (97 + whitePawColPos);
            System.out.printf("Game over! White pawn is promoted to a queen at %s8.", letter);
        } else {
            char letter = (char) (97 + blackPawColPos);
            System.out.printf("Game over! Black pawn is promoted to a queen at %s1.", letter);
        }

    }

    private static String[][] readMatrix(Scanner scanner) {
        int rows = 8;
        int cols = 8;
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
        return matrix;
    }

    private static int rowPosition(String[][] matrix, String paw) {
        int position = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (Arrays.asList(matrix[i]).contains(paw)) {
                position = i;
            }
        }
        return position;
    }

    private static int colPosition(String[][] matrix, String paw) {
        int position = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(paw)) {
                    position = j;
                }
            }
        }
        return position;
    }

    private static int chessDeskRow(int rowPos) {
        int chessDeskPos = 8;
        for (int i = 1; i <= rowPos; i++) {
            chessDeskPos--;
        }
        return chessDeskPos;
    }
}
