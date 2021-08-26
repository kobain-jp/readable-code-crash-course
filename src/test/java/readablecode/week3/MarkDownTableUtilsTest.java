package readablecode.week3;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

class MarkDownTableUtilsTest {

	@Test
	@DisplayName("第一引数がnullの場合にNullPointerException")
	void testCreateEmptyTable_ColumnCaptionIsNull() {

		String EXPECTED_ERROR_MSG = "headerCaptions must not be null";

		Throwable exception = Assertions.assertThrows(NullPointerException.class, () -> {
			MarkDownTableUtils.createEmptyTable(null, 1);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));
	}

	@Test
	@DisplayName("第一引数が空のリストの場合にIllegalArgumentException")
	void testCreateEmptyTable_ColumnCaptionIsEmpty() {

		String EXPECTED_ERROR_MSG = "headerCaptions must have one more elements";

		Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkDownTableUtils.createEmptyTable(new ArrayList<String>(), 1);
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
			MarkDownTableUtils.createEmptyTable(headerCaptions, 0);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkDownTableUtils.createEmptyTable(headerCaptions, -1);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));
	}

	@Test
	@DisplayName("単数のカラムと値が空の行を1行を持つテーブル")
	void testCreateEmptyTable_SingleColumnWithSingleEmptyRow() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("COL1");
		int emptyRowCount = 1;
		String actualMarkDownText = MarkDownTableUtils.createEmptyTable(columnCaptions, emptyRowCount);

		String expectedHeader = "|COL1|" + System.lineSeparator();
		String expectedSeparator = "|----|" + System.lineSeparator();
		String expectedRecoreds = "|    |" + System.lineSeparator();
		String expectedMarkDownText = expectedHeader + expectedSeparator + expectedRecoreds;

		assertThat(actualMarkDownText, is(expectedMarkDownText));

	}

	@Test
	@DisplayName("複数のカラムと値が空の行を複数行持つテーブル")
	void testCreateEmptyTable_MultipleColumnWithMultipleEmptyRows() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("COL1", "COL2");
		int emptyRowCount = 2;
		String actualMarkDownText = MarkDownTableUtils.createEmptyTable(columnCaptions, emptyRowCount);

		String expectedHeader = "|COL1|COL2|" + System.lineSeparator();
		String expectedSeparator = "|----|----|" + System.lineSeparator();
		String expectedRecoreds = "|    |    |" + System.lineSeparator() + "|    |    |" + System.lineSeparator();

		assertThat(actualMarkDownText, is(expectedHeader + expectedSeparator + expectedRecoreds));

	}

}
