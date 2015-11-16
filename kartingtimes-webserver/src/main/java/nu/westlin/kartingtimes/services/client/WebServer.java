package nu.westlin.kartingtimes.services.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "nu.westlin.kartingtimes.services.client")
public class WebServer {

    protected static final Logger logger = Logger.getLogger(WebServer.class.getName());

    /**
     * URL uses the logical name of account-service - upper or lower case,
     * doesn't matter.
     */
/*
    @Value("${drivers.service.url}")
    public String driversServiceUrl;
*/

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(WebServer.class, args);
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
/*
    @Bean
    public DriverRepository driversService() {
        return new DriverRepository(driversServiceUrl);
    }

    @Bean
    public ClientController driversController() {
        return new ClientController(driversService());
    }
*/

}
