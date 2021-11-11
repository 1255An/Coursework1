package ru.skypro.coursework1.level1;

public class MainMin {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        addEmployee(employees, new Employee("Иванов Иван Иванович","Отдел 1", 67590));
        addEmployee(employees, new Employee("Петров Петр Петрович", "Отдел 2", 45340));
        addEmployee(employees, new Employee("Федоров Федор Федорович", "Отдел 1", 74530));
        addEmployee(employees, new Employee("Семенов Семен Семенович", "Отдел 3", 81230));
        addEmployee(employees, new Employee("Викторов Виктор Викторович", "Отдел 5", 54380));
        System.out.println("Список сотрудников компании:");

        for (Employee employee : employees) {
            if (employee != null) {
                printList(employee);
           }
        }
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Сумма затрат на зарплаты в месяц: \n" + calcSum(employees) + " руб.");
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Сотрудник с минимальной заработной платой: \n" + findMinSalary(employees).getName());
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Сотрудник с максимальной заработной платой:\n" + findMaxSalary(employees).getName());
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Средняя заработная плата сотрудников:\n" + findAvgFrom(employees));
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("ФИО всех сотрудников:");

        for (Employee employee : employees) {
            if (employee != null) {
                printNames(employee);
            }
        }
    }

    private static boolean addEmployee(Employee[] employees, Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    private static void printList(Employee employee) {
        System.out.println("ФИО: " + employee.getName() + ", Отдел: " + employee.getDepartment() +
                ", З/п: " + employee.getSalary() + " руб." + ", ID: " + employee.getId());
    }


    private static int calcSum(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null) {
                sum += employees [i].getSalary();
                  }
            }
            return sum;
        }


    private static Employee findMinSalary(Employee[] employees) {
        Employee employeeMinSalary = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null && employees[i].getSalary() < employeeMinSalary.getSalary()) {
                employeeMinSalary = employees[i];
            }
        }
        return employeeMinSalary;
    }


    private static Employee findMaxSalary(Employee[] employees) {
        Employee employeeMaxSalary = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null && employees[i].getSalary() > employeeMaxSalary.getSalary()) {
                employeeMaxSalary = employees[i];
            }
        }
        return employeeMaxSalary;
    }

    private static double calcAvgValue(int sum, int elementAmount) {
        return sum / (double) elementAmount;
    }

    private static double findAvgFrom(Employee[] employees) {
        int sum = calcSum(employees);
        return calcAvgValue(sum, employees.length);
    }

    private static void printNames(Employee employee) {
        System.out.println(employee.getName());
    }
}
