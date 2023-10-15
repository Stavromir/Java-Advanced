package P19_IteratorsAndComparators.EXERCISE.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StrategyPatternMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Person> nameSet = new TreeSet<>(new NameComparator());
        Set<Person> ageSet = new TreeSet<>(new AgeComparator());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person newPerson = new Person(name, age);
            nameSet.add(newPerson);
            ageSet.add(newPerson);
        }

        nameSet.forEach(System.out::println);
        ageSet.forEach(System.out::println);
    }
}
