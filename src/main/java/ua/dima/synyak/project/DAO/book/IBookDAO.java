package ua.dima.synyak.project.DAO.book;

import ua.dima.synyak.project.beans.author.Author;
import ua.dima.synyak.project.beans.book.Book;
import ua.dima.synyak.project.beans.person.Person;
import ua.dima.synyak.project.beans.publisher.Publisher;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
public interface IBookDAO {

    List<Book> getBooksByGenreId(int genreId);
    List<Book> getBooksByletter(String letter);
    void insertBook(Author author, String genre, Publisher publisher, Book book);
    void insertBook(Book book);
    Book getBookById(int book_id);

}
