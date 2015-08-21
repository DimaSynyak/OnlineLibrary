package ua.dima.synyak.project.db.DAO;

import ua.dima.synyak.project.db.DAO.book.BookDAO;
import ua.dima.synyak.project.db.DAO.book.IBookDAO;
import ua.dima.synyak.project.db.DAO.genre.GenreDAO;
import ua.dima.synyak.project.db.DAO.genre.IGenreDAO;
import ua.dima.synyak.project.db.DAO.person.IPersonDAO;
import ua.dima.synyak.project.db.DAO.person.PersonDAO;

/**
 * Created by root on 8/13/15.
 */
public class Factory {
    private static Factory instance;
    private static IPersonDAO personDAO;
    private  static IGenreDAO genreDAO;
    private static IBookDAO bookDAO;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }

        return instance;
    }

    public static IPersonDAO getPersonDAO(){
        if (personDAO == null){
            personDAO = new PersonDAO();
        }

        return personDAO;
    }

    public static IGenreDAO getGenreDAO() {
        if (genreDAO == null) {
            genreDAO = new GenreDAO();
        }

        return genreDAO;
    }

    public static IBookDAO getBookDAO(){
        if (bookDAO == null){
            bookDAO = new BookDAO();
        }

        return bookDAO;
    }
}
