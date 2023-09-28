package P05_MultiDimensopnalArrays.EXEERCISES;

import java.util.Scanner;

public class T08_TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double playerDamage = Double.parseDouble(scanner.nextLine());
        double bossHealth = 3000000;
        int playerHealth = 18500;
        int plagueCloudPower = 3500;
        int eruptionPower = 6000;
        int plagueCount = 0;
        String lastSpell = "";

        int[][] matrixField = new int[15][15];

        int plRowPos = 7;
        int plColPos = 7;

        boolean playerDefeated = false;
        boolean bossDefeated = false;


        while (!playerDefeated) {

            String[] spellCommand = scanner.nextLine().split("\\s+");
            int spellRow = Integer.parseInt(spellCommand[1]);
            int spellCol = Integer.parseInt(spellCommand[2]);
            spellRange(matrixField, spellRow, spellCol);

            bossHealth = bossHealth - playerDamage;

            if (bossHealth <= 0) {
                bossDefeated = true;
                if (plagueCount > 0) {
                    playerHealth -= plagueCloudPower;
                    if (playerHealth <= 0) {
                        playerDefeated = true;
                    }
                }
                break;
            }
            if (plagueCount > 0) {
                playerHealth -= plagueCloudPower;
                plagueCount--;
                if (playerHealth <= 0) {
                    playerDefeated = true;
                    break;
                }
            }

            if (matrixField[plRowPos][plColPos] == 1) {
                if (isInside(matrixField, plRowPos - 1, plColPos)
                        && matrixField[plRowPos - 1][plColPos] != 1) {
                    plRowPos = plRowPos - 1;

                } else if (isInside(matrixField, plRowPos, plColPos + 1)
                        && matrixField[plRowPos][plColPos + 1] != 1) {
                    plColPos = plColPos + 1;

                } else if (isInside(matrixField, plRowPos + 1, plColPos)
                        && matrixField[plRowPos + 1][plColPos] != 1) {
                    plRowPos = plRowPos + 1;

                } else if (isInside(matrixField, plRowPos, plColPos - 1)
                        && matrixField[plRowPos][plColPos - 1] != 1) {
                    plColPos = plColPos - 1;
                } else {

                    switch (spellCommand[0]) {
                        case "Cloud":
                            lastSpell = "Plague Cloud";
                            plagueCount++;
                            playerHealth -= plagueCloudPower;

                            if (playerHealth <= 0) {
                                playerDefeated = true;
                            }
                            break;
                        case "Eruption":
                            lastSpell = "Eruption";
                            playerHealth -= eruptionPower;

                            if (playerHealth <= 0) {
                                playerDefeated = true;
                            }
                            break;
                    }
                }
            }
            matrixField = new int[15][15];
        }

        if (bossDefeated) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        }

        if (playerDefeated) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }
        System.out.println("Final position: " + plRowPos + ", " + plColPos);
    }

    private static void spellRange(int[][] matrixField, int spellRow, int spellCol) {
        for (int row = spellRow - 1; row <= spellRow + 1; row++) {
            for (int col = spellCol - 1; col <= spellCol + 1; col++) {
                if (isInside(matrixField, row, col)) {
                    matrixField[row][col] = 1;
                }
            }
        }
    }

    private static boolean isInside(int[][] matrixField, int row, int col) {
        return row >= 0 && row < matrixField.length && col >= 0 && col < matrixField[0].length;
    }
}
