package package1;

import java.util.ArrayList;
import java.util.List;

public class EmpList {

	static List<Employee> empList = null;
	static EmpList e = new EmpList();

	private EmpList() {
		
		 String nameFirstArr[] = {"Anne", "Ben", "Joe", "Mike","Tom"};
		 String nameLastArr[] = {"Brown", "Miller", "Johnson", "Smith","Williams"};
		 
		empList = new ArrayList<Employee>();

		for (int i = 0; i <= 4; i++) {
			Employee emp = null;
			emp = new Employee();
			emp.setId(1001 + i);
			emp.setFirstName(nameFirstArr[i]);
			emp.setLastName(nameLastArr[i]);

			empList.add(emp);
		}
		System.out.println("empList created - first time");
	}

	public static List<Employee> getEmpList() {
		return empList;
	}
	
	public static List<Employee> getEmpList(int id) {
		List<Employee> employeelist = new ArrayList<>();
		for (Employee e : empList) {
			if (e.getId() == id) {
				employeelist.add(e);
				return employeelist;
			}
		}
		return employeelist;
		
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
