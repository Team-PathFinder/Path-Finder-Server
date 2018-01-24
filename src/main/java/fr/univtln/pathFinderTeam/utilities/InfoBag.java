package fr.univtln.pathFinderTeam.utilities;

import fr.univtln.pathFinderTeam.classes.RPCharacter;

public class InfoBag {
    private static InfoBag ourInstance = new InfoBag();

    public static InfoBag getInstance() {
        return ourInstance;
    }

    private InfoBag() {}

    public RPCharacter rpCharacter = new RPCharacter();
}
