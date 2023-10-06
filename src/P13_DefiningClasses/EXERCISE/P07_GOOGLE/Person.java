package P13_DefiningClasses.EXERCISE.P07_GOOGLE;

public class Person {

    public String name;

    public Person(String name) {
        this.name = name;
    }

    public static class Company {
        public String companyName;
        public String department;
        public String salary;

        public Company(String companyName, String department, String salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Company:%n" + "%s %s %s%n", this.companyName, this.department, this.salary);
        }
    }


    public static class Pokemon {
        public String pokemonName;
        public String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }

        @Override
        public String toString() {
            return String.format("Pokemon:%n" + "%s %s%n", this.pokemonName, this.pokemonType);
        }
    }

    public static class Parent {
        public String parentName;
        public String parentBirthday;

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        @Override
        public String toString() {
            return String.format("Parent:%n" + "%s %s%n", this.parentName, this.parentBirthday);
        }
    }

    public class Children {
        public String childName;
        public String childBirthday;

        public Children(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }

        @Override
        public String toString() {
            return String.format("Children:%n" + "%s %s%n", this.childName, this.childBirthday);
        }
    }

    public static class Car {
        public String carModel;
        public String carSpeed;

        public Car(String carModel, String carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }

        @Override
        public String toString() {
            return String.format("Car:%n" + "%s %s%n", this.carSpeed, this.carSpeed);
        }
    }
}
