package ch7.sec5;

public final class Strings {

	// TODO2: refactor this constructor after you read effective java item 4 / 
	public Strings() {

	} 

	// TODO1: refactor this method after you read Readable Code 7.5 and 7.7
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
