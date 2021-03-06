package diploma.autos.similarity.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ADVERTISEMENT")
//@IdClass(AdvertisementPK.class)
public class Advertisement {
    @Column(name = "created")
    private Timestamp created;

    @Id
    @Column(name = "advertisementID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int advertisementId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorID", referencedColumnName = "authorID")
    private Author author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carID", referencedColumnName = "carID")
    private Car car;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "price")
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return advertisementId == that.advertisementId &&
                Objects.equals(created, that.created) &&
                Objects.equals(rating, that.rating) &&
                price.equals(that.price);
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "created=" + created +
                ", advertisementId=" + advertisementId +
                ", author=" + author +
                ", car=" + car +
                ", rating=" + rating +
                ", price=" + price +
                '}';
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
