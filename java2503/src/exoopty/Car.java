package exoopty;

public class Car {

	private String brand;
	private String name;
	private int price;
	private String type;
	private Break br;
	private Engine engine;
	private Wheel wheel;
	private Speaker speaker;
	private Navgation navgation;
	
	public Car() {
	}

	public Car(String brand, String name, int price, String type, Break br, Engine engine, Wheel wheel,
			Speaker speaker, Navgation navgation) {
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.type = type;
		this.br = br;
		this.engine = engine;
		this.wheel = wheel;
		this.speaker = speaker;
		this.navgation = navgation;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Break getBr() {
		return br;
	}

	public void setBr(Break br) {
		this.br = br;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public Navgation getNavgation() {
		return navgation;
	}

	public void setNavgation(Navgation navgation) {
		this.navgation = navgation;
	}
	
	@Override
	public String toString() {  // 브레이크부터 수정필요
		return "브랜드: " + brand + "이름: "+name+"가격: "
	+price+"종류: "+type+"브레이크: "+ getBr().getBrand() +"엔진: "+ getEngine().getBrand()
	+"휠: "+ getWheel().getBrand()+"스피커: "+getSpeaker().getBrand()+"네비게이션: "+getNavgation().getBrand();
	}
	
	
	
	
}
