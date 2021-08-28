package com.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloService {
	
	// http://localhost:8080/AppWebBackend/service/hello/john
	@Path("/john")
	@GET
	@Produces("text/plain")
	public String helloJohn() {
		return "Hello John";
	}
	
}
