package dao.Models;

import java.util.Objects;

public class Crop {
    private int cropId;
    private int farmId;
    private String name;
    private String plantingDate;
    private String harvestDate;

    public Crop( int cropId, int farmId, String name, String plantingDate, String harvestDate){

        this.cropId = cropId;
        this.farmId = farmId;
        this.name = name;
        this.plantingDate = plantingDate;
        this.harvestDate = harvestDate;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(String plantingDate) {
        this.plantingDate = plantingDate;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }
    @Override
    public String toString() {
        return "Crop:" +
                "CropId" + cropId +
                ", farmId: " + farmId + ',' +
                ", Name: " + name + ',' +
                ", PlantingDate: " + plantingDate + ',' +
                ", HarvestDate: " + harvestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crop that = (Crop) o;
        return cropId == that.cropId &&
                Objects.equals(farmId, that.farmId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(plantingDate, that.cropId)&&
                Objects.equals(harvestDate, that.harvestDate );
    }

    @Override
    public int hashCode() {
        return Objects.hash(cropId, farmId, name, plantingDate,harvestDate);
    }
}
