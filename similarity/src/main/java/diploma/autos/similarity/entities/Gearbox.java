package diploma.autos.similarity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Gearbox {

    @EmbeddedId GearboxId gearboxId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "gearbox")
    @JsonIgnore
    private Set<Car> car;

    public Set<Car> getCar() {
        return car;
    }

    public void setCar(Set<Car> car) {
        this.car = car;
    }

    public GearboxId getGearboxId() {
        return gearboxId;
    }

    public void setGearboxId(GearboxId gearboxId) {
        this.gearboxId = gearboxId;
    }
}
