package mobi.mpk.chessServerSpring.controller;

import mobi.mpk.chessServerSpring.model.User;
import mobi.mpk.chessServerSpring.service.SecurityService;
import mobi.mpk.chessServerSpring.service.UserService;
import mobi.mpk.chessServerSpring.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(String request, BindingResult bindingResult) {

        User user = new User();

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(user);

        securityService.autologin(user.getUsername(), user.getPassword());

        return "welcome";
    }

}
