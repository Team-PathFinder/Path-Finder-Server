package fr.univtln.pathFinderTeam;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import fr.univtln.pathFinderTeam.classes.Race;

import javax.ws.rs.core.MediaType;

public class InsertRace {

    public static void main(String[] args) {

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        WebResource webResource = c.resource("http://localhost:8080/pathFinderServer-1.0-character_resources-SNAPSHOT/rest/");

        Race nain = new Race();
        nain.setName("Nain");

        Race halflin = new Race();
        halflin.setName("Halflin");

        Race gnome = new Race();
        gnome.setName("Gnome");

        Race humain = new Race();
        humain.setName("Humain");

        Race elfe = new Race();
        elfe.setName("Elfe");

        Race demiElfe = new Race();
        demiElfe.setName("Demi-Elfe");

        Race demiOrque = new Race();
        demiOrque.setName("Demi-Orque");

        Race aasimar = new Race();
        aasimar.setName("Aasimar");

        Race dhampir = new Race();
        dhampir.setName("Dhampir");

        Race drow = new Race();
        drow.setName("Drow");

        Race fetchelin = new Race();
        fetchelin.setName("Fetchelin");

        Race gobelin = new Race();
        gobelin.setName("Gobelin");

        Race hobGobelin = new Race();
        hobGobelin.setName("Hobgobelin");

        Race hommeFelin = new Race();
        hommeFelin.setName("Homme-felin");

        Race hommeRat = new Race();
        hommeRat.setName("Homme-rat");

        Race ifrit = new Race();
        ifrit.setName("Ifrit");

        Race kobold = new Race();
        kobold.setName("Kobold");

        Race ondin = new Race();
        ondin.setName("Ondin");

        Race orque = new Race();
        orque.setName("Orque");

        Race oreade = new Race();
        oreade.setName("Oréade");

        Race sylphes = new Race();
        sylphes.setName("Sylphes");

        Race tengu = new Race();
        tengu.setName("Tengu");

        Race tieffelin = new Race();
        tieffelin.setName("Tieffelin");

        Race aquatique = new Race();
        aquatique.setName("Aquatique");

        Race changelin = new Race();
        changelin.setName("Changelin");

        Race duergar = new Race();
        duergar.setName("Duergar");

        Race grippli = new Race();
        grippli.setName("Grippli");

        Race hommePoisson = new Race();
        hommePoisson.setName("Hommes-poisson");

        Race kitsune = new Race();
        kitsune.setName("Kitsune");

        Race nagaji = new Race();
        nagaji.setName("Nagaji");

        Race samsaran = new Race();
        samsaran.setName("Samsaran");

        Race strix = new Race();
        strix.setName("Strix");

        Race suli = new Race();
        suli.setName("Suli");

        Race svirfneblin = new Race();
        svirfneblin.setName("Svirfneblin");

        Race vanara = new Race();
        vanara.setName("Vanara");

        Race vishkanya = new Race();
        vishkanya.setName("Vishkanya");

        Race wayang = new Race();
        wayang.setName("Wayang");

        webResource.path("race").type(MediaType.APPLICATION_JSON).post(nain);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(halflin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(gnome);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(humain);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(elfe);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(demiElfe);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(demiOrque);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(aasimar);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(dhampir);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(drow);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(fetchelin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(gobelin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(hobGobelin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(hommeFelin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(hommeRat);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(ifrit);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(kobold);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(ondin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(orque);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(oreade);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(sylphes);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(tengu);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(tieffelin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(aquatique);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(changelin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(duergar);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(grippli);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(hommePoisson);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(kitsune);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(nagaji);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(samsaran);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(strix);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(suli);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(svirfneblin);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(vanara);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(vishkanya);
        webResource.path("race").type(MediaType.APPLICATION_JSON).post(wayang);
    }
}
