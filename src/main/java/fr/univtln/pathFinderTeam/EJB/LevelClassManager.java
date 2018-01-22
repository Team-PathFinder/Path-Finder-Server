package fr.univtln.pathFinderTeam.EJB;

import fr.univtln.pathFinderTeam.DAO.CrudService;
import fr.univtln.pathFinderTeam.DAO.QueryParameter;
import fr.univtln.pathFinderTeam.classes.LevelClass;
import fr.univtln.pathFinderTeam.classes.utilites.Properties;
import fr.univtln.pathFinderTeam.utilities.Errors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Stateless
public class LevelClassManager implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(LevelClass.class.getSimpleName());

    private ValidatorFactory vf;
    private Validator validator;

    @Inject
    CrudService<LevelClass> cs;

    public LevelClassManager(){
        this.vf = Validation.buildDefaultValidatorFactory();
        this.validator  = vf.getValidator();
    }

    public LevelClass findByName(String pName) {

        return (LevelClass) cs.findWithNamedQuery(Properties.FIND_LEVELCLASS_BY_NAME, QueryParameter.with("pName",pName).parameters()).get(0);
    }

    public LevelClass create(LevelClass levelClass) {

        Set<ConstraintViolation<LevelClass>> constraintViolations = validator.validate(levelClass);

        if (constraintViolations.size() > 0) {
            constraintViolations.forEach(c -> LOGGER.severe(Errors.LEVELCLASS_CREATE_ERROR + c.getMessage()));
            return null;
        }
        else
            return cs.create(levelClass);
    }

    public LevelClass update(LevelClass lc) {

        return cs.update(lc);
    }

    public LevelClass find(int id) {

        return cs.find(LevelClass.class, id);
    }

    public List<LevelClass> findAll() {

        return cs.findAll(LevelClass.class);
    }
}
