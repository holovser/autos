package diploma.autos.creation.repositories;

import diploma.autos.creation.entities.Gearbox;
import diploma.autos.creation.entities.GearboxId;
import org.springframework.data.repository.CrudRepository;

public interface GearboxRepository extends CrudRepository<Gearbox, GearboxId> {
}
