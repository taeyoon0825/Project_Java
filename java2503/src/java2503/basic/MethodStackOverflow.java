package java2503.basic;

public class MethodStackOverflow {

	public static void main(String[] args) {
		// StackOverflowError 발생
		// main  > a > b > a > b > a... 스택 넘침! (순환 호출)
		a();
	}

	static void a() {
		System.out.println("a 메소드 호출됨!");
		b();
	}

	static void b() {
		System.out.println("b 메소드 호출됨!");
		a();
	}


}
