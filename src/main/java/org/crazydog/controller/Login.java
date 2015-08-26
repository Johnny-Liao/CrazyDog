package org.crazydog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by never on 2015/8/26.
 */
@Controller
public class Login {

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public void verify() {

    }
}
