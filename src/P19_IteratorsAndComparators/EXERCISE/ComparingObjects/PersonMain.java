package P19_IteratorsAndComparators.EXERCISE.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> data = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            String town = input.split("\\s+")[2];

            Person newPerson = new Person(name, age, town);
            data.add(newPerson);
            input = scanner.nextLine();
        }

        int placeInDataList = Integer.parseInt(scanner.nextLine());

        int equalPeople = 0;
        int notEqualPeople = 0;

        Person toCompare = data.get(placeInDataList - 1);

        data.remove(placeInDataList - 1);

        for (Person current : data) {
                if (current.compareTo(toCompare) == 0) {
                    equalPeople++;
                } else {
                    notEqualPeople++;
                }
        }

        if (equalPeople != 0) {
            System.out.printf("%d %d %d%n", equalPeople + 1, notEqualPeople, data.size() + 1);
        } else {
            System.out.println("No matches");
        }

    }
}
