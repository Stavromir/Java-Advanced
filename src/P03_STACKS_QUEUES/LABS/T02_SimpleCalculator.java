package P03_STACKS_QUEUES.LABS;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T02_SimpleCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] stringArr = input.split("\\s+");

        int sum = 0;

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = stringArr.length - 1; i >= 0; i--) {
            stack.push(stringArr[i]);
        }

        int number = Integer.parseInt(stack.pop());
        sum += number;

        while (!stack.isEmpty()) {

            String currentSymbol = stack.pop();

            if (currentSymbol.equals("+")) {
                number = Integer.parseInt(stack.pop());
                sum += number;

            } else if (currentSymbol.equals("-")) {
                number = Integer.parseInt(stack.pop());
                sum -= number;

            }
        }

        System.out.println(sum);
    }
}
