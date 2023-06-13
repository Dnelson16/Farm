package dao.Models;

import java.util.Objects;

public class BarnAnimal {
    private int barnId;
    private int animalId;

    public BarnAnimal(int barnId, int animalId){
        this.barnId = barnId;
        this.animalId = animalId;
    }

    public int getBarnId() {
        return barnId;
    }

    public void setBarnId(int barnId) {
        this.barnId = barnId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
    @Override
    public String toString() {
        return "Barn Animal: " +
                "BarnId: " + barnId +
                ", AnimalId: " + animalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarnAnimal that = (BarnAnimal)  o;
        return barnId == that.barnId&&
                animalId == that.animalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barnId, animalId);
    }

}
