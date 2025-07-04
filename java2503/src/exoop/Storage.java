package exoop;

public class Storage {

	private String type;
	private int capacity;
	private int allCapacity;

	public Storage() {
	}

	public Storage(String type, int capacity, int allCapacity) {
		super();
		this.type = type;
		this.capacity = capacity;
		this.allCapacity = allCapacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAllCapacity() {
		return allCapacity;
	}

	public void setAllCapacity(int allCapacity) {
		this.allCapacity = allCapacity;
	}

	
	@Override
	   public String toString() {
	      return "타입: " + type + ", 용량: " + capacity + ", 총용량: " + allCapacity;
	   }

	
	
}
