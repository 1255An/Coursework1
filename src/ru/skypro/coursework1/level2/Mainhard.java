package ru.skypro.coursework1.level2;

public class Mainhard {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        Employee employee1 = new Employee("Иванов Иван Иванович", "Отдел 1", 67590);
        Employee employee2 = new Employee("Петров Петр Петрович", "Отдел 2", 45340);
        Employee employee3 = new Employee("Федоров Федор Федорович", "Отдел 1", 74530);
        Employee employee4 = new Employee("Семенов Семен Семенович", "Отдел 3", 81230);
        Employee employee5 = new Employee("Викторов Виктор Викторович", "Отдел 5", 54380);

        addEmployee(employees, employee1);
        addEmployee(employees, employee2);
        addEmployee(employees, employee3);
        addEmployee(employees, employee4);
        addEmployee(employees, employee5);

        int percent = 10;
        String department = "Отдел 1";
        int numb = 50_000;

        System.out.println("Итог индексации з/п сотрудников компании на " + percent+ " % :");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("ФИО: " + employee.getName() + ", " + employee.getDepartment() +
                        ", З/п: " + increaseSalary(employee, percent) + " руб., ID: " + employee.getId());
            }
        }

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("Минимальная з/п в выбранном отделе (" + department+ "):\n"
                + findMinSalaryOfDepartment(employees, department).getName());

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("Максмальная з/п в выбранном отделе (" + department+ "):\n"
                + findMaxSalaryOfDepartment(employees, department).getName());

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("Сумма затрат на з/п в месяц (" + department+ "):\n"
                + sumSalariesOfDepartment(employees, department) + " руб.");

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("Средняя з/п в выбранном отделе (" + department+ "):\n"
                + sumSalariesOfDepartment(employees, department)/avgSalary(department, employees) + " руб.");

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("Итог индексации з/п в выбранном отеделе (" + department+ ")" + " на " + percent + " % :");

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment().equals(department)) {
                System.out.println("ФИО: " + employee.getName() + " , "
                        +increaseSalaryOfDepartment(employee, department, percent) + " руб., ID: " + employee.getId());
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("Список сотрудников в введенном отделе (" + department + "): " );

        printListOfDepartment(employees,department);

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("З/п выше, чем введенное число (" +numb + ") у следующих сотрудников:");

        printEmployeesWithHigherSalary(employees, numb);

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("З/п ниже, чем введенное число (" +numb + ") у следующих сотрудников:");

        printEmployeesWithLowerSalary(employees, numb);
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

    private static int increaseSalary(Employee employee, int percent) {
        int increment = 0;
        int newSalary = employee.getSalary();
        if (employee != null) {
            increment += (newSalary * percent / 100);
            newSalary = newSalary + increment;
            employee.setSalary(newSalary);
        }
        return newSalary;
    }

    private static Employee findMinSalaryOfDepartment(Employee[] employees, String department) {
        Employee minSalaryOfDepartment = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null && (employees[i].getDepartment().equals(department))
                    && employees[i].getSalary() < minSalaryOfDepartment.getSalary()) {
                minSalaryOfDepartment = employees[i];
            }
        }
        return minSalaryOfDepartment;
    }

    private static Employee findMaxSalaryOfDepartment(Employee[] employees, String department) {
        Employee maxSalaryOfDepartment = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null && (employees[i].getDepartment().equals(department))
                    && employees[i].getSalary() > maxSalaryOfDepartment.getSalary()) {
                maxSalaryOfDepartment = employees[i];
            }
        }
        return maxSalaryOfDepartment;
    }

    private static int sumSalariesOfDepartment (Employee [] employees, String department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null && employees[i].getDepartment().equals(department)) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    private static int increaseSalaryOfDepartment(Employee employee, String department, int percent) {
        int increment = 0;
        int newSalary = employee.getSalary();
        if (employee != null && employee.getDepartment().equals(department)) {
            increment += (newSalary * percent / 100);
            newSalary = newSalary + increment;
        }
        return newSalary;
    }

    private static double avgSalary(String department, Employee [] employees) {
        int sum = sumSalariesOfDepartment(employees, department);
        int amount = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment().equals(department)) {
                amount++;
            }
        } return amount;
    }

    private static void printListOfDepartment(Employee[] employees, String department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null && employees[i].getDepartment().equals(department)) {
                System.out.println("ФИО: " +employees[i].getName() + ", З/п: " + employees[i].getSalary()
                        + " руб., ID: " + employees[i].getId());
            }
        }
    }

    private static void printEmployeesWithHigherSalary(Employee[] employees, int numb) {
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null && employees[i].getSalary() >= numb) {
                System.out.println("ФИО: " + employees[i].getName() + ", З/п: " + employees[i].getSalary()
                        + " руб., ID: " + employees[i].getId());
            }
        }
    }

    private static void printEmployeesWithLowerSalary(Employee[] employees, int numb) {
        for (int i = 0; i < employees.length; i++) {
            if (employees [i] != null && employees[i].getSalary() < numb) {
                System.out.println("ФИО: " + employees[i].getName() + ", З/п: " + employees[i].getSalary()
                        + " руб., ID: " + employees[i].getId());
            }
        }
    }
}