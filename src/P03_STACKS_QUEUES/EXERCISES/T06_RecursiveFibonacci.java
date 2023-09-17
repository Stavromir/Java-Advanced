package P03_STACKS_QUEUES.EXERCISES;

import java.util.Scanner;

public class T06_RecursiveFibonacci {

    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1];

        long result = fibonacci(n);
        System.out.println(result);
    }
    public static long fibonacci (int n) {

        if (n < 2) {
            return 2;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] =  fibonacci(n - 1) + fibonacci(n - 2);
        return memory[n];
    }
}
