package java2503.basic.api;

public class ObjectTest {

	public static void main(String[] args) {

		Person person = new Person("홍길동", 20);
		System.out.println(person.hashCode());
		System.out.println(person);

		// clone된 객체는 같은 내용을 가진 다른 객체
		// clone 메소드는 왜 있지? => 동일한 내용의 객체를 빠르게 생성하는 장점

		// clone 메소드 호출시 클론이 지원되지 않으면 예외발생하므로 예외처리 해야 함
		try {
			// clone 메소드는 Object를 반환하므로 Person으로 하위형변환 해야 함
			Person clone = (Person)person.clone();
			System.out.println(clone.hashCode());
			System.out.println(clone);
		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}





	} // main

}
