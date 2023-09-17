package P03_STACKS_QUEUES.EXERCISES;

import java.util.*;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split("\\s+")[0]);
        int s = Integer.parseInt(input.split("\\s+")[1]);
        int x = Integer.parseInt(input.split("\\s+")[2]);

        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(numbersArray[i]);
        }

        for (int j = 0; j < s; j++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(x)){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
