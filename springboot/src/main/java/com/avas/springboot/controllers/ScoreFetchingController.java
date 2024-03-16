package com.avas.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreFetchingController {
    private static final Logger logger = LoggerFactory.getLogger(ScoreFetchingController.class);
    @GetMapping("/getScore")
    public String getScore(@RequestParam("sport") String sport, @RequestParam("match") String match){
        logger.info("Client has made a request");
        return "Hello " + sport + " " + match;
    }
}
