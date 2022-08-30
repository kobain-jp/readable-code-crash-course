package readablecode.week1;

public class Strings {

	// TODO 1: 7.5,7.7 and 9.1
	public static String capitalize(String str) {

		if (str == null || str.length() == 0) {
			return str;
		}

		if (str.length() == 1) {
			return str.toUpperCase();
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);

	}

}
