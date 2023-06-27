package dao.Proxy;

import dao.Interfaces.IEmployeeService;
import dao.Models.Employee;

import java.util.List;

public class EmployeeServiceProxy implements IEmployeeService {
    private IEmployeeService realService;

    public EmployeeServiceProxy(IEmployeeService realService) {
        this.realService = realService;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return realService.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return realService.getEmployeeById(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        realService.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        realService.deleteEmployee(employeeId);
    }
}
