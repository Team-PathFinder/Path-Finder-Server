package fr.univtln.pathFinderTeam.backingbean;

import fr.univtln.pathFinderTeam.EJB.LevelClassManager;
import fr.univtln.pathFinderTeam.EJB.RPCharacterManager;
import fr.univtln.pathFinderTeam.classes.LevelClass;
import fr.univtln.pathFinderTeam.classes.RPCharacter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

    private RPCharacter character;

    private String name;

    private String classe;

    public CharacterBean() {
        this.character = new RPCharacter();
    }

    public String createCharacter(){
        characterManager.create(character);

        return "welcome";
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
}
