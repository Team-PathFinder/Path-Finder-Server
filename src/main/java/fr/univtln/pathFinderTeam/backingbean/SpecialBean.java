package fr.univtln.pathFinderTeam.backingbean;

import fr.univtln.pathFinderTeam.EJB.SpecialManager;
import fr.univtln.pathFinderTeam.classes.Special;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@ViewScoped
public class SpecialBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private final static Logger LOGGER = Logger.getLogger(Special.class.getSimpleName());

    @Inject
    SpecialManager specialManager;

    private Special special;

    private String name;

    private String classe;

    public SpecialBean() {
        this.special = new Special();
    }

    public String createSpecial(){
        specialManager.create(special);

        return "welcome";
    }
}
