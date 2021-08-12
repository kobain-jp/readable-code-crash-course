package ch8.sec1;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductParserTest {

	@Test
	void testParse() {
		try {
			Product product = ProductParser.parse("1,B8J4059,SD1,$60.66,1981/01/01");
			Assertions.assertEquals(1, product.productId);
			Assertions.assertEquals("b8j4059", product.productCode);
			Assertions.assertEquals("SD1", product.productName);
			Assertions.assertEquals(60.66, product.price);
			Assertions.assertEquals(LocalDate.of(1981, 1, 1), product.releaseDate);
		} catch (ParseException e) {
			e.printStackTrace();
			fail();
		}
	}

}
