package java2503.basic;

public class Method1 {

	public static void main(String[] args) {

		// 메소드 호출 (Invocation 또는 Call)
		// 실행흐름 : JVM > main시작 > print시작 > print종료 > main종료
		print("Hello");

		// 실행흐름 JVM > main > print > println > main > println > add > main종료
		//           Method Call Stack
		 System.out.println (add(3, 5));







	} // main

	// default 접근제한 : 동일한 패키지내의 모든 클래스에서 접근 가능
	// static : 객체 생성 없이 클래스명으로 접근 가능 (= 객체가 없어도 사용가능)
	// void : 메소드 실행 후에 호출한 쪽으로 넘겨주는 값이 없음
	// print : 메소드 이름
	// string str : 메소드 실행에 필요한 문자열을 저장할 변수 (= method parameter, 메소드 파라미터)
	static void print(String str) { // str은 변수명 아무렇게나 지어도 됨
	System.out.println(str);
	// return 구문 뒤에 반환값이 있는 경우는 return 구문 생략 불가
	// return; 구문이 생략된 것! (모든 메소드는 return구문이 있음)
	}

	static int add(int a, int b) {
//     한번만 사용할 목적의 변수는 생성하지 않는 것이 코드 가독성에 좋다
//		int result = a + b;
//		return result;

		// int result = 100 / 0;


		return a + b ;
	}



} // class
