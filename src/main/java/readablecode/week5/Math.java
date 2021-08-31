package readablecode.week5;

public class Math {

	// TODO1 7.4 
	public boolean isNagativeValue(int value) {

		if (0 > value) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isPositiveValue(int value) {

		if (value > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isZero(int value) {
		// TODO2 7.3
		return 0 == value ? true : false;
	}

}
