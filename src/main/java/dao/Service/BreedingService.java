package dao.Service;

import dao.Interfaces.IAnimalDao;
import dao.Models.Animal;

import java.util.List;

public class BreedingService {
    private IAnimalDao animalDao;

    public BreedingService(IAnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public void setAnimalDao(IAnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public void addAnimal(Animal animal) {
        if (animalDao != null) {
            animalDao.insertAnimal(animal);
        } else {
            throw new IllegalStateException("AnimalDao is not initialized.");
        }
    }

    public List<Animal> getAll() {
        if (animalDao != null) {
            return animalDao.getAll();
        } else {
            throw new IllegalStateException("AnimalDao is not initialized.");
        }
    }

    public Animal getById(int animalId) {
        if (animalDao != null) {
            return animalDao.getById(animalId);
        } else {
            throw new IllegalStateException("AnimalDao is not initialized.");
        }
    }

    public void updateAnimal(Animal animal) {
        if (animalDao != null) {
            animalDao.updateAnimal(animal);
        } else {
            throw new IllegalStateException("AnimalDao is not initialized.");
        }
    }

    public void deleteAnimal(int animalId) {
        if (animalDao != null) {
            animalDao.deleteAnimal(animalId);
        } else {
            throw new IllegalStateException("AnimalDao is not initialized.");
        }
    }

    public void breedAnimals(Animal parent1, Animal parent2) {
        // Implementation of breedAnimals method
    }

    public List<Animal> getAllAnimals() {
        return null;
    }
}
