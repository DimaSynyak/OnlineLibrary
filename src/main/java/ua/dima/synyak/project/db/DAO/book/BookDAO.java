package ua.dima.synyak.project.db.DAO.book;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.dima.synyak.project.beans.book.Book;
import ua.dima.synyak.project.beans.person.Person;
import ua.dima.synyak.project.db.util.HibernateUtil;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
public class BookDAO implements IBookDAO {

    public List<Book> getBooksByGenreId(int genreId) {
        Session session = null;
        List<Book> books = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            books = session.createCriteria(Book.class)
                    .add(Restrictions.eq("genre_id", genreId))
                    .list();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return books;
    }

    public List<Book> getBooksByletter(String letter) {
        Session session = null;
        List<Book> books = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            books = session.createCriteria(Book.class)
                    .add(Restrictions.like("name", letter + "%"))
                    .list();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return books;
    }

    public Book getBookById(int book_id) {
        Session session = null;
        Book book = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            book = (Book) session.createCriteria(Book.class)
                    .add(Restrictions.eq("id", book_id))
                    .uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return book;
    }

}
