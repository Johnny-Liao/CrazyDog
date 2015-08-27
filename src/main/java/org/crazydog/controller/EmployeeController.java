package org.crazydog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by johnny on 15-8-27.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {


    // eg : .../employee?pages=1 will get the information about the first page employee
    @RequestMapping(method = RequestMethod.GET, params = "pages")
    public ModelAndView getEmployeeByPages(@RequestParam("pages") String page, Model model) {
        return null;
    }

}
