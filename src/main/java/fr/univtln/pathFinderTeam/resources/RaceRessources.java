package fr.univtln.pathFinderTeam.resources;

import fr.univtln.pathFinderTeam.EJB.RaceManager;
import fr.univtln.pathFinderTeam.classes.RPCharacter;
import fr.univtln.pathFinderTeam.classes.Race;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@Path("/races")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RaceRessources{

    @Inject
    RaceManager rm;

    public RaceRessources(){}

    @POST
    public Response create(Race race){

        Race newRace = rm.create(race);

        if (newRace == null)
            return Response.serverError().build();

        return Response.ok(newRace).build();
    }

    @PUT
    public Response update(Race race) {

        Race newRace = rm.update(race);
        return Response.ok(newRace).build();
    }

    @GET
    @Path("/{id}")
    public Response getRace(@PathParam("id") int id) {

        Race newRace = rm.find(id);
        return Response.ok(newRace).build();
    }
}
