package P13_DefiningClasses.EXERCISE.P01_OpinionPoll;

import java.util.*;

public class OpinionPollMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> list = new ArrayList<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);

            Person person = new Person(name, age);
            list.add(person);
        }

        list.stream()
                .filter(f -> f.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
