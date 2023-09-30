package P11_FunctionalPrograming.LAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05_FilterByAge {

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String inputText = scanner.nextLine();
            String name = inputText.split(", ")[0];
            int age = Integer.parseInt(inputText.split(", ")[1]);

            Person newPerson = new Person(name, age);
            people.add(newPerson);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people.stream()
                .filter(filterByAge(condition, age))
                .forEach(print(format));
    }

    public static Predicate<Person> filterByAge(String condition, int age) {
        if (condition.equals("older")) {
            return c -> c.age >= age;
        } else {
            return c -> c.age <= age;
        }
    }

    public static Consumer<Person> print(String format) {
        if (format.equals("name")) {
            return p -> System.out.println(p.name);
        } else if (format.equals("age")) {
            return p -> System.out.println(p.age);
        } else {
            return p -> System.out.printf("%s - %d%n", p.name, p.age);
        }
    }
}
