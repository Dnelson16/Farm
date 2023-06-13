package org.farm;

import dao.Models.*;
import dao.ConnectionPool.ConnectionPool;
import dao.DAOJDBC.EmployeeDaoJDBC;
import dao.Interfaces.IEmployeeDao;
import dao.Service.EmployeeService;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        IEmployeeDao employeeDao = new EmployeeDaoJDBC();


        EmployeeService employeeService = new EmployeeService((EmployeeDaoJDBC) employeeDao);


        List<Employee> employeeList = employeeService.getAll();
        System.out.println("All Employees:");
        for (Employee employee : employeeList) {
            System.out.println(employee.getEmployeeId() + " : " + employee.getFarmId() + " : " +
                    employee.getName() + " : " + employee.getPosition() + " : " + employee.getSalary() +
                    " : " + employee.getFarmerId());
        }

        int employeeId = 2;
        Employee specificEmployee = employeeService.getById(employeeId);
        if (specificEmployee != null) {
            System.out.println("\nEmployee with ID " + employeeId + ":");
            System.out.println(specificEmployee.getEmployeeId() + " : " + specificEmployee.getFarmId() + " : " +
                    specificEmployee.getName() + " : " + specificEmployee.getPosition() + " : " +
                    specificEmployee.getSalary() + " : " + specificEmployee.getFarmerId());
        } else {
            System.out.println("\nEmployee with ID " + employeeId + " not found.");
        }


        Employee updatedEmployee = new Employee(3, 2, "Jane Smith", "Supervisor", 6000.0, 2);
        employeeService.update(updatedEmployee);


        int employeeIdToDelete = 4;
        employeeService.delete(employeeIdToDelete);


        ConnectionPool.shutdown();

        BreedingService breedingService = new BreedingService();

        Animal parent1 = new Animal(1,1,"Cow", "Belgian", 3, "Male");
        Animal parent2 = new Animal(1,2,"Dog","Shephard", 4, "Female");
        breedingService.addAnimal(parent1);
        breedingService.addAnimal(parent2);

        breedingService.breedAnimals(parent1, parent2);


        List<Animal> allAnimals = breedingService.getAllAnimals();
        for (Animal animal : allAnimals) {
            System.out.println("Species: " + animal.getSpecies() + ", Age: " + animal.getAge() + ", Gender: " + animal.getGender());
        }

        FoodSelling sellingSystem = new FoodSelling();

        AnimalFood item1 = new AnimalFood("Carrots", 1.99,3);
        AnimalFood item2 = new AnimalFood("Apples", 2.49, 1);
        sellingSystem.addFoodItem(item1);
        sellingSystem.addFoodItem(item2);

        // Get all food items
        List<AnimalFood> allFoodItems = sellingSystem.getAllFoodItems();

        if (allFoodItems != null) {
            for (AnimalFood animalFood : allFoodItems) {
                System.out.println("Food: " + animalFood.getName() + ", Price: $" + animalFood.getPrice());
            }
        } else {
            System.out.println("No food items found.");
        }


//        // Create an instance of BreedingService
//        BreedingService breedingService = new BreedingService();
//
//        // Create parent animals
//        Animal parent1 = new Animal("Parent1", "Breed1");
//        Animal parent2 = new Animal("Parent2", "Breed2");
//
//        //\ Breed animals
//        Animal offspring = breedingService.breedAnimals(parent1, parent2);
//        System.out.println("New offspring: " + offspring.getName() + " (" + offspring.getBreed() + ")");
//
//        // Create an instance of FoodService
//        FoodService foodService = new FoodService();
//
//        // Create animal food
//        AnimalFood animalFood = new AnimalFood("Food1", 10, 2.5);
//
//        // Sell food
//        int quantitySold = 5;
//        foodService.sellFood(animalFood, quantitySold);
//
//        // Display updated stock
//        System.out.println("Updated stock: " + animalFood.getStock());
//    }
//    }
//}
    }
}
