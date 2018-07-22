package package1;

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
	http://localhost:8080/CreateRESTFulService/employee/list — to get all employees list
	http://localhost:8080/CreateRESTFulService/employee/list/id — to get specific id from employee list
	http://localhost:8080/CreateRESTFulService/employee/add — to add an employee to employee list
	http://localhost:8080/CreateRESTFulService/employee/delete/id — to delete an employee
	http://localhost:8080/CreateRESTFulService/employee/update/id — to update an employee info
*/
	
	ResultOK result ;
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeesList(){
		return EmpList.getEmpList();
		
	}
	
	@GET
	@Path("list/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Employee> getEmployee(@PathParam("id") int id){
		return EmpList.getEmpList();
	}
	
	@POST
	@Path("add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public ResultOK createEmployee(Employee emp){
		
		EmpList.addEmployee(emp);
		
		result = new ResultOK("Employee Added");
		System.out.println(result.getMessage());
		return result;
	}
	
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public ResultOK updateEmployee(Employee emp){
		
		EmpList.updateEmployee(emp);
		
		result = new ResultOK("Employee Added");
		System.out.println(result.getMessage());
		return result;
	}
	
	@DELETE
	@Path("delete/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public ResultOK deleteEmployee(@PathParam("id") int id){
		
		String s = EmpList.deleteEmployee(id);
		
		result = new ResultOK(s);
		System.out.println(result.getMessage());
		return result;
	}
	
}
