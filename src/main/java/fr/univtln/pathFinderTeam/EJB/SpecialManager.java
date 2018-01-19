package fr.univtln.pathFinderTeam.EJB;

import fr.univtln.pathFinderTeam.DAO.CrudService;
import fr.univtln.pathFinderTeam.classes.Special;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class SpecialManager implements Serializable {

    @EJB
    CrudService<Special> cs;

    public SpecialManager(){}

    public Special create(Special special) {

        return cs.create(special);
    }

    public Special update(Special special) {

        return cs.update(special);
    }

    public Special find(int id) {

        return cs.find(Special.class, id);
    }
}
