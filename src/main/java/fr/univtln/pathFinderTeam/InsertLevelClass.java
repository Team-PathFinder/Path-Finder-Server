package fr.univtln.pathFinderTeam;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.univtln.pathFinderTeam.classes.LevelClass;
import fr.univtln.pathFinderTeam.classes.Special;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class InsertLevelClass {

    public static void main(String[] args) {

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        WebResource webResource = c.resource("http://localhost:8080/pathFinderServer-1.0-character_resources-SNAPSHOT/rest/");

        Special s1 = new Special();
        s1.setId(40);
        Special s2 = new Special();
        s2.setId(41);
        Special s3 = new Special();
        s3.setId(42);
        Special s4 = new Special();
        s4.setId(43);
        Special s5 = new Special();
        s4.setId(44);
        Special s6 = new Special();
        s4.setId(45);

        List<Special> specials1 = new ArrayList<>();
        specials1.add(s1);
        specials1.add(s4);

        LevelClass lc1 = new LevelClass() ;
        lc1.setSpecials(specials1);
        lc1.setName("Level barbare 1");
        lc1.setDescription("Le personnage prend un level de barbare");
        lc1.setLevel(1);
        lc1.setBBA(10);
        lc1.setReflex(10);
        lc1.setVigor(10);
        lc1.setWill(10);

        ///////////////

        List<Special> specials2 = new ArrayList<>();
        specials2.add(s1);
        specials2.add(s2);

        LevelClass lc2 = new LevelClass() ;
        lc2.setSpecials(specials2);
        lc2.setName("Level barbare 2");
        lc2.setDescription("Le personnage prend un level de barbare");
        lc2.setLevel(2);
        lc2.setBBA(10);
        lc2.setReflex(10);
        lc2.setVigor(10);
        lc2.setWill(10);

        ///////////////

        List<Special> specials3 = new ArrayList<>();
        specials3.add(s3);
        specials3.add(s5);

        LevelClass lc3 = new LevelClass() ;
        lc3.setSpecials(specials3);
        lc3.setName("Level barbare 3");
        lc3.setDescription("Le personnage prend un level de barbare");
        lc3.setLevel(2);
        lc3.setBBA(10);
        lc3.setReflex(10);
        lc3.setVigor(10);
        lc3.setWill(10);

//        webResource.path("level").type(MediaType.APPLICATION_JSON).post(lc1);
//        webResource.path("level").type(MediaType.APPLICATION_JSON).post(lc2);
        webResource.path("level").type(MediaType.APPLICATION_JSON).post(lc3);
    }
}
