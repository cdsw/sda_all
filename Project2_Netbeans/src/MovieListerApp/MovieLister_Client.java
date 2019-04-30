/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieListerApp;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author clementichen
 */
public class MovieLister_Client {

    public static void main(String[] args) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println(s);
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("configuration.xml");
        MovieLister movieLister = ctx.getBean("movieLister", MovieLister.class);
        MovieFinder tabDelimFinder = ctx.getBean("tabDelimFinder", MovieFinder.class);
        MovieFinder databaseFinder = ctx.getBean("databaseFinder", MovieFinder.class);
        String input;
        String findern;

        System.out.println("================================================================");
        //Initial MovieFinder Assignment
        while (true) {
            System.out.print("Choose initial finder: (1) Database, (2) Tab-Delimited > ");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            if (input.equals("1")) {
                movieLister.setMovieFinder(databaseFinder);
                findern = movieLister.getFinderName();
                System.out.println("Chosen:" + findern + " Finder");
                break;
            } else if (input.equals("2")) {
                findern = movieLister.getFinderName();
                movieLister.setMovieFinder(tabDelimFinder);
                System.out.println("Chosen:" + findern + " Finder");
                break;
            }
            System.out.println("Try again.");
        }

        //Main Loop
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("================================================================");
            System.out.print("Menu: (1) List all movies | "
                    + "Search movie by (2) Name (3) Director (4) Year | "
                    + "(5) Swap finder | "
                    + "(6) Quit: > ");
            input = sc.nextLine();
            switch (input) {
                case "1":
                    movieLister.listAllMovies();
                    break;
                case "2":
                    System.out.print("Partial or full Movie name to search: ");
                    input = sc.nextLine();
                    movieLister.listMovieByName(input);
                    break;
                case "3":
                    System.out.print("Partial or full Director name to search: ");
                    input = sc.nextLine();
                    movieLister.listMovieByDirector(input);
                    break;
                case "4":
                    System.out.print("Movie year to search: ");
                    input = sc.nextLine();
                    movieLister.listMovieByYear(input);
                    break;
                case "5":
                    if (findern.equals("Database")) {
                        movieLister.setMovieFinder(tabDelimFinder);
                    } else if (findern.equals("Tab-Delimited")) {
                        movieLister.setMovieFinder(databaseFinder);
                    }
                    findern = movieLister.getFinderName();
                    System.out.println("Finder swapped to :" + findern + " Finder");
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Try again.");
                    break;
            }
        }

    }
}
