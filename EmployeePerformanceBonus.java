
import java.util.Scanner;

class Employee {
    protected String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public double calculateBonus() {
        return 0.0;
    }

    public double calculateBonus(double amount) {
        return 0.0;
    }
}

class TechnicalEmployee extends Employee {
    private double basicSalary;
    private int rating;

    public TechnicalEmployee(String employeeName, double basicSalary, int rating) {
        super(employeeName);
        this.basicSalary = basicSalary;
        this.rating = rating;
    }

    @Override
    public double calculateBonus() {
        return basicSalary * rating * 2 / 100.0;
    }

    public double calculateBonus(double salary, int employeeRating) {
        return salary * employeeRating * 2 / 100.0;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}

class SalesEmployee extends Employee {
    private double salesAmount;

    public SalesEmployee(String employeeName, double salesAmount) {
        super(employeeName);
        this.salesAmount = salesAmount;
    }

    @Override
    public double calculateBonus() {
        return salesAmount * 3 / 100.0;
    }

    @Override
    public double calculateBonus(double amount) {
        return amount * 3 / 100.0;
    }

    public double getSalesAmount() {
        return salesAmount;
    }
}

public class EmployeePerformanceBonus {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int employeeType = scanner.nextInt();
        String employeeName = scanner.next();

        Employee emp;
        
        double basicSalary = 0.0;
        double salesAmount = 0.0;
        int rating = 0;

        if (employeeType == 1) {
            basicSalary = scanner.nextDouble();
            rating = scanner.nextInt();
            emp = new TechnicalEmployee(employeeName, basicSalary, rating);

        } else if (employeeType == 2) {
            salesAmount = scanner.nextDouble();
            emp = new SalesEmployee(employeeName, salesAmount);

        } else {
            System.out.println("Invalid");
            scanner.close();
            return;
        }
        double bonus = emp.calculateBonus();
        double totalEarnings;

        if (employeeType == 1) {
            totalEarnings = basicSalary + bonus;
        } else {
            totalEarnings = salesAmount + bonus;
        }

        System.out.println("Employee Name: " + employeeName);
        System.out.printf("Bonus: %.2f%n", bonus);
        System.out.printf("Total Earnings: %.2f%n", totalEarnings);

        scanner.close();
    }
}
