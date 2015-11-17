package nu.westlin.kartingtimes.services.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class LapTimeRepository {

    protected Logger logger = Logger.getLogger(LapTimeRepository.class.getName());

    private final String serviceUrl;

    protected RestTemplate restTemplate;

    @Inject
    public LapTimeRepository(RestTemplate restTemplate, @Value("${laptimes.service.url}") String serviceUrl) {
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
            : "http://" + serviceUrl;

        this.logger.info("serviceUrl = " + serviceUrl);
    }

    public List<LapTime> getLapTimeByDriver(Long driverId) {
        LapTime[] lapTimes = restTemplate.getForObject(serviceUrl + "/laptime/driver/{id}", LapTime[].class, driverId);
        //LapTime[] lapTimes = restTemplate.getForObject(serviceUrl + "/laptimes", LapTime[].class);

        if (lapTimes != null && lapTimes.length > 0) {
            return Arrays.asList(lapTimes);
        } else {
            return null;
        }
    }

    public List<LapTime> getLapTimeByTrack(Long trackId) {
        LapTime[] lapTimes = restTemplate.getForObject(serviceUrl + "/laptime/track/{id}", LapTime[].class, trackId);
        //LapTime[] lapTimes = restTemplate.getForObject(serviceUrl + "/laptimes", LapTime[].class);

        if (lapTimes != null && lapTimes.length > 0) {
            return Arrays.asList(lapTimes);
        } else {
            return null;
        }
    }

    public List<LapTime> getLapTimeByTrackAndDriver(Long driverId, Long trackId) {
        LapTime[] lapTimes = restTemplate.getForObject(serviceUrl + "/laptime/driver/{driverId}/track/{trackId}", LapTime[].class, driverId, trackId);
        //LapTime[] lapTimes = restTemplate.getForObject(serviceUrl + "/laptimes", LapTime[].class);

        if (lapTimes != null && lapTimes.length > 0) {
            return Arrays.asList(lapTimes);
        } else {
            return null;
        }
    }
}
