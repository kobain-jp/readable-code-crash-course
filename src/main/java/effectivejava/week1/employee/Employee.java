package effectivejava.week1.employee;

import java.time.LocalDate;

public class Employee {

	// TODO1 apply getter/setter pattern and change the visibility as it should be
	// Effective Java Item16
	long empId;
	String empNo;
	String empNm;
	LocalDate entryDate;

	// TODO2 refactor the code to accomplish the followings.
	// remove mutator for empId,empNo,empNm,entryDate not allow change value except
	// when creating instance and change this class name to emphasize your design
	// TODO3 force developer not to extend this class
	// Effective Java Item 17

	// TODO9 : Effective java Item12 
	public String printLine() {
		// TODO8  use com.google.common.base.MoreObjects.toStringHelper to implement this function
		// Effective java Item 59
		return "Employee{empId=999, empNo=2021-07-03}";
	}
	
	// TODO10 : implement equals java Item10
	// TODO11 : implement hashcode Java Item  Effective java Item11

}
