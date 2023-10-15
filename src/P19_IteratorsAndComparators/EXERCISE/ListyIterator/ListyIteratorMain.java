package P19_IteratorsAndComparators.EXERCISE.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListyIteratorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator<String> data = new ListyIterator<>();

        String createList = scanner.nextLine();

        data.setData(Arrays.stream(createList.split("\\s+"))
                .skip(1)
                .collect(Collectors.toList()));

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            switch (command) {
                case "Move":
                    System.out.println(data.move());
                    break;
                case "HasNext":
                    System.out.println(data.hasNext());
                    break;
                case "PrintAll":
                    data.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
                case "Print":
                    try {
                        data.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
