package dao.Models;

import java.util.ArrayList;
import java.util.List;


public class BreedingService {
    private List<Animal> animals;

    public BreedingService() {
        animals = new ArrayList<>();
    }

    public void breedAnimals(Animal parent1, Animal parent2) {

    }



    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public List<Animal> getAllAnimals() {
        return animals;
    }
}
