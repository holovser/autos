package diploma.autos.rating.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

public class EnginePK implements Serializable {
    private String brand;
    private String model;
    private BigDecimal volume;

    @Column(name = "brand")
    @Id
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model")
    @Id
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "volume")
    @Id
    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnginePK enginePK = (EnginePK) o;

        if (brand != null ? !brand.equals(enginePK.brand) : enginePK.brand != null) return false;
        if (model != null ? !model.equals(enginePK.model) : enginePK.model != null) return false;
        if (volume != null ? !volume.equals(enginePK.volume) : enginePK.volume != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        return result;
    }
}
