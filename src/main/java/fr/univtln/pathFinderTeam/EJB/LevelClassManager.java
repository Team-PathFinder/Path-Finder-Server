package fr.univtln.pathFinderTeam.EJB;

import fr.univtln.pathFinderTeam.DAO.CrudService;
import fr.univtln.pathFinderTeam.DAO.QueryParameter;
import fr.univtln.pathFinderTeam.classes.LevelClass;
import fr.univtln.pathFinderTeam.classes.RPCharacter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class LevelClassManager implements Serializable {

    @EJB
    CrudService<LevelClass> cs;

    public LevelClass findByName(String pName) {

        return (LevelClass) cs.findWithNamedQuery("findByName", QueryParameter.with("pName",pName).parameters()).get(0);
    }

    public LevelClassManager(){}

    public LevelClass create(LevelClass levelClass) {

        return cs.create(levelClass);
    }

    public LevelClass update(LevelClass lc) {

        return cs.update(lc);
    }

    public LevelClass find(int id) {

        return cs.find(LevelClass.class, id);
    }
}
