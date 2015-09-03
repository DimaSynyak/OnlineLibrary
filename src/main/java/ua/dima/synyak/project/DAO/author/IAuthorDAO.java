package ua.dima.synyak.project.DAO.author;

import ua.dima.synyak.project.beans.author.Author;
import ua.dima.synyak.project.beans.person.Person;

/**
 * Created by root on 8/13/15.
 */
public interface IAuthorDAO {
    void insertAuthor(Author author);
    Author getAuthorByName(String name);
}
