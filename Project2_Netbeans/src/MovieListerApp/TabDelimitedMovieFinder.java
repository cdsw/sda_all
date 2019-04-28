
package MovieListerApp;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TabDelimitedMovieFinder implements MovieFinder{
    private List<Movie> movies;
    private String filename;

    public void parseFile() throws IOException{
        List<String[]> movieData = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("src/MovieListerApp/movies.txt"),
                     StandardCharsets.UTF_8);  
        for (String s : lines) {
            String[] kl = s.split("\\t+");
            movieData.add(kl);
        }    
        populateMovies(movieData);
    }
    
    public void populateMovies(List<String[]> movieData){
        ;
    }
    
    public TabDelimitedMovieFinder(String filename){
        this.filename = filename;
    }
    
    @Override
    public List findMovieByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findMovieByYear(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findMovieByDirector(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
