package fr.univtln.pathFinderTeam;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.univtln.pathFinderTeam.classes.LevelClass;
import fr.univtln.pathFinderTeam.classes.RPCharacter;
import fr.univtln.pathFinderTeam.classes.Race;

import javax.ws.rs.core.MediaType;

public class InsertCharacter {

    public static void main(String[] args) {


        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        WebResource webResource = c.resource("http://localhost:8080/pathFinderServer-1.0-character_resources-SNAPSHOT/rest/");

        RPCharacter character1 = new RPCharacter();
        character1.setName("LOLOLOLOLOL");
        character1.setAge(23);
        character1.setConstitution(14);
        character1.setCharisma(18);
        character1.setDexterity(12);
//        character1.setHealthpoint(8);
        character1.setIntelligence(8);
        character1.setWisdom(8);
        character1.setStrength(10);
        character1.setGender("male");

        Race wayang = new Race();
        wayang.setName("Wayang");

        character1.setRace(wayang);

//        List<LevelClass> levels = new ArrayList<>();
//        character1.setLevels(levels);
//        character1.addLevelClass(levelClass);
//
//        character1.addLevelClass(levelClass1);

        webResource.path("character").type(MediaType.APPLICATION_JSON).post(character1);
    }
}
