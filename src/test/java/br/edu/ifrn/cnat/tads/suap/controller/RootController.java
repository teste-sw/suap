package br.edu.ifrn.cnat.tads.suap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RootController {

    // private final GreetingService service;

    public RootController() {
        // this.service = service;
    }

    @RequestMapping("/")
    public @ResponseBody String root() {
        return "OK";
    }

}
