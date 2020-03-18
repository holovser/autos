package diploma.autos.rating.repositories;


import diploma.autos.rating.entities.Engine;
import diploma.autos.rating.entities.EnginePK;
import org.springframework.data.repository.CrudRepository;


public interface EngineRepository extends CrudRepository<Engine, EnginePK> {
    Engine findByBrandAndModelAndVolume(String brand, String model, Double volume);
}
