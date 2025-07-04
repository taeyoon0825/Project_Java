package java2503.basic;

public class Method2 {

	public static void main(String[] args) {

		// print("Hello"); // 객체 생성없이 사용 불가

		// Method2타입의 객체를 생성
		Method2 method2 = new Method2();
		method2.print("Hello");


		// System.out.println(add(3, 5));

		System.out.println(method2.add(3, 5));



	} // main


	// non-static 메소드 : 객체를 생성해서 객체를 통해 호출할 수 있는 메소드
	void print(String str) {
		System.out.println(str);
	}

	int add(int a, int b) {
		return a + b;
	}


} // class
