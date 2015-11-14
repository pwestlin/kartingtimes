package nu.westlin.kartingtimes.tracks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DriversController {

    protected Logger logger = Logger.getLogger(DriversController.class.getName());
    protected DriverRepository driverRepository;

    /**
     * Create an instance plugging in the respository of Accounts.
     *
     * @param driverRepository An account repository implementation.
     */
    @Autowired
    public DriversController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;

        logger.info("DriverRepository says system has "
            + driverRepository.countDrivers() + " drivers");
    }

    /**
     * Fetch an account with the specified account number.
     *
     * @param accountNumber A numeric, 9 digit account number.
     * @return The account if found.
     * @throws AccountNotFoundException If the number is not recognised.
     */
    @RequestMapping(value = "/drivers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Driver byId(@PathVariable("id") long id) {

        logger.info("drivers-service byId() invoked: " + id);
        Driver driver = driverRepository.findById(id);
        logger.info("drivers-service byId() found: " + driver);

        if (driver == null)
            throw new DriverNotFoundException(id);
        else {
            return driver;
        }
    }

    @RequestMapping(value = "/driver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Driver driver() {
        return new Driver(1L, "Peter", "Westlin");
    }

    @RequestMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Driver> drivers() {
        return driverRepository.findAll();
    }

    @RequestMapping(value = "/drivers/firstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Driver> byFirstName(@PathVariable("firstName") String firstName) {
        logger.info("drivers-byFirstName byOwner() invoked");

        List<Driver> accounts = driverRepository.findByFirstName(firstName);
        logger.info("drivers-service byFirstName() found: " + accounts);

        if (accounts == null || accounts.size() == 0)
            throw new DriverNotFoundException(firstName);
        else {
            return accounts;
        }
    }
}
