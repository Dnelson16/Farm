package dao.Interfaces;

import dao.Models.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int employeeId);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}


