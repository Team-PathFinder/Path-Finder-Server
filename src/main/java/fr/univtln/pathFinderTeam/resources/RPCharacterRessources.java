package fr.univtln.pathFinderTeam.resources;


import fr.univtln.pathFinderTeam.EJB.RPCharacterManager;
import fr.univtln.pathFinderTeam.classes.LevelClass;
import fr.univtln.pathFinderTeam.classes.RPCharacter;
import fr.univtln.pathFinderTeam.classes.Race;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Stateless
@Path("/characters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RPCharacterRessources{

    @Inject
    RPCharacterManager rcm;

    public RPCharacterRessources(){}

    @POST
    public Response create(RPCharacter rpchar) {

        RPCharacter newRPchar = rcm.create(rpchar);

        if (newRPchar == null)
            return Response.serverError().build();

        return Response.ok(newRPchar).build();
    }

    @PUT
    public Response update(RPCharacter rpChar) {

        RPCharacter newRPchar = rcm.update(rpChar);
        return Response.ok(newRPchar).build();
    }

    @GET
    @Path("/{id}")
    public Response getRPChar(@PathParam("id") int id) {

        RPCharacter newRPchar = rcm.find(id);
        return Response.ok(newRPchar).build();
    }

    @GET
    public Response getAll() {

        List<RPCharacter> all = rcm.findAll();
        return Response.ok(all).build();
    }
}
