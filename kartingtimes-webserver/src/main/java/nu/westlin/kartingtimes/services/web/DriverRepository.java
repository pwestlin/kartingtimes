package nu.westlin.kartingtimes.services.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static nu.westlin.kartingtimes.services.web.Services.DRIVERS_SERVICE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(DRIVERS_SERVICE)
public interface DriverRepository {

    @RequestMapping(value = "/drivers", method = GET) List<Driver> getDrivers();

    @RequestMapping(value = "/drivers/firstName/{firstName}", method = GET) List<Driver> findByFirstName(@PathVariable("firstName") String firstName);

    @RequestMapping(value = "/driver", method = GET) Driver getDriver();

    @RequestMapping(value = "/driver/{id}", method = GET) Driver getDriver(@PathVariable("id") Long driverId);


}
