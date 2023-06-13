package dao.Models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Animal extends Farmstead {


    @XmlElement
    private int animalId;

    @XmlElement
    private int farmId;

    @XmlElement
    private String species;

    @XmlElement
    private String breed;

    @XmlElement
    private int age;

    @XmlElement
    private String gender;


    public Animal(int animalId, int farmId, String name, String species, int age, String gender) {
        super();
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Override
    public int getFarmId() {
        return farmId;
    }

    @Override
    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

//    private int animalId;
//    private int farmId;
//    private String species;
//    private String breed;
//    private int age;
//    private String gender;
//
//
//    public Animal(int animalId, int farmId, String species, String breed, int age, String gender){
//        this.animalId = animalId;
//        this.farmId = farmId;
//        this.species = species;
//        this.breed = breed;
//        this.age = age;
//        this.gender = gender;
//    }
//
//    public Animal(String offspringName, String offspringBreed) {
//    }
//
//    public int getAnimalId() {
//        return animalId;
//    }
//
//    public void setAnimalId(int animalId) {
//        this.animalId = animalId;
//    }
//
//    public int getFarmId() {
//        return farmId;
//    }
//
//    public void setFarmId(int farmId) {
//        this.farmId = farmId;
//    }
//
//    public String getSpecies() {
//        return species;
//    }
//
//    public void setSpecies(String species) {
//        this.species = species;
//    }
//
//    public String getBreed() {
//        return breed;
//    }
//
//    public void setBreed(String breed) {
//        this.breed = breed;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    @Override
//    public String toString() {
//        return "Animal:" +
//                "animalId" + animalId +
//                ", farmId='" + farmId+ '\'' +
//                ", species='" + species + '\'' +
//                ", breed='" + breed + '\'' +
//                ", age='" + age + '\'' +
//                ", gender='" + gender + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Animal that = (Animal) o;
//        return animalId == that.animalId &&
//                Objects.equals(farmId, that.farmId) &&
//                Objects.equals(species, that.species) &&
//                Objects.equals(breed, that.breed) &&
//                Objects.equals(age, that.age) &&
//                Objects.equals(gender, that.gender);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(animalId, farmId, species, breed, age, gender);
//    }
//}
//
