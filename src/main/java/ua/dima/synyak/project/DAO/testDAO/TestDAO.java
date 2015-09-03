package ua.dima.synyak.project.DAO.testDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import ua.dima.synyak.project.DAO.AOP.annotation.Transaction;
import ua.dima.synyak.project.DAO.author.AuthorDAO;
import ua.dima.synyak.project.DAO.publisher.PublisherDAO;
import ua.dima.synyak.project.beans.author.Author;
import ua.dima.synyak.project.beans.publisher.Publisher;

import java.sql.Date;
import java.util.List;

/**
 * Created by root on 8/28/15.
 */
@Component(value = "testDAO")
public class TestDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private PublisherDAO publisherDAO;

    @Autowired
    private ua.dima.synyak.project.DAO.session.Session session;

    @Transaction
    public void insertAuthor(){

            Author author = new Author();
            author.setName("Дмитрий");
            author.setBirthday(Date.valueOf("1988-11-01"));

            session.getSession().save(author);
            insertPublisher();

    }

    public void insertPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("My publisher");
        session.getSession().save(publisher);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public PublisherDAO getPublisherDAO() {
        return publisherDAO;
    }

    public void setPublisherDAO(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }


}
