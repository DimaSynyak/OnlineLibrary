package ua.dima.synyak.project.DAO.author;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import ua.dima.synyak.project.DAO.AOP.annotation.Receiver;
import ua.dima.synyak.project.DAO.AOP.annotation.Transaction;
import ua.dima.synyak.project.beans.author.Author;

/**
 * Created by root on 8/13/15.
 */
@Component(value = "authorDAO")
public class AuthorDAO implements IAuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ua.dima.synyak.project.DAO.session.Session session;

    public AuthorDAO() {
        System.out.println(this);
    }

    @Override
    @Transaction
    public void insertAuthor(Author author) {
        session.getSession().save(author);
    }

    @Override
    @Receiver
    public Author getAuthorByName(String name) {
        Author author = null;
        author = (Author) session.getSession().createCriteria(Author.class).add(Restrictions.eq("name", name)).uniqueResult();

        return author;
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
