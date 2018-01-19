package fr.univtln.pathFinderTeam.EJB;


import fr.univtln.pathFinderTeam.DAO.CrudService;
import fr.univtln.pathFinderTeam.DAO.CrudServiceBean;
import fr.univtln.pathFinderTeam.classes.RPCharacter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.io.Serializable;


@Stateless
public class RPCharacterManager implements Serializable {

    @EJB
    CrudService<RPCharacter> cs;

    public RPCharacterManager(){}

    public RPCharacter create(RPCharacter rpchar) {
        System.out.println(rpchar.toString());
        return cs.create(rpchar);
    }

    public RPCharacter update(RPCharacter rpChar) {

        return cs.update(rpChar);
    }

    public RPCharacter find(int id) {

        return cs.find(RPCharacter.class, id);
    }
}
