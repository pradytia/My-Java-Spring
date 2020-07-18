package controller;

import adapter.HelloAdapter;
import database.DatabaseAdapter;
import model.mdlTblWaArtikel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello Brother";
    }

    @RequestMapping(value = "/nothing", method = RequestMethod.GET)
    public String sayNothing() {

        String id = HelloAdapter.GetDataArtikel();

        return id;
    }
}
