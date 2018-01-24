package fr.univtln.pathFinderTeam.backingbean;

import fr.univtln.pathFinderTeam.EJB.LevelClassManager;
import fr.univtln.pathFinderTeam.EJB.RPCharacterManager;
import fr.univtln.pathFinderTeam.EJB.RaceManager;
import fr.univtln.pathFinderTeam.classes.LevelClass;
import fr.univtln.pathFinderTeam.classes.RPCharacter;
import fr.univtln.pathFinderTeam.classes.Race;
import fr.univtln.pathFinderTeam.utilities.InfoBag;

import javax.faces.bean.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Created by maxence on 19/01/18.
 */

@Named
@ViewScoped
public class CharacterBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final static Logger LOGGER = Logger.getLogger(CharacterBean.class.getSimpleName());

    @Inject
    RPCharacterManager characterManager;

    @Inject
    LevelClassManager levelClassManager;

    @Inject
    RaceManager raceManager;

    private RPCharacter character;

    private String name;

    private String classe;

    private String raceName;

    public CharacterBean() {
        this.character = InfoBag.getInstance().rpCharacter;
    }

    public String createCharacter(){

        Race race = raceManager.findByName(raceName);

        character.setRace(race);

        characterManager.create(character);

        return "welcome";
    }

    public String findCharacter() {

        character = characterManager.findByName(name);
        InfoBag.getInstance().rpCharacter = character;

        return "character_view.xhtml";
    }

    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    public String levelUp(){
        //Recuperer level classe dans bdd
        LevelClass levelClass = levelClassManager.findByName(classe);
        //Recuperer le character
        RPCharacter character = characterManager.findByName(name);
        //Ajouter level class dans character avec la fonctin addLevelClass
        if(character != null){
            character.addLevelClass(levelClass);
            //Mettre a jour le character
            characterManager.update(character);
        }
        else{
            LOGGER.severe("Character ne peut pas etre nul");
        }

        return "welcome";
    }

    public RPCharacter getCharacter() {
        return character;
    }

    public void setCharacter(RPCharacter character) {
        this.character = character;
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

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
}
