package effectivejava.week1;

import java.util.List;

import effectivejava.week1.employee.Employee;
import effectivejava.week1.employee.MockEmployeeDao;

public class App {

	public static void main(String[] args) {

		// TODO7 : Effective Java Item 64
		MockEmployeeDao dao = new MockEmployeeDao();
		@SuppressWarnings("rawtypes")
		List employees = dao.findAll();

		// TODO9 : Effective Java Item 58 
		for (int i = 0; i < employees.size(); i++) {
			// TODO9 refactor here after you fix todo9 on Employee
			Employee employee = (Employee) employees.get(i);
			System.out.println(employee.printLine());
		}

	}

}
