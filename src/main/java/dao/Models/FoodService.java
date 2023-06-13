//package dao.Models;
//
//public class FoodService {
//    public void sellFood(AnimalFood animalFood, int quantity) {
//        // Check if the available stock is sufficient
//        if (animalFood.getStock() >= quantity) {
//            // Deduct the sold quantity from the available stock
//            int updatedStock = animalFood.getStock() - quantity;
//            animalFood.setStock(updatedStock);
//
//            // Calculate the total price based on the quantity sold and the price per unit
//            double totalPrice = quantity * animalFood.getPricePerUnit();
//
//            // Perform any necessary calculations or validations
//            // For example, you can update the revenue, track sales, etc.
//
//            System.out.println("Sold " + quantity + " units of " + animalFood.getName() + ".");
//            System.out.println("Total price: " + totalPrice);
//        } else {
//            System.out.println("Insufficient stock for " + animalFood.getName() + ".");
//        }
//    }
//}

