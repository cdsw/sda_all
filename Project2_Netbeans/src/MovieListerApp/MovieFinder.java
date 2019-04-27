package MovieListerApp;

import java.util.ArrayList;

public interface MovieFinder {
    ArrayList findMovieByName(String name);
    ArrayList findMovieByYear(String name);
    ArrayList findMovieByDirector(String name);
}
