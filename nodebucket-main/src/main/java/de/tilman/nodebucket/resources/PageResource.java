package de.tilman.nodebucket.resources;

import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;

import de.tilman.nodebucket.dao.PageDAO;
import de.tilman.nodebucket.representations.Page;

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class PageResource {

	private final PageDAO pageDao;

	public PageResource(DBI jdbi) {
		pageDao = jdbi.onDemand(PageDAO.class);
	}

	@GET
	@Path("/{id}")
	public Response getContact(@PathParam("id") int id, @Auth(required=false) Boolean isAuthenticated) {
		Page page = pageDao.getPageById(id);
		return Response.ok(page).build();
	}

//	@POST
//	public Response createContact(@Valid Page contact, @Auth Boolean isAuthenticated) throws URISyntaxException {
//		int newContactId = pageDao.createContact(contact.getFirstName(), contact.getLastName(), contact.getPhone());
//		return Response.created(new URI(String.valueOf(newContactId))).build();
//	}
//
//	@DELETE
//	@Path("/{id}")
//	public Response deleteContact(@PathParam("id") int id, @Auth Boolean isAuthenticated) {
//		pageDao.deleteContact(id);
//		return Response.noContent().build();
//	}
//
//	@PUT
//	@Path("/{id}")
//	public Response updateContact(@PathParam("id") int id, @Valid Page contact, @Auth Boolean isAuthenticated) {
//		pageDao.updateContact(id, contact.getFirstName(), contact.getLastName(), contact.getPhone());
//		return Response.ok(new Page(id, contact.getFirstName(), contact.getLastName(), contact.getPhone())).build();
//	}
}
