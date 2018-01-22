package fr.univtln.pathFinderTeam.EJB;

import fr.univtln.pathFinderTeam.DAO.CrudService;
import fr.univtln.pathFinderTeam.classes.Race;
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
public class RaceManager implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(Race.class.getSimpleName());

    private ValidatorFactory vf;
    private Validator validator;

    @Inject
    CrudService<Race> cs;

    public RaceManager(){
        this.vf = Validation.buildDefaultValidatorFactory();
        this.validator  = vf.getValidator();
    }

    public Race create(Race race) {

        Set<ConstraintViolation<Race>> constraintViolations = validator.validate(race);

        if (constraintViolations.size() > 0) {
            constraintViolations.forEach(c -> LOGGER.severe(Errors.RACE_CREATE_ERROR + c.getMessage()));
            return null;
        }
        else
            return cs.create(race);
    }

    public Race update(Race race) {

        return cs.update(race);
    }

    public Race find(int id) {

        return cs.find(Race.class, id);
    }

    public List<Race> findAll() {

        return cs.findAll(Race.class);
    }
}
