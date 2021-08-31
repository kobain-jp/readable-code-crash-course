package readablecode.week4;

import java.util.List;
import java.util.Objects;

import com.google.common.base.Strings;

public class MarkdownTableUtilsAnswerIdea2 {

	private static final String PIPE = "|";
	private static final String HYPHEN = "-";
	private static final String SPACE = " ";

	/**
	 * Returns the string of table which has empty rows as Markdown table syntax.
	 * length of captions for separator cell and empty cell is same with their
	 * header captions
	 * 
	 * @param headerRowCaptions the captions for header row
	 * @param emptyRowCount     the number of empty rows.
	 * 
	 * @return the string of table which has empty rows as Markdown table
	 * 
	 * @throws NullPointerException     if headerRowCaptions is null
	 * @throws IllegalArgumentException if headerRowCaptions is empty
	 * @throws IllegalArgumentException if emptyRowCount is less than 1
	 * 
	 */
	public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount) {
		// validate args
		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or 0");
		}

		String headerRows = createHeaderRow(headerRowCaptions);
		String separatorRow = createSeparatorRow(headerRowCaptions);
		String emptyRows = createEmptyRows(headerRowCaptions, emptyRowCount);

		return headerRows + separatorRow + emptyRows;

	}

	private static String createHeaderRow(List<String> captions) {
		return convertCaptionAndCreateRow(captions, false, null);
	}

	private static String createSeparatorRow(List<String> captions) {
		return convertCaptionAndCreateRow(captions, true, HYPHEN);
	}

	private static String createEmptyRows(List<String> captions, int emptyRowCount) {
		StringBuilder emptyRows = new StringBuilder();
		for (int i = 0; i < emptyRowCount; i++) {
			emptyRows.append(convertCaptionAndCreateRow(captions, true, SPACE));
		}
		return emptyRows.toString();
	}

	// Anti pattern
	// https://moderatemisbehaviour.github.io/clean-code-smells-and-heuristics/general/g15-selector-arguments.html
	// createRow(captions, false, null); hard to understand what is false and null
	private static String convertCaptionAndCreateRow(List<String> captions, boolean shouldReplaceWithRepeatedCaption,
			String repeatedChar) {
		StringBuilder row = new StringBuilder();

		for (String caption : captions) {
			row.append(PIPE);
			if (shouldReplaceWithRepeatedCaption) {
				row.append(Strings.repeat(repeatedChar, caption.length()));
			} else {
				row.append(caption);
			}

		}
		row.append(PIPE);
		row.append(System.lineSeparator());

		return row.toString();
	}

}
