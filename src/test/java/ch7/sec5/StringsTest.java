package ch7.sec5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringsTest {

	@Test
	@DisplayName("nullが引数の場合にnullを返す")
	void testCapitalize_null() {
		Assertions.assertNull(Strings.capitalize(null));
	}

	@Test
	@DisplayName("空文字が引数の場合に空文字を返す")
	void testCapitalize_blank() {
		Assertions.assertEquals("", Strings.capitalize(""));
	}

	@Test
	@DisplayName("引数が複数文字の場合")
	void testCapitalize_multiLetter() {
		Assertions.assertEquals("Abc", Strings.capitalize("abc"));
	}

	@Test
	@DisplayName("引数が1文字の場合")
	void testCapitalize_oneLetter() {
		Assertions.assertEquals("A", Strings.capitalize("a"));
	}

}
