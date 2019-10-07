package package1;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

@Path("/employee")
public class RESTMethods {

	/*
	 * http://localhost:8080/CreateRESTfulService/rest/employee/list — to get all
	 * employees list
	 * http://localhost:8080/CreateRESTfulService/rest/employee/list/id — to get
	 * specific id from employee list
	 * http://localhost:8080/CreateRESTfulService/rest/employee/add — to add an
	 * employee to employee list
	 * http://localhost:8080/CreateRESTfulService/rest/employee/delete/id — to
	 * delete an employee
	 * http://localhost:8080/CreateRESTfulService/rest/employee/update — to update
	 * an employee info
	 */

	Message result;

	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeesList() {
		return EmpList.getEmpList();

	}

	@GET
	@Path("list/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getEmployee(@PathParam("id") int id) {
		return EmpList.getEmpList(id);
	}

	@POST
	@Path("add")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message createEmployee(Employee emp) {

		EmpList.addEmployee(emp);

		result = new Message("Employee Added");
		System.out.println(result.getMessage());
		return result;
	}

	@POST
	@Path("addMultiple")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message createEmployeeMultiple(List<Employee> emp) {
		for (Employee e : emp) {
			EmpList.addEmployee(e);
		}
		result = new Message("Multiple Employees Added");
		System.out.println(result.getMessage());
		return result;
	}

	@PUT
	@Path("update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message updateEmployee(Employee emp) {

		EmpList.updateEmployee(emp);

		result = new Message("Employee Added");
		System.out.println(result.getMessage());
		return result;
	}

	@DELETE
	@Path("delete/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message deleteEmployee(@PathParam("id") int id) {

		String s = EmpList.deleteEmployee(id);

		result = new Message(s);
		System.out.println(result.getMessage());
		return result;
	}

	@DELETE
	@Path("deleteMultiple")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Message> deleteEmployees(List<EmployeeId> idList) {

		List<Message> messageList = new ArrayList<>();

		for (EmployeeId ids : idList) {
			String s = EmpList.deleteEmployee(ids.getId());
			messageList.add(new Message("ids : " + ids.getId() + " -- " + s));
		}
		System.out.println();
		return messageList;
	}

}
