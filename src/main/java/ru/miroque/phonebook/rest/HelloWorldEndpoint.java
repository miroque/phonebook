package ru.miroque.phonebook.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ru.miroque.phonebook.services.FooService;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {
	@Inject
	private FooService fooservice;

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response doGet() {
		fooservice.name();
		return Response.ok("Hello from Thorntail!").build();
	}
}
