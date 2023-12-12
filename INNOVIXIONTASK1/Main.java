import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private int employeeId;
    private double hourlyRate;
    private int hoursWorked;
    private double deductions;

    public Employee(String name, int employeeId, double hourlyRate) {
        this.name = name;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
        this.deductions = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getDeductions() {
        return deductions;
    }

    // Setters
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    // Calculate salary after deductions
    public double calculateSalary() {
        double salaryBeforeDeductions = hourlyRate * hoursWorked;
        return salaryBeforeDeductions - deductions;
    }

    // Generate pay stub
    public String generatePayStub() {
        return "Pay Stub for Employee ID: " + employeeId +
                "\nName: " + name +
                "\nHourly Rate: $" + hourlyRate +
                "\nHours Worked: " + hoursWorked +
                "\nDeductions: $" + deductions +
                "\nNet Salary: $" + calculateSalary() + "\n";
    }
}

class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void processPayroll() {
        System.out.println("Processing Payroll...\n");
        for (Employee employee : employees) {
            System.out.println(employee.generatePayStub());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create employees
        Employee employee1 = new Employee("John Doe", 101, 20.0);
        Employee employee2 = new Employee("Jane Smith", 102, 25.0);

        // Set hours worked and deductions
        System.out.print("Enter hours worked for " + employee1.getName() + ": ");
        int hoursWorked1 = scanner.nextInt();
        employee1.setHoursWorked(hoursWorked1);

        System.out.print("Enter deductions for " + employee1.getName() + ": $");
        double deductions1 = scanner.nextDouble();
        employee1.setDeductions(deductions1);

        System.out.print("Enter hours worked for " + employee2.getName() + ": ");
        int hoursWorked2 = scanner.nextInt();
        employee2.setHoursWorked(hoursWorked2);

        System.out.print("Enter deductions for " + employee2.getName() + ": $");
        double deductions2 = scanner.nextDouble();
        employee2.setDeductions(deductions2);

        // Create payroll system
        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.addEmployee(employee1);
        payrollSystem.addEmployee(employee2);

        // Process and display payroll
        payrollSystem.processPayroll();

        scanner.close();
    }
}
