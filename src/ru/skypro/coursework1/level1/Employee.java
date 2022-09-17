package ru.skypro.coursework1.level1;

public class Employee {
    private final String name;
    private String department;
    private int salary ;
    private int id;

    private static int counter = 1;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
           id = counter++;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary (int salary) {
        this.salary = salary;
    }

    public String toString () {
        return name + " : " + department + " : " + salary + " : ";
    }
}
