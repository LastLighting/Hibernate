package beans;



import entities.HouseEntity;
import entities.ManEntity;
import service.ManService;

import javax.annotation.PostConstruct;
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

    ManService manService = new ManService();
    ManEntity manEntity = new ManEntity();
    List<ManEntity> manEntities ;
    HouseEntity house = new HouseEntity();

    public HouseEntity getHouse() {
        return house;
    }

    public void setHouse(HouseEntity house) {
        this.house = house;
    }

    public ManEntity getManEntity() {
        return manEntity;
    }

    public void setManEntity(ManEntity manEntity) {
        this.manEntity = manEntity;
    }

    public List<ManEntity> getManEntities() {
        return manEntities = manService.getAll();
    }

    public void setManEntities(List<ManEntity> manEntities) {
        this.manEntities = manEntities;
    }

    public String add(){
        return "add";
    }

    public String confirmPage(){
        manEntity.setHouse(house);
        manService.addMan(manEntity,house);
        return "index";
    }

//    public String addHome(){
//        manService.addHome(house);
//        return "index";
//    }

    public String goAddHome(){
        return "addHome";
    }

}
