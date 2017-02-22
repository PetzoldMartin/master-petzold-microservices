package Billing.Controller;

import Billing.Loader.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Aismael on 08.02.2017.
 */
@RestController
@RequestMapping(path = "/config")
public class RestConfigController {
    @Autowired
    MyConfig myConfig;
    @RequestMapping(value = "/json")
    public String getConfig() {
        return myConfig.getConfigJson();
    }
}
