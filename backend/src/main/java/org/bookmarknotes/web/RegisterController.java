package org.bookmarknotes.web;

import org.bookmarknotes.dto.UserDTO;
import org.bookmarknotes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zealot on 09.08.18.
 */
@Controller
public class RegisterController {
    private UserService service;
    @RequestMapping("/register")
    public ModelAndView register(@ModelAttribute UserDTO user) {
        service.save(user);
        return new ModelAndView("/");
    }

    @Autowired
    public RegisterController setService(UserService service) {
        this.service = service;
        return this;
    }
}
