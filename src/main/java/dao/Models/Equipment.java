package dao.Models;

import java.util.Objects;

public class Equipment {
    private int equipmentId;
    private int farmId;
    private String name;


    public Equipment(int equipmentId, int farmId, String name) {
        this.equipmentId = equipmentId;
        this.farmId = farmId;
        this.name = name;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
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
    @Override
    public String toString() {
        return "Equipment:" +
                "EquipmentId" + equipmentId +
                ", farmId: " + farmId + ',' +
                ", Name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment that = (Equipment) o;
        return equipmentId == that.equipmentId &&
                Objects.equals(farmId, that.farmId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId, farmId, name);
    }
}

