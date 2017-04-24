package entities;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by aalle on 24.04.2017.
 */
@Entity
@Table(name = "man", schema = "testbd", catalog = "")
@NamedQuery(name = "Man.getAll", query = "SELECT c from ManEntity c")
public class ManEntity {
    private int id;
    private String name;
    private Date dateOfBirth;
    private HouseEntity house;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<CarEntity> getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(Set<CarEntity> carEntity) {
        this.carEntity = carEntity;
    }

    private Set<CarEntity> carEntity;

    @OneToOne
    @JoinColumn(name = "id_house", referencedColumnName = "id")
    public HouseEntity getHouse() {
        return house;
    }

    public void setHouse(HouseEntity house) {
        this.house = house;
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
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManEntity manEntity = (ManEntity) o;

        if (id != manEntity.id) return false;
        if (name != null ? !name.equals(manEntity.name) : manEntity.name != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(manEntity.dateOfBirth) : manEntity.dateOfBirth != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }
}
