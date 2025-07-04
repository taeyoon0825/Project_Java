package exoop;

public class Display {

	private String resolution;
	private String kind;
	private int length;

	public Display() {
	}



	public Display(String resolution, String kind, int length) {
		super();
		this.resolution = resolution;
		this.kind = kind;
		this.length = length;
	}




	public String getResolution() {
		return resolution;
	}



	public void setResolution(String resolution) {
		this.resolution = resolution;
	}



	public String getKind() {
		return kind;
	}



	public void setKind(String kind) {
		this.kind = kind;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	@Override
	   public String toString() {
	      return "해상도: " + resolution + ", 종류: " + kind + ", 크기: " + length;
	   }


}
