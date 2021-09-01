package readablecode.week5.explanatoryvariable;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

import readablecode.week4.idea1strategy.MarkdownTableUtilsAnswerIdea1;

class MarkdownTableUtilsTest {

	// TODO5 14.5 14.6
	@Test
	void test1() {

		String EXPECTED_ERROR_MSG = "headerCaptions must not be null";

		Throwable exception = Assertions.assertThrows(NullPointerException.class, () -> {
			MarkdownTableUtils.createEmptyTable(null, 1);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));

		EXPECTED_ERROR_MSG = "headerCaptions must have one more elements";

		exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MarkdownTableUtilsAnswerIdea1.createEmptyTable(new ArrayList<String>(), 1);
		});
		assertThat(exception.getMessage(), is(EXPECTED_ERROR_MSG));
	}

	@Test
	void test2() throws IllegalArgumentException {

		List<String> columnCaptions = ImmutableList.of("Name", "Quantity");
		int emptyRowCount = 2;
		String actualMarkDownText = MarkdownTableUtilsAnswerIdea1.createEmptyTable(columnCaptions, emptyRowCount);

		String line1 = "|Name|Quantity|" + System.lineSeparator();
		String line2 = "|----|--------|" + System.lineSeparator();
		String line3 = "|    |        |" + System.lineSeparator();
		String line4 = "|    |        |" + System.lineSeparator();

		assertThat(actualMarkDownText, is(line1 + line2 + line3 + line4));

		columnCaptions = ImmutableList.of("Name");
		emptyRowCount = 1;
		actualMarkDownText = MarkdownTableUtilsAnswerIdea1.createEmptyTable(columnCaptions, emptyRowCount);

		line1 = "|Name|" + System.lineSeparator();
		line2 = "|----|" + System.lineSeparator();
		line3 = "|    |" + System.lineSeparator();

		assertThat(actualMarkDownText, is(line1 + line2 + line3));

	}

}
