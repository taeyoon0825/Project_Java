package exoop;

public class Camera {

	private String type;
	private String pixel;
	private String zoom;

	public Camera() {
	}

	public Camera(String type, String pixel, String zoom) {
		super();
		this.type = type;
		this.pixel = pixel;
		this.zoom = zoom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPixel() {
		return pixel;
	}

	public void setPixel(String pixel) {
		this.pixel = pixel;
	}

	public String getZoom() {
		return zoom;
	}

	public void setZoom(String zoom) {
		this.zoom = zoom;
	}
	@Override
	public String toString() {
	   return "타입: " + type + ", 화소: " + pixel + ", 줌: " + zoom;
	}

	
	
	
	
	
	
}

