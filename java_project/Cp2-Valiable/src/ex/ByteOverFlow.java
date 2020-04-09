package ex;

public class ByteOverFlow {

	public static void main(String[] args) {
		
		byte b = 0;
		int i = 0;
		
		for(int x=0;x<270;x++) {
			System.out.print(b++);
			System.out.print("\t");
			System.out.println(i++);			
		}

	}

}
