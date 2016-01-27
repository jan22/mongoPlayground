package de.controller;

import de.services.MongoDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niebuhr on 22.01.16.
 */

@Controller
public class MongoPageController {

    @RequestMapping(value="/")
    public ModelAndView get() {
        ModelAndView model = new ModelAndView("mongo");

        MongoDataService service = new MongoDataService();

        List<String> dbs = service.getDbNames();
        model.addObject("dbs", dbs);

        ArrayList<String> restaurants = service.getRestaurantNames();
        model.addObject("restaurants", restaurants);

        return model;
    }

}
