package dao.Models;

import java.util.ArrayList;
import java.util.List;

public class FoodSelling {
    private List<AnimalFood> foodItems;

    public FoodSelling() {
        foodItems = new ArrayList<>();
    }

    public void sellFood(AnimalFood food, int quantity) {
        // Add selling logic here
        // Check if the requested quantity is available
        // Update the quantity of the food item after the sale
        // Calculate and handle the transaction
    }

    // Other methods for managing food items

    public void addFoodItem(AnimalFood food) {
        foodItems.add(food);
    }

    public void removeFoodItem(AnimalFood food) {
        foodItems.remove(food);
    }

    public List<AnimalFood> getAllFoodItems() {
        return foodItems;
    }
}

