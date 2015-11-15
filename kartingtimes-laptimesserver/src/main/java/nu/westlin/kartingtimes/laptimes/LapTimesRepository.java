package nu.westlin.kartingtimes.laptimes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LapTimesRepository extends Repository<LapTime, Long> {

    @Query("SELECT count(*) from LapTime") int countLapTimes();

    List<LapTime> findAll();

    LapTime findById(long id);

    List<LapTime> findByDriverId(long driverId);

    List<LapTime> findByTrackId(long trackId);

    List<LapTime> findByDriverIdAndTrackId(long driverId, long trackId);
}
