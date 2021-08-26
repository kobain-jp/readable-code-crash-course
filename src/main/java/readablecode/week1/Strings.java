package readablecode.week1;

public class Strings {

	// TODO 1: refactor this method after you read Readable Code 7.5,7.7 and 9.1
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
