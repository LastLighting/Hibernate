package dao;

import entities.InsertEvent;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import java.util.Date;

/**
 * Created by Алексей on 28.03.2017.
 */
@Singleton
@Named
public class MySingleton {

    private String add;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void handleInsertEvent(@Observes InsertEvent event) {
        add = "Добавлен " + event.getData() + " в ";
        time = event.getTime();
    }
}
