package ua.dima.synyak.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.dima.synyak.project.beans.author.Author;
import ua.dima.synyak.project.beans.book.Book;
import ua.dima.synyak.project.beans.book.BookList;
import ua.dima.synyak.project.beans.genre.GenreList;
import ua.dima.synyak.project.beans.person.Person;
import ua.dima.synyak.project.beans.publisher.Publisher;
import ua.dima.synyak.project.services.Letters;
import ua.dima.synyak.project.services.datails.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Date;

/**
 * Created by root on 8/12/15.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private GenreList genreList;

    @Autowired
    private BookList bookList;

    @Autowired
    private Letters letters;

    @RequestMapping("/main")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
        String name = null;
        if (request.getUserPrincipal() != null) {
            name = request.getUserPrincipal().getName();
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("main");
        model.addObject("letters", letters.getList());
        model.addObject("genres", genreList.getGenres());

        if (name == null){
            return model;
        }
        Person person = userService.getPerson(name);

        model.addObject("name", person.getName());
        model.addObject("role", person.getRole());

        return model;
    }

    @RequestMapping(value = "/books/genreId={genreId}")
    public ModelAndView getGenreId(@PathVariable String genreId, HttpServletRequest request, HttpServletResponse response){
        String name = null;
        if (request.getUserPrincipal() != null) {
            name = request.getUserPrincipal().getName();
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("books");
        model.addObject("books", bookList.getBooksByGenreId(genreId));
        model.addObject("letters", letters.getList());
        model.addObject("genres", genreList.getGenres());
        model.addObject("imgBook", "../resources/images/image_title_book2.jpg");

        if (name == null){
            return model;
        }
        Person person = userService.getPerson(name);

        model.addObject("name", person.getName());
        model.addObject("role", person.getRole());

        return model;
    }

    @RequestMapping(value = "/books/image={bookId}", method = RequestMethod.GET)
    public void getImage(@PathVariable String bookId, HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("image/jpeg");
            OutputStream out = response.getOutputStream();

            Book book = bookList.getBook(Integer.parseInt(bookId));
            response.setContentLength(book.getImage().length);
            out.write(book.getImage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/books/bookletter={bookLetter}")
    public ModelAndView getBooks(@PathVariable String bookLetter, HttpServletRequest request, HttpServletResponse response){
        String name = null;
        if (request.getUserPrincipal() != null) {
            name = request.getUserPrincipal().getName();
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("books");
        model.addObject("books", bookList.getBooksByLetter(bookLetter));
        model.addObject("letters", letters.getList());
        model.addObject("genres", genreList.getGenres());
        model.addObject("imgBook", "../resources/images/image_title_book2.jpg");

        if (name == null){
            return model;
        }
        Person person = userService.getPerson(name);

        model.addObject("name", person.getName());
        model.addObject("role", person.getRole());

        return model;
    }

    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    public ModelAndView getBooksSearch(HttpServletRequest request, HttpServletResponse response){
        String name = null;
        if (request.getUserPrincipal() != null) {
            name = request.getUserPrincipal().getName();
        }
        String line = request.getParameter("search_string");
        ModelAndView model = new ModelAndView();
        model.addObject("search_string", line);
        model.setViewName("books");
        model.addObject("books", bookList.getBooksByLetter(line));
        model.addObject("letters", letters.getList());
        model.addObject("genres", genreList.getGenres());
        model.addObject("imgBook", "../resources/images/image_title_book2.jpg");

        if (name == null){
            return model;
        }
        Person person = userService.getPerson(name);

        model.addObject("name", person.getName());
        model.addObject("role", person.getRole());

        return model;
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response){
        String name = null;
        if (request.getUserPrincipal() != null) {
            name = request.getUserPrincipal().getName();
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("addBooks");
        model.addObject("letters", letters.getList());
        model.addObject("genres", genreList.getGenres());
        model.addObject("imgBook", "/resources/images/image_title_book2.jpg");//warning

        if (name == null){
            return model;
        }
        Person person = userService.getPerson(name);

        model.addObject("name", person.getName());
        model.addObject("role", person.getRole());

        return model;
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView handleFileUpload(
                               @RequestParam("image") MultipartFile file,
                               HttpServletRequest request,
                               HttpServletResponse response){
        String name = null;
        if (request.getUserPrincipal() != null) {
            name = request.getUserPrincipal().getName();
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("addBooks");
        model.addObject("letters", letters.getList());
        model.addObject("genres", genreList.getGenres());
        model.addObject("imgBook", "/resources/images/image_title_book2.jpg");
        model.addObject("upload", true);
        try {
            request.getSession().setAttribute("image", file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (name == null){
            return model;
        }
        Person person = userService.getPerson(name);

        model.addObject("name", person.getName());
        model.addObject("role", person.getRole());

        return model;
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/addbook/editbook", method = RequestMethod.GET)
    public void editimage(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        byte[] image = (byte[]) session.getAttribute("image");
        try{
            if (image == null){
                image = bookList.getBook(Integer.parseInt("1")).getImage();
            }


            response.setContentType("image/jpeg");
            OutputStream out = response.getOutputStream();

            response.setContentLength(image.length);
            out.write(image);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ModelAndView validate(@RequestParam("file") MultipartFile file,
                                         HttpServletRequest request,
                                         HttpServletResponse response){
        HttpSession session = request.getSession();
        byte[] content = null;
        byte[] image = (byte[]) session.getAttribute("image");

        if (!file.isEmpty() ){
            try {
                content = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        boolean flag = true;
        ModelAndView model = new ModelAndView();

        String authorName = request.getParameter("authorName");
        String authorBirthday = request.getParameter("authorBirthday");
        String bookName = request.getParameter("bookName");
        String pageCount = request.getParameter("pageCount");
        String publisherName = request.getParameter("publisherName");
        String publisherYear = request.getParameter("publisherYear");
        String genreName = request.getParameter("genreName");
        String isbn = request.getParameter("isbn");

        if (authorName == null || authorName.equals("")){
            flag = false;
            model.addObject("authorName", "*required field input");
        }
        else {
            model.addObject("authorName", "");
        }

        if (authorBirthday == null || authorBirthday.equals("")){
            flag = false;
            model.addObject("authorBirthday", "*required field input");
        }
        else {
            model.addObject("authorBirthday", "");
        }
//
        if (bookName == null || bookName.equals("")){
            flag = false;
            model.addObject("bookName", "*required field input");
        }
        else {
            model.addObject("bookName", "");
        }
//
        if (pageCount == null || pageCount.equals("")){
            flag = false;
            model.addObject("pageCount", "*required field input");
        }
        else {
            model.addObject("pageCount", "");
        }
//
        if (publisherName == null || publisherName.equals("")){
            flag = false;
            model.addObject("publisherName", "*required field input");
        }
        else {
            model.addObject("publisherName", "");
        }
//
        if (publisherYear == null || publisherYear.equals("")){
            flag = false;
            model.addObject("publisherYear", "*required field input");
        }
        else {
            model.addObject("publisherYear", "");
        }

        if (isbn == null || isbn.equals("")){
            flag = false;
            model.addObject("isbn", "*required field input");
        }
        else {
            model.addObject("isbn", "");
        }


        if (flag){
            Author author = new Author();
            author.setName(authorName);
            author.setBirthday(Date.valueOf(authorBirthday));

            Publisher publisher = new Publisher();
            publisher.setName(publisherName);

            Book book = new Book();
            book.setName(bookName);
            book.setPage_count(Integer.parseInt(pageCount));
            book.setImage(image);
            book.setIsbn(isbn);
            book.setContent(content);
            book.setPublish_year(Date.valueOf(publisherYear));
//            book.setAuthor(author);
//            book.setPublish(publisher);


            session.setAttribute("state", "Кгига записана");
        }
        else {
            session.setAttribute("state", "Ошибка записи книги");
        }

        String name = null;
        if (request.getUserPrincipal() != null) {
            name = request.getUserPrincipal().getName();
        }

        model.setViewName("addBooks");
        model.addObject("letters", letters.getList());
        model.addObject("genres", genreList.getGenres());
        model.addObject("imgBook", "/resources/images/image_title_book2.jpg");//warning
        model.addObject("upload", true);

        if (name == null){
            return model;
        }
        Person person = userService.getPerson(name);

        model.addObject("name", person.getName());
        model.addObject("role", person.getRole());

        return model;
    }

}
