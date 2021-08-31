package readablecode.week4.idea1strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MarkdownTableUtilsAnswerIdea1 {

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
		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or 0");
		}

		// create rows
		List<Row> rows = new ArrayList<Row>();
		rows.add(new HeaderRow(headerRowCaptions));
		rows.add(new SeparatorRow(headerRowCaptions));
		for (int i = 0; i < emptyRowCount; i++) {
			rows.add(new EmptyRow(headerRowCaptions));
		}

		// rows to string
		StringBuilder markdownTable = new StringBuilder();
		for (Row row : rows) {
			markdownTable.append(row.toString());
		}

		return markdownTable.toString();

	}

}
