package ex;

public class Increment {
	int num = 0;

	void increment() {

		synchronized (this) {
			num++;
		}

	}

	int getNum() {
		return num;
	}

}
