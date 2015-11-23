package nu.westlin.kartingtimes.services.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static nu.westlin.kartingtimes.services.web.Services.TRACKS_SERVICE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(TRACKS_SERVICE)
public interface TrackRepository {

    @RequestMapping(value = "/tracks", method = GET) List<Track> getTracks();

    @RequestMapping(value = "/tracks/{id}", method = GET) Track getTrack(@PathVariable("id") Long trackId);
}
