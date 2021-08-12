package ch8.sec1;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ProductParser {
	
	// TODO 3: this class is utility class which has just static methods and no need to be extended and no need to be created as instance.
	//         refactor this class to achive the above.           

	// TODO 1: refactor this method after you read 8.1 -> 4.7 -> 2.2 -> 9.1
	// you do not need to care about exception handling (out of scope from this todo)
	public static Product parse(String source) throws ParseException {
		String[] tmp = source.split(",");
		Product product = new Product(Long.parseLong(tmp[0]), tmp[1].toLowerCase(), tmp[2],
				NumberFormat.getCurrencyInstance(Locale.US).parse(tmp[3]).doubleValue(),
				LocalDate.parse(tmp[4], DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		return product;
	}

}
