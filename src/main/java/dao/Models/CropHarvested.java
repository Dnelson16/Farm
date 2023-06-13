package dao.Models;

import java.util.Objects;

public class CropHarvested {
    private int cropId;
    private int employeeId;

    public CropHarvested(int cropId, int employeeId){
        this.cropId = cropId;
        this.employeeId = employeeId;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    @Override
    public String toString() {
        return "Crop Harvested: " +
                "CropId: " + cropId +
                ", EmployeeId: " + employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CropHarvested that = (CropHarvested)  o;
        return cropId == that.cropId &&
                employeeId == that.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cropId, employeeId);
    }
}
