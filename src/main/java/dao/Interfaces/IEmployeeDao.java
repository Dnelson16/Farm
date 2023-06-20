package dao.Interfaces;

import dao.Models.Employee;
import java.util.List;

public interface IEmployeeDao {
    List<Employee> getAll();

    Employee getById(int employeeId);

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int employeeId);
    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}

