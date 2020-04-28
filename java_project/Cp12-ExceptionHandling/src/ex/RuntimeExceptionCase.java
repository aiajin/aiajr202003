package ex;

public class RuntimeExceptionCase {

	public static void main(String[] args) {

		try {
			int[] arr = new int[3];
			arr[-3] = 20;
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		try {
			Object obj = new int[10];
			String str = (String) obj;
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());

		}

		try {
			int[] ar = new int[-10];
		} catch (NegativeArraySizeException e) {
			System.out.println(e.getMessage());
		}

		try {
			String str = null;
			int len = str.length();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

}
