package dao.Interfaces;

import dao.Models.Animal;


import java.util.List;

public interface IAnimalDao extends IDAO<Animal> {
    Animal create(Animal animal);
    Animal getById(int id);
    List<Animal> getAll();
    Animal update(Animal animal);
    int delete(int id);

    void insertAnimal(Animal animal);

    void updateAnimal(Animal animal);

    void deleteAnimal(int animalId);
}

