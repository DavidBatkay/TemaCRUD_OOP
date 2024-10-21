package ro.emanuel.rubiks.pojo;

public class Mousepad {

	private int id;
	private String color;
	private double diagonal;
	private boolean isRGB;
	
	public Mousepad(int id, String color, double diagonal, boolean isRGB) {
		super();
		this.id = id;
		this.color = color;
		this.diagonal = diagonal;
		this.isRGB = isRGB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}

	public boolean isRGB() {
		return isRGB;
	}

	public void setRGB(boolean isRGB) {
		this.isRGB = isRGB;
	}
	
	
	
	
}
