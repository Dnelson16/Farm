package dao.Models;

import java.util.Objects;

public class Employee {
    private int employeeId;
    private int farmId;
    private String name;
    private String position;
    private Double salary;
    private int farmerId;

    public Employee(int employeeId, int farmId, String name, String position, Double salary, int farmerId) {
        this.employeeId = employeeId;
        this.farmId = farmId;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.farmerId = farmerId;
    }

    public Employee() {

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }
    @Override
    public String toString() {
        return "Employee: " +
                "EmployeeId" + employeeId +
                ", FarmId: " + farmId + ',' +
                ", Name: " + name + ',' +
                ", Position: " + position + ',' +
                ", Salary: " + salary + ',' +
                ", FarmerId: " + farmerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return employeeId == that.employeeId &&
                Objects.equals(farmId, that.farmId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(position, that.position)&&
                Objects.equals(farmerId, that.farmerId );
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, farmId, name, position, farmerId);
    }

    public void create(Employee newEmployee) {
    }

    public boolean update(Employee updatedEmployee) {
        return false;
    }
}
