package diploma.autos.rating.repositories;

import diploma.autos.rating.entities.Gearbox;
import diploma.autos.rating.entities.GearboxPK;
import org.springframework.data.repository.CrudRepository;

public interface GearboxRepository extends CrudRepository<Gearbox, GearboxPK> {
    Gearbox findByBrandAndType(String brand, String type);
}
