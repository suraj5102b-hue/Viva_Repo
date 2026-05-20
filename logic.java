import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

class HCLManagement {
    ArrayList<Employee> employees = new ArrayList<>();

    // 1. Add Employee
    void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully.");
    }

    // 2. Remove Employee
    void removeEmployee(int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                employees.remove(e);
                System.out.println("Employee removed.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // 3. Update Salary
    void updateSalary(int id, double newSalary) {
        for (Employee e : employees) {
            if (e.id == id) {
                e.salary = newSalary;
                System.out.println("Salary updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // 4. Display Employee
    void displayEmployee(int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                e.display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // 5. Display All Employees
    void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }
        for (Employee e : employees) {
            e.display();
        }
    }

    // 6. Count Employees
    void countEmployees() {
        System.out.println("Total Employees: " + employees.size());
    }
}

public class HCLSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HCLManagement hcl = new HCLManagement();

        while (true) {
            System.out.println("\n===== HCL Employee Management =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Display Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Count Employees");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    hcl.addEmployee(id, name, salary);
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    hcl.removeEmployee(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new Salary: ");
                    double newSalary = sc.nextDouble();
                    hcl.updateSalary(uid, newSalary);
                    break;

                case 4:
                    System.out.print("Enter ID to display: ");
                    hcl.displayEmployee(sc.nextInt());
                    break;

                case 5:
                    hcl.displayAll();
                    break;

                case 6:
                    hcl.countEmployees();
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
