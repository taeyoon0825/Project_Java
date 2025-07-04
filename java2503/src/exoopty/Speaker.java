package exoopty;

public class Speaker {

	private String brand;
	private String tune;
	private String premium;
	private int price;
	
	public Speaker() {
	}

	public Speaker(String brand, String tune, String premium, int price) {
		super();
		this.brand = brand;
		this.tune = tune;
		this.premium = premium;
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

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "브랜드: "+brand+"튜닝여부: "+tune+"기기분류: "+premium+"가격: "+price;
	}
	
}
