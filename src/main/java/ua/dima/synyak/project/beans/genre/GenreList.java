package ua.dima.synyak.project.beans.genre;

import org.springframework.stereotype.Service;
import ua.dima.synyak.project.db.DAO.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 8/13/15.
 */
@Service
public class GenreList {
    private List<Genre> genres = new ArrayList();


    public List<Genre> getGenres(){
        if (genres.size() == 0){
            genres = Factory.getInstance().getGenreDAO().getGenres();
        }
        return genres;
    }
}
