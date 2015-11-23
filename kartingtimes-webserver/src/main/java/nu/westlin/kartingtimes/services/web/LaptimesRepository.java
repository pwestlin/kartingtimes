package nu.westlin.kartingtimes.services.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static nu.westlin.kartingtimes.services.web.Services.LAPTIMES_SERVICE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(LAPTIMES_SERVICE)
public interface LaptimesRepository {

    @RequestMapping(value = "/laptime/driver/{id}", method = GET) List<LapTime> getLapTimeByDriver(@PathVariable("id") Long driverId);

    @RequestMapping(value = "/laptime/track/{id}", method = GET) List<LapTime> getLapTimeByTrack(@PathVariable("id") Long trackId);

    @RequestMapping(value = "/laptime/driver/{driverId}/track/{trackId}", method = GET) List<LapTime> getLapTimeByTrackAndDriver(
        @PathVariable("driverId") Long driverId, @PathVariable("trackId") Long trackId);

}
