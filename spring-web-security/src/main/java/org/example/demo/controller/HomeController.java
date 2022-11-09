package org.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value="/home")
    public ModelAndView hello(@RequestParam(required=false, defaultValue="World", name = "name") String name, HttpServletRequest req) {
        String cookie = req.getHeader("Cookie");
        ModelAndView ret = new ModelAndView("home");
        // Adds an objet to be used in home.jsp
        ret.addObject("name", name);
        //ret.addObject("cookie", cookie);home.jsp
        return ret;
    }

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView login(HttpServletResponse response, HttpServletRequest request) {
        ModelAndView ret = new ModelAndView("index");
        // Adds an objet to be used in index.jsp
        ret.addObject("name", request.getUserPrincipal().getName());
        return ret;
    }
}