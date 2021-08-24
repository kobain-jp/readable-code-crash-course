package ch4.sec7;

import java.util.List;
import java.util.Objects;

public class MarkDownUtilsWeekTwo {
	// TODO8 : search DRY and OAOO on internet and find the code to use same method which you use

	// TODO9 : remove the comment and extract method - readable code 11.4

	// TODO10(IMO and you could skip it) : refactor the extracted method by removing StringBuilder Argument and return String
	// in order to privent the potential problems as follows
	// https://techacademy.jp/magazine/35137#sec5

	// TODO11 : find more repeated code and refactor them hint:|caption1|caption2|
	// you might need to create the method to create List which has caption for separator or brank column

	// TODO6 : add javadoc for public method by typing /** and return key method and
	// add @throws - Effective Java item 56
	public static String createEmptyTableWithHeader(List<String> headerCaptions, int emptyRowCount) {
		// validate args
		Objects.requireNonNull(headerCaptions, "headerCaptions must not be null");
		if (headerCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
		}

		StringBuilder markdownTable = new StringBuilder();
		// create header
		for (String e : headerCaptions) {
			markdownTable.append("|");
			markdownTable.append(e);
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// create separator
		for (String e : headerCaptions) {
			markdownTable.append("|");
			// TODO7 : use com.google.common.base.Strings to replace your code : readable
			// code 12.2 13.4
			// https://guava.dev/releases/19.0/api/docs/com/google/common/base/Strings.html
			for (int i = 0; i < e.length(); i++) {
				markdownTable.append("-");
			}
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// create empty rows
		for (int i = 0; i < emptyRowCount; i++) {
			for (String e : headerCaptions) {
				markdownTable.append("|");
				for (int j = 0; j < e.length(); j++) {
					markdownTable.append(" ");
				}
			}
			markdownTable.append("|");
			markdownTable.append(System.lineSeparator());
		}

		return markdownTable.toString();

	}

}
