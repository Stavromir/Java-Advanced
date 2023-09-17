package P03_STACKS_QUEUES.EXERCISES;

import java.util.*;

public class T02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputIntegers = scanner.nextLine();

        int n = Integer.parseInt(inputIntegers.split("\\s+")[0]);
        int s = Integer.parseInt(inputIntegers.split("\\s+")[1]);
        int x = Integer.parseInt(inputIntegers.split("\\s+")[2]);

        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(numbersArray[i]);
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
