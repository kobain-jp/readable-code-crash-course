package readablecode.week2;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.google.common.collect.ImmutableList;

class MarkdownUtilsTest {

	@Test
	@DisplayName("第一引数がnullの場合にIllegalArgumentException")
	void testCreateTable_ColumnCaptionIsNull() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkdownUtils.createEmptyTable(null, 1);
		});

	}

	@Test
	@DisplayName("第一引数が空のリストの場合にIllegalArgumentException")
	void testCreateTable_ColumnCaptionIsEmpty() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkdownUtils.createEmptyTable(new ArrayList<String>(), 1);
		});

	}

	@ParameterizedTest(name = "第一引数が要素を持つリストで第二引数が0以下の場合にIllegalArgumentException")
	@ValueSource(ints = {0, -1})
	void testCreateTable_EmptyRowCountIsZero(int arg) {

		List<String> captions = new ArrayList<String>();
		captions.add("COL1");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkdownUtils.createEmptyTable(captions, arg);
		});
	}

	@Test
	@DisplayName("単数のカラムと値が空の行を1行を持つテーブル")
	void testCreateTable_SingleColumnWithSingleEmptyRow() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("COL1");
		int emptyRowCount = 1;
		String actualMarkDownText = MarkdownUtils.createEmptyTable(columnCaptions, emptyRowCount);

		String expectedHeader = "|COL1|" + System.lineSeparator();
		String expectedSeparator = "|----|" + System.lineSeparator();
		String expectedRecoreds = "|    |" + System.lineSeparator();
		String expectedMarkDownText = expectedHeader + expectedSeparator + expectedRecoreds;

		assertThat(actualMarkDownText, is(expectedMarkDownText));

	}

	@Test
	@DisplayName("複数のカラムと値が空の行を複数行持つテーブル")
	void testCreateTable_MultipleColumnWithMultipleEmptyRows() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("COL1", "COL2");
		int emptyRowCount = 2;
		String actualMarkDownText = MarkdownUtils.createEmptyTable(columnCaptions, emptyRowCount);

		String expectedHeader = "|COL1|COL2|" + System.lineSeparator();
		String expectedSeparator = "|----|----|" + System.lineSeparator();
		String expectedRecoreds = "|    |    |" + System.lineSeparator() + "|    |    |" + System.lineSeparator();

		assertThat(actualMarkDownText, is(expectedHeader + expectedSeparator + expectedRecoreds));

	}

}
