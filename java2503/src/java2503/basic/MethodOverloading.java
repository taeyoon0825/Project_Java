package java2503.basic;

public class MethodOverloading {

	public static void main(String[] args) {

		// 오버로딩의 조건
		// 1. 반환타입이 같아야 함
		// 2. 메소드명이 같아야 함
		// 3. 파리미터리스트가 달라야 함 (개수, 타입, 순서 중 하나라도 달라야 함)

		printStr("Hello");

		printStr("Hello", 5);

		printStr("Hello", 5L);


	} // main

	static void printStr(String str) {
		System.out.println(str);
	}

	static void printStr(String str, int loopCount) {
		System.out.println("int");
		for (int i=0; i<loopCount; i++) {
			System.out.println(str);
		}
	}

	static void printStr(String str, long loopCount) {
		System.out.println("long");
		for (int i=0; i<loopCount; i++) {
			System.out.println(str);
		}
	}

} // class
