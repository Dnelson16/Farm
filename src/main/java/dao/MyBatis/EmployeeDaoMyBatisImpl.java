package dao.MyBatis;

import dao.Interfaces.IEmployeeDao;
import dao.Models.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public  class EmployeeDaoMyBatisImpl implements IEmployeeDao {
    private final SqlSession sqlSession;

    public EmployeeDaoMyBatisImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Employee> getAll() {
        return sqlSession.selectList("org.farm.dao.EmployeeDao.getAllEmployees");
    }

    @Override
    public Employee getById(int employeeId) {
        return sqlSession.selectOne("org.farm.dao.EmployeeDao.getEmployeeById", employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) {
        sqlSession.insert("org.farm.dao.EmployeeDao.insertEmployee", employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        sqlSession.update("org.farm.dao.EmployeeDao.updateEmployee", employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        sqlSession.delete("org.farm.dao.EmployeeDao.deleteEmployee", employeeId);
    }
}

