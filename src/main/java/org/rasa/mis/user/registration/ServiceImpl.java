package org.rasa.mis.user.registration;

import org.rasa.mis.user.registration.beans.User;

import javax.ws.rs.core.Response;

/**
 * User Registration Service Implementation
 */
public class ServiceImpl implements Service{

    public Response test(String parameter) {
        String output = "Roger that \"" + parameter + "\"";
        return Response.status(200).entity(output).build();
    }

    public Response getUser(String parameter) {
        User user = new User();
        user.setFirstName(parameter);
        return Response.status(200).entity(user).build();
    }
}
