package MovieListerApp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class DatabaseMovieFinder implements MovieFinder {

    private EntityManagerFactory factory;
    private EntityManager em;

    public DatabaseMovieFinder() {
        this.factory = Persistence.createEntityManagerFactory("Project2_NetbeansPU");
        this.em = factory.createEntityManager();
    }

    @Override
    public List findMovieByName(String name) {
        name = "%" + name.toLowerCase() + "%";
        try {
            List movies = em.createNamedQuery("Movie.findByMoviename").setParameter("moviename", name).getResultList();
            return movies;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List findMovieByDirector(String name) {
        name = "%" + name.toLowerCase() + "%";
        try {
            List movies = em.createNamedQuery("Movie.findByDirector").setParameter("director", name).getResultList();
            return movies;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List findMovieByYear(String year) {
        int y = Integer.parseInt(year);
        try {
            List movies = em.createNamedQuery("Movie.findByYear").setParameter("year", y).getResultList();
            return movies;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getFinderName() {
        return "Database";
    }

    @Override
    public List listAll() {
        try {
            List movies = em.createNamedQuery("Movie.findAll").getResultList();
            return movies;
        } catch (Exception e) {
            System.out.println("Not found");
            return null;
        }
    }
}
