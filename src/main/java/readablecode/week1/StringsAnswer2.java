package readablecode.week1;

public class StringsAnswer2 {

	public static String capitalize(String str) {

		if (str == null || str.length() == 0) {
			return str;
		}

		// it work but not readable because reader might not know 'str.substring(1)' return ""
		// and might confirm substring logic
		return str.substring(0, 1).toUpperCase() + str.substring(1);

	}

}
