package ch4.sec7;

import java.util.List;

public class MarkDownUtils {
	// TODO1 : use early return:Readable code 7.5, 7.7 and remove the 1 nest(you might need to change if condition)
	// * you do not need to improve exception handling
	// TODO2 : add line break after you read Readable code 4.7
	// TODO3 : re-name the variables after you read Readable code 2.7
	// TODO4 : re-name method as it is after you read Readable code 3.0, 3.9
	// TODO5 : move the variables after you read Readable code 9.2(定義の位置を下げる）
	// TODO6 : use com.google.common.base.Strings to replace your code after you read Readable code 12.2 and search DRY and OAOO on internet
	// TODO7 : find repeated coding which does not follow DRY and OAOO and extract method and follow them.
	// TODO8 : extract method after you read Readable code 11.1
	public static String createTables(List<String> l, int c) throws IllegalArgumentException {
		if (l != null && !l.isEmpty() && c > 0) {
			StringBuilder tmp = new StringBuilder();
			String sepCaption;
			String brCapt;
			for (String e : l) {
				tmp.append("|");
				tmp.append(e);
			}
			tmp.append("|");
			tmp.append(System.lineSeparator());
			for (String e : l) {
				tmp.append("|");
				sepCaption = "";
				for (int i = 0; i < e.length(); i++) {
					sepCaption += "-";
				}
				tmp.append(sepCaption.toString());
			}
			tmp.append("|");
			tmp.append(System.lineSeparator());
			for (int i = 0; i < c; i++) {
				for (String e : l) {
					tmp.append("|");
					brCapt = "";
					for (int j = 0; j < e.length(); j++) {
						brCapt += " ";
					}					
					tmp.append(brCapt);
				}
				tmp.append("|");
				tmp.append(System.lineSeparator());
			}
			String result = tmp.toString();
			return result;
		} else {
			throw new IllegalArgumentException("");
		}
	}

}
