package org.farm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import dao.DAOJDBC.AnimalDaoJDBC;
import dao.DAOJDBC.EmployeeDaoJDBC;
import dao.Interfaces.IAnimalDao;
import dao.Interfaces.IEmployeeDao;
import dao.Models.Animal;
import dao.Models.AnimalFood;
import dao.Models.Employee;
import dao.ConnectionPool.ConnectionPool;
import dao.Models.FoodSelling;
import dao.Service.BreedingService;
import dao.Service.EmployeeService;


public class Main {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ConnectionPool.initialize();

        try (Connection connection = ConnectionPool.getConnection()) {
            LOGGER.info("Connected to the database!");
            IEmployeeDao employeeDao = new EmployeeDaoJDBC();
            EmployeeService employeeService = new EmployeeService(employeeDao);

            List<Employee> employeeList = employeeService.getAllEmployees();
            LOGGER.info("All Employees:");
            for (Employee employee : employeeList) {
                LOGGER.info(employee.getEmployeeId() + " : " + employee.getFarmId() + " : " +
                        employee.getName() + " : " + employee.getPosition() + " : " + employee.getSalary() +
                        " : " + employee.getFarmerId());
            }

            int employeeId = 2;
            Employee specificEmployee = employeeService.getEmployeeById(employeeId);
            if (specificEmployee != null) {
                LOGGER.info("\nEmployee with ID " + employeeId + ":");
                LOGGER.info(specificEmployee.getEmployeeId() + " : " + specificEmployee.getFarmId() + " : " +
                        specificEmployee.getName() + " : " + specificEmployee.getPosition() + " : " +
                        specificEmployee.getSalary() + " : " + specificEmployee.getFarmerId());
            } else {
                LOGGER.info("\nEmployee with ID " + employeeId + " not found.");
            }

            Employee updatedEmployee = new Employee(3, 2, "Jane Smith", "Supervisor", 6000.0, 2);
            employeeService.updateEmployee(updatedEmployee);

            int employeeIdToDelete = 4;
            employeeService.deleteEmployee(employeeIdToDelete);


            IAnimalDao animalDao = new AnimalDaoJDBC();
            BreedingService breedingService = new BreedingService(animalDao);

            Animal parent1 = new Animal(1, 1, "Cow", "Belgian", 3, "Male");
            Animal parent2 = new Animal(1, 2, "Dog", "Shepherd", 4, "Female");
            breedingService.addAnimal(parent1);
            breedingService.addAnimal(parent2);

            breedingService.breedAnimals(parent1, parent2);

            List<Animal> allAnimals = breedingService.getAll();
            for (Animal animal : allAnimals) {
                LOGGER.info("Species: " + animal.getSpecies() + ", Age: " + animal.getAge() + ", Gender: " + animal.getGender());
            }

            FoodSelling sellingSystem = new FoodSelling();

            AnimalFood item1 = new AnimalFood("Carrots", 1.99, 3);
            AnimalFood item2 = new AnimalFood("Apples", 2.49, 1);
            sellingSystem.addFoodItem(item1);
            sellingSystem.addFoodItem(item2);

            // Get all food items
            List<AnimalFood> allFoodItems = sellingSystem.getAllFoodItems();

            if (allFoodItems != null) {
                for (AnimalFood animalFood : allFoodItems) {
                    LOGGER.info("Food: " + animalFood.getName() + ", Price: $" + animalFood.getPrice());
                }
            } else {
                LOGGER.info("No food items found.");
            }

            // Sell food
            sellingSystem.sellFood(item1, 2);
            sellingSystem.sellFood(item2, 3);

            ConnectionPool.shutdown(); // Shutdown the connection pool
        } catch (SQLException e) {
            LOGGER.severe("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}

