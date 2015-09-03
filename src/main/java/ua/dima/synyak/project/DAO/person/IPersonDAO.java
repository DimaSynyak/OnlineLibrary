package ua.dima.synyak.project.DAO.person;

import ua.dima.synyak.project.beans.person.Person;

/**
 * Created by root on 8/13/15.
 */
public interface IPersonDAO {
    Person getPersonByLogin(String login);
}
