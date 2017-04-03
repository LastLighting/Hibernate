package beans;

import dao.ManDAO;
import dao.ManDAOCont;
import dao.ManDAOImpl;
import entities.Man;
import entities.ManEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ConversationScoped
@Named
public class ManContBean implements Serializable {

    private Man man;

    @EJB
    ManDAOCont manDAOCont;

    @Inject
    Conversation conversation;

    @PostConstruct
    public void PostConstruct() {
        if(conversation.isTransient()) {
            conversation.begin();
        }
        man = new Man();
    }

    public List<ManEntity> show(){
        ManDAOImpl manDAO = new ManDAOImpl();
        return manDAO.findAll();
    }

    public String confirmPage() {
        return "confirm";
    }

    public String delete(int id){
        manDAOCont.deleteMan(id);
        return "index";
    }

    public String confirm() {
        manDAOCont.addMan(man);
        conversation.end();
        return "index";
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }
}
