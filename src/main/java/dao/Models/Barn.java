package dao.Models;

import java.util.Objects;

public class Barn {
    private int barnId;
    private int farmId;
    private int capacity;
    private String location;

    public Barn(int barnId, int farmId, int capacity, String location){
        this.barnId = barnId;
        this.farmId = farmId;
        this.capacity = capacity;
        this.location = location;
    }

    public int getBarnId() {
        return barnId;
    }

    public void setBarnId(int barnId) {
        this.barnId = barnId;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Barn:" +
                "BarnId" + barnId +
                ", farmId: " + farmId + ',' +
                ", Capacity: " + capacity + ',' +
                ", Location; " + location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barn that = (Barn) o;
        return barnId == that.barnId &&
                Objects.equals(farmId, that.farmId) &&
                Objects.equals(capacity, that.capacity) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barnId, farmId, capacity, location);
    }

}
