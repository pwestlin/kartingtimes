package nu.westlin.kartingtimes.drivers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DriverRepository extends Repository<Driver, Long> {

    // TODO petves: Implementera
    //public Driver findByName(String firstName, String surname);

    Driver findById(long id);

    @Query("SELECT count(*) from Driver") int countDrivers();

    List<Driver> findByFirstName(String firstName);

    List<Driver> findAll();
}
