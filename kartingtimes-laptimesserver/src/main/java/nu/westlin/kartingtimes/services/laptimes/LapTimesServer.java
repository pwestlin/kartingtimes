package nu.westlin.kartingtimes.services.laptimes;

import nu.westlin.kartingtimes.laptimes.LapTimesWebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import java.util.logging.Logger;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(LapTimesWebApplication.class)
public class LapTimesServer {

    protected Logger logger = Logger.getLogger(LapTimesServer.class.getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        SpringApplication.run(LapTimesServer.class, args);
    }
}
