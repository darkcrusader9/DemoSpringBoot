package com.avas.springboot.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ImageController {
    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] fetchImageController(@RequestParam("id") String id,
                                       @RequestParam(value = "height", required = false, defaultValue = "200") String height,
                                       @RequestParam(value = "width", required = false, defaultValue = "200") String width) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://picsum.photos/" + "id/" + id + "/" + height + "/" + width;
        return restTemplate.getForObject(new URI(url), byte[].class);
    }
}
