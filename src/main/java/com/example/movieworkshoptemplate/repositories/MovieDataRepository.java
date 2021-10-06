package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDataRepository {
    //Methods to get data from file
    private List<Movie> movieListResult = new ArrayList<Movie>();

    public List<Movie> readCsv () throws FileNotFoundException {
        File f = new File("resources/imdb-data.csv");
        Scanner sc = new Scanner(f);

        sc.nextLine();

        while (sc.hasNext()){
            String thisLine = sc.nextLine();
            String[] movieList = thisLine.split(";");

            int year = Integer.parseInt(movieList[0]);
            int lenght = Integer.parseInt(movieList[1]);
            String title = movieList[2];
            String subject  = movieList[3];
            int popularity  = Integer.parseInt(movieList[4]);
            String awards  = movieList[5];
            Movie movies = new Movie(year, lenght, title, subject, popularity, awards);
            movieListResult.add(movies);
        }
        return movieListResult;
    }

    public List<Movie> getMovieListResult() {
        return movieListResult;
    }

}
