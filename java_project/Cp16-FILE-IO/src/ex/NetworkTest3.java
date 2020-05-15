package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkTest3 {

	public static void main(String[] args) {

		URL url = null;
		String address = "https://cafe.naver.com/aiajr202003";
		
		BufferedReader input = null;
		
		String line = "";
		
		try {
			
			url = new URL(address);
			
			
			input = new BufferedReader(
					new InputStreamReader(
							url.openStream()));
			
			while(true) {
				
				line = input.readLine();
				if(line==null) {
					break;
				}
				
				System.out.println(line);
				
			}
			
			input.close();
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
