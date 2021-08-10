package ch7.sec5;

public final class Strings {

	private Strings() {

	}

	// TODO: refactor this method after you read Readable Code 7.5
	public static String capitalize(String str) {
		String ret = str;
		if (str == null) {
			ret = str;
		} else if (str.length() == 0) {
			ret = str;
		} else {
			if (str.length() == 1) {
				ret = str.toUpperCase();
			} else {
				ret = str.substring(0, 1).toUpperCase() + str.substring(1);
			}
		}
		return ret;
	}

}
