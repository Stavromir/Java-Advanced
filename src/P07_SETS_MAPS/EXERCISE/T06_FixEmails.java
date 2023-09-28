package P07_SETS_MAPS.EXERCISE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> mailMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"stop".equals(input)) {

            String name = input;
            String email = scanner.nextLine();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                mailMap.put(name, email);
            }

            input = scanner.nextLine();
        }

        mailMap.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }
}
