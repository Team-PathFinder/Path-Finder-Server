package fr.univtln.pathFinderTeam.backingbean;

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

    //@Inject
    //CharacterManager characterManager;

    //Character character;

    private String name;

    private String classe;

    public CharacterBean() {
        //this.character = new Character();
    }

    public String createCharacter(){
        //characterManager.create(character);

        return "welcome";
    }

    public String levelUp(){
        //characterManager.levelup(name, classe);

        return "welcome";
    }




}
