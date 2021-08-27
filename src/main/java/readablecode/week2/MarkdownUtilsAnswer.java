package readablecode.week2;

import java.util.List;

public class MarkdownUtilsAnswer {

	public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount) {
		// validate args
		if (headerRowCaptions == null || headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must not null and must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
		}

		StringBuilder markdownTable = new StringBuilder();
		// create line for header row captions
		for (String e : headerRowCaptions) {
			markdownTable.append("|");
			markdownTable.append(e);
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// create line for header row separator
		for (String e : headerRowCaptions) {
			markdownTable.append("|");
			for (int i = 0; i < e.length(); i++) {
				markdownTable.append("-");
			}

		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// create lines for empty rows
		for (int i = 0; i < emptyRowCount; i++) {
			for (String e : headerRowCaptions) {
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
