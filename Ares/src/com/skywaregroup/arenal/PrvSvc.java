package com.skywaregroup.arenal;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/provider") 
@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
public class PrvSvc {
	
	@Context private UriInfo uriInfo;
		
	//GET = Select
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public ServiceProvider retrieveProvider() {
			
		//TODO: Get Service Providers from database
		ServiceProvider rv = ServiceProvider.demoObject();
		
		return rv;
		
		
	}	

}
