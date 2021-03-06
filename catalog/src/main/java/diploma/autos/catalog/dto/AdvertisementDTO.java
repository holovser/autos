package diploma.autos.catalog.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * DTO class for working with advertisement table
 */
@Entity
@Table(name = "Advertisement", schema = "catalog", catalog = "")
public class AdvertisementDTO {
    private int advertisementId;
    private Timestamp created;
    private Double rating;
    private Integer price;

    @Id
    @Column(name = "AdvertisementID")
    public int getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(int advertisementId) {
        this.advertisementId = advertisementId;
    }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    @Column()
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Column()
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementDTO that = (AdvertisementDTO) o;

        if (advertisementId != that.advertisementId) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = advertisementId;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
