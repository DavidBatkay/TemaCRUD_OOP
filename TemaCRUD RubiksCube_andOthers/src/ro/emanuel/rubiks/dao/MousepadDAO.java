package ro.emanuel.rubiks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.rubiks.helper.DBHelper;
import ro.emanuel.rubiks.pojo.Mousepad;

public class MousepadDAO {

	public static Mousepad getMousepadeById(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM mousepad WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		
		Mousepad m=null;
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			String color = rs.getString("color");
			double diagonal = rs.getDouble("diagonal");
			boolean isRGB = rs.getBoolean("isRGB");
			m=new Mousepad(id,color, diagonal, isRGB);
		}
		DBHelper.closeConnection();
		return m;
	}
	

	public static void displayMousepad(Mousepad m) {
		System.out.println(m.getId()+" | "+m.getColor()+" | "+m.getDiagonal()+" | "+m.isRGB());
	
	}
	
	public static ArrayList<Mousepad> getAllMousepad() throws SQLException{
		Connection conn =DBHelper.getConnection();
		String query="SELECT * FROM mousepad";
		Statement stmt=conn.createStatement();
		ArrayList<Mousepad> results = new ArrayList<Mousepad>();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int id= rs.getInt("id");
			String color = rs.getString("color");
			double diagonal = rs.getDouble("diagonal");
			boolean isRGB = rs.getBoolean("isRGB");
			Mousepad m = new Mousepad(id,color, diagonal, isRGB);
			results.add(m);
		}
		DBHelper.closeConnection();
		return results;
	}
	
	public static void displayAllMousepads() throws SQLException {
		ArrayList<Mousepad> allMousepads = getAllMousepad();
		for(Mousepad m : allMousepads) {
			displayMousepad(m);
		}
	}
	
	public static void updateColorById(String color,int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "UPDATE mousepad SET color = ? WHERE id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1,color);
		stmt.setInt(2, id);
		stmt.execute();
		System.out.println("Color of Mousepad with id "+id+" was set to "+color);
	}
	
	public static void createNewMousepad(Mousepad m) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "INSERT INTO mousepad (color, diagonal, isRGB) VALUES (?, ?, ?)";
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setString(1, m.getColor() );
		stmt.setDouble(2, m.getDiagonal());
		stmt.setBoolean(3,m.isRGB());
		stmt.execute();
		System.out.println("New Mousepad added into database!");
		
	}
	
	public static void deleteMousepadById(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "DELETE FROM mousepad WHERE id=?";
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.execute();
		System.out.println("Mousepad with id "+id+" was deleted!");
	}
}