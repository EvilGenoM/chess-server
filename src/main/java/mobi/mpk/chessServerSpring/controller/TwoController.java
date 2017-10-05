package mobi.mpk.chessServerSpring.controller;

import mobi.mpk.chessServerSpring.registry.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoController {

    @Autowired
    private Test test;

    @Autowired
    private Test test2;

    @GetMapping("/one")
    public String two(){

        test.text += "misha";

        test2.text += "sadadsa";

        return test.text;

    }

}
