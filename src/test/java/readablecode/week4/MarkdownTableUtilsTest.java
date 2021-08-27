package readablecode.week4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

class MarkdownTableUtilsTest {

	@Test
	@DisplayName("第一引数がnullの場合にNullPointerException")
	void testCreateEmptyTable_ColumnCaptionIsNull() {

		String EXPECTED_ERROR_MSG = "headerCaptions must not be null";

		Throwable exception = Assertions.assertThrows(NullPointerException.class, () -> {
			MarkdownTableUtils.createEmptyTable(null, 1);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));
	}

	@Test
	@DisplayName("第一引数が空のリストの場合にIllegalArgumentException")
	void testCreateEmptyTable_ColumnCaptionIsEmpty() {

		String EXPECTED_ERROR_MSG = "headerCaptions must have one more elements";

		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkdownTableUtils.createEmptyTable(new ArrayList<String>(), 1);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));
	}

	@Test
	@DisplayName("第一引数が要素を持つリスト かつ 第二引数が0以下の場合にIllegalArgumentException")
	void testCreateEmptyTable_EmptyRowCountIsZero() {

		String EXPECTED_ERROR_MSG = "emptyRowCount must be greater than or equal to 1";

		List<String> headerCaptions = new ArrayList<String>();
		headerCaptions.add("COL1");

		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkdownTableUtils.createEmptyTable(headerCaptions, 0);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkdownTableUtils.createEmptyTable(headerCaptions, -1);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));
	}

	@Test
	@DisplayName("単数のカラムと値が空の行を1行を持つテーブル")
	void testCreateEmptyTable_SingleColumnWithSingleEmptyRow() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("Name");
		int emptyRowCount = 1;
		String actualMarkDownText = MarkdownTableUtils.createEmptyTable(columnCaptions, emptyRowCount);

		String line1 = "|Name|" + System.lineSeparator();
		String line2 = "|----|" + System.lineSeparator();
		String line3 = "|    |" + System.lineSeparator();

		assertThat(actualMarkDownText, is(line1 + line2 + line3));

	}

	@Test
	@DisplayName("複数のカラムと値が空の行を複数行持つテーブル")
	void testCreateEmptyTable_MultipleColumnWithMultipleEmptyRows() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("Name", "Quantity");
		int emptyRowCount = 2;
		String actualMarkDownText = MarkdownTableUtils.createEmptyTable(columnCaptions, emptyRowCount);

		String line1 = "|Name|Quantity|" + System.lineSeparator();
		String line2 = "|----|--------|" + System.lineSeparator();
		String line3 = "|    |        |" + System.lineSeparator();
		String line4 = "|    |        |" + System.lineSeparator();

		assertThat(actualMarkDownText, is(line1 + line2 + line3 + line4));

	}

}
