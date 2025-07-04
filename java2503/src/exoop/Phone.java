package exoop;

import exoopty.Break;
import exoopty.Engine;
import exoopty.Navgation;
import exoopty.Speaker;
import exoopty.Wheel;

public class Phone {

	private String brand;
	private String name;
	private int price;
	private String telecom;
	private Display display;
	private Camera camera;
	private Storage storage;
	private Application application;
	private Os os;

	public Phone() {
	}

	public Phone(String brand, String name, int price, String telecom, Display display, Camera camera, Storage storage,
			Application application, Os os) {
		super();
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.telecom = telecom;
		this.display = display;
		this.camera = camera;
		this.storage = storage;
		this.application = application;
		this.os = os;
		
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

	public String getTelecom() {
		return telecom;
	}

	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Os getOs() {
		return os;
	}

	public void setOs(Os os) {
		this.os = os;
	}

	@Override
	public String toString() {
		return  "브랜드: " + brand + "이름: " + name + ", 가격: " + price + ", 통신사: " + telecom 
				+ ", 디스플레이: " + getDisplay().getKind() + ", 카메라:" + getCamera().getPixel() 
				+ ",저장장치: " + getStorage().getAllCapacity(); + ",저장장치: " + getStorage().getAllCapacity() + ", 앱: " + getApplication().getName() 
				+ ", 운영체제: " + getOs().getVersion();
	}

// String brand, String name, int price, String type, Break br, Engine engine, Wheel wheel,
//	Speaker speaker, Navgation navgation	
}
