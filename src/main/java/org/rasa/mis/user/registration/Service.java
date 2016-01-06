package org.rasa.mis.user.registration;

import org.rasa.mis.user.registration.beans.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * User Registration Service
 */
@Path("/")
public class Service {

    @GET
    @Produces("text/plain")
    @Path("/{param}")
    public Response test(@PathParam("param") String parameter) {
        String output = "Roger that \"" + parameter + "\"";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces("application/json")
    @Path("/users/{param}")
    public Response getUser(@PathParam("param") String parameter) {
        User user = new User();
        user.setFirstName(parameter);
        return Response.status(200).entity(user).build();
    }
}
