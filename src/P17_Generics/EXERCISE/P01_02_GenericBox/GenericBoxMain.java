package P17_Generics.EXERCISE.P01_02_GenericBox;

import java.util.Scanner;

public class GenericBoxMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            Integer input = Integer.parseInt(scanner.nextLine());
            GenericBox<Integer> newString = new GenericBox<>(input);
            System.out.print(newString);
        }
    }
}