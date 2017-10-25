package mobi.mpk.chessServerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConnectController {

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(String name, String password) {


        return null;
    }

}
