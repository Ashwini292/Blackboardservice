package com.csye6225.spring2020.courseservice.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2020.courseservice.datamodel.Department;
import com.csye6225.spring2020.courseservice.service.DepartmentService;

@Path("/departments")
public class DepartmentResource {
DepartmentService deptService = new DepartmentService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Department> getDepartments(
		@QueryParam("numofstudents") int numofstudents){
			if(numofstudents==0) {			
				return deptService.getAllDepartments();
			}
		
		return deptService.getDepartmentByStudents(numofstudents);
	}
	

	
	// ... webapi/department/1 
	@GET
	@Path("/{departmentId}")
	@Produces(MediaType.APPLICATION_XML)
	public Department getDepartment(@PathParam("departmentId") int deptId) {
		System.out.println("Dept Resource: Looking for: " + deptId);
		return deptService.getDepartment(deptId);
	}

	@DELETE
	@Path("/{departmentId}")
	@Produces(MediaType.APPLICATION_XML)
	public Department deleteDepartment(@PathParam("departmentId") String deptId) {
		return deptService.deleteDepartment(deptId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Department addDepartment(Department dept) {
		dept.setDeptName(dept.getDeptName());
		dept.setDeptId(dept.getDeptId());
		dept.setNumofstudents(dept.getNumofstudents());
		
			return deptService.addDepartment(dept.getDeptName(), dept.getDeptId(), dept.getNumofstudents());
	}
	
	@PUT
	@Path("/{departmentId}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Department updateDepartment(@PathParam("departmentId") String deptId, 
			Department dept) {
		return deptService.updateDepartmentInformation(deptId, dept);
	}
	
	/*public void addDepartment(String firstName, String lastName, String department, Date joiningDate) {
		profService.addDepartment(firstName, lastName, department, joiningDate);
	}*/
}

