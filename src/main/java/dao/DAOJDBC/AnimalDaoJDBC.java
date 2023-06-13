package dao.DAOJDBC;

import dao.Models.Animal;
import dao.ConnectionPool.ConnectionPool;
import dao.Interfaces.IAnimalDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDaoJDBC implements IAnimalDao {

    public Animal create(Animal animal) {
        String query = "INSERT INTO animal (name, species, age, gender) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, animal.getAnimalId());
            ps.setString(2, animal.getSpecies());
            ps.setInt(3, animal.getAge());
            ps.setString(4, animal.getGender());

            int rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        } catch (SQLException e) {
            System.out.println("Error creating animal: " + e.getMessage());
            e.printStackTrace();
        }
        return animal;
    }

    public Animal getById(int id) {
        String query = "SELECT * FROM animal WHERE animal_id=?";
        ResultSet rs = null;
        Animal animal = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                animal = new Animal(
                        rs.getInt("animal_id"),
                        rs.getInt("farm_id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        rs.getString("gender")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving animal: " + e.getMessage());
            e.printStackTrace();
        }
        return animal;
    }

    public List<Animal> getAll() {
        List<Animal> animalList = new ArrayList<>();
        String query = "SELECT * FROM animal";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getInt("animal_id"),
                        rs.getInt("farm_id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        rs.getString("gender")
                );
                animalList.add(animal);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving animals: " + e.getMessage());
            e.printStackTrace();
        }
        return animalList;
    }

    public Animal update(Animal animal) {
        String query = "UPDATE animal SET name=?, species=?, age=?, gender=? WHERE animal_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, animal.getAnimalId());
            ps.setString(2, animal.getSpecies());
            ps.setInt(3, animal.getAge());
            ps.setString(4, animal.getGender());
            ps.setInt(5, animal.getAnimalId());

            int count = ps.executeUpdate();
            System.out.println(count + " row/s affected");
        } catch (SQLException e) {
            System.out.println("Error updating animal: " + e.getMessage());
            e.printStackTrace();
        }
        return animal;
    }

    public int delete(int id) {
        String query = "DELETE FROM animal WHERE animal_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);

            int count = ps.executeUpdate();
            System.out.println("\n" + count + " row/s deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting animal: " + e.getMessage());
            e.printStackTrace();
        }
        return id;
    }
}



