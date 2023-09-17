package P03_STACKS_QUEUES.EXERCISES;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sbText = new StringBuilder();

        Deque<String> historyStack = new ArrayDeque<>();

        int iterations = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < iterations; i++) {
            String command = scanner.nextLine();

            int commandType = Integer.parseInt(command.split("\\s+")[0]);

            switch (commandType) {
                case 1:
                    historyStack.push(sbText.toString());
                    String textToAdd = command.split("\\s+")[1];
                    sbText.append(textToAdd);
                    break;
                case 2:
                    historyStack.push(sbText.toString());
                    int eraseCount = Integer.parseInt(command.split("\\s+")[1]);
                    String subString = sbText.substring(0, sbText.length() - eraseCount);
                    sbText.setLength(0);
                    sbText.append(subString);
                    break;
                case 3:
                    int indexPosition = Integer.parseInt(command.split("\\s+")[1]);
                    System.out.println(sbText.charAt(indexPosition - 1));
                    break;
                case 4:
                    sbText.setLength(0);
                    sbText.append(historyStack.pop());
                    break;
            }
        }
    }
}

