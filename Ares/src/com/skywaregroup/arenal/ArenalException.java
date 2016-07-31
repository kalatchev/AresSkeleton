package com.skywaregroup.arenal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ArenalException extends WebApplicationException {

	private static final long serialVersionUID = 1L;
	
	public ArenalException(Status httpStatus, ExcetionInfo info)
    {
    	super(Response.status(httpStatus)
    			.header(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate") // HTTP 1.1.
				.header("Pragma", "no-cache") // HTTP 1.0.
				.header(HttpHeaders.EXPIRES, "0") // Proxies.
    			.type(MediaType.APPLICATION_XML + ";charset=utf-8") //XML and encoding
    			.entity(info) //Body
    			.build());
    }
	
	public ArenalException(ExcetionInfo info) {
		this(Status.INTERNAL_SERVER_ERROR, info);
    }

}
