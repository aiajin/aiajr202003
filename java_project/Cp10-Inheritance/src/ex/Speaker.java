package ex;

public class Speaker {
	
	private int volumeRate;

	void showCurrentState() {
		System.out.println("볼륨의 크기 : "+this.volumeRate);
	}
	
	void setVolume(int vol) {
		this.volumeRate=vol;
	}

}
