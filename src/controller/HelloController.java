package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello Brother";
    }

    @RequestMapping(value = "/nothing", method = RequestMethod.GET)
    public String sayNothing(){
        return "hello nothing";
    }
}
