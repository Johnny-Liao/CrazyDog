package org.crazydog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by never on 2015/8/26.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(params = "method=verify", method = RequestMethod.POST)
    public void verify(String userName, String password) {
        System.out.println(userName + ":" + password);
    }
}
