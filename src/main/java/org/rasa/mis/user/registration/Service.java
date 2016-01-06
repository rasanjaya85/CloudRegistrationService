package org.rasa.mis.user.registration;


import org.rasa.mis.user.registration.beans.User;

import javax.ws.rs.*;
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
    public Response getUser(@PathParam("param") int parameter);

    @GET
    @Produces("application/json")
    @Path("/cards/{id}")
    public Response getCard(@PathParam("id") int id);

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/users")
    public Response addUser(User user);
}
