package dao;

import dao.Models.Employee;
import dao.Service.EmployeeService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyBatisRunner {

    private static final Logger LOGGER = Logger.getLogger(MyBatisRunner.class.getName());

    private static SqlSessionFactory sessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error initializing MyBatis", e);
        }
    }

    public static void main(String[] args) {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            EmployeeService employeeService = new EmployeeService(sqlSession);

            // Get all employees
            List<Employee> employees = employeeService.getAllEmployees();
            LOGGER.info("All Employees:");
            for (Employee employee : employees) {
                LOGGER.info(employee.toString());
            }
            LOGGER.info("");

            // Get employee by ID
            int employeeId = 1;
            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee != null) {
                LOGGER.info("Employee with ID " + employeeId + ":");
                LOGGER.info(employee.toString());
                LOGGER.info("");
            } else {
                LOGGER.info("Employee with ID " + employeeId + " not found.");
            }

            // Insert a new employee
            Employee newEmployee = new Employee();
            newEmployee.setFarmId(1);
            newEmployee.setName("John Doe");
            newEmployee.setPosition("Manager");
            newEmployee.setSalary(5000.0);
            newEmployee.setFarmerId(1);
            employeeService.insertEmployee(newEmployee);
            LOGGER.info("New Employee inserted:");
            LOGGER.info(newEmployee.toString());
            LOGGER.info("");

            // Update an employee
            employee.setPosition("Senior Manager");
            employee.setSalary(6000.0);
            employeeService.updateEmployee(employee);
            LOGGER.info("Employee updated:");
            LOGGER.info(employee.toString());
            LOGGER.info("");

            // Delete an employee
            int employeeIdToDelete = 3;
            employeeService.deleteEmployee(employeeIdToDelete);
            LOGGER.info("Employee with ID " + employeeIdToDelete + " deleted.");

            // Get all employees again to verify deletion
            employees = employeeService.getAllEmployees();
            LOGGER.info("\nAll Employees after deletion:");
            for (Employee emp : employees) {
                LOGGER.info(emp.toString());
            }
        }
    }
}
