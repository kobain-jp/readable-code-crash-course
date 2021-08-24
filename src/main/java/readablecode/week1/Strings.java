package readablecode.week1;

// TODO 3: add more signature after you read effective java item 17 
public class Strings {

	// TODO 2: refactor this constructor after you read effective java item 4
	public Strings() {

	} 

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
