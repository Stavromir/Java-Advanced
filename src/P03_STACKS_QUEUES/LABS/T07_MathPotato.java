package P03_STACKS_QUEUES.LABS;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int tosses = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> childrenQueue = new PriorityQueue<>();

        for (String current : children) {
            childrenQueue.offer(current);
        }

        int cycle = 1;

        while (childrenQueue.size() > 1) {

            for (int i = 1; i < tosses; i++) {
                childrenQueue.offer(childrenQueue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + childrenQueue.peek());
            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }
            cycle ++;
        }
        System.out.println("Last is " + childrenQueue.peek());
    }

    public static boolean isPrime (int cycle) {

        int count = 0;

        for (int i = 1; i <= cycle; i++) {

            if (cycle % i == 0 ) {
                count ++;
            }
        }

        if (count > 2 || count == 1) {
            return false;
        }
        return true;
    }
}
