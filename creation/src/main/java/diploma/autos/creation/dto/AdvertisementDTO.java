package diploma.autos.creation.dto;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "advertisement", schema = "catalog", catalog = "")
public class AdvertisementDTO {
    private int advertisementId;
    private Timestamp created;
    private int authorId;
    private Integer carId;

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

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "authorID")
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "carID")
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementDTO that = (AdvertisementDTO) o;

        if (advertisementId != that.advertisementId) return false;
        if (authorId != that.authorId) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (carId != null ? !carId.equals(that.carId) : that.carId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = advertisementId;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + authorId;
        result = 31 * result + (carId != null ? carId.hashCode() : 0);
        return result;
    }
}
