package dao.Interfaces;


import dao.Models.Employee;
import org.apache.ibatis.annotations.*;


@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM Employee WHERE id = #{id}")
    Employee getEmployeeById(@Param("id") int id);

    @Insert("INSERT INTO Employee(id, name) VALUES (#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEmployee(Employee employee);
}

