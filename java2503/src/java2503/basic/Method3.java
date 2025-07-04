package java2503.basic;

import java2503.basic2.Basic2Method3;

public class Method3 {

	public static void main(String[] args) {

		// 접근지정자=접근제한자=접근한정자(access modifier)
		// public : 모든 패키지의 모든 클래스에서 접근 가능
		// protected : 동일 패키지의 모든 클래스 또는 다른 패키지에 있더라도 상속관계 있는 클래스에서 접근 가능
		// default : 동일 패키지의 모든 클래스에서 접근 가능
		// private : 클래스 내에서만 접근 가능

		//클래스 앞에는 public 또는 default 사용 가능
		// 생성자, 변수 (프라퍼티), 메소드 앞에는 4가지 모두 사용가능

		// java2503.basic2 패키지에 있는 Basic2Method3 클래스의 객체를 생성
		Basic2Method3 bm = new Basic2Method3();

		bm.publicMethod();




	} // main

} // class
