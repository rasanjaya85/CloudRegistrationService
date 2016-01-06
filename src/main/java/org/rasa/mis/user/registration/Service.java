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
public class Service {

    @GET
    @Produces("text/plain")
    @Path("/{param}")
    public Response getClichedMessage(@PathParam("param") String parameter) {
        String output = "Hello World " + parameter;
        return Response.status(200).entity(output).build();
    }

}
