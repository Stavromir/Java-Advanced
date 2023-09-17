package P03_STACKS_QUEUES.EXERCISES;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class T03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsQuantity = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsQuantity; i++) {

            String[] inputCommand = scanner.nextLine().split("\\s+");

            switch (inputCommand[0]) {
                case "1":
                    stack.push(Integer.parseInt(inputCommand[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
