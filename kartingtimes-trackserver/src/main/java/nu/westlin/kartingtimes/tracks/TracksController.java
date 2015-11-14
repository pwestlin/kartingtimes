package nu.westlin.kartingtimes.tracks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TracksController {

    protected Logger logger = Logger.getLogger(TracksController.class.getName());
    protected TrackRepository trackRepository;

    /**
     * Create an instance plugging in the respository of Accounts.
     *
     * @param trackRepository An account repository implementation.
     */
    @Autowired
    public TracksController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;

        logger.info("TrackRepository says system has "
            + trackRepository.countTracks() + " tracks");
    }

    @RequestMapping(value = "/tracks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Track byId(@PathVariable("id") long id) {

        logger.info("tracks-service byId() invoked: " + id);
        Track track = trackRepository.findById(id);
        logger.info("tracks-service byId() found: " + track);

        if (track == null)
            throw new TrackNotFoundException(id);
        else {
            return track;
        }
    }

    @RequestMapping(value = "/track", produces = MediaType.APPLICATION_JSON_VALUE)
    public Track track() {
        return new Track(1L, "Peter", "Westlin");
    }

    @RequestMapping(value = "/tracks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Track> tracks() {
        return trackRepository.findAll();
    }

    @RequestMapping(value = "/tracks/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Track> byFirstName(@PathVariable("name") String name) {
        logger.info("tracks-byFirstName byOwner() invoked");

        List<Track> accounts = trackRepository.findByName(name);
        logger.info("tracks-service byFirstName() found: " + accounts);

        if (accounts == null || accounts.size() == 0)
            throw new TrackNotFoundException(name);
        else {
            return accounts;
        }
    }
}
