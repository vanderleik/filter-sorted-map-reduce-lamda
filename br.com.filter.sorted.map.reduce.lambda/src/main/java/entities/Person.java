package entities;

public class Person {
    private String name;
    private String email;
    private double salary;

    public Person(String name, String email, double wage) {
        this.name = name;
        this.email = email;
        this.salary = wage;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", wage=" + salary +
                '}';
    }
}
