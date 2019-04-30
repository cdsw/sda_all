package MovieListerApp;

import java.util.List;

public interface MovieFinder {
    List findMovieByName(String name);
    List findMovieByYear(String name);
    List findMovieByDirector(String name);
    List listAll();
    String getFinderName();
}
