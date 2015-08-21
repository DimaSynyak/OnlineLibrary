package ua.dima.synyak.project.services.datails;

import ua.dima.synyak.project.beans.person.Person;

/**
 * Created by root on 8/13/15.
 */
public interface IUserService {
    Person getPerson(String login);
}
