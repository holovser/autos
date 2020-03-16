package diploma.autos.catalog.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ADVERTISEMENT")
//@IdClass(AdvertisementPK.class)
public class Advertisement {
    @Column(name = "CREATED")
    private Timestamp created;
    @Id
    @Column(name = "advertisementID")
    private int advertisementId;

//    @Transient
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorID", referencedColumnName = "authorID")
    private Author author;

//    @Transient
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carID", referencedColumnName = "carID")
    private Car car;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(int advertisementId) {
        this.advertisementId = advertisementId;
    }


    @Override
    public boolean equals(Object o) {

        return true;
    }

    @Override
    public int hashCode() {
        int result = created != null ? created.hashCode() : 0;
        result = 31 * result;
        result = 31 * result + advertisementId;
        result = 31 * result;
        return result;
    }
}
