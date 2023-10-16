package P21_ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> maleStack = new ArrayDeque<>();
        Deque<Integer> femaleQueue = new ArrayDeque<>();

        int[] readData = readArray(scanner);
        for (int male : readData) {
            maleStack.push(male);
        }

        readData = readArray(scanner);
        for (int female : readData) {
            femaleQueue.offer(female);
        }

        int matchesCount = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {

            int male = maleStack.peek();
            int female = femaleQueue.peek();

            if (equalToZero(male, female)) {
                if (male <= 0) {
                    maleStack.pop();
                }
                if (female <= 0) {
                    femaleQueue.poll();
                }
                continue;
            }

            if (isDivisible(male, female)) {
                if (male % 25 == 0) {
                    maleStack.pop();
                    maleStack.pop();
                }
                if (female % 25 == 0) {
                    femaleQueue.poll();
                    femaleQueue.poll();
                }
                continue;
            }

            if (male == female) {
                matchesCount++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);

        if (maleStack.isEmpty() && femaleQueue.isEmpty()) {
            System.out.println("Males left: none");
            System.out.print("Females left: none");

        } else if (femaleQueue.isEmpty()){
            System.out.print("Males left: ");
            for (int i = 0; i < maleStack.size() - 1; i++) {
                System.out.print(maleStack.pop() + ", ");
                i--;
            }
            System.out.println(maleStack.pop());
            System.out.print("Females left: none");
        } else {
            System.out.println("Males left: none");
            System.out.print("Females left: ");
            for (int i = 0; i < femaleQueue.size() - 1; i++) {
                System.out.print(femaleQueue.poll() + ", ");
                i--;
            }
            System.out.println(femaleQueue.poll());
        }
    }

    private static int[] readArray (Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean equalToZero (int male, int female) {
        return male <= 0 || female <= 0;
    }

    private static boolean isDivisible (int male, int female) {
        return male % 25 == 0 || female % 25 == 0;
    }
}
