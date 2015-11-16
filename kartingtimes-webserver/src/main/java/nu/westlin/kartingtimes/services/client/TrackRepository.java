package nu.westlin.kartingtimes.services.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class TrackRepository {

    protected Logger logger = Logger.getLogger(TrackRepository.class.getName());

    private final String serviceUrl;

    protected RestTemplate restTemplate;

    @Inject
    public TrackRepository(RestTemplate restTemplate, @Value("${tracks.service.url}") String serviceUrl) {
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
            : "http://" + serviceUrl;

        this.logger.info("serviceUrl = " + serviceUrl);
    }

    public List<Track> getTracks() {
        Track[] tracks = null;

        tracks = restTemplate.getForObject(serviceUrl + "/tracks", Track[].class);

        if (tracks != null && tracks.length > 0) {
            return Arrays.asList(tracks);
        } else {
            return null;
        }
    }

    public Track getTrack(Long id) {
        return restTemplate.getForObject(serviceUrl + "/tracks/{id}", Track.class, id);
    }
}
