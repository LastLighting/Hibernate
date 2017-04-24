package entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by aalle on 25.04.2017.
 */
@Entity
@Table(name = "car", schema = "testbd", catalog = "")
public class CarEntity {
    private int id;
    private String name;
    private int cost;
    private ManEntity manEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_car")
    public ManEntity getManEntity() {
        return manEntity;
    }

    public void setManEntity(ManEntity manEntity) {
        this.manEntity = manEntity;
    }



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
