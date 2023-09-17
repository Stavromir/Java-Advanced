package P03_STACKS_QUEUES.EXERCISES;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T08_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> tokensStack = new ArrayDeque<>();
        Deque<String> outputQueue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");


        for (int i = 0; i < input.length; i++) {

            String token = input[i];

            if (!token.equals("+") & !token.equals("-") & !token.equals("*") & !token.equals("/")
                    & !token.equals("(") & !token.equals(")")) {
                outputQueue.offer(token);
            } else {
                if (tokensStack.isEmpty()) {
                    tokensStack.push(token);
                } else {
                    int powerOfPreviousToken = power(tokensStack.peek());
                    int powerOfCurrentToken = power(token);

                    if (token.equals("(")) {
                        tokensStack.push(token);
                    } else if (token.equals(")")) {
                        while (!tokensStack.peek().equals("(")) {
                            outputQueue.offer(tokensStack.pop());
                        }
                        tokensStack.pop();
                    } else if (powerOfCurrentToken > powerOfPreviousToken) {
                        tokensStack.push(token);
                    } else if (powerOfCurrentToken == powerOfPreviousToken) {
                        outputQueue.offer(tokensStack.pop());
                        tokensStack.push(token);
                    } else {
                        outputQueue.offer(tokensStack.pop());
                        tokensStack.push(token);
                    }
                }
            }
        }
        while (!tokensStack.isEmpty()) {
            outputQueue.offer(tokensStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }
    }

    public static int power(String operator) {
        int power = 0;
        if (operator.equals("*") || operator.equals("/")) {
            power = 3;
        } else if (operator.equals("+") || operator.equals("-")) {
            power = 2;
        } else {
            power = 1;
        }
        return power;
    }
}
