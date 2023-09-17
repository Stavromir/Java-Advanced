package P03_STACKS_QUEUES.LABS;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T03_DecimalToBinary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        if (input == 0) {
            System.out.println(input);
            return;
        }

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        while (input != 0) {
            int remainder = input % 2;
            input = input / 2;
            binaryNumber.push(remainder);
        }

        for (Integer current : binaryNumber) {
            System.out.print(current);
        }
    }
}
