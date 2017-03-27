package beans;

import dao.ManDAOCont;
import entities.Man;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

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

    public String confirmPage() {
        return "confirm";
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
