package dao.Models;

import java.util.Objects;

public class Farmer {
    private int farmerId;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private String contactEmail;


    public Farmer(int farmerId, String firstName, String lastName, String address, String contactNumber, String contactEmail) {
        this.farmerId = farmerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    @Override
    public String toString() {
        return "Farmer:" +
                "FarmerId" + farmerId +
                ", First Name: " + firstName + ',' +
                ", Last Name: " + lastName + ',' +
                ", Address: " + address + ',' +
                ", Contact Number: " + contactNumber + ',' +
                ", Contact Email: " + contactEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farmer that = (Farmer) o;
        return farmerId == that.farmerId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address)&&
                Objects.equals(contactNumber, that.contactNumber )&&
                Objects.equals(contactEmail,that.contactEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(farmerId, firstName, lastName, address, contactNumber, contactEmail);
    }
}

