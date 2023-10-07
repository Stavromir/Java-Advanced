package P13_DefiningClasses.EXERCISE.P07_GOOGLE;

import java.util.*;

public class GoogleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> personInfo = new LinkedHashMap<>();


        while (!input.equals("End")) {

            String[] inputArr = input.split("\\s+");

            String personName = inputArr[0];
            String about = inputArr[1];
            String tokenOne = inputArr[2];
            String tokenTwo = inputArr[3];
            Person person = new Person();
            personInfo.putIfAbsent(personName, person);

            if (about.equals("company")) {
                double tokenThree = Double.parseDouble(inputArr[4]);
                personInfo.get(personName).setCompany(tokenOne, tokenTwo, tokenThree);
            } else if (about.equals("pokemon")) {
                personInfo.get(personName).setPokemon(tokenOne, tokenTwo);
            } else if (about.equals("parents")) {
                personInfo.get(personName).setParent(tokenOne, tokenTwo);
            } else if (about.equals("children")) {
                personInfo.get(personName).setChildren(tokenOne, tokenTwo);
            } else if (about.equals("car")) {
                personInfo.get(personName).setCar(tokenOne, tokenTwo);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        System.out.println(input);
        personInfo.get(input).printInfo();
    }
}
