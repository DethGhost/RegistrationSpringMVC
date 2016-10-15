package org.ua.deth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.ua.deth.entity.User;
import org.ua.deth.validation.FromValidator;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes(types = User.class)
public class RegistrationController {

    @Autowired
    FromValidator validator;

    @RequestMapping(value = "registration.html", method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView doRegistration(@ModelAttribute("user") @Validated User user, BindingResult result, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:confirmation.html");
            session.setAttribute("UserConfirm", user);
            return modelAndView;
        }
    }

    @RequestMapping(value = "confirmation.html", method = RequestMethod.GET)
    public String getConfirm(HttpSession session) {
        return "confirmation";
    }

    @RequestMapping(value = "confirm", method = RequestMethod.POST)
    public ModelAndView getConfirmation(SessionStatus sessionStatus) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        sessionStatus.setComplete(); // set session NULL
        return modelAndView;
    }

    @InitBinder
    protected void initValidator(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validator);
    }
}
