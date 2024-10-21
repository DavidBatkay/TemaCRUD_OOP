package ro.emanuel.rubiks.main;

import java.sql.SQLException;

import ro.emanuel.rubiks.dao.*;
import ro.emanuel.rubiks.pojo.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		rubiksCubeOperations();
		mousepadOperations();
		medicineOperations();
	}
	
	public static void rubiksCubeOperations() throws SQLException {
		RubiksCube rc1 = new RubiksCube(1,"Gucci", 40.2, 6);
		RubiksCube rc2 = new RubiksCube(2,"Louis Vuitton", 60.5, 12);
		RubiksCubeDAO.createNewRubiksCube(rc1);
		RubiksCubeDAO.createNewRubiksCube(rc2);
		
		RubiksCubeDAO.displayAllRubiksCube();
		RubiksCubeDAO.updateWeightById(50.5, 2);
		RubiksCube rc3 = new RubiksCube(3,"ToBeDeleted", 99.9, 1);
		RubiksCubeDAO.deleteRubiksCubeById(3);
	}
	
	public static void mousepadOperations() throws SQLException {
		Mousepad m1 = new Mousepad(1, "Pink", 10.8, false);
		Mousepad m2 =  new Mousepad(2,"Matte Black" , 80.1, true);
		MousepadDAO.createNewMousepad(m1);
		MousepadDAO.createNewMousepad(m2);
		
		MousepadDAO.displayAllMousepads();
		MousepadDAO.updateColorById("Red", 1);
		Mousepad m3 = new Mousepad(3, "Green", 12.1, false);
		MousepadDAO.deleteMousepadById(3);
	}

	public static void medicineOperations() throws SQLException {
	    Medicine med1 = new Medicine(1, "Aspirin", 50, true);
	    Medicine med2 = new Medicine(2, "Ibuprofen", 100, false);
	    MedicineDAO.createNewMedicine(med1);
	    MedicineDAO.createNewMedicine(med2);
	    
	    MedicineDAO.displayAllMedicines();
	    MedicineDAO.updateQuantityById(75, 2);
	    Medicine med3 = new Medicine(3, "Paracetamol", 200, false);
	    MedicineDAO.deleteMedicineById(3);
	}

}
