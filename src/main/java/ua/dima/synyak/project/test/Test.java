package ua.dima.synyak.project.test;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.dima.synyak.project.DAO.book.BookDAO;
import ua.dima.synyak.project.DAO.testDAO.TestDAO;
import ua.dima.synyak.project.beans.author.Author;
import ua.dima.synyak.project.DAO.author.AuthorDAO;
import ua.dima.synyak.project.beans.book.Book;
import ua.dima.synyak.project.beans.publisher.Publisher;


import java.sql.Date;

/**
 * Created by root on 8/28/15.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TestDAO test = (TestDAO) context.getBean("testDAO");
        test.insertAuthor();
        System.out.println(1);
//        byte[] bytes = {-1, 25, -89, 45, 52, 74};
//        BookDAO bookDAO = (BookDAO) context.getBean("bookDAO");
//        Author author = new Author();
//        author.setName("Дмитрий");
//        author.setBirthday(Date.valueOf("1988-11-01"));
//
//        Publisher publisher = new Publisher();
//        publisher.setName("My publisher");
//
//        Book book = new Book();
//        book.setName("My book");
//        book.setPage_count(Integer.parseInt("145"));
//        book.setImage(bytes);
//        book.setIsbn("FGH-45872II");
//        book.setContent(bytes);
//        book.setPublish_year(Date.valueOf("2014-11-01"));
//
//        bookDAO.insertBook(author, "Детектив", publisher, book);
//        System.out.println(author);
    }
}
