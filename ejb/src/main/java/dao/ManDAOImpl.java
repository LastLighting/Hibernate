package dao;

import entities.ConditionEntity;
import entities.InsertEvent;
import entities.Man;
import entities.ManEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ManDAOImpl extends DAO implements ManDAO {

    private Session session;

    public List<ManEntity> findAll() {
        return session.createQuery("from ManEntity c").list();
    }

    public ConditionEntity findAddressById(int id) {
        Query query = session.createQuery("from ConditionEntity a where a.idMan = :id");
        query.setParameter("id", id);
        return (ConditionEntity) query.uniqueResult() ;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
