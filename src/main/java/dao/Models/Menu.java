package dao.Models;

import java.util.Scanner;

import static org.farm.Main.LOGGER;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            LOGGER.info("Menu:");
            LOGGER.info("1. Database Operations");
            LOGGER.info("2. XML Parsing");
            LOGGER.info("3. Exit");

            LOGGER.info("Enter your choice: ");
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
                    LOGGER.info("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void performDatabaseOperations() {
        boolean exit = false;

        while (!exit) {
            LOGGER.info("Database Operations:");
            LOGGER.info("1. Insert data");
            LOGGER.info("2. Update data");
            LOGGER.info("3. Delete data");
            LOGGER.info("4. Back to main menu");

            LOGGER.info("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LOGGER.info("Performing database insertion...");

                    LOGGER.info("Enter employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();

                    LOGGER.info("Enter farm ID: ");
                    int farmId = scanner.nextInt();
                    scanner.nextLine();

                    LOGGER.info("Enter employee name: ");
                    String name = scanner.nextLine();

                    LOGGER.info("Enter position: ");
                    String position = scanner.nextLine();

                    LOGGER.info("Enter salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();

                    LOGGER.info("Enter farmer ID: ");
                    int farmerId = scanner.nextInt();
                    scanner.nextLine();

                    Employee newEmployee = new Employee(employeeId, farmId, name, position, salary, farmerId);

                    newEmployee.create(newEmployee);

                    LOGGER.info("Employee inserted successfully.");
                    break;
                case 2:
                    LOGGER.info("Performing database update...");

                    LOGGER.info("Enter the employee ID to update: ");
                    int employeeIdToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    LOGGER.info("Enter updated farm ID: ");
                    int updatedFarmId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    LOGGER.info("Enter updated employee name: ");
                    String updatedName = scanner.nextLine();

                    LOGGER.info("Enter updated position: ");
                    String updatedPosition = scanner.nextLine();

                    LOGGER.info("Enter updated salary: ");
                    double updatedSalary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character

                    LOGGER.info("Enter updated farmer ID: ");
                    int updatedFarmerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character


                    Employee updatedEmployee = new Employee(employeeIdToUpdate, updatedFarmId, updatedName, updatedPosition, updatedSalary, updatedFarmerId);


                    boolean updateResult = updatedEmployee.update(updatedEmployee);
                    if (updateResult) {
                        LOGGER.info("Employee updated successfully.");
                    } else {
                        LOGGER.info("Error updating employee.");
                    }
                    break;

                case 3:
                    // Implement logic to delete data from the database
                    LOGGER.info("Performing database deletion...");
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void performXMLParsing() {
        boolean exit = false;

        while (!exit) {
            LOGGER.info("XML Parsing:");
            LOGGER.info("1. DOM Parser");
            LOGGER.info("2. SAX Parser");
            LOGGER.info("3. StAX Parser");
            LOGGER.info("4. Back to main menu");

            LOGGER.info("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Implement logic to parse XML using DOM parser
                    LOGGER.info("Performing XML parsing with DOM parser...");
                    break;
                case 2:
                    // Implement logic to parse XML using SAX parser
                    LOGGER.info("Performing XML parsing with SAX parser...");
                    break;
                case 3:
                    // Implement logic to parse XML using StAX parser
                    LOGGER.info("Performing XML parsing with StAX parser...");
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    LOGGER.info("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
