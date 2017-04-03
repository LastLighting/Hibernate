package entities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by aalle on 03.04.2017.
 */
@Entity
@Table(name = "condition", schema = "ejbdb", catalog = "")
public class ConditionEntity {
    private int id;
    private ManEntity idMan;
    private String name;
    private int price;


    @OneToOne
    @Column(name = "id_man")
    public ManEntity getIdMan() {
        return idMan;
    }

    public void setIdMan(ManEntity idMan) {
        this.idMan = idMan;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
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
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConditionEntity that = (ConditionEntity) o;

        if (id != that.id) return false;
        if (idMan != that.idMan) return false;
        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

}
