package dao.Interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<E> implements IDAO<E> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;


    public E findById(int id) {
        E entity = null;
        String query = "SELECT * FROM Farm WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                entity = mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }


    public List<E> findAll() {
        List<E> entities = new ArrayList<>();
        String query = "SELECT * FROM Farm";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                E entity = mapResultSetToEntity(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }


    public void save(E entity) {
        String query = "INSERT INTO Farm (...) VALUES (...)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {


            // Execute the insert statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public E update(E entity) {
        String query = "UPDATE Farm SET ... WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void delete(E entity) {
        String query = "DELETE FROM Farm WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}