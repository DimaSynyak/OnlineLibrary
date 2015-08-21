package ua.dima.synyak.project.db.DAO.genre;

import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import sun.net.www.http.Hurryable;
import ua.dima.synyak.project.beans.genre.Genre;
import ua.dima.synyak.project.beans.person.Person;
import ua.dima.synyak.project.db.util.HibernateUtil;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
public class GenreDAO implements IGenreDAO {

    public List<Genre> getGenres() {
        Session session = null;
        List<Genre> genres = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            genres = (List<Genre>) session.createCriteria(Genre.class).addOrder(Property.forName("name").asc()).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return genres;
    }
}
