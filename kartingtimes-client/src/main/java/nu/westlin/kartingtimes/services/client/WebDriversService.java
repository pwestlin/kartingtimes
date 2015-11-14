package nu.westlin.kartingtimes.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class WebDriversService {

    protected Logger logger = Logger.getLogger(WebDriversService.class.getName());

    private final String serviceUrl;

    //@LoadBalanced
    @Autowired
    protected RestTemplate restTemplate;

    public WebDriversService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
            : "http://" + serviceUrl;

        this.logger.info("serviceUrl = " + serviceUrl);
    }

    public Driver getDriver(Long id) {
        logger.info("Looking for: " + serviceUrl + "/drivers/{" + id + "}");
        return restTemplate.getForObject(serviceUrl + "/drivers/{id}", Driver.class, id);
    }

    public Driver getDriver() {
        logger.info("Looking for: " + serviceUrl + "/driver");
        return restTemplate.getForObject(serviceUrl + "/driver", Driver.class);
    }

    public List<Driver> getDrivers() {
        Driver[] drivers = null;

        drivers = restTemplate.getForObject(serviceUrl + "/drivers", Driver[].class);

        if (drivers != null && drivers.length > 0) {
            return Arrays.asList(drivers);
        } else {
            return null;
        }
    }

    public List<Driver> findByFirstName(String firstName) {
        Driver[] drivers = null;

        drivers = restTemplate.getForObject(serviceUrl + "/drivers/firstName/{firstName}", Driver[].class, firstName);

        if (drivers != null && drivers.length > 0) {
            return Arrays.asList(drivers);
        } else {
            return null;
        }
    }
}
