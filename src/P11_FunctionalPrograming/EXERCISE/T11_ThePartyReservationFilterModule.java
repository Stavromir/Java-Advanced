package P11_FunctionalPrograming.EXERCISE;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String inputText = scanner.nextLine();

        while (!"Print".equals(inputText)) {





            inputText = scanner.nextLine();
        }


    }
}
