package P07_SETS_MAPS.EXERCISE;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!"search".equals(input)) {
            String name = input.split("-")[0];
            String phone = input.split("-")[1];

            phonebook.put(name, phone);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!"stop".equals(input)) {

            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
