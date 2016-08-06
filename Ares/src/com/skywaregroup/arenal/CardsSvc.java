package com.skywaregroup.arenal;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/cards")
@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
public class CardsSvc {
	
	@Context private UriInfo uriInfo;

	//GET /id = Select
	@Path("/{id:\\d+}")
	@GET
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public Card retrieveCard(
			@HeaderParam(Const.HEADER_TOKEN_NAME) @DefaultValue("") String accessToken, 
			@PathParam("id") String cardId) {
			
		//TODO: Enable following code to provide security
//		if(accessToken == null || accessToken.isEmpty() || !accessToken.matches(Const.SIMPLE_TOKEN)) {
//			//No token provided or incorrect format
//			throw new ArenalException(Status.UNAUTHORIZED, new ExcetionInfo(ErrorCodes.INVALID_TOKEN));}
//		if (!WHEREVER_TOKEN_IS_STORED.equals(accessToken)) {
//			//Token doesn't match
//			throw new ArenalException(Status.UNAUTHORIZED, new ExcetionInfo(ErrorCodes.INVALID_TOKEN));
//		}
		Card rv = new Card();
		rv.id = Integer.parseInt(cardId);
		rv.FillDemoData();
		
		return rv;
	}	

}
