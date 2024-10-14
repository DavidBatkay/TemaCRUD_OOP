package ro.david;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/oop2024", connectionProps);

        Statement stmt = conn.createStatement();


        createMobila(stmt, "Scaun", 3, "Brad");

        readMobila(stmt);

        updateMobila(stmt, 1, 2);  

        deleteMobila(stmt, 1);  

        createLivrare(stmt, "Marcel Cireasa", "Sanmartin", "AWB46842668");
        readLivrari(stmt);
        updateLivrare(stmt, 1, "Beius");  
        deleteLivrare(stmt, 1);  

        conn.close();
    }

   
    public static void createMobila(Statement stmt, String tip, int cantitate , String material) throws SQLException {
        String sql = "INSERT INTO mobila (tip, cantitate, material) " +
                     "VALUES ('" + tip + "', '" + cantitate + "', '" + material + "')";
        stmt.executeUpdate(sql);
        System.out.println("Mobila inserata cu succes!");
    }


    public static void readMobila(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM mobila");
        while (rs.next()) {
            int id = rs.getInt("id");
            String tip = rs.getString("tip");
            int cantitate = rs.getInt("cantitate");
            String material = rs.getString("material");
            System.out.println(id + " | " + tip + " | " + cantitate + " | " + material);
        }
    }

    public static void updateMobila(Statement stmt, int id, int cantitateNoua) throws SQLException {
        String sql = "UPDATE mobila SET cantitate = " + cantitateNoua + " WHERE id = " + id;
        stmt.executeUpdate(sql);
        System.out.println("Mobila cu id " + id + " a fost actualizata!");
    }

    public static void deleteMobila(Statement stmt, int id) throws SQLException {
        String sql = "DELETE FROM mobila WHERE id = " + id;
        stmt.executeUpdate(sql);
        System.out.println("Mobila cu id " + id + " a fost ștearsa!");
    }

  

    public static void createLivrare(Statement stmt, String sofer, String locatie, String cod) throws SQLException {
        String sql = "INSERT INTO livrari (sofer, locatie, cod) " +
                     "VALUES ('" + sofer + "', '" + locatie + "', '" + cod + "')";
        stmt.executeUpdate(sql);
        System.out.println("Livrare inserată cu succes!");
    }

    public static void readLivrari(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM livrari");
        while (rs.next()) {
            int id = rs.getInt("id");
            String sofer = rs.getString("sofer");
            String locatie = rs.getString("locatie");
            String cod = rs.getString("cod");
            System.out.println(id + " | " + sofer + " | " + locatie + " | " + cod);
        }
    }
    
   
    public static void updateLivrare(Statement stmt, int id, String locatie) throws SQLException {
        String sql = "UPDATE livrari SET locatie = '" + locatie + "' WHERE id = " + id;
        stmt.executeUpdate(sql);
        System.out.println("Livrarea cu id " + id + " a fost actualizată!");
    }

    public static void deleteLivrare(Statement stmt, int id)throws SQLException{
    	String sql = "DELETE FROM livrari WHERE id = "+id;
    	stmt.executeUpdate(sql);
    	System.out.println("Livrarea cu id "+id+" a fost ștearsă!");
    }
    
}