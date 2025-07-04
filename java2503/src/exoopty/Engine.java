package exoopty;

public class Engine {

	private String brand;
	private String cilender;
	private String hp;
	private String tune;
	private int price;
	
	public Engine() {
	}

	public Engine(String brand, String cilender, String hp, String tune, int price) {
		super();
		this.brand = brand;
		this.cilender = cilender;
		this.hp = hp;
		this.tune = tune;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCilender() {
		return cilender;
	}

	public void setCilender(String cilender) {
		this.cilender = cilender;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getTune() {
		return tune;
	}

	public void setTune(String tune) {
		this.tune = tune;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "브랜드: "+brand+"기통: "+cilender+"마력: "+hp+"튜닝여부: "+tune+"가격"+price;
	}
	
	
}
