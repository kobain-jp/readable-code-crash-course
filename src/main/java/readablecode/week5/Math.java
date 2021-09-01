package readablecode.week5;

public class Math {

	// TODO1 7.4
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

	public boolean isZero(int value) {
		// TODO2 7.3
		return 0 == value ? true : false;
	}

	public boolean isZero2(int value) {

		if (0 == value) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isZero3(int value) {

		return 0 == value;

	}

}
