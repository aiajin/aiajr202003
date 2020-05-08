package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	public static void main(String[] args) {

		InputStream in = null;
		OutputStream out = null;

		int copyByte = 0;
		int bData;

		try {

			// 원본 파일의 데이터를 프로그램안으로 가져와야한다.
			// => InputStream 인스턴스 생성
			in = new FileInputStream("test.txt");

			// 새로운 파일을 생성
			// => OutputStream 인스턴스 생성
			out = new FileOutputStream("copy.txt");

			while (true) {

				bData = in.read();

				if (bData == -1) {
					break;
				}
				out.write(bData);
				copyByte++;

			}
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("복사된 바이트 크기 : " + copyByte);

	}

}
