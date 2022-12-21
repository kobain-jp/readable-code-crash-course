package readablecode.week1;

public class Strings {

	public static String capitalize(String str) {
		if (str == null || str == "") {
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
