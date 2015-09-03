package ua.dima.synyak.project.DAO.genre;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import ua.dima.synyak.project.DAO.AOP.annotation.Receiver;
import ua.dima.synyak.project.beans.genre.Genre;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Component(value = "genreDAO")
public class GenreDAO implements IGenreDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ua.dima.synyak.project.DAO.session.Session session;

    @Override
    @Receiver
    public List<Genre> getGenres() {
        List<Genre> genres = null;
        genres = (List<Genre>) session.getSession().createCriteria(Genre.class).addOrder(Property.forName("name").asc()).list();

        return genres;
    }

    @Override
    @Receiver
    public Genre getGenreByName(String genre) {
        Genre genreObj = null;

        genreObj = (Genre) session.getSession().createCriteria(Genre.class)
                .add(Restrictions.eq("name", genre))
                .uniqueResult();

        return genreObj;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ua.dima.synyak.project.DAO.session.Session getSession() {
        return session;
    }

    public void setSession(ua.dima.synyak.project.DAO.session.Session session) {
        this.session = session;
    }
}
