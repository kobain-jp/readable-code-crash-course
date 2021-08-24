package effectivejava.week1.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockEmployeeDao implements IEmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {

		@SuppressWarnings("rawtypes")
		//TODO4 : Effective Java Item 64
		//TODO5 : Effective Java Item 25 and 26
		ArrayList employees = new ArrayList();

		// refactor the followings after TODO2
		Employee emp1 = new Employee();
		emp1.empId = 1;
		emp1.empNo = "1";
		emp1.empNm = "Kobayashi Taro";
		emp1.entryDate = LocalDate.of(2000, 4, 1);

		employees.add(emp1);

		Employee emp2 = new Employee();
		emp2.empId = 2;
		emp2.empNo = "2";
		emp2.empNm = "Kobayashi Jiro";
		emp1.entryDate = LocalDate.of(2001, 4, 1);

		employees.add(emp2);

		return employees;
	}

}
