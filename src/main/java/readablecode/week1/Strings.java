package readablecode.week1;

public class Strings {

	// TODO 1: 7.5,7.7 and 9.1
	public static String capitalize(String str) {

		if (str == null) {
			return null;
		}

		if (str.isEmpty()) {
			return str;
		}

		if (str.length() == 1) {
			return str.toUpperCase();
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}

		//もともとのコード
		//		String ret = str;
		//		if (str == null) {
		//			ret = str;
		//		} else if (str.length() == 0) {
		//			ret = str;
		//		} else {
		//			if (str.length() == 1) {
		//				ret = str.toUpperCase();
		//			} else {
		//				ret = str.substring(0, 1).toUpperCase() + str.substring(1);
		//			}
		//		}
		//		return ret;
	}
}
