package com.techienotes.movieconsumer.controller;

import com.techienotes.movieconsumer.service.MovieProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieConsumerController {

    @Autowired
    private MovieProviderService movieProviderService;

    @GetMapping("/")
    public String getMovieName() {
        return movieProviderService.getMovieName();
    }

    @GetMapping("{name}")
    public String getMovieName(@PathVariable("name") String movieName) {
        return movieProviderService.getMovieName(movieName);
    }
}
