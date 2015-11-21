package nu.westlin.kartingtimes.laptimes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class LapTimesController {

    protected Logger logger = Logger.getLogger(LapTimesController.class.getName());
    protected LapTimesRepository lapTimesRepository;

    @Autowired
    public LapTimesController(LapTimesRepository lapTimesRepository) {
        this.lapTimesRepository = lapTimesRepository;

        logger.info("LapTimesRepository says system has "
            + lapTimesRepository.countLapTimes() + " lapTimes");
    }

    @RequestMapping(value = "/laptimes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LapTime byId(@PathVariable("id") long id) {

        logger.info("laptimes-service byId() invoked: " + id);
        LapTime lapTime = lapTimesRepository.findById(id);
        logger.info("laptimes-service byId() found: " + lapTime);

        if (lapTime == null)
            throw new LapTimeNotFoundException(id);
        else {
            return lapTime;
        }
    }

    @RequestMapping(value = "/laptime/driver/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LapTime> lapTimesByDriver(@PathVariable("id") long driverId) {
        return lapTimesRepository.findByDriverId(driverId);
    }

    @RequestMapping(value = "/laptime/track/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LapTime> lapTimesByTrack(@PathVariable("id") long trackId) {
        return lapTimesRepository.findByTrackId(trackId);
    }

    @RequestMapping(value = "/laptime/driver/{driverId}/track/{trackId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LapTime> lapTimesByDriverAndTrack(@PathVariable("driverId") long driverId, @PathVariable("trackId") long trackId) {
        return lapTimesRepository.findByDriverIdAndTrackId(driverId, trackId);
    }

    @RequestMapping(value = "/laptimes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LapTime> laptimes() {
        return lapTimesRepository.findAll();
    }
}
