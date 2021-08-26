package readablecode.week1;

public class StringsAnswer {

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
