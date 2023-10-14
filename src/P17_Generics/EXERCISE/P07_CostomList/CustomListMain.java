package P17_Generics.EXERCISE.P07_CostomList;

import java.sql.PseudoColumnUsage;
import java.util.Scanner;

public class CustomListMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> data = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String command = input.split("\\s+")[0];

            switch (command) {
                case "Add":
                    data.add(input.split("\\s+")[1]);
                    break;
                case "Remove":
                    data.remove(Integer.parseInt(input.split("\\s+")[1]));
                    break;
                case "Contains":
                    System.out.println(data.contains(input.split("\\s+")[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(input.split("\\s+")[2]);
                    data.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(data.countGreaterThen(input.split("\\s+")[1]));
                    break;
                case "Max":
                    System.out.println(data.getMax());
                    break;
                case "Min":
                    System.out.println(data.getMin());
                    break;
                case "Sort":
                    Sorter.sort(data);
                    break;
                default:
                    for (String current : data) {
                        System.out.println(current);
                    }
            }
            input = scanner.nextLine();
        }
    }
}
