package dao;

import entities.Man;

import javax.ejb.Stateful;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateful
public class ManDAOContImpl extends DAO implements ManDAOCont {

    private final String deleteMan = "delete from man where id=?";
    private final String addMan = "insert into man values(null, ?, ?)";


    public void addMan(Man man) {
        toConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addMan);
            preparedStatement.setString(1, man.getName());
            preparedStatement.setInt(2, man.getOld());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {

        } finally {
            closeConnection();
        }
    }


    public void deleteMan(int id) {
        toConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteMan);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {

        } finally {
            closeConnection();
        }
    }
}
