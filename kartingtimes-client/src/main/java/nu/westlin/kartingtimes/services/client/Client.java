package nu.westlin.kartingtimes.services.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
// Disable component scan
@ComponentScan(useDefaultFilters = false)
public class Client {

    protected static final Logger logger = Logger.getLogger(Client.class.getName());

    /**
     * URL uses the logical name of account-service - upper or lower case,
     * doesn't matter.
     */
    public static final String DRIVERS_SERVICE_URL = "http://DRIVERS-SERVICE";

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Client.class, args);
/*
        WebDriversService driversService = ctx.getBean(WebDriversService.class);

        //Driver driver = driversService.getDriver(123l);
        Driver driver = driversService.getDriver();

        logger.info("driver = " + driver);
*/

    }

    /**
     * The AccountService encapsulates the interaction with the micro-service.
     *
     * @return A new service instance.
     */
    @Bean
    public WebDriversService accountsService() {
        return new WebDriversService(DRIVERS_SERVICE_URL);
    }

    @Bean
    public WebDriversController driversController() {
        return new WebDriversController(accountsService());
    }

}
