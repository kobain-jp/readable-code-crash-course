package readablecode.week2;

import java.util.List;

public class MarkdownUtils {
	// TODO1 : use early return:Readable code 7.5, 7.7 and remove the 1 nest(you
	// might need to change if condition and if condition is complicated such as
	// if(!(...)) please refactor it after you read 7.2)
	// * you do not need to improve exception handling

	// TODO2 : add line break and comment for each block/paragraph after you read
	// Readable code 4.7

	// TODO3 : re-name the variables after you read Readable code 2.2 2.7, 3.8

	// TODO4 : re-name method as it is after you read Readable code 3.0, 3.9

	// TODO5 : remove the unnecessary variable after you read Readable code 9.1

	public static String createEmptyTable(List<String> headerRowValue, int emptyRowCount) throws IllegalArgumentException {

		if (headerRowValue == null || headerRowValue.isEmpty() || emptyRowCount < 1) {
			throw new IllegalArgumentException("");
		}

		//ヘッダ行の値を追加
		StringBuilder markdownTable = new StringBuilder();
		for (String e : headerRowValue) {
			markdownTable.append("|");
			markdownTable.append(e);
		}

		//アラインメント行を追加
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());
		for (String e : headerRowValue) {
			markdownTable.append("|");
			for (int i = 0; i < e.length(); i++) {
				markdownTable.append("-");
			}
		}

		//データ行を追加
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());
		for (int i = 0; i < emptyRowCount; i++) {
			for (String e : headerRowValue) {
				markdownTable.append("|");
				for (int j = 0; j < e.length(); j++) {
					markdownTable.append(" ");
				}
			}
			markdownTable.append("|");
			markdownTable.append(System.lineSeparator());
		}

		//ヘッダ付きの
		return markdownTable.toString();
	}
}