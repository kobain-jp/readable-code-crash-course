package readablecode.week4;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import com.google.common.base.Strings;

public class MarkdownTableUtilsAnswerIdea2Function {

	private static final String PIPE = "|";
	private static final String HYPHEN = "-";
	private static final String SPACE = " ";

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
	 * @throws IllegalArgumentException if headerRowCation is empty or emptyRowount
	 *                                  is less than 1
	 *
	 */
	public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount)
			throws NullPointerException, IllegalArgumentException {

		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or 0");
		}

		String headerRow = createHeaderRow(headerRowCaptions);
		String separatorRow = createSeparatorRow(headerRowCaptions);
		String emptyRows = createEmptyRows(headerRowCaptions, emptyRowCount);

		return headerRow + separatorRow + emptyRows;

	}

	private static String createHeaderRow(List<String> headerRowCaptions) {
		return convertCaptionAndCreateRow(headerRowCaptions, caption -> caption);
	}

	private static String createSeparatorRow(List<String> headerRowCaptions) {
		return convertCaptionAndCreateRow(headerRowCaptions, caption -> Strings.repeat(HYPHEN, caption.length()));
	}

	private static String createEmptyRows(List<String> headerRowCaptions, int emptyRowCount) {
		return Strings.repeat(createEmptyRow(headerRowCaptions), emptyRowCount);
	}

	private static String createEmptyRow(List<String> headerRowCaptions) {
		return convertCaptionAndCreateRow(headerRowCaptions, caption -> Strings.repeat(SPACE, caption.length()));
	}

	private static String convertCaptionAndCreateRow(List<String> captions, Function<String, String> converter) {
		StringBuilder row = new StringBuilder();
		for (String caption : captions) {
			row.append(PIPE);
			row.append(converter.apply(caption));
		}
		row.append(PIPE);
		row.append(System.lineSeparator());

		return row.toString();

	}

}
