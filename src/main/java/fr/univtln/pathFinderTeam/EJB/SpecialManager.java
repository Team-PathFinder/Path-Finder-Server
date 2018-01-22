package fr.univtln.pathFinderTeam.EJB;

import fr.univtln.pathFinderTeam.DAO.CrudService;
import fr.univtln.pathFinderTeam.classes.Special;
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
public class SpecialManager implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(Special.class.getSimpleName());

    private ValidatorFactory vf;
    private Validator validator;

    @Inject
    CrudService<Special> cs;

    public SpecialManager(){
        this.vf = Validation.buildDefaultValidatorFactory();
        this.validator  = vf.getValidator();
    }

    public Special create(Special special) {

        Set<ConstraintViolation<Special>> constraintViolations = validator.validate(special);

        if (constraintViolations.size() > 0) {
            constraintViolations.forEach(c -> LOGGER.severe(Errors.SPECIAL_CREATE_ERROR + c.getMessage()));
            return null;
        }
        else
            return cs.create(special);
    }

    public Special update(Special special) {

        return cs.update(special);
    }

    public Special find(int id) {

        return cs.find(Special.class, id);
    }

    public List<Special> findAll() {

        return cs.findAll(Special.class);
    }
}
