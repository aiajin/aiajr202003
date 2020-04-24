package ex;

public class InstanceOf {

	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);

	}

	public static void wrapBox(Box box) {
		
		box.wrap();
		
//		if (box instanceof GoldPaperBox)
//			((GoldPaperBox) box).goldWrap();
//		else if (box instanceof PaperBox)
//			((PaperBox) box).paperWrap();
//		else
//			box.simpleWrap();
	}

}

class Box {
	public void simpleWrap() {
		System.out.println("simple wrap");
	}
	
	public void wrap() {
		System.out.println("simple wrap");
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("paper wrap");
	}

	@Override
	public void wrap() {
		System.out.println("paper wrap");
	}
	
	
}

class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("gold wrap");
	}

	@Override
	public void wrap() {
		System.out.println("gold wrap");
	}
	
	
}









