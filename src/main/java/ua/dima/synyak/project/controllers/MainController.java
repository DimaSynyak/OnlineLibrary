package ua.dima.synyak.project.controllers;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import ua.dima.synyak.project.beans.book.Book;
import ua.dima.synyak.project.beans.book.BookList;
import ua.dima.synyak.project.beans.genre.GenreList;
import ua.dima.synyak.project.beans.person.Person;
import ua.dima.synyak.project.services.Letters;
import ua.dima.synyak.project.services.datails.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by root on 8/12/15.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    private byte[] bytes;

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
        model.addObject("imgBook", "${pageContext.request.contextPath}/resources/images/image_title_book2.jpg");

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
        model.addObject("imgBook", "${pageContext.request.contextPath}/resources/images/image_title_book2.jpg");
        model.addObject("upload", true);
        try {
            this.bytes = file.getBytes();
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

    @RequestMapping(value = "/addbook/editbook", method = RequestMethod.GET)
    public void editimage(HttpServletRequest request, HttpServletResponse response){
        try{
            if (bytes == null){
                bytes = bookList.getBook(Integer.parseInt("1")).getImage();
            }


            response.setContentType("image/jpeg");
            OutputStream out = response.getOutputStream();

            response.setContentLength(bytes.length);
            out.write(bytes);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
