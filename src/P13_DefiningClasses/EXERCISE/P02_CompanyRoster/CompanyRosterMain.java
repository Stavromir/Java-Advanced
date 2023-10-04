package P13_DefiningClasses.EXERCISE.P02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRosterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();


        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            int age;
            String mail;
            Employee employee;


            switch (input.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (input[4].matches("\\d+")) {
                        age = Integer.parseInt(input[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        mail = input[4];
                        employee = new Employee(name, salary, position, department, mail);
                    }
                    break;
                default:
                    mail = input[4];
                    age = Integer.parseInt(input[5]);
                    employee = new Employee(name, salary, position, department, mail, age);
            }

            employees.add(employee);
        }


        Map.Entry<String, List<Employee>> listEntry = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((d1, d2) -> {
                    double d1Average = d1.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    double d2Average = d2.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    return Double.compare(d2Average, d1Average);
                })
                .findFirst()
                .orElse(null);

        System.out.println("Highest Average Salary: " + listEntry.getKey());

        listEntry.getValue()
                .stream()
                .sorted((e2, e1) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .forEach(System.out::println);
    }
}
