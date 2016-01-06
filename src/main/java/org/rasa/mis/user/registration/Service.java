package org.rasa.mis.user.registration;

import org.rasa.mis.user.registration.beans.Card;
import org.rasa.mis.user.registration.beans.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.*;

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
        getUserFromDB("abc");
        return Response.status(200).entity(user).build();
    }

    @GET
    @Produces("application/json")
    @Path("/cards/{param}")
    public Response getCard(@PathParam("param") int id) {
        Card card = new Card();
        card.setId(id);
        return Response.status(200).entity(card).build();
    }



    private static void getUserFromDB(String username) {
        try
        {
            // create our mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/userDB";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM users";
            System.out.println(query);

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date dateCreated = rs.getDate("date_created");
                boolean isAdmin = rs.getBoolean("is_admin");
                int numPoints = rs.getInt("num_points");

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
            }
            st.close();
            //conn.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
            System.err.println(e.getMessage());
        }
    }
}
