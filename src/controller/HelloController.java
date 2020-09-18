package controller;

import adapter.HelloAdapter;
import org.springframework.web.bind.annotation.*;


@CrossOrigin    //==> enable allow cross origin (spy bs di akses dr fe)
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

    @RequestMapping(value = "/testing", method = RequestMethod.POST)
    public @ResponseBody String
    testing(
            @RequestHeader String Authorization,
            @RequestBody String param
    ) {

        String auth= "";
        String body = "";

        auth = Authorization;
        body =  param;

        System.out.println(auth + body);

        String id = HelloAdapter.GetDataArtikel();

        return id;
    }
}
