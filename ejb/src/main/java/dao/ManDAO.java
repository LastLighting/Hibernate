package dao;

import entities.ConditionEntity;
import entities.Man;
import entities.ManEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by aalle on 27.03.2017.
 */
@Remote
public interface ManDAO {

    public List<ManEntity> findAll();

    public ConditionEntity findAddressById(int id);
}
