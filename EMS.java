import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class EMS {
    public static class Employee {
        private int id;
        private String name;
        private String department;
        private double hourlyPay;
        private int startDate;

        //contructor
        public Employee(int id, String name, String department, double hourlyPay, int startDate) {
            this.id = id;
            this.name =name;
            this.department = department;
            this.hourlyPay = hourlyPay;
            this.startDate = startDate;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public void setHourlyPay(double hourlyPay) {
            this.hourlyPay = hourlyPay;
        }
        public void setStartDate(int startDate) {
            this.startDate = startDate;
        }



        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getHourlyPay() {
            return hourlyPay;
        }

        public int getStartDate() {
            return startDate;
        }

    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View All Employee");
            System.out.println("4. Update Employee");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    Employee employee = addEmployee(scanner);
                    employees.add(employee);
                    break;
                case 2:
                    Employee emptoRemove = removEmployee(scanner, employees);
                    if (emptoRemove != null) {
                        employees.remove(emptoRemove);
                    }
                    break;
                case 3:
                    System.out.println("List of employees:");
                    for (Employee emp: employees) {
                     System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDepartment() + " " + emp.getHourlyPay() + " " + emp.getStartDate());
                    }
                    break;
                case 4:
                    System.out.print("Enter the ID of the employee you want to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    Employee employeeToUpdate = getEmployee(idToUpdate, employees);
                    if (employeeToUpdate == null) {
                        System.out.println("Employee with ID " + idToUpdate + " was not found");
                        break;
                    }
                    EMS.updateEmployee(employeeToUpdate, scanner);
                    break;
                case 9:
                    exit = true;
                    break;


            }

        }
        /*boolean addMore = true;

        while(addMore) {
            Employee employee = addEmployee(scanner);
            employees.add(employee);

            System.out.print("Do you want to add another employee? (yes/no): ");
            String response = scanner.next();
            addMore = response.equalsIgnoreCase("yes");
            scanner.nextLine();
        }
        

        System.out.println("List of employees:");
        for (Employee emp: employees) {
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDepartment() + " " + emp.getHourlyPay() + " " + emp.getStartDate());
        }
        scanner.close();
        */
    }

    public static Employee addEmployee(Scanner scanner) {

        Random random = new Random();

        int id;
        boolean hasID;

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();

        System.out.print("Enter employee hourly pay: ");
        double hourlyPay = scanner.nextDouble();

        System.out.print("Enter employee start date(MMDDYYYY): ");
        int startDate = scanner.nextInt();

        System.out.print("Does Employee have an ID? (yes/no): ");
        String exist = scanner.next();
        hasID = exist.equalsIgnoreCase("yes");
        
        if (!hasID){
            id = random.nextInt(9000) + 1000;
            System.out.println("Employee ID: " + id);
        } else {
            System.out.print("Enter Employee ID: ");
            id = scanner.nextInt();
        }

        Employee employee = new Employee(id, name, department, hourlyPay, startDate);
        return employee;

    }  

    public static Employee removEmployee(Scanner scanner, List<Employee> employees) {
        int idhold;
        boolean ans;
        System.out.println("Enter ID of employee you wish to remove: ");
        idhold = scanner.nextInt();
        scanner.nextLine();

        List<Employee> employeesToRemove = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getId() == idhold) {
                employeesToRemove.add(emp);
            }
        }

        if (employeesToRemove.isEmpty()) {
            System.out.println("Employee with ID " + idhold + " was not found");
            return null;
        }

        if (employeesToRemove.size() == 1) {
            System.out.println("Is this the employee you wish to remove? ");
            String remAns = scanner.nextLine();
            ans = remAns.equalsIgnoreCase("yes");

            if (ans) {
                employees.remove(employeesToRemove.get(0));
                System.out.println("Employee with ID " + idhold + " has been removed");
                return employeesToRemove.get(0);
            } else {
                System.out.println("Employee with ID " + idhold + " was not found");
                return null;
            }
        } else {
            System.out.println("Employee with ID " + idhold + " was not found");
            return null;
        }

    }

    public static Employee getEmployee(int id, List<Employee> employees) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
    

    public static void updateEmployee(Employee employeeToUpdate, Scanner scanner) {
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



/*4. Define a method to remove an employee from the list:
   a. Prompt user for input of employee id
   b. Find the employee in the list with matching id
   c. Remove the employee from the list*/

/*5. Define a method to update an employee's information:
   a. Prompt user for input of employee id
   b. Find the employee in the list with matching id
   c. Prompt user for input of new employee information
   d. Update the employee object with the new information*/

/*6. Define a method to search for an employee:
   a. Prompt user for input of search term (id, name, department, position)
   b. Iterate over the list of employees and find any employees that match the search term
   c. Display the matching employees*/

/*7. Define a method to display all employees:
   a. Iterate over the list of employees and display each employee's information8?

/*8. Define a method to calculate total salary expense:
   a. Iterate over the list of employees and sum up the salary for each employee
   b. Display the total salary expense*/

/*9. Define a method to save the list of employees to a file:
   a. Open a file for writing
   b. Iterate over the list of employees and write each employee's information to the file*/

/*10. Define a method to load the list of employees from a file:
    a. Open a file for reading
    b. Read each line from the file and create an employee object with the information
    c. Add the employee object to the list*/

/*11. Define a main method to display a menu of options to the user:
    a. Prompt user to select an option (add employee, remove employee, update employee, search for employee, display all employees, calculate total salary expense, save to file, load from file, quit)
    b. Call the appropriate method based on the user's choice
    c. Repeat until the user chooses to quit*/

    
