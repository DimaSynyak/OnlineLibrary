package ua.dima.synyak.project.DAO.book;

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
import ua.dima.synyak.project.DAO.author.AuthorDAO;
import ua.dima.synyak.project.DAO.genre.GenreDAO;
import ua.dima.synyak.project.DAO.publisher.PublisherDAO;
import ua.dima.synyak.project.beans.author.Author;
import ua.dima.synyak.project.beans.book.Book;
import ua.dima.synyak.project.beans.genre.Genre;
import ua.dima.synyak.project.beans.publisher.Publisher;


import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Component(value = "bookDAO")
public class BookDAO implements IBookDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private GenreDAO genreDAO;

    @Autowired
    private PublisherDAO publisherDAO;

    @Autowired
    private ua.dima.synyak.project.DAO.session.Session session;

    @Override
    @Receiver
    public List<Book> getBooksByGenreId(int genreId) {
        List<Book> books = null;

        books = session.getSession().createCriteria(Book.class)
                .add(Restrictions.eq("genre_id", genreId))
                .list();

        return books;
    }

    @Override
    @Receiver
    public List<Book> getBooksByletter(String letter) {
        List<Book> books = null;
        books = session.getSession().createCriteria(Book.class)
                .add(Restrictions.like("name", letter + "%"))
                .list();

        return books;
    }


    @Override
    @Transaction
    public void insertBook(Author author, String genre, Publisher publisher, Book book) {

        authorDAO.insertAuthor(author);
        Author authorObj = authorDAO.getAuthorByName(author.getName());
        book.setAuthor_id(authorObj.getId());

        Genre genreObj = genreDAO.getGenreByName(genre);
        book.setGenre_id(genreObj.getId());

        publisherDAO.insertPublisher(publisher);
        Publisher publisherObj = publisherDAO.getPublisherByName(publisher.getName());
        book.setPublisher_id(publisherObj.getId());

        insertBook(book);
    }

    @Override
    public void insertBook(Book book) {
        session.getSession().save(book);
    }

    @Override
    @Receiver
    public Book getBookById(int book_id) {
        Book book = null;

        book = (Book) session.getSession().createCriteria(Book.class)
                .add(Restrictions.eq("id", book_id))
                .uniqueResult();

        return book;
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

    public GenreDAO getGenreDAO() {
        return genreDAO;
    }

    public void setGenreDAO(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    public PublisherDAO getPublisherDAO() {
        return publisherDAO;
    }

    public void setPublisherDAO(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    public ua.dima.synyak.project.DAO.session.Session getSession() {
        return session;
    }

    public void setSession(ua.dima.synyak.project.DAO.session.Session session) {
        this.session = session;
    }
}
