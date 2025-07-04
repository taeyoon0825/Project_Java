package java2503.basic.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintTest {

	public static void main(String[] args) {

		File file = new File("D:\\java2503\\files\\print.dat");

		PrintStream ps = null;

		try {

			// FileOutputStream으로 PrintStream 생성, true : autoflush 여부
			ps = new PrintStream(new FileOutputStream(file),true);
			ps.print("홍길동");
			ps.println("강감찬");
			ps.printf("%s은 %d살 입니다!","이순신", 30);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

		File file2 = new File("D:\\java2503\\files\\print2.txt");

		PrintWriter pw = null;

		try {

			pw = new PrintWriter(new FileWriter(file2), true);
			pw.print("안녕하세요!");
			pw.println("하이!");
			pw.printf("%s은 %d살 입니다!", "이순신", 30);


		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}


	}

}
