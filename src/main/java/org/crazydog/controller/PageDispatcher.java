package org.crazydog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 这个是jsp资源跳转的分配器
 * Created by never on 2015/8/27.
 */
@Deprecated
@Controller
public class PageDispatcher {

    @RequestMapping("/views")
    public String dispatch(HttpServletRequest request) {
        String parameter = request.getParameter("page");
//        System.out.println(parameter);
        if (parameter != null) {
//            return "forward:/WEB-INF/views/" + parameter + ".jsp";
            return parameter;
        }
        return null;
    }

}
