package fr.univtln.pathFinderTeam.EJB;

import fr.univtln.pathFinderTeam.DAO.CrudService;
import fr.univtln.pathFinderTeam.classes.Race;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class RaceManager implements Serializable {

    @EJB
    CrudService<Race> cs;

    public RaceManager(){}

    public Race create(Race race) {

        return cs.create(race);
    }

    public Race update(Race race) {

        return cs.update(race);
    }

    public Race find(int id) {

        return cs.find(Race.class, id);
    }
}
