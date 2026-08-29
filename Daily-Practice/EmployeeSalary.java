import java.util.Scanner;
class Employee {
    double calculateSalary() {
        System.out.println("Calculating generic employee salary...");
        return 0.0;
    }
}
class FullTimeEmployee extends Employee {
    @Override
    double calculateSalary() {
        System.out.println("Calculating Full-Time Employee salary (Fixed Monthly Base)...");
        return 50000.0;
    }
}
class PartTimeEmployee extends Employee {
    @Override
    double calculateSalary() {
        System.out.println("Calculating Part-Time Employee salary (Hourly Wages)...");
        return 25000.0;
    }
}
class Intern extends Employee {
    @Override
    double calculateSalary() {
        System.out.println("Calculating Intern salary (Fixed Stipend)...");
        return 10000.0;
    }
}
class EmployeeSalary {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        Employee emp;       
        System.out.println("--- Employee Salary Calculator ---\n");
        System.out.println("Choose the type of employee to calculate salary for; \n1. Full-time \n2. Part-time \n3. Intern");
        int a=sc.nextInt();
        sc.close();
        switch(a){
            case 1: emp=new FullTimeEmployee();
                        System.out.println("Salary: Rs "+emp.calculateSalary() + "\n");
                        break;
            case 2: emp = new PartTimeEmployee(); 
                    System.out.println("Salary: Rs "+emp.calculateSalary() + "\n");
                    break;
            case 3: emp = new Intern(); 
                    System.out.println("Salary: Rs "+emp.calculateSalary() + "\n");
                    break;
            default: System.out.println("Invalid Choice!");
        }
    }
}