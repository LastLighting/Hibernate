package beans;

import dao.ManDAO;
import dao.ManDAOImpl;
import entities.Man;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by aalle on 27.03.2017.
 */
@ManagedBean
public class ManBean {

    @EJB
    ManDAO manDAO;

    public List<Man> getListMans() {
        return manDAO.selectAllMan();
    }

    public String add(){return "add";}
}
