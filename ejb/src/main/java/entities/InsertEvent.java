package entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by aalle on 03.04.2017.
 */
public class InsertEvent implements Serializable {
    private String data;
    private Date time;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
