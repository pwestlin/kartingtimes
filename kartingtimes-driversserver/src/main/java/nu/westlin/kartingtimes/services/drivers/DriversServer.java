package nu.westlin.kartingtimes.services.drivers;

import nu.westlin.kartingtimes.drivers.DriversWebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import java.util.logging.Logger;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(DriversWebApplication.class)
public class DriversServer {

    protected Logger logger = Logger.getLogger(DriversServer.class.getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        SpringApplication.run(DriversServer.class, args);
    }
}
