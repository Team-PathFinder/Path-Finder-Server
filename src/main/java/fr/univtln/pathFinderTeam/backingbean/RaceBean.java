package fr.univtln.pathFinderTeam.backingbean;


import fr.univtln.pathFinderTeam.EJB.RaceManager;
import fr.univtln.pathFinderTeam.classes.Race;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@ViewScoped
public class RaceBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private final static Logger LOGGER = Logger.getLogger(Race.class.getSimpleName());

    @Inject
    RaceManager raceManager;

    private Race race;

    private String name;

    private String classe;

    public RaceBean() {
        this.race = new Race();
    }

    public String createRace(){
        raceManager.create(race);

        return "welcome";
    }
}
