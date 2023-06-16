package dao.Resources.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Models.Animal;
import dao.Models.Farmstead;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


import static org.farm.Main.LOGGER;

public class JSONParser {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON from file
            File jsonFile = new File("/Users/dylannelson16/IdeaProjects/Farm/src/main/java/dao/Resources/JSON/farmstead.json");
            Farmstead farmstead = objectMapper.readValue(jsonFile, Farmstead.class);

            // Access the parsed data
            int farmId = farmstead.getFarmId();
            String farmName = farmstead.getName();
            List<Animal> animals = farmstead.getAnimals();
            Date dateCreated = farmstead.getDateCreated();

            LOGGER.info("Farm ID: " + farmId);
            LOGGER.info("Farm Name: " + farmName);
            LOGGER.info("Animals: " + animals);
            LOGGER.info("Date Created: " + dateCreated);

            // Other processing logic

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
