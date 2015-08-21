package ua.dima.synyak.project.services.datails;

import org.springframework.stereotype.Service;
import ua.dima.synyak.project.beans.person.Person;
import ua.dima.synyak.project.db.DAO.Factory;

/**
 * Created by root on 8/13/15.
 */
@Service
public class UserService implements IUserService {

    public Person getPerson(String login) {
        Person person = null;
        person = Factory.getInstance().getPersonDAO().getPersonByLogin(login);
        return person;
    }
}
