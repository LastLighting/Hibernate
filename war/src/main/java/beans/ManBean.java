package beans;

import dao.ManDAO;
import dao.ManDAOImpl;
import entities.Man;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by aalle on 27.03.2017.
 */
@ManagedBean
public class ManBean {

    @EJB
    ManDAO manDAO;

    private String event;


    public String add(){return "add";}

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

}
