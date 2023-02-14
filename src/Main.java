import java.util.Random;

public class Main {
    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        fillEmployees();
        printFullInfo();
        System.out.println("Зарплата: " + totalSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeMaxSalary());
        System.out.println("Сотрудник с минимальной зарплатой:  " + employeeMinSalary());
        System.out.println("средняя зарплата: " + findAverageSalary());
        fullName();
    }

    private static void fillEmployees() {
        Random random = new Random();
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = new Employee("Сотрудник " + (i + 1), random.nextInt(5) + 1, random.nextInt(50_000) + 35_000);

        }
    }

    private static void printFullInfo() {
        for (Employee empoloyee : EMPLOYEES) {
            System.out.println(empoloyee);
        }
    }

    private static int totalSalary() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee employeeMinSalary() {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for (Employee emp : EMPLOYEES) {
            if (emp.getSalary() < min) {
                min = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
   }
    private static Employee employeeMaxSalary() {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee emp : EMPLOYEES) {
            if (emp.getSalary() > max) {
                max = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    private static double findAverageSalary(){
        return totalSalary() / (double) EMPLOYEES.length;

    }
    private static void fullName(){
        for(Employee employee : EMPLOYEES){
            System.out.println(employee.getFullName());
        }
    }
}