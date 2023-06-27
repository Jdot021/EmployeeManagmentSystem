/*import java.util.Scanner;
import java.util.List;

public class EmployeeUpdater  {

    public static void updateEmployee(Employee employee, Scanner scanner) {
        System.out.println("Enter ID of employee you wish to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employeeToUpdate = null;
        for (Employee emp: employee) {
            if (emp.getId() == id) {
                employeeToUpdate = emp;
                break;
            }
        }

        if (employeeToUpdate == null) {
            System.out.println("Employee with ID " + id + "not found");
            return;
        }

        System.out.println("Employee found:");
        System.out.println(employeeToUpdate.getId() + " " + employeeToUpdate.getName());

        System.out.println("Select information to update:");
        System.out.println("1. Name");
        System.out.println("2. Department");
        System.out.println("3. Hourly Pay");
        System.out.println("4. Start Date");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                employeeToUpdate.setName(newName);
                break;
            case 2:
                System.out.print("Enter new department: ");
                String newDepartment = scanner.nextLine();
                employeeToUpdate.setDepartment(newDepartment);
                break;
            case 3:
                System.out.print("Enter new hourly pay: ");
                double newHourlyPay = scanner.nextDouble();
                scanner.nextLine();
                employeeToUpdate.setHourlyPay(newHourlyPay);
                break;
            case 4:
                System.out.print("Enter new start date (MMDDYYYY): ");
                int newStartDate = scanner.nextInt();
                scanner.nextLine();
                employeeToUpdate.setStartDate(newStartDate);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        System.out.println("Employee updated:");
        System.out.println(employeeToUpdate.getId() + " " + employeeToUpdate.getName() + " " + employeeToUpdate.getDepartment() + " " + employeeToUpdate.getHourlyPay() + " " + employeeToUpdate.getStartDate());
    }
}
     */
      