package diploma.autos.similarity.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Engine {

    @EmbeddedId
    private EngineId engineId;

//    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "engine")
//    @JsonIgnore
//    private Set<Car> car;

//    public Set<Car> getCar() {
//        return car;
//    }
//
//    public void setCar(Set<Car> car) {
//        this.car = car;
//    }

    public EngineId getEngineId() {
        return engineId;
    }

    public void setEngineId(EngineId engineId) {
        this.engineId = engineId;
    }
}
