package readablecode.week5;

public class Math {

	// TODO1 7.4 which way do you prefer between 1 and 2
	public boolean isNagativeValue1(int value) {
		if (0 > value) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isNagativeValue2(int value) {
		if (value < 0) {
			return true;
		} else {
			return false;
		}
	}

	// TODO2 7.4 which way do you prefer between 1, 3 and 4
	public boolean isNagativeValue3(int value) {
		// TODO2 7.3
		return 0 == value ? true : false;
	}

	public boolean isNagativeValue4(int value) {
		return value < 0;
	}

}
