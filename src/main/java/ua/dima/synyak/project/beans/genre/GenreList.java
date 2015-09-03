package ua.dima.synyak.project.beans.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dima.synyak.project.DAO.genre.GenreDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Service
public class GenreList {

    @Autowired
    private GenreDAO genreDAO;

    private List<Genre> genres = new ArrayList();


    public List<Genre> getGenres(){
        if (genres.size() == 0){
            genres = genreDAO.getGenres();
        }
        return genres;
    }
}
