package dao.DAOJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionPool.ConnectionPool;
import dao.Interfaces.IFarmsteadDao;
import dao.Models.Farmstead;

public class FarmsteadDaoJDBC implements IFarmsteadDao {

    public Farmstead create(Farmstead farmstead) {
        String query = "INSERT INTO farmstead (farmer_id, name, established, type) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, farmstead.getFarmerId());
            ps.setString(2, farmstead.getName());
            ps.setInt(3, farmstead.getEstablished());
            ps.setString(4, farmstead.getType());

            int rowsAffected = ps.executeUpdate();
            System.out.println("\n" + rowsAffected + " row/s affected");
        } catch (SQLException e) {
            System.out.println("Error creating farmstead: " + e.getMessage());
            e.printStackTrace();
        }
        return farmstead;
    }

    public Farmstead getById(int id) {
        String query = "SELECT * FROM farmstead WHERE farm_id=?";
        ResultSet rs = null;
        Farmstead farmstead = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                farmstead = new Farmstead();
                farmstead.setFarmId(rs.getInt("farm_id"));
                farmstead.setFarmerId(rs.getInt("farmer_id"));
                farmstead.setName(rs.getString("name"));
                farmstead.setEstablished(rs.getInt("established"));
                farmstead.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving farmstead: " + e.getMessage());
            e.printStackTrace();
        }
        return farmstead;
    }

    public List<Farmstead> getAll() {
        List<Farmstead> farmsteadList = new ArrayList<>();
        String query = "SELECT * FROM farmstead";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Farmstead farmstead = new Farmstead();
                farmstead.setFarmId(rs.getInt("farm_id"));
                farmstead.setFarmerId(rs.getInt("farmer_id"));
                farmstead.setName(rs.getString("name"));
                farmstead.setEstablished(rs.getInt("established"));
                farmstead.setType(rs.getString("type"));
                farmsteadList.add(farmstead);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving farmsteads: " + e.getMessage());
            e.printStackTrace();
        }
        return farmsteadList;
    }

    public Farmstead update(Farmstead farmstead) {
        String query = "UPDATE farmstead SET farmer_id=?, name=?, established=?, type=? WHERE farm_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, farmstead.getFarmerId());
            ps.setString(2, farmstead.getName());
            ps.setInt(3, farmstead.getEstablished());
            ps.setString(4, farmstead.getType());
            ps.setInt(5, farmstead.getFarmId());

            int count = ps.executeUpdate();
            System.out.println(count + " row/s affected");
        } catch (SQLException e) {
            System.out.println("Error updating farmstead: " + e.getMessage());
            e.printStackTrace();
        }
        return farmstead;
    }

    public int delete(int id) {
        String query = "DELETE FROM farmstead WHERE farm_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);

            int count = ps.executeUpdate();
            System.out.println("\n" + count + " row/s deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting farmstead: " + e.getMessage());
            e.printStackTrace();
        }
        return id;
    }
}

