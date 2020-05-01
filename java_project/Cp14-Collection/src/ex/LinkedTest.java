package ex;

public class LinkedTest {

	public static void main(String[] args) {
		
		String str1 = "one";
		String str2 = "two";
		String str3 = "three";
		String str4 = "four";
				
		Data d1 = new Data(str1, str2);
		
		Data d2 = new Data(str2, str3);
		Data d3 = new Data(str3, null);
		
		
		// 중간에 삽입		
		Data d4 = new Data(str4, str2);
		d1.setNextValue(str4);
		
		
		
		

	}

}


class Data{
	
	Object value;
	Object nextValue;
	
	
	Data(Object obj, Object nextObj){
		this.value = obj;
		this.nextValue = nextObj;
	}
	
	Object getValue() {
		return value;
	}
	
	void setNextValue(Object nextvalue) {
		this.nextValue = nextvalue;
	}
	
	
	
}












