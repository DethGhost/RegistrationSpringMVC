package org.ua.deth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.ua.deth.entity.User;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes(types = User.class)
public class RegistrationController {

    @RequestMapping(value = "registration.html", method = RequestMethod.GET)
    public ModelAndView getPage(ModelAndView modelAndView){
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView doRegistration(@ModelAttribute("user") User user, ModelAndView modelAndView, HttpSession session){
        modelAndView.setViewName("redirect:confirmation.html");
        session.setAttribute("UserConfirm", user);
        return modelAndView;
    }

    @RequestMapping(value = "confirmation.html", method = RequestMethod.GET)
    public String getConfirm(HttpSession session){
        return "confirmation";
    }

    @RequestMapping(value = "confirm", method = RequestMethod.POST)
    public ModelAndView getConfirmation(ModelAndView modelAndView, SessionStatus sessionStatus){
        modelAndView.setViewName("login");

        sessionStatus.setComplete(); // set session NULL
        return modelAndView;
    }
}
