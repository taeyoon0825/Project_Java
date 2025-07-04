package java2503.basic.api;

// 1. 클래스의 객체가 복제되려면 Cloneable 인터페이스를 구현해야 함
// Cloneable : 복제가능한 클래스임을 표시하는 역할을 하는 마커인터페이스
public class Person implements Cloneable {

	String name;
	int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 2. 복제 가능하려면 Object의 clone 메소드를 오버라이딩 해야 함
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// Object 의 finlaize를 오버라이딩해야만 finalize를 호출 할 수있음
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	// Object의 toString을 오버라이딩
	@Override
	public String toString() {
		return this.name + " " + this.age;
	}

	// Object의 equals를 오버라이딩
	// 두 객체가 메모리의 다른곳에 있더라도 (= 참조가 다르더라도) name과 age가 모두 같다면 true 를 반환
	@Override
	public boolean equals(Object obj) {
		return ((Person)obj).name.equals(this.name) && ((Person)obj).age==this.age;
	}









}
