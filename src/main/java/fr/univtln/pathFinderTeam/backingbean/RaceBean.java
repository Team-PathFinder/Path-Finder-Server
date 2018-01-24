package fr.univtln.pathFinderTeam.backingbean;


import fr.univtln.pathFinderTeam.EJB.RaceManager;
import fr.univtln.pathFinderTeam.classes.Race;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        race.setName(name);
        raceManager.create(race);

        return "La nouvelle race à bien été créée !";
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
