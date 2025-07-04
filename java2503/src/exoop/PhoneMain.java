package exoop;

public class PhoneMain {
	
	public static void main(String[] args) {
		Display display = new Display("2560 × 1440","LED",17);
		Camera camera = new Camera("전면", "1200만", "디지털줌" );
		Storage storage = new Storage("ufs",128, 256);
		Application app = new Application("계산기", "Apple");
		Os os = new Os("ios","Apple",18);
		
		Phone phone = new Phone("애플", "iphone16", 8000, "KT", display, camera, storage, app, os);
		
		System.out.println(phone);
		System.out.println(display);
		System.out.println(camera);
		System.out.println(app);
		System.out.println(os);
		System.out.println(storage);
	}
}
