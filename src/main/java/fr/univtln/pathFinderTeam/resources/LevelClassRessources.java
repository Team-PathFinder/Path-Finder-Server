package fr.univtln.pathFinderTeam.resources;

import fr.univtln.pathFinderTeam.EJB.LevelClassManager;
import fr.univtln.pathFinderTeam.classes.LevelClass;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Stateless
@Path("/levels")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LevelClassRessources{

    @Inject
    LevelClassManager lcm;

    public LevelClassRessources(){}

    @POST
    public Response create(LevelClass lc) {

        LevelClass newLC = lcm.create(lc);

        if (newLC == null)
            return Response.serverError().build();

        return Response.ok(newLC).build();
    }

    @PUT
    public Response update(LevelClass lc) {

        LevelClass newLC = lcm.update(lc);
        return Response.ok(newLC).build();
    }

    @GET
    @Path("/{id}")
    public Response getRPChar(@PathParam("id") int id) {

        LevelClass newLC = lcm.find(id);
        return Response.ok(newLC).build();
    }

    @GET
    public Response getAll() {

        List<LevelClass> levelClasses = lcm.findAll();
        return Response.ok(levelClasses).build();
    }
}
