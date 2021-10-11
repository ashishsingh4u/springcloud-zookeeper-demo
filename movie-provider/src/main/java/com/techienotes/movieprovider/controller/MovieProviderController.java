package com.techienotes.movieprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieProviderController {

    @GetMapping("{name}")
    public String getMovieName(@PathVariable("name") String movieName) {
        log.info("Request for movie: {}", movieName);
        return String.format("MovieName: %s", movieName);
    }

    @GetMapping("/")
    public String getMovieName() {
        log.info("Default request for movie");
        return String.format("MovieName: %s", "Titanic");
    }
}
