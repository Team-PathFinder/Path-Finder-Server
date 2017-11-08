package fr.univtln.pathFinderTeam.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by clemzux on 03/08/2016.
 */

public class EntityManager {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private javax.persistence.EntityManager em = emf.createEntityManager();

    private static EntityManager INSTANCE = null;

    public static EntityManager getINSTANCE(){
        if(INSTANCE == null)
            INSTANCE = new EntityManager();
        return INSTANCE;
    }

    private EntityManager() {}

    public javax.persistence.EntityManager getEm() {
        return em;
    }
}
