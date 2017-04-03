package dao;

import beans.SimpleLogger;
import entities.InsertEvent;
import entities.Man;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateful
public class ManDAOContImpl extends DAO implements ManDAOCont {

    private final String deleteMan = "delete from man where id=?";
    private final String addMan = "insert into man values(null, ?, ?)";

    @Inject
    private Event<InsertEvent> insertEvent;

    @Interceptors(SimpleLogger.class)
    public void addMan(Man man) {
        toConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addMan);
            preparedStatement.setString(1, man.getName());
            preparedStatement.setInt(2, man.getOld());
            preparedStatement.executeUpdate();

            InsertEvent payload = new InsertEvent();
            payload.setData(man.getName());
            payload.setTime(new java.util.Date());
            insertEvent.fire(payload);
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

    @Interceptors(SimpleLogger.class)
    @PostConstruct
    void postConstruct(){}

    @Interceptors(SimpleLogger.class)
    @PreDestroy
    void preDestroy(){}

    @Interceptors(SimpleLogger.class)
    @PrePassivate
    void prePassivate(){}

    @Interceptors(SimpleLogger.class)
    @PostActivate
    void postActivate(){}
}
