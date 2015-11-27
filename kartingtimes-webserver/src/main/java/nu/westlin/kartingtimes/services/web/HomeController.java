package nu.westlin.kartingtimes.services.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home page controller.
 *
 * @author Paul Chapman
 */
@Controller
public class HomeController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/accounts/search", method = RequestMethod.GET)
    public String laptimesSearchForm(Model model) {
        model.addAttribute("searchCriteria", new SearchCriteria());
        return "laptimesSearch";
    }

    @RequestMapping(value = "/laptimes/dosearch")
    public String doSearch(Model model, SearchCriteria criteria,
                           BindingResult result) {
        logger.info("web-service search() invoked: " + criteria);

        criteria.validate(result);

        if (result.hasErrors())
            return "laptimesSearch";

        String accountNumber = criteria.getAccountNumber();
        if (StringUtils.hasText(accountNumber)) {
            return byNumber(model, accountNumber);
        } else {
            String searchText = criteria.getSearchText();
            return ownerSearch(model, searchText);
        }
    }
}
