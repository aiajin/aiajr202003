package ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringReader {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("news.txt");
		
		BufferedReader br = new BufferedReader(fr);
		
		String str = null;
		
		while(true) {
			str = br.readLine();
			
			if(str==null) {
				break;
			}
			
			System.out.println(str);
			
		}
		
		br.close();

	}

}









