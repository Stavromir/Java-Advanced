package P19_IteratorsAndComparators.EXERCISE.StackIterator;

import java.util.Scanner;

public class StackIteratorMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StackIterator<String> data = new StackIterator<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String command = input.split("\\s+")[0];

            switch (command) {
                case "Push":
                    String[] dataArd = input.split("[\\s,]+");
                    for (int i = 1; i < dataArd.length; i++) {
                        data.push(dataArd[i]);
                    }
                    break;
                case "Pop":
                    try {
                        data.pop();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        data.forEach(System.out::println);
        data.forEach(System.out::println);
    }
}
