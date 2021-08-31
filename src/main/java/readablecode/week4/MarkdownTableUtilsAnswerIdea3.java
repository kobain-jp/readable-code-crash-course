package readablecode.week4;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

public class MarkdownTableUtilsAnswerIdea3 {

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

		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or 0");
		}

		String headerRows = createHeaderRows(headerRowCaptions);
		String separatorRow = createSeparatorRow(headerRowCaptions);
		String emptyRows = createEmptyRows(headerRowCaptions, emptyRowCount);

		return headerRows + separatorRow + emptyRows;
	}

	private static String createHeaderRows(List<String> headerRowCaptions) {
		return createRow(headerRowCaptions);
	}

	private static String createSeparatorRow(List<String> headerRowCaptions) {
		List<String> separatorCaptions = createCaptionsReplacedByRepeatedChar(headerRowCaptions, HYPHEN);
		return createRow(separatorCaptions);
	}

	private static String createEmptyRows(List<String> headerRowCaptions, int emptyRowCount) {
		List<String> emptyCaptions = createCaptionsReplacedByRepeatedChar(headerRowCaptions, SPACE);
		String emptyRow = createRow(emptyCaptions);
		return Strings.repeat(emptyRow, emptyRowCount);

	}

	private static String createRow(List<String> captions) {
		return PIPE + String.join(PIPE, captions) + PIPE + System.lineSeparator();
	}

	private static List<String> createCaptionsReplacedByRepeatedChar(List<String> captions, String repeatedChar) {
		return captions.stream().map(caption -> Strings.repeat(repeatedChar, caption.length())).collect(Collectors.toList());

	}

}
