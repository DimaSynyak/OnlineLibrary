package ua.dima.synyak.project.beans.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dima.synyak.project.DAO.book.BookDAO;
import ua.dima.synyak.project.DAO.genre.GenreDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Service
public class BookList {

    @Autowired
    private BookDAO bookDAO;

    private List<Book> books = new ArrayList();

    public List<Book> getBooks(){
        return books;
    }

    public List<Book> getBooksByGenreId(String genre){
        return bookDAO.getBooksByGenreId(Integer.parseInt(genre));
    }

    public Book getBook(int book_id){
        return bookDAO.getBookById(book_id);
    }
    

    public List<Book> getBooksByLetter(String letter){
        return bookDAO.getBooksByletter(letter);
    }
}