package org.rasa.mis.user.registration;

import org.rasa.mis.user.registration.beans.Card;
import org.rasa.mis.user.registration.beans.User;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * User Registration Service Implementation
 */
public class ServiceImpl implements Service{

    public Response test(String parameter) {
        String output = "Roger that \"" + parameter + "\"";
        return Response.status(200).entity(output).build();
    }

    public Response getUser(int userId) {
        try {
            User retrievedUser = ServiceUtils.getUserById(userId);
            if (retrievedUser == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(retrievedUser).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response getCard(int id) {
        try {
            Card card = ServiceUtils.getCardbyID(id);
            if(card == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(card).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response addUser(User user) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
