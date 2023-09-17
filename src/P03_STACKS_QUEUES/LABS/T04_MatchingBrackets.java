package P03_STACKS_QUEUES.LABS;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(') {
                indexStack.push(i);
            } else if (currentSymbol == ')') {
                String textSubstring = input.substring(indexStack.pop(), i + 1);
                System.out.println(textSubstring);
            }
        }
    }
}
