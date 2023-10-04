package P13_DefiningClasses.EXERCISE.P02_CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String mail;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary, String position, String department, String mail) {
        this(name, salary, position, department, mail, -1);
    }

    public Employee(String name, double salary, String position, String department, String mail, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.mail = mail;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", getName(), getSalary()
                , getMail(), getAge());
    }
}
