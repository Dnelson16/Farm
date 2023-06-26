package dao.Mapper;


import dao.Models.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeMapper {

    @Select("SELECT * FROM employees")
    List<Employee> getAllEmployees();

    @Select("SELECT * FROM employees WHERE employee_id = #{employeeId}")
    Employee getEmployeeById(int employeeId);

    @Insert("INSERT INTO employees (employee_id, farm_id, name, position, salary, farmer_id) " +
            "VALUES (#{employeeId}, #{farmId}, #{name}, #{position}, #{salary}, #{farmerId})")
    void insertEmployee(Employee employee);

    @Update("UPDATE employees SET farm_id = #{farmId}, name = #{name}, position = #{position}, " +
            "salary = #{salary}, farmer_id = #{farmerId} WHERE employee_id = #{employeeId}")
    void updateEmployee(Employee employee);

    @Delete("DELETE FROM employees WHERE employee_id = #{employeeId}")
    void deleteEmployee(int employeeId);
}


