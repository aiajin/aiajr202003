package ex;

public class AccessWayMain {

	public static void main(String[] args) {
		
		System.out.println(AccessWay.num);
		AccessWay.num++;
		System.out.println(AccessWay.num);
		
		AccessWay ac = new AccessWay();
		
		System.out.println(ac.num2);
		System.out.println(ac.num);
		
	}

}
