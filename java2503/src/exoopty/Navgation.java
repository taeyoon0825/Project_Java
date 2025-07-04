package exoopty;

public class Navgation {

	private String brand;
	private String type;
	private int price;
	
	public Navgation() {
	}

	public Navgation(String brand, String type, int price) {
		super();
		this.brand = brand;
		this.type = type;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "브랜드: "+brand+"타입: "+type+"가격: "+price;
	}
	
}
