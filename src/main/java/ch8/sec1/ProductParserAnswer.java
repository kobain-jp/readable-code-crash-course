package ch8.sec1;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class ProductParserAnswer {

	private ProductParserAnswer() {
	}

	public Product parse(String source) throws ParseException {
		String[] productStrArray = source.split(",");
		
		// process each value of productArray
		long productId = Long.parseLong(productStrArray[0]);
		String productCd = productStrArray[1].toLowerCase();
		String productName = productStrArray[2];
		double price = NumberFormat.getCurrencyInstance(Locale.US).parse(productStrArray[3]).doubleValue();
		LocalDate releaseDate = LocalDate.parse(productStrArray[4], DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
		return new Product(productId, productCd, productName, price, releaseDate);
	}
}
