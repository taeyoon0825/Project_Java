package exoopty;

public class CarMain {

	public static void main(String[] args) {
		
		Break br = new Break("Endless", "스포츠브레이크", 2000);
		Engine engine = new Engine("AMG", "V8", "612hp", "순정", 30000);
		Wheel wheel = new Wheel("BBS", "튜닝완료", "알루미늄 휠", "스포크 타입", 5000);
		Speaker speaker = new Speaker("BOSE", "순정", "보급형", 1500);
		Navgation navgation = new Navgation("AMG", "track", 4000);
		
		Car car = new Car("벤츠", "S 63AMG Cuope", 70000, "SportsCar", br, engine, wheel, speaker, navgation);
		
		System.out.println(car);
		System.out.println(br);
		System.out.println(engine);
		System.out.println(wheel);
		System.out.println(speaker);
		System.out.println(navgation);
		
	}
	
}
