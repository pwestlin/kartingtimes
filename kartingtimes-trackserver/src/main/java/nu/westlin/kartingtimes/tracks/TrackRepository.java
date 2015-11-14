package nu.westlin.kartingtimes.tracks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TrackRepository extends Repository<Track, Long> {

    Track findById(long id);

    @Query("SELECT count(*) from Track") int countTracks();

    List<Track> findAll();

    List<Track> findByName(String name);
}
