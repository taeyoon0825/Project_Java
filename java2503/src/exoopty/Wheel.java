package exoopty;

public class Wheel {

	private String brand;
	private String tune;
	private String type;
	private String design;
	private int price;
	
	public Wheel() {
	}

	public Wheel(String brand, String tune, String type, String design, int price) {
		super();
		this.brand = brand;
		this.tune = tune;
		this.type = type;
		this.design = design;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTune() {
		return tune;
	}

	public void setTune(String tune) {
		this.tune = tune;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "브랜드: "+brand+"튜닝여부: "+tune+"구성타입: "+type+"디자인: "+design+"가격: "+price;
	}
	
	
}
