package dao.Models;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Database Operations");
            System.out.println("2. XML Parsing");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    performDatabaseOperations();
                    break;
                case 2:
                    performXMLParsing();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void performDatabaseOperations() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Database Operations:");
            System.out.println("1. Insert data");
            System.out.println("2. Update data");
            System.out.println("3. Delete data");
            System.out.println("4. Back to main menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Performing database insertion...");

                    System.out.print("Enter employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter farm ID: ");
                    int farmId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter farmer ID: ");
                    int farmerId = scanner.nextInt();
                    scanner.nextLine();

                    Employee newEmployee = new Employee(employeeId, farmId, name, position, salary, farmerId);

                    newEmployee.create(newEmployee);

                    System.out.println("Employee inserted successfully.");
                    break;
                case 2:
                    System.out.println("Performing database update...");

                    System.out.print("Enter the employee ID to update: ");
                    int employeeIdToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter updated farm ID: ");
                    int updatedFarmId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter updated employee name: ");
                    String updatedName = scanner.nextLine();

                    System.out.print("Enter updated position: ");
                    String updatedPosition = scanner.nextLine();

                    System.out.print("Enter updated salary: ");
                    double updatedSalary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter updated farmer ID: ");
                    int updatedFarmerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character


                    Employee updatedEmployee = new Employee(employeeIdToUpdate, updatedFarmId, updatedName, updatedPosition, updatedSalary, updatedFarmerId);


                    boolean updateResult = updatedEmployee.update(updatedEmployee);
                    if (updateResult) {
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Error updating employee.");
                    }
                    break;

                case 3:
                    // Implement logic to delete data from the database
                    System.out.println("Performing database deletion...");
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void performXMLParsing() {
        boolean exit = false;

        while (!exit) {
            System.out.println("XML Parsing:");
            System.out.println("1. DOM Parser");
            System.out.println("2. SAX Parser");
            System.out.println("3. StAX Parser");
            System.out.println("4. Back to main menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Implement logic to parse XML using DOM parser
                    System.out.println("Performing XML parsing with DOM parser...");
                    break;
                case 2:
                    // Implement logic to parse XML using SAX parser
                    System.out.println("Performing XML parsing with SAX parser...");
                    break;
                case 3:
                    // Implement logic to parse XML using StAX parser
                    System.out.println("Performing XML parsing with StAX parser...");
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
