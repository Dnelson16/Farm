package dao.Models;
import java.util.ArrayList;
import java.util.List;

import static org.farm.Main.LOGGER;

public class FoodSelling {
    private List<AnimalFood> foodItems;

    public FoodSelling() {
        foodItems = new ArrayList<>();
    }

    public void sellFood(AnimalFood food, int quantity) {
        // Check if the food item exists in the inventory
        if (foodItems.contains(food)) {
            // Get the available quantity of the food item
            int availableQuantity = food.getQuantity();

            // Check if there is enough quantity to sell
            if (availableQuantity >= quantity) {
                // Reduce the quantity of the food item
                food.setQuantity(availableQuantity - quantity);
                LOGGER.info(quantity + " " + food.getName() + "(s) sold.");
            } else {
                LOGGER.info("Insufficient quantity of " + food.getName() + " to sell.");
            }
        } else {
            LOGGER.info(food.getName() + " is not available for sale.");
        }
    }

    public void addFoodItem(AnimalFood food) {
        foodItems.add(food);
        LOGGER.info(food.getName() + " added to the food inventory.");
    }

    public void removeFoodItem(AnimalFood food) {
        if (foodItems.remove(food)) {
            LOGGER.info(food.getName() + " removed from the food inventory.");
        } else {
            LOGGER.info(food.getName() + " is not found in the food inventory.");
        }
    }

    public List<AnimalFood> getAllFoodItems() {
        return foodItems;
    }
}

