package ch7.sec5;

public final class Strings {

	private Strings() {

	}

	// TODO: refactor this method after you read 7.5
	// TODO: read the implementation for substring and
	public static String capitalize(String str) {
		String ret = str;
		if (str == null) {
			ret = str;
		} else if (str.length() == 0) {
			ret = str;
		} else {
			if (str.length() == 1) {
				ret = str.substring(0, 1).toUpperCase();
			} else {
				ret = str.substring(0, 1).toUpperCase() + str.substring(1);
			}
		}
		return ret;
	}

}
