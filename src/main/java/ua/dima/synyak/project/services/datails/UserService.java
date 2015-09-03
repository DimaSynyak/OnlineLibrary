package ua.dima.synyak.project.services.datails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.dima.synyak.project.DAO.person.PersonDAO;
import ua.dima.synyak.project.beans.person.Person;

/**
 * Created by root on 8/13/15.
 */
@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private PersonDAO personDAO;

    public UserService() {
        System.out.println(this);
    }

    public Person getPerson(String login) {
        Person person = null;
        person = personDAO.getPersonByLogin(login);

        return person;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
}
