package fr.univtln.pathFinderTeam;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.univtln.pathFinderTeam.classes.Special;

import javax.ws.rs.core.MediaType;

public class InsertSpecial {

    public static void main(String[] args) {

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        WebResource webResource = c.resource("http://localhost:8080/pathFinderServer-1.0-character_resources-SNAPSHOT/rest/");

        Special s1 = new Special();
        s1.setName("La spéciale");
        s1.setDescription("Cette spéciale est plus forte que les autres !");

        Special s2 = new Special();
        s2.setName("Tourbilol");
        s2.setDescription("Cette fais tournoyer le personage sur lui meme avec une grosse épée :D !");

        Special s3 = new Special();
        s3.setName("Le coupe en deux");
        s3.setDescription("En utilisant cette spéciale, le personnage a de fortes probabilités de couper en deux son adversaire !");

        Special s4 = new Special();
        s4.setName("Le recolle deux morceaux");
        s4.setDescription("Apres avoir été coupé en deux, le personnage a l'abilité de se recoller spontanément !");

        Special s5 = new Special();
        s5.setName("Avada kedavra");
        s5.setDescription("Le personnage fais apparaitre Voldemort et tue instantanément le personnage adverse !");

        Special s6 = new Special();
        s6.setName("Abra kadabra");
        s6.setDescription("Le personnage fais apparaitre une baguette en bois qui ne sert a rien !");

        webResource.path("special").type(MediaType.APPLICATION_JSON).post(s1);
        webResource.path("special").type(MediaType.APPLICATION_JSON).post(s2);
        webResource.path("special").type(MediaType.APPLICATION_JSON).post(s3);
        webResource.path("special").type(MediaType.APPLICATION_JSON).post(s4);
        webResource.path("special").type(MediaType.APPLICATION_JSON).post(s5);
        webResource.path("special").type(MediaType.APPLICATION_JSON).post(s6);
    }
}
