package dao.Service;

import dao.Interfaces.IEmployeeDao;
import dao.Models.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private IEmployeeDao employeeDao;

    public EmployeeService(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeService(SqlSession sqlSession) {
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeDao.getAllEmployees();

        // Check if the employeeList is null and return an empty list instead
        if (employeeList == null) {
            return new ArrayList<>();
        }

        return employeeList;
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    // Additional methods...

    public void delete(int employeeIdToDelete) {
        // Implementation goes here
    }

    public Employee getEmployeeById() {
        // Implementation goes here
        return null;
    }

    public List<Employee> getAll() {
        // Implementation goes here
        return null;
    }

    public void create(Employee newEmployee) {
        // Implementation goes here
    }

    public void update(Employee updatedEmployee) {
        // Implementation goes here
    }
}

