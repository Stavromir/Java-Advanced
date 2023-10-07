package P13_DefiningClasses.EXERCISE.P07_GOOGLE;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parent> parent;
    private List<Children> children;
    private Car car;

    private class Company {

        private String companyName;
        private String department;
        private double salary;

        private Company(String companyName, String department, double salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }

        private void printCompany() {
            System.out.printf("%s %s %.2f%n", this.companyName, this.department, this.salary);
        }
    }

    private static class Pokemon {
        private String pokemonName;
        private String pokemonType;

        private Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }
        private void printPokemon() {
            System.out.printf("%s %s%n", this.pokemonName, this.pokemonType);
        }
    }

    private static class Parent {

        private String parentName;
        private String parentBirthday;

        private Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        private void printParent() {
            System.out.printf("%s %s%n", this.parentName, this.parentBirthday);
        }
    }

    private class Children {
        private String childName;
        private String childBirthday;

        private Children(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }

        private void printChild() {
            System.out.printf("%s %s%n", this.childName, this.childBirthday);
        }
    }

    private class Car {
        public String carModel;
        public String carSpeed;

        private Car(String carModel, String carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }
        private void printCar() {
            System.out.printf("%s %s%n", this.carModel, this.carSpeed);
        }
    }

    public void setCompany(String companyName, String department, double salary) {
        this.company = new Company(companyName, department, salary);
    }

    public void setPokemon(String pokemonName, String pokemonType) {
        if (this.pokemon == null) {
            this.pokemon = new ArrayList<>();
            this.pokemon.add(new Pokemon(pokemonName, pokemonType));
        } else {
            this.pokemon.add(new Pokemon(pokemonName, pokemonType));
        }
    }

    public void setParent(String parentName, String parentBirthday) {
        if (this.parent == null) {
            this.parent = new ArrayList<>();
            this.parent.add(new Parent(parentName, parentBirthday));
        } else {
            this.parent.add(new Parent(parentName, parentBirthday));
        }
    }

    public void setChildren(String childName, String childBirthday) {
        if (this.children == null) {
            this.children = new ArrayList<>();
            this.children.add(new Children(childName, childBirthday));
        } else  {
            this.children.add(new Children(childName, childBirthday));
        }
    }

    public void setCar(String carModel, String carSpeed) {
        this.car = new Car(carModel, carSpeed);
    }

    public void printInfo () {
        System.out.println("Company:");
        if (this.company != null) {
            this.company.printCompany();
        }
        System.out.println("Car:");
        if (this.car != null) {
            this.car.printCar();
        }
        System.out.println("Pokemon:");
        if (this.pokemon != null) {
            this.pokemon.forEach(Pokemon::printPokemon);
        }
        System.out.println("Parents:");
        if (this.parent != null) {
            this.parent.forEach(Parent::printParent);
        }
        System.out.println("Children:");
        if (this.children != null) {
            this.children.forEach(Children::printChild);
        }


    }
}
