package java2503.basic.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataTest {

	public static void main(String[] args) {

		File file = new File("D:\\java2503\\files\\data.dat");

		// 기본타입 8가지와 문자열을 바이트단위로 출력하는 스트림
		DataOutputStream dos = null ;

		try {

			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeInt(20); // 4바이트 int
			dos.writeBoolean(false); // 1바이트 boolean
			dos.writeFloat(3.14f); // 4바이트 float
			dos.writeUTF("안녕"); // String

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		DataInputStream dis = null;

		try {

			dis = new DataInputStream(new FileInputStream(file));

			// DataOutputStream으로 출력한 순서대로 DataInputStream으로 읽어야 함
			System.out.println(dis.readInt());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readFloat());
			System.out.println(dis.readUTF());

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}






















	}

}
