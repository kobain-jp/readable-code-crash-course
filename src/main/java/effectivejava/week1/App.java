package effectivejava.week1;

import java.util.List;

import effectivejava.week1.employee.Employee;
import effectivejava.week1.employee.MockEmployeeDao;

public class App {

	public static void main(String[] args) {

		//TODO7 : Effective Java Item 64
		MockEmployeeDao dao = new MockEmployeeDao();
		@SuppressWarnings("rawtypes")
		List employees = dao.findAll();

		for (Object object : employees) {
			// TODO8 refactor here after you fix todo8 on Employee
			Employee employee = (Employee) object;
			System.out.println(employee.printLine());
		}

	}

}
