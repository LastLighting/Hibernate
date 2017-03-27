package dao;

import entities.Man;

import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ManDAOImpl extends DAO implements ManDAO {
    private final String selectAllMan = "select * from man";


    public List<Man> selectAllMan() {
        toConnection();
        List<Man> list = new ArrayList<Man>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllMan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Man man = new Man();
                man.setId(resultSet.getInt("id"));
                man.setName(resultSet.getString("name"));
                man.setOld(resultSet.getInt("old"));
                list.add(man);
            }
        }
        catch (SQLException sqlException) {
        }
        finally {
            closeConnection();
        }
        return list;
    }
}
