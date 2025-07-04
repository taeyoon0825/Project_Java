package java2503.basic.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URITest {

	public static void main(String[] args) {

		// 1. URI 객체 생성
		try {
		URI uri =new URI("https://koreaitacademy.com");

		// 2. URL 객체 생성
		URL url = uri.toURL();

		// 3. URLConnection 객체 생성
		URLConnection conn = url.openConnection();

		// 4. InputStream 객체 생성
		InputStream is = conn.getInputStream();

		// 5. 문자들을 읽을 경우 InputStream을 Reader로 변환 (데이터가 많을 경우 5번 생략가능)
		InputStreamReader isr = new InputStreamReader(is, "EUC-KR");

		// 6. 데이터가 많은 경우 BufferedReader 생성 (데이터가 적을 경우 6번 생략가능)
		BufferedReader br = new BufferedReader(isr);


// 데이터 읽어서 출력
//		String readLine = "";
//		while ((readLine=br.readLine()) !=null) {
//			System.out.println(readLine);
//		}

		File file =new File("D:\\java2503\\eclipse_workspace\\java2503\\java2503\\src\\java2503\\basic\\network\\koreaitacademy.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		String readLine ="";
		while ((readLine=br.readLine()) !=null) {
			bw.write(readLine);
			bw.newLine();
		}



		} catch (Exception ex) {
			ex.printStackTrace();
		}







	} // main

} // class
