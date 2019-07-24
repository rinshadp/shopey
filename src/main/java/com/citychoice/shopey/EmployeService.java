package com.citychoice.shopey;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;

import com.citychoice.shopey.EmployeRepo;
import com.citychoice.shopey.Employe;
import com.citychoice.shopey.Secured;
 
@Path("/employe")
public class EmployeService {
	private EmployeRepo employeRepo;

	public EmployeService(){
		employeRepo = new EmployeRepo();
	}
 
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Employe getEmployeJSON(@PathParam("id") Integer id) {
		Employe e = employeRepo.getEmploye(id);
		return e;
	}

	@GET
	@Secured
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{id}")
	public Employe getEmployeXML(@PathParam("id") Integer id) {
		Employe e = employeRepo.getEmploye(id);
		return e;
	}

	@POST
	@Secured
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createCustomer(@FormParam("id") Integer id,
								 @FormParam("name") String name,
	                             @FormParam("address") String address) {

		String result = "failed";
		Employe employe = new  Employe(id, name , address);
		result = employeRepo.saveEmploye(employe);
	    return result;
	}

	@POST
	@Secured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createCustomer(Employe employe) {

		String result = "failed";
		//Employe employe = new  Employe(id, name , address);
		result = employeRepo.saveEmploye(employe);
	    return result;
	}
 
}
