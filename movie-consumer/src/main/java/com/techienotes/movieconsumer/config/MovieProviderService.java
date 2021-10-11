package com.techienotes.movieconsumer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@EnableDiscoveryClient
@EnableFeignClients
public class MovieProviderService {

    @Autowired
    private MovieProviderClient client;

    public String getMovieName() {
        return client.getMovieName();
    }

    public String getMovieName(String movieName) {
        return client.getMovieName(movieName);
    }

    @FeignClient(name = "movie-provider")
    interface MovieProviderClient {

        @GetMapping(path = "/movies/")
        @ResponseBody
        String getMovieName();

        @GetMapping(path = "/movies/{name}")
        @ResponseBody
        String getMovieName(@PathVariable("name") String movieName);
    }
}
