package dao.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "farm")
@XmlAccessorType(XmlAccessType.FIELD)
public class Farmstead {
    @XmlElement
    @JsonProperty("farmId")
    private int farmId;

    @XmlElement
    private int farmerId;

    @XmlElement
    @JsonProperty("farmName")
    private String Name;

    @XmlElement
    private int established;

    @XmlElement
    private String type;

    @XmlElementWrapper(name = "animals")
    @XmlElement(name = "animal")
    private List<Animal> animals;

    @XmlElement(name = "crop")
    private Crop crop;

    @XmlElement
    @XmlSchemaType(name = "date")
    private Date dateCreated;
    private String location;


    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEstablished() {
        return established;
    }

    public void setEstablished(int established) {
        this.established = established;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Animal> getAnimals() {
        return null;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setAnimals(List<Animal> animal) {
    }

    public void setFoods(List<AnimalFood> food) {
    }
}
//    private int farmId;
//    private int farmerId;
//    private String name;
//    private int established;
//    private String type;
//
//    public Farmstead(int farmId, int farmerId, String name, int established, String type) {
//        this.farmId = farmId;
//        this.farmerId = farmerId;
//        this.name = name;
//        this.established = established;
//        this.type = type;
//    }
//
//    public Farmstead() {
//
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
//    public int getFarmerId() {
//        return farmerId;
//    }
//
//    public void setFarmerId(int farmerId) {
//        this.farmerId = farmerId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getEstablished() {
//        return established;
//    }
//
//    public void setEstablished(int established) {
//        this.established = established;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//    @Override
//    public String toString() {
//        return "Farmstead:" +
//                "FarmId" + farmId +
//                ", FarmerId: " + farmerId + ',' +
//                ", Name: " + name + ',' +
//                ", Established: " + established + ',' +
//                ", Type: " + type;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Farmstead that = (Farmstead) o;
//        return farmId == that.farmId &&
//                Objects.equals(farmerId, that.farmerId) &&
//                Objects.equals(name, that.name) &&
//                Objects.equals(established, that.established)&&
//                Objects.equals(type, that.type );
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(farmId, farmerId, name, established,type);
//    }
//
//    public void update(Farmstead updatedFarmstead) {
//    }
//
//    public void create(Farmstead newFarmstead) {
//    }
//
//    public void delete(int farmsteadId) {
//    }
//
//    public List<Farmstead> getAll() {
//        return null;
//    }
//}
//
