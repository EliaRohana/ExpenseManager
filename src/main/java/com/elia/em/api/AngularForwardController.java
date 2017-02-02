package com.elia.em.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Elia on 2/2/2017.
 */
@Controller
public class AngularForwardController {

    @RequestMapping(value = "/em/**")
    public String redirect() {
        return "forward:/index.html";
    }
    @RequestMapping("/")
    public String index() {
        return "forward:/index.html";
    }
}
