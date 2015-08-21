package ua.dima.synyak.project.db.DAO.book;

import ua.dima.synyak.project.beans.book.Book;
import ua.dima.synyak.project.beans.person.Person;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
public interface IBookDAO {

    List<Book> getBooksByGenreId(int genreId);
    List<Book> getBooksByletter(String letter);
    Book getBookById(int book_id);

}
