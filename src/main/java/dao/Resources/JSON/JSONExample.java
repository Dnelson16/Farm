package dao.Resources.JSON;

import dao.Models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import static org.farm.Main.LOGGER;

public class JSONExample {
    public static void main(String[] args) {
        try {
            // Create objects
            Animal animal = new Animal();
            animal.setFarmId(1);
            animal.setName("Animal Farm");
            animal.setDateCreated(new Date());
            animal.setSpecies("Cow");

            AnimalFood food = new AnimalFood();
            food.setFarmId(2);
            food.setName("Food Farm");
            food.setDateCreated(new Date());
            food.setName("Hay");
            food.setQuantity(100);

            Farmstead farm = new Farmstead() {
            };
            farm.setFarmId(3);
            farm.setName("Mixed Farm");
            farm.setDateCreated(new Date());
            farm.setLocation("Countryside");
            farm.setAnimals(List.of(animal));
            farm.setFoods(List.of(food));

            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();


            objectMapper.writeValue(new File("farmstead.json"), farm);

            LOGGER.info("JSON file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
