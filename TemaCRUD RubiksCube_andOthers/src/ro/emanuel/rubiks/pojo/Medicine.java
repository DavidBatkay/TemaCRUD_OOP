package ro.emanuel.rubiks.pojo;

public class Medicine {

	private int id;
	private String name;
	private int quantity;
	private boolean needsPrescription;
	
	public Medicine(int id, String name, int quantity, boolean needsPrescription) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.needsPrescription = needsPrescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isNeedsPrescription() {
		return needsPrescription;
	}

	public void setNeedsPrescription(boolean needsPrescription) {
		this.needsPrescription = needsPrescription;
	}
	
	
	
}
