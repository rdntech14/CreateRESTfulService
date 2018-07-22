package package1;

import java.util.ArrayList;
import java.util.List;

public class EmpList {

	static List<Employee> empList = null;
	static EmpList e = new EmpList();

	private EmpList() {
		empList = new ArrayList();

		for (int i = 1; i <= 5; i++) {
			Employee emp = null;
			emp = new Employee();
			emp.setId(i);
			emp.setFirstName("first" + i);
			emp.setLastName("last" + i);

			empList.add(emp);
		}
		System.out.println("empList created one time");
	}

	public static List<Employee> getEmpList() {
		return empList;
	}

	public static void addEmployee(Employee e) {
		empList.add(e);
	}

	public static String deleteEmployee(int id) {
		boolean deleteStatus = false;
		for (Employee e : empList) {
			if (e.getId() == id) {
				empList.remove(e);
				deleteStatus = true;
				break;
			}
		}
		if (deleteStatus) {
			return "Employee Deleted";
		} else {
			return "Employee NOT Deleted";
		}

	}
	
	public static String updateEmployee(Employee updateE) {
		boolean updateStatus = false;
		for (Employee e : empList) {
			if (e.getId() == updateE.getId()) {
				e.setFirstName(updateE.getFirstName());
				e.setLastName(updateE.getLastName());
				updateStatus = true;
				break;
			}
		}
		if (updateStatus) {
			return "Employee Updated";
		} else {
			return "Employee NOT Updated";
		}

	}

}
