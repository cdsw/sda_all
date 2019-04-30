/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieListerApp;

import java.util.List;

/**
 *
 * @author clementichen
 */
public class MovieLister {

    private MovieFinder movieFinder;
    String mode;

    public MovieLister() {
    }

    public MovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void printList(List list) {
        if (list != null && !list.isEmpty()) {
            if (mode.equalsIgnoreCase("all")) {
                System.out.println("List all movies");
            } else {
                System.out.println("List movie by " + mode);
            }
            list.stream().forEach((movie) -> {
                System.out.println(movie);
            });
        } else {
            System.out.println("Not found.");
        }
    }

    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void listAllMovies() {
        List movieList = this.movieFinder.listAll();
        mode = "all";
        printList(movieList);
    }

    public void listMovieByName(String name) {
        List movieList = this.movieFinder.findMovieByName(name);
        mode = "Name";
        printList(movieList);
    }

    public void listMovieByDirector(String name) {
        List movieList = this.movieFinder.findMovieByDirector(name);
        mode = "Director";
        printList(movieList);
    }

    public void listMovieByYear(String year) {
        List movieList = this.movieFinder.findMovieByYear(year);
        mode = "Year";
        printList(movieList);
    }

    public String getFinderName() {
        return this.movieFinder.getFinderName();
    }
}
