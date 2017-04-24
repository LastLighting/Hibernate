package service;

import entities.HouseEntity;
import entities.ManEntity;

import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by aalle on 24.04.2017.
 */
public class ManService {

    public EntityManager em = Persistence.createEntityManagerFactory("MANS").createEntityManager();

    public void addMan(ManEntity man,HouseEntity house){
        em.getTransaction().begin();
        house = em.merge(house);
        man.setHouse(house);
        em.merge(man);
        em.getTransaction().commit();
    }

    public void addHome(){
    }

    public List<ManEntity> getAll(){
        TypedQuery<ManEntity> namedQuery = em.createNamedQuery("Man.getAll", ManEntity.class);
        return namedQuery.getResultList();
    }
}
