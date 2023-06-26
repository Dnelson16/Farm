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


    public BreedingService() {

    }

    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    public Animal getById(int animalId) {
        return animalDao.getById(animalId);
    }



    public void updateAnimal(Animal animal) {
        animalDao.updateAnimal(animal);
    }

    public void deleteAnimal(int animalId) {
        animalDao.deleteAnimal(animalId);
    }

    public void breedAnimals(Animal parent1, Animal parent2) {
    }

    public List<Animal> getAllAnimals() {
        return null;
    }
}
