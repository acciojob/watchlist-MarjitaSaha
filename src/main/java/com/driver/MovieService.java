package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie)
    {
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director)
    {
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String director, String movie)
    {
        movieRepository.addMovieDirectorPair(director,movie);
    }
    public Movie findMovie(String movieName){
        return movieRepository.getMovieByName(movieName);
    }

    public Director findDirector(String directorName){
        return movieRepository.getDirectorByName(directorName);
    }

    public List<String> findMoviesFromDirector(String director){
        return movieRepository.getMoviesByDirectorName(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirectorByName(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}


