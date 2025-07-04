package exoop;

public class Application {

	private String name;
	private String developer;

	public Application() {
	}


	
	public Application(String name, String developer) {
		this.name = name;
		this.developer = developer;
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

	@Override
	public String toString() {
	   return "이름: " + name + ", 개발자: " + developer;
	}


	

}

