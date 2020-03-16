package diploma.autos.catalog.dto;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "advertisement", schema = "catalog", catalog = "")
public class AdvertisementDTO {
    private int advertisementId;
    private Timestamp created;
    private Integer authorId;

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

    @Basic
    @Column(name = "authorID")
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
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
