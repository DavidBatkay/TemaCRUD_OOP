package ro.emanuel.rubiks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.rubiks.helper.DBHelper;
import ro.emanuel.rubiks.pojo.Medicine;

public class MedicineDAO {

    public static Medicine getMedicineById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM medicine WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        
        Medicine medicine = null;
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            boolean needsPrescription = rs.getBoolean("needsPrescription");
            medicine = new Medicine(id, name, quantity, needsPrescription);
        }
        DBHelper.closeConnection();
        return medicine;
    }

    public static void displayMedicine(Medicine medicine) {
        System.out.println(medicine.getId() + " | " + medicine.getName() + " | " + medicine.getQuantity() + " | " + medicine.isNeedsPrescription());
    }

    public static ArrayList<Medicine> getAllMedicine() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM medicine";
        Statement stmt = conn.createStatement();
        ArrayList<Medicine> results = new ArrayList<Medicine>();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            boolean needsPrescription = rs.getBoolean("needsPrescription");
            Medicine medicine = new Medicine(id, name, quantity, needsPrescription);
            results.add(medicine);
        }
        DBHelper.closeConnection();
        return results;
    }

    public static void displayAllMedicines() throws SQLException {
        ArrayList<Medicine> allMedicines = getAllMedicine();
        for (Medicine medicine : allMedicines) {
            displayMedicine(medicine);
        }
    }

    public static void updateQuantityById(int quantity, int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "UPDATE medicine SET quantity = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, quantity);
        stmt.setInt(2, id);
        stmt.execute();
        System.out.println("Quantity of Medicine with id " + id + " was set to " + quantity);
    }

    public static void createNewMedicine(Medicine medicine) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "INSERT INTO medicine (name, quantity, needsPrescription) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, medicine.getName());
        stmt.setInt(2, medicine.getQuantity());
        stmt.setBoolean(3, medicine.isNeedsPrescription());
        stmt.execute();
        System.out.println("New Medicine added into the database!");
    }

    public static void deleteMedicineById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "DELETE FROM medicine WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.execute();
        System.out.println("Medicine with id " + id + " was deleted!");
    }
}
