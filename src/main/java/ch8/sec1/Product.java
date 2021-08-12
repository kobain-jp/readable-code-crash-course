package ch8.sec1;

import java.time.LocalDate;

public class Product {

	// TODO 2: refactor the following fields after your read effective java 16, 17
    //         the following fields does not need to be changed once you set the value.
	//         after you refactor the code, refactor junit test case as well.
	public long productId;
	public String productCode;
	public String productName;
	public double price;
	public LocalDate releaseDate;

	public Product(long productId, String productCode, String productName, double price, LocalDate releaseDate) {
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.releaseDate = releaseDate;
	}

}
