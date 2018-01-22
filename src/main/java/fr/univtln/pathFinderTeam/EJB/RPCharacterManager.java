package fr.univtln.pathFinderTeam.EJB;


import fr.univtln.pathFinderTeam.DAO.CrudService;
import fr.univtln.pathFinderTeam.DAO.QueryParameter;
import fr.univtln.pathFinderTeam.classes.RPCharacter;
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
public class RPCharacterManager implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(RPCharacter.class.getSimpleName());

    private ValidatorFactory vf;
    private Validator validator;

    @Inject
    CrudService<RPCharacter> cs;

    public RPCharacterManager(){
        this.vf = Validation.buildDefaultValidatorFactory();
        this.validator  = vf.getValidator();
    }

    public RPCharacter create(RPCharacter rpchar) {

        Set<ConstraintViolation<RPCharacter>> constraintViolations = validator.validate(rpchar);

        if (constraintViolations.size() > 0) {
            constraintViolations.forEach(c -> LOGGER.severe(Errors.RPCHARACTER_CREATE_ERROR + c.getMessage()));
            return null;
        }
        else
            return cs.create(rpchar);
    }

    public RPCharacter findByName(String pName) {

        return (RPCharacter) cs.findWithNamedQuery(Properties.FIND_CHARACTER_BY_NAME, QueryParameter.with("pName",pName).parameters()).get(0);
    }

    public RPCharacter update(RPCharacter rpChar) {

        return cs.update(rpChar);
    }

    public RPCharacter find(int id) {

        return cs.find(RPCharacter.class, id);
    }

    public List<RPCharacter> findAll() {

        return cs.findAll(RPCharacter.class);
    }
}
