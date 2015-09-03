package ua.dima.synyak.project.DAO.genre;

import ua.dima.synyak.project.beans.genre.Genre;
import ua.dima.synyak.project.beans.person.Person;

import java.util.List;

/**
 * Created by root on 8/13/15.
 */
public interface IGenreDAO {
    List<Genre> getGenres();
    Genre getGenreByName(String genre);
}
