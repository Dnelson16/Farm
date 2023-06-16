package dao.Service;

import dao.Models.Employee;
import dao.DAOJDBC.EmployeeDaoJDBC;

import java.util.List;
import static org.farm.Main.LOGGER;

public class EmployeeService {

        private EmployeeDaoJDBC employeeDao;

        public EmployeeService(EmployeeDaoJDBC employeeDao) {
            this.employeeDao = employeeDao;
        }

        public Employee create(Employee employee) {
            employeeDao.create(employee);
            LOGGER.info("Employee created successfully");
            return employee;
        }

        public Employee getById(int id) {
            return employeeDao.getById(id);
        }

        public List<Employee> getAll() {
            return employeeDao.getAll();
        }

        public Employee update(Employee employee) {
            return employeeDao.update(employee);
        }

        public int delete(int id) {
            employeeDao.delete(id);
            return id;
        }
    }
