package ua.dima.synyak.project.beans.book;

import org.springframework.stereotype.Service;
import ua.dima.synyak.project.db.DAO.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Service
public class BookList {
    private List<Book> books = new ArrayList();

    public List<Book> getBooks(){
        return books;
    }

    public List<Book> getBooksByGenreId(String genre){
        return Factory.getInstance().getBookDAO().getBooksByGenreId(Integer.parseInt(genre));
    }

    public Book getBook(int book_id){
        return Factory.getInstance().getBookDAO().getBookById(book_id);
    }

    public List<Book> getBooksByLetter(String letter){
        return Factory.getInstance().getBookDAO().getBooksByletter(letter);
    }
}