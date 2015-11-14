package nu.westlin.kartingtimes.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class WebDriversController {

    @Autowired
    protected WebDriversService accountsService;

    protected Logger logger = Logger.getLogger(WebDriversController.class
        .getName());

    public WebDriversController(WebDriversService accountsService) {
        this.accountsService = accountsService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("accountNumber", "searchText");
    }

    @RequestMapping("/driver")
    public Driver driver() {
        return new Driver();
    }

    @RequestMapping("/drivers")
    public List<Driver> drivers() {
        return accountsService.getDrivers();
        //return Lists.newArrayList(new Driver(), new Driver(), new Driver());
    }
}
