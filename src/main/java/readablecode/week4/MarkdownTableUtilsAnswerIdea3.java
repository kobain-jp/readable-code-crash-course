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

		String headerRow = createHeaderRows(headerRowCaptions);
		String separatorRow = createSeparatorRow(headerRowCaptions);
		String emptyRows = createEmptyRows(headerRowCaptions, emptyRowCount);

		return headerRow + separatorRow + emptyRows;
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

	// idea3 
	// セパレータと空白行の処理の仕方を変更することにより、createRowを利用する
	// 元のロジック
	// SringBuilderに|をアペンド -> headerRowCaptionsから一つ取り出しStrings.repeatでアペンドする値を作成し、アペンド 
	// SringBuilderに|をアペンド
	// 処理の仕方を変更
	// headerRowCaptionsをもとにList<String> separatorCaptions/emptyCaptionsを作成する:createCaptionsReplacedByRepeatedChar
	// 作成したseparatorCaptions/emptyCaptionsをcreateRowに渡す
	// ループ回数が増えるので時と場合により採用すべき
	private static String createRow(List<String> captions) {
		return PIPE + String.join(PIPE, captions) + PIPE + System.lineSeparator();
	}

	//adapter method for separator row and empty row to use createRow
	private static List<String> createCaptionsReplacedByRepeatedChar(List<String> captions, String repeatedChar) {
		return captions.stream().map(caption -> Strings.repeat(repeatedChar, caption.length())).collect(Collectors.toList());

	}

}
