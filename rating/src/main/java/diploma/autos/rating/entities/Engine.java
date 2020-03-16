package diploma.autos.rating.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@IdClass(EnginePK.class)
public class Engine {
    private String brand;
    private String model;
    private BigDecimal volume;
    private Integer value;

    @Id
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Id
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Id
    @Column(name = "volume")
    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (brand != null ? !brand.equals(engine.brand) : engine.brand != null) return false;
        if (model != null ? !model.equals(engine.model) : engine.model != null) return false;
        if (volume != null ? !volume.equals(engine.volume) : engine.volume != null) return false;
        if (value != null ? !value.equals(engine.value) : engine.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
