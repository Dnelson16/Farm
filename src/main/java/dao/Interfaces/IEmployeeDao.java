package dao.Interfaces;
import dao.Models.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IEmployeeDao {

    @Select("SELECT * FROM employees")
    List<Employee> getAllEmployees();

    @Select("SELECT * FROM employees WHERE employeeId = #{employeeId}")
    Employee getEmployeeById(int employeeId);

    @Insert("INSERT INTO employees (employeeId, farmId, name, position, salary, farmerId) " +
            "VALUES (#{employee.employeeId}, #{employee.farmId}, #{employee.name}, " +
            "#{employee.position}, #{employee.salary}, #{employee.farmerId})")
    void insertEmployee(@Param("employee") Employee employee);

    @Update("UPDATE employees SET farmId = #{employee.farmId}, name = #{employee.name}, " +
            "position = #{employee.position}, salary = #{employee.salary}, farmerId = #{employee.farmerId} " +
            "WHERE employeeId = #{employee.employeeId}")
    void updateEmployee(@Param("employee") Employee employee);

    @Delete("DELETE FROM employees WHERE employeeId = #{employeeId}")
    void deleteEmployee(int employeeId);

}
