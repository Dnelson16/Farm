package dao.Interfaces;

import dao.Models.Employee;

import java.util.List;


public interface IEmployeeDao extends IDAO<Employee> {
    @Override
    Employee create(Employee employee);

    @Override
    Employee getById(int id);

    @Override
    List<Employee> getAll();

    @Override
    Employee update(Employee employee);

    @Override
    int delete(int id);
}
