package dao.DAOJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Models.Employee;
import dao.ConnectionPool.ConnectionPool;
import dao.Interfaces.IEmployeeDao;


public class EmployeeDaoJDBC implements IEmployeeDao {

    public Employee create(Employee employee) {
        String query = "INSERT INTO employee (farm_id, name, position, salary, farmer_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, employee.getFarmId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getPosition());
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getFarmerId());

            int rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        } catch (SQLException e) {
            System.out.println("Error creating employee: " + e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }

    public Employee getById(int id) {
        String query = "SELECT * FROM employee WHERE employee_id=?";
        ResultSet rs = null;
        Employee employee = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFarmId(rs.getInt("farm_id"));
                employee.setName(rs.getString("name"));
                employee.setPosition(rs.getString("position"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setFarmerId(rs.getInt("farmer_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employee: " + e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) {

    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int employeeId) {

    }

    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        String query = "SELECT * FROM employee";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFarmId(rs.getInt("farm_id"));
                employee.setName(rs.getString("name"));
                employee.setPosition(rs.getString("position"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setFarmerId(rs.getInt("farmer_id"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
            e.printStackTrace();
        }
        return employeeList;
    }

    public Employee update(Employee employee) {
        String query = "UPDATE employee SET farm_id=?, name=?, position=?, salary=?, farmer_id=? WHERE employee_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, employee.getFarmId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getPosition());
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getFarmerId());
            ps.setInt(6, employee.getEmployeeId());

            int count = ps.executeUpdate();
            System.out.println(count + " row/s affected");
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }

    public int delete(int id) {
        String query = "DELETE FROM employee WHERE employee_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);

            int count = ps.executeUpdate();
            System.out.println("\n" + count + " row/s deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            e.printStackTrace();
        }
        return id;
    }
}
