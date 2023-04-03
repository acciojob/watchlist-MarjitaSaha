package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    Map<String,Movie> movieMap=new HashMap<>();
    Map<String,Director> directorMap = new HashMap<>();
    Map<String, List<String>> directorMovieMap=new HashMap<>();
    public void addMovie(Movie movie)
    {
        movieMap.put(movie.getName(), movie);
    }
    public void addDirector(Director director)
    {
        directorMap.put(director.getName(), director);
    }
    public void addMovieDirectorPair(String director, String movie)
    {
        if (movieMap.containsKey(movie) && directorMap.containsKey(director))
        {
            if(directorMovieMap.containsKey(director))
            {
                List<String> temp=directorMovieMap.get(director);
                temp.add(movie);
                directorMovieMap.put(director,temp);
            }
            else
            {
                List<String> arr = new ArrayList<>();
                arr.add(movie);
                directorMovieMap.put(director,arr);
            }
        }
    }
    public Movie getMovieByName(String movieName)
    {
        if(movieMap.containsKey(movieName))
         return movieMap.get(movieName);
        return null;
    }
    public Director getDirectorByName(String directorName)
    {
        if(directorMap.containsKey(directorName))
            return directorMap.get(directorName);
        return null;
    }
    public List<String> getMoviesByDirectorName(String directorName)
    {
        List<String> moviesDirectedByDirector=new ArrayList<>();
        if(directorMovieMap.containsKey(directorName))
        {
            for (String movie:directorMovieMap.get(directorName))
            {
                moviesDirectedByDirector.add(movie);
            }
        }
        return moviesDirectedByDirector;
    }
    public List<String> findAllMovies()
    {
        return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirectorByName(String directorName)
    {
        List<String> movies = new ArrayList<>();
        if(directorMovieMap.containsKey(directorName))
        {
            for (String movie:directorMovieMap.get(directorName)) movies.add(movie);
            for (String movie:movies)
            {
                if (movieMap.containsKey(movie)) movieMap.remove(movie);
            }

        }
        directorMovieMap.remove(directorName);
        if (directorMap.containsKey(directorName)) directorMap.remove(directorName);
    }
    public void deleteAllDirectors()
    {

        HashSet<String> moviesSet = new HashSet<String>();

        for(String director: directorMovieMap.keySet()){
            for(String movie: directorMovieMap.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }

    }
}
