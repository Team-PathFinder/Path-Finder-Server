package fr.univtln.pathFinderTeam.backingbean;

import fr.univtln.pathFinderTeam.EJB.LevelClassManager;
import fr.univtln.pathFinderTeam.EJB.SpecialManager;
import fr.univtln.pathFinderTeam.classes.LevelClass;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@ViewScoped
public class LevelClassBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private final static Logger LOGGER = Logger.getLogger(LevelClass.class.getSimpleName());

    @Inject
    LevelClassManager levelClassManager;

    @Inject
    SpecialManager specialManager;

    private LevelClass levelClass;

    private String name;

    private String classe;

    public LevelClassBean() {
        this.levelClass = new LevelClass();
    }

    public String createLevelClass(){
        levelClassManager.create(levelClass);

        return "welcome";
    }
}
