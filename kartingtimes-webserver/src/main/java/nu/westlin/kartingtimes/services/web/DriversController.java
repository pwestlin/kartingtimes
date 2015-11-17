package nu.westlin.kartingtimes.services.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

@Controller
public class DriversController {

    protected DriverRepository driverRepository;

    @Inject
    public DriversController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @RequestMapping("/drivers")
    public String drivers(Model model) {
        List<Driver> accounts = driverRepository.getDrivers();
        model.addAttribute("drivers", accounts);
        return "drivers";
    }

}
