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
	// when creating instance
	// TODO3 force developer not to extend this class
	// Effective Java Item 17

	// TODO8 : Effective java Item12
	public String printLine() {
		// TODO use com.google.common.base.MoreObjects.toStringHelper
		return "Employee{empId=1, empNo=2001-04-01}";
	}

}
