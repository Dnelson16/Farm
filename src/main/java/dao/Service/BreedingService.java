package dao.Service;


import dao.Interfaces.IAnimalDao;
import dao.Models.Animal;

import java.util.List;

public class BreedingService {
    private final IAnimalDao animalDao;

    public BreedingService(IAnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    public Animal getById(int animalId) {
        return animalDao.getById(animalId);
    }

    public void addAnimal(Animal animal) {
        animalDao.insertAnimal(animal);
    }

    public void updateAnimal(Animal animal) {
        animalDao.updateAnimal(animal);
    }

    public void deleteAnimal(int animalId) {
        animalDao.deleteAnimal(animalId);
    }

    public void breedAnimals(Animal parent1, Animal parent2) {
    }
}
