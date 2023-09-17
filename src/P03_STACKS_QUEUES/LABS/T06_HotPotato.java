package P03_STACKS_QUEUES.LABS;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T06_HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int tosses = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (String child : children) {
            childrenQueue.offer(child);
        }

        while (childrenQueue.size() > 1) {

            for (int i = 1; i < tosses; i++) {
                String childPassPotato = childrenQueue.poll();
                childrenQueue.offer(childPassPotato);
            }

            System.out.println("Removed " + childrenQueue.poll());
        }

        System.out.println("Last is " + childrenQueue.peek());
    }
}
