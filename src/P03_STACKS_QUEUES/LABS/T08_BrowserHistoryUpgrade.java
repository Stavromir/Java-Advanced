package P03_STACKS_QUEUES.LABS;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stackBackward = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();


        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (stackBackward.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stackForward.push(stackBackward.pop());
                    System.out.println(stackBackward.peek());
                }
            } else if (input.equals("forward")) {

                if (stackForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(stackForward.peek());
                    stackBackward.push(stackForward.pop());
                }
            } else {
                stackBackward.push(input);
                System.out.println(input);
                stackForward.clear();
            }

            input = scanner.nextLine();
        }


    }
}
