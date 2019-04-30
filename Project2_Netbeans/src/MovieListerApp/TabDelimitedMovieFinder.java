
package MovieListerApp;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public final class TabDelimitedMovieFinder implements MovieFinder{
    private List<Movie> movies = new ArrayList<>();
    private final String filename;

    public void parseFile() throws IOException{
        List<String[]> movieData = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filename),
                     StandardCharsets.UTF_8);  
        for (String s : lines) {
            String[] kl = s.split("\\t+");
            movieData.add(kl);
        }    
        populateMovies(movieData);
    }
    
    public void populateMovies(List<String[]> movieData){
        for (String[] mov : movieData){
            movies.add(new Movie(Integer.parseInt(mov[0]), mov[1], mov[2], Integer.parseInt(mov[3])));
        }
    }
    
    public TabDelimitedMovieFinder(String filename) throws IOException{
        this.filename = filename;
        parseFile();
    }
    
    @Override
    public List findMovieByName(String name) {
        List result = new ArrayList<>();
        for (Movie m : movies){
            if (m.getMoviename().toLowerCase().contains(name.toLowerCase())){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public List findMovieByYear(String year) {
        List result = new ArrayList<>();
        for (Movie m : movies){
            if (m.getYear() == Integer.parseInt(year)){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public List findMovieByDirector(String name) {
        List result = new ArrayList<>();
        for (Movie m : movies){
            if (m.getDirector().toLowerCase().contains(name.toLowerCase())){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public String getFinderName() {
        return "Tab-Delimited";
    }

    @Override
    public List listAll() {
        return movies;
    }
    
}
