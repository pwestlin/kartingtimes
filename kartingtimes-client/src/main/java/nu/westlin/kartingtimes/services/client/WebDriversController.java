package nu.westlin.kartingtimes.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@RestController
public class WebDriversController {

    @Autowired
    protected WebDriversService driversService;

    protected Logger logger = Logger.getLogger(WebDriversController.class
        .getName());

    public WebDriversController(WebDriversService driversService) {
        this.driversService = driversService;
    }

/*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("accountNumber", "searchText");
    }
*/

    @RequestMapping(value = "/driver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Driver driver() {
        return new Driver();
    }

    @RequestMapping(value = "/randomdriver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Driver randomdriver() {
        List<Driver> drivers = driversService.getDrivers();
        Random rand = new Random();

        return drivers.get(rand.nextInt(drivers.size()));
    }

    @RequestMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Driver> drivers() {
        return driversService.getDrivers();
    }

    @RequestMapping(value = "/drivers/firstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Driver> byFirstName(@PathVariable("firstName") String firstName) {
        logger.info("drivers-byFirstName byOwner() invoked");

        List<Driver> drivers = driversService.findByFirstName(firstName);
        logger.info("drivers-service byFirstName() found: " + drivers);

        if (drivers == null || drivers.size() == 0)
            throw new DriverNotFoundException(firstName);
        else {
            return drivers;
        }
    }

}
