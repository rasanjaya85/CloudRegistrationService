package org.rasa.mis.user.registration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * User Registration Service
 */
@Path("/")
public interface Service {
    @GET
    @Produces("text/plain")
    @Path("/{param}")
    public Response test(@PathParam("param") String parameter);

    @GET
    @Produces("application/json")
    @Path("/users/{param}")
    public Response getUser(@PathParam("param") String parameter);
}
