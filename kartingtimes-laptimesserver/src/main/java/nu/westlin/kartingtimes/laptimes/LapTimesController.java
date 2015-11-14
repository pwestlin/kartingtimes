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

    /**
     * Create an instance plugging in the respository of Accounts.
     *
     * @param lapTimesRepository An account repository implementation.
     */
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

    @RequestMapping(value = "/laptimes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LapTime> tracks() {
        return lapTimesRepository.findAll();
    }
}
