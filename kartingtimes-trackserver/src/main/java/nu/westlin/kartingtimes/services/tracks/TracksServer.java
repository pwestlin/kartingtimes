package nu.westlin.kartingtimes.services.tracks;

import nu.westlin.kartingtimes.tracks.TracksWebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import java.util.logging.Logger;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(TracksWebApplication.class)
public class TracksServer {

    protected Logger logger = Logger.getLogger(TracksServer.class.getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        SpringApplication.run(TracksServer.class, args);
    }
}
