package P13_DefiningClasses.EXERCISE.P07_GOOGLE;

import P13_DefiningClasses.EXERCISE.P06_PokemonTrainer.Pokemon;

import java.util.Scanner;

public class GoogleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.toString();

        Person person;

        while (!input.equals("End")) {

            String[] inputArr = input.split("\\s+");

            String personName = inputArr[0];
            String about = inputArr[1];
            String tokenOne = inputArr[2];
            String tokenTwo = inputArr[3];

            switch (about) {
                case "company":
                    String tokenThree = inputArr[4];

                    Person.Company companyInfo = new Person.Company(tokenOne, tokenTwo, tokenThree);

                    break;


                case "car":
                    person = new Person(personName);
                    Person.Car carInfo = new Person.Car(tokenOne, tokenTwo);
                    System.out.println(person.toString());
                    System.out.println();
                    break;
            }





            input = scanner.nextLine();
        }

    }
}
