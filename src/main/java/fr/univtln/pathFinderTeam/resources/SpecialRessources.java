package fr.univtln.pathFinderTeam.resources;

import fr.univtln.pathFinderTeam.EJB.SpecialManager;
import fr.univtln.pathFinderTeam.classes.Special;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@Path("/special")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SpecialRessources {

    @EJB
    SpecialManager sm;

    public SpecialRessources(){}

    @POST
    public Response create(Special special){

        Special newSpecial = sm.create(special);
        return Response.ok(newSpecial).build();
    }

    @PUT
    public Response update(Special special) {

        Special newSpecial = sm.update(special);
        return Response.ok(newSpecial).build();
    }

    @GET
    @Path("/{id}")
    public Response getSpecial(@PathParam("id") int id) {

        Special newSpecial = sm.find(id);
        return Response.ok(newSpecial).build();
    }
}
