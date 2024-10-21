package ro.emanuel.rubiks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.rubiks.helper.DBHelper;
import ro.emanuel.rubiks.pojo.RubiksCube;

public class RubiksCubeDAO {

	public static RubiksCube getRubiksCubeById(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM rubiks_cube WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		
		RubiksCube rc=null;
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			String brand = rs.getString("brand");
			double weight = rs.getDouble("weight");
			int sides = rs.getInt("sides");
			rc=new RubiksCube(id,brand, weight, sides);
		}
		DBHelper.closeConnection();
		return rc;
	}
	

	public static void displayRubiksCube(RubiksCube rc) {
		System.out.println(rc.getId()+" | "+rc.getBrand()+" | "+rc.getWeight()+" | "+rc.getSides());
	
	}
	
	public static ArrayList<RubiksCube> getAllRubiksCube() throws SQLException{
Connection conn =DBHelper.getConnection();
		
		String query="SELECT * FROM rubiks_cube";
		Statement stmt=conn.createStatement();
		ArrayList<RubiksCube> results = new ArrayList<RubiksCube>();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int id= rs.getInt("id");
			String brand = rs.getString("brand");
			double weight = rs.getDouble("weight");
			int sides = rs.getInt("sides");
			RubiksCube rc = new RubiksCube(id, brand, weight, sides);
			results.add(rc);
		}
		DBHelper.closeConnection();
		return results;
	}
	
	public static void displayAllRubiksCube() throws SQLException {
		ArrayList<RubiksCube> allRubiksCubes = getAllRubiksCube();
		for(RubiksCube rc : allRubiksCubes) {
			displayRubiksCube(rc);
		}
	}
	
	public static void updateWeightById(double newWeight,int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "UPDATE rubiks_cube SET weight = ? WHERE id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setDouble(1,newWeight);
		stmt.setInt(2, id);
		stmt.execute();
		System.out.println("Weight of Rubiks Cube with id "+id+" was set to "+newWeight);
	}
	
	public static void createNewRubiksCube(RubiksCube rc) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "INSERT INTO rubiks_cube (brand, weight, sides) VALUES (?, ?, ?)";
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setString(1, rc.getBrand() );
		stmt.setDouble(2, rc.getWeight());
		stmt.setInt(3,rc.getSides());
		stmt.execute();
		System.out.println("New Rubiks Cube added into database!");
		
	}
	
	public static void deleteRubiksCubeById(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "DELETE FROM rubiks_cube WHERE id=?";
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.execute();
		System.out.println("Rubiks Cube with id "+id+" was deleted!");
	}
}