package P22_ExamPrep;


import java.util.Scanner;

public class P02_ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = matrixRead(scanner, rows);
        String parisLocation = locationReturn(matrix, 'P');
        int parisRowLoc = Integer.parseInt(parisLocation.split("")[0]);
        int parisColLoc = Integer.parseInt(parisLocation.split("")[1]);
//        String helenLocation = locationReturn(matrix, 'H');
//        int helenRowLoc = Integer.parseInt(helenLocation.split("")[0]);
//        int helenColLoc = Integer.parseInt(helenLocation.split("")[1]);

        while (energy > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int spartanSpawnRow = Integer.parseInt(input[1]);
            int spartanSpawnCol = Integer.parseInt(input[2]);
            spawnSpartan(matrix, spartanSpawnRow, spartanSpawnCol);
            energy--;
//            int parisNewRow;
//            int parisNewCol;

            switch (command) {
                case "up":
                    if (inRange(matrix, parisRowLoc - 1, parisColLoc)) {
                        matrix[parisRowLoc][parisColLoc] = '-';
                        parisRowLoc -= 1;
                        if (fightWithSpartan(matrix, parisRowLoc, parisColLoc)) {
                            energy -= 2;
                            if (notEnoughEnergy(matrix, parisRowLoc, parisColLoc, energy)) {
                                printMatrix(matrix, parisRowLoc, parisColLoc, energy);
                                return;
                            }
                        } else if (findHelen(matrix, parisRowLoc, parisColLoc)) {
                            printMatrix(matrix, parisRowLoc, parisColLoc, energy);
                            return;
                        } else {
                            matrix[parisRowLoc][parisColLoc] = 'P';
                        }
                    }
                    break;
                case "down":
                    if (inRange(matrix, parisRowLoc + 1, parisColLoc)) {
                        matrix[parisRowLoc][parisColLoc] = '-';
                        parisRowLoc += 1;
                        if (fightWithSpartan(matrix, parisRowLoc, parisColLoc)) {
                            energy -= 2;
                            if (notEnoughEnergy(matrix, parisRowLoc, parisColLoc, energy)) {
                                printMatrix(matrix, parisRowLoc, parisColLoc, energy);
                                return;
                            }
                        } else if (findHelen(matrix, parisRowLoc, parisColLoc)) {
                            printMatrix(matrix, parisRowLoc, parisColLoc, energy);
                            return;
                        } else {
                            matrix[parisRowLoc][parisColLoc] = 'P';
                        }
                    }
                    break;
                case "left":
                    if (inRange(matrix, parisRowLoc, parisColLoc - 1)) {
                        matrix[parisRowLoc][parisColLoc] = '-';
                        parisColLoc -= 1;
                        if (fightWithSpartan(matrix, parisRowLoc, parisColLoc)) {
                            energy -= 2;
                            if (notEnoughEnergy(matrix, parisRowLoc, parisColLoc, energy)) {
                                printMatrix(matrix, parisRowLoc, parisColLoc, energy);
                                return;
                            }
                        } else if (findHelen(matrix, parisRowLoc, parisColLoc)) {
                            printMatrix(matrix, parisRowLoc, parisColLoc, energy);
                            return;
                        } else {
                            matrix[parisRowLoc][parisColLoc] = 'P';
                        }
                    }
                    break;
                case "right":
                    if (inRange(matrix, parisRowLoc, parisColLoc + 1)) {
                        matrix[parisRowLoc][parisColLoc] = '-';
                        parisColLoc += 1;
                        if (fightWithSpartan(matrix, parisRowLoc, parisColLoc)) {
                            energy -= 2;
                            if (notEnoughEnergy(matrix, parisRowLoc, parisColLoc, energy)) {
                                printMatrix(matrix, parisRowLoc, parisColLoc, energy);
                                return;
                            }
                        } else if (findHelen(matrix, parisRowLoc, parisColLoc)) {
                            printMatrix(matrix, parisRowLoc, parisColLoc, energy);
                            return;
                        } else {
                            matrix[parisRowLoc][parisColLoc] = 'P';
                        }
                    }
                    break;
            }
        }
        printMatrix(matrix, parisRowLoc, parisColLoc, energy);
    }

    private static boolean notEnoughEnergy(char[][] matrix, int row, int col, int energy) {
        if (energy <= 0) {
            matrix[row][col] = 'X';
            return true;
        } else {
            matrix[row][col] = 'P';
            return false;
        }
    }

    private static boolean findHelen(char[][] matrix, int row, int col) {
        if (matrix[row][col] == 'H') {
            matrix[row][col] = '-';
            return true;
        }
        return false;
    }

    private static boolean fightWithSpartan(char[][] matrix, int row, int col) {
        return matrix[row][col] == 'S';
    }

    private static String locationReturn(char[][] matrix, char symbol) {
        String location = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char current = matrix[i][j];
                if (current == symbol) {
                    location = String.valueOf(i) + String.valueOf(j);
                    return location;
                }
            }
        }
        return location;
    }

    private static void spawnSpartan(char[][] matrix, int row, int col) {
        matrix[row][col] = 'S';
    }

    private static char[][] matrixRead(Scanner scanner, int rows) {
        char[][] matrixRead = new char[rows][];

        for (int i = 0; i < rows; i++) {
            char[] arrRead = scanner.nextLine().toCharArray();
            matrixRead[i] = arrRead;
        }
        return matrixRead;
    }

    private static boolean inRange(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static void printMatrix(char[][] matrix,int row, int col, int energy) {
        if (energy <= 0) {
            System.out.printf("Paris died at %d;%d.%n", row, col);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }

        for (char[] rows : matrix) {
            for (char element : rows) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
