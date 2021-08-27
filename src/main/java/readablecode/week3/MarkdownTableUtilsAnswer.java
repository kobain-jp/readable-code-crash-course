package readablecode.week3;

import java.util.List;
import java.util.Objects;

import com.google.common.base.Strings;

public class MarkdownTableUtilsAnswer {
	
	/**
	 * Returns the string of table which has empty rows as Markdown table syntax.
	 * length of captions for separator cell and empty cell is same with their
	 * header captions
	 * 
	 * 
	 * @param headerRowCaptions the captions for header row
	 * @param emptyRowCount     the number of empty rows.
	 * @return the string of table which has empty rows as Markdown table
	 * @throws NullPointerException     if headerRowCaptions is null
	 * @throws IllegalArgumentException if headerRowCaptions is empty
	 * @throws IllegalArgumentException if emptyRowCount is less than 1
	 */
	public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount) {
		// validate args
		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
		}

		String headerRows = createHeaderRows(headerRowCaptions);
		String emptyRows = createEmptyRows(headerRowCaptions, emptyRowCount);

		return headerRows + emptyRows;

	}

	private static String createEmptyRows(List<String> headerRowCaptions, int emptyRowCount) {
		StringBuilder markdownTable = new StringBuilder();
		for (int i = 0; i < emptyRowCount; i++) {
			for (String e : headerRowCaptions) {
				markdownTable.append("|");
				markdownTable.append(Strings.repeat(" ", e.length()));
			}
			markdownTable.append("|");
			markdownTable.append(System.lineSeparator());
		}
		return markdownTable.toString();
	}

	private static String createHeaderRows(List<String> headerRowCaptions) {
		// create line for header row captions
		StringBuilder markdownTable = new StringBuilder();
		for (String e : headerRowCaptions) {
			markdownTable.append("|");
			markdownTable.append(e);
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// create line for header row separator
		for (String e : headerRowCaptions) {
			markdownTable.append("|");
			markdownTable.append(Strings.repeat("-", e.length()));

		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());
		return markdownTable.toString();
	}

}
