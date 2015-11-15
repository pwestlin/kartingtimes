package nu.westlin.kartingtimes.services.client;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@RestController
public class ClientController {

    protected KartingTimesService service;

    protected Logger logger = Logger.getLogger(ClientController.class
        .getName());

    @Inject
    public ClientController(KartingTimesService service) {
        this.service = service;
    }


    @RequestMapping(value = "/driver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Driver driver() {
        return new Driver();
    }

    @RequestMapping(value = "/randomdriver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Driver randomdriver() {
        List<Driver> drivers = service.drivers();
        Random rand = new Random();

        return drivers.get(rand.nextInt(drivers.size()));
    }

    @RequestMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Driver> drivers() {
        return service.drivers();
    }

    @RequestMapping(value = "/drivers/firstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Driver> driverByFirstName(@PathVariable("firstName") String firstName) {
        logger.info("drivers-byFirstName driverByFirstName() invoked");

        List<Driver> drivers = service.findDriverByFirstName(firstName);
        logger.info("drivers-service driverByFirstName() found: " + drivers);

        if (drivers == null || drivers.size() == 0)
            throw new DriverNotFoundException(firstName);
        else {
            return drivers;
        }
    }

    @RequestMapping(value = "/tracks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Track> tracks() {
        return service.tracks();
    }

    @RequestMapping(value = "/laptimes/driver/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LapTime> lapTimesOnAllTracksForDriver(@PathVariable("driverId") Long driverId) {
        return service.lapTimesOnAllTracksForDriver(driverId);
    }

    @RequestMapping(value = "/laptimes/driver/{driverId}/track/{trackId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LapTime> lapTimesOnAllTracksForDriver(@PathVariable("driverId") Long driverId, @PathVariable("trackId") Long trackId) {
        return service.lapTimesOnTrackForDriver(driverId, trackId);
    }

    @RequestMapping(value = "/laptimes/track/{trackId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LapTime> lapTimesOnOneTrackAllDrivers(@PathVariable("trackId") Long trackId) {
        return service.lapTimesOnOneTrackAllDrivers(trackId);
    }
}
