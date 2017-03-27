package dao;

import entities.Man;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by aalle on 27.03.2017.
 */
@Remote
public interface ManDAO {
    List<Man> selectAllMan();
//    void addSoul(LostSoul lostSoul);
//    void deleteSoulById(int id);
}
