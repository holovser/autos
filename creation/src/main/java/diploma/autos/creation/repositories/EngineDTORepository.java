package diploma.autos.creation.repositories;

import diploma.autos.creation.entities.Engine;
import diploma.autos.creation.entities.EngineId;
import org.springframework.data.repository.CrudRepository;

public interface EngineDTORepository extends CrudRepository<Engine, EngineId> {
}
