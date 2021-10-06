package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@RestController
public class MovieController {
    MovieService service = new MovieService();

    //Controller methods
    @GetMapping("/")
    public String index(){
        return "Hello World welcome to my application - Movie Reader";
    }

    @GetMapping("/first")
    public String first() throws FileNotFoundException {
        return service.getFirst();
    }
    @GetMapping("/getRand")
    public String rand() throws FileNotFoundException {
        return service.getRandom();
    }

    @GetMapping("/howmanywonanaward")
    public int award() throws FileNotFoundException{
        return service.awardWinners();
    }

    @GetMapping("/getTenSortByPopularity")
    public ArrayList<Movie> list() throws FileNotFoundException {
        return service.getTenSortByPopularity();
    }


}
