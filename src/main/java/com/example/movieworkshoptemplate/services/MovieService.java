package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MovieService {
    //Services called from controllers that returns what the client requests
    MovieDataRepository data = new MovieDataRepository();

    public String getFirst() throws FileNotFoundException {
        data.readCsv();

        return data.getMovieListResult().get(0).getTitle();
    }

    public String getRandom() throws FileNotFoundException {
        data.readCsv();
        Random rand = new Random();
        int randomInt = rand.nextInt(data.getMovieListResult().size());
        return data.getMovieListResult().get(randomInt).getTitle();
    }

    public int awardWinners () throws FileNotFoundException{
        data.readCsv();
        int count = 0;
        for (int i=0; i < data.getMovieListResult().size(); i++)
            if (data.getMovieListResult().get(i).getAwards() == "Yes"){
                count ++;
                System.out.println(data.getMovieListResult().get(i).getTitle());
            }

        else {

            }
        return count;

    }

    public ArrayList<Movie> getTenSortByPopularity () throws FileNotFoundException {
        data.readCsv();
        Random randomMovie = new Random();
        ArrayList<Movie> movieList = new ArrayList<>();

        for (int i=0; i < 10; i++){
            int movieInt = randomMovie.nextInt(data.getMovieListResult().size());
            movieList.add(data.getMovieListResult().get(movieInt));
        }


        return movieList;
    }
    
}
