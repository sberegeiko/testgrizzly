package by.beregeiko.testgrizzly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Simple controller to show welcome page
 *
 * @author Think
 */

@Controller
@RequestMapping(value = {"/", "/welcome"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String show() {
        return "welcome";
    }
}
