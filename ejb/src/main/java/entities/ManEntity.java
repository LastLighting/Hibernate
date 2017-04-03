package entities;

import javax.persistence.*;

/**
 * Created by aalle on 03.04.2017.
 */
@Entity
@Table(name = "man", schema = "ejbdb", catalog = "")
public class ManEntity {
    private int id;
    private String name;
    private int old;

    private ConditionEntity conditionEntity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idMan")
    public ConditionEntity getConditionEntity() {
        return conditionEntity;
    }

    public void setConditionEntity(ConditionEntity conditionEntity) {
        this.conditionEntity = conditionEntity;
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
    @Column(name = "old")
    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManEntity manEntity = (ManEntity) o;

        if (id != manEntity.id) return false;
        if (old != manEntity.old) return false;
        if (name != null ? !name.equals(manEntity.name) : manEntity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + old;
        return result;
    }
}
