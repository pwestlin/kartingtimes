package nu.westlin.kartingtimes.services.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

@Controller
public class DriversController {

    protected DriverRepository driverRepository;
    protected TrackRepository trackRepository;

    @Inject
    public DriversController(DriverRepository driverRepository, TrackRepository trackRepository) {
        this.driverRepository = driverRepository;
        this.trackRepository = trackRepository;
    }


    @RequestMapping("/drivers")
    public String drivers(Model model) {
        List<Driver> drivers = driverRepository.getDrivers();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }

    @RequestMapping("/tracks")
    public String tracks(Model model) {
/*
        List<Driver> tracks = driverRepository.getDrivers();
        model.addAttribute("tracks", tracks);
        return "tracks";
*/
        List<Track> tracks = trackRepository.getTracks();
        model.addAttribute("tracks", tracks);
        return "tracks";
    }

}
