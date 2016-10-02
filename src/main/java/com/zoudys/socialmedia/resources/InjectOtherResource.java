package com.zoudys.socialmedia.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("injectMe")
@Produces(value=MediaType.TEXT_PLAIN)
@Consumes(value=MediaType.TEXT_PLAIN)
public class InjectOtherResource {

	@GET
	@Path("annotations")
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
									@HeaderParam("authSessionID") String header,
									@CookieParam("name") String cookie){
		
		return "Matrix Param : "+ matrixParam +" ------ Header pram : "+ header+"---- Cookie param : "+cookie;
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		String cookie = headers.getCookies().toString();
		return "Uri Info "+path+" Cookies "+cookie;
	}
	
	
	
}



