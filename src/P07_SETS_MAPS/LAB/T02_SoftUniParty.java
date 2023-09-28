package P07_SETS_MAPS.LAB;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class T02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();

        String input = scanner.nextLine();

        while (!"PARTY".equals(input)) {
            char firstChar = input.charAt(0);

            if (Character.isDigit(firstChar)) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!"END".equals(input)) {
            vip.remove(input);
            regular.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(regular.size() + vip.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
