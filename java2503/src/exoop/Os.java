package exoop;

public class Os {

	private String name;
	private String developer;
	private int version;

	public Os() {
	}

	public Os(String name, String developer, int version) {
		super();
		this.name = name;
		this.developer = developer;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	   public String toString() {
	      return "이름: " + name + ", 개발자: " + developer + ", 버전: " + version;
	   }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	