package dao.Proxy;

import dao.Interfaces.IEmployeeDao;
import dao.Models.Employee;

import java.util.List;
import java.util.logging.Logger;

public class EmployeeDaoProxy implements IEmployeeDao {
    private final IEmployeeDao employeeDao;
    private final Logger logger;

    public EmployeeDaoProxy(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
        this.logger = Logger.getLogger(EmployeeDaoProxy.class.getName());
    }

    @Override
    public List<Employee> getAllEmployees() {
        // Perform additional operations before delegating to the real implementation
        logger.info("Additional operation before getAllEmployees()");

        List<Employee> employees = employeeDao.getAllEmployees();

        // Perform additional operations after delegating to the real implementation
        logger.info("Additional operation after getAllEmployees()");

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        // Perform additional operations before delegating to the real implementation
        logger.info("Additional operation before getEmployeeById(" + id + ")");

        Employee employee = employeeDao.getEmployeeById(id);

        // Perform additional operations after delegating to the real implementation
        logger.info("Additional operation after getEmployeeById(" + id + ")");

        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) {

    }

    @Override
    public void updateEmployee(Employee employee) {
        // Perform additional operations before delegating to the real implementation
        logger.info("Additional operation before updateEmployee(" + employee.getEmployeeId() + ")");

        employeeDao.updateEmployee(employee);

        // Perform additional operations after delegating to the real implementation
        logger.info("Additional operation after updateEmployee(" + employee.getEmployeeId() + ")");
    }

    @Override
    public void deleteEmployee(int id) {
        // Perform additional operations before delegating to the real implementation
        logger.info("Additional operation before deleteEmployee(" + id + ")");

        employeeDao.deleteEmployee(id);

        // Perform additional operations after delegating to the real implementation
        logger.info("Additional operation after deleteEmployee(" + id + ")");
    }
}
