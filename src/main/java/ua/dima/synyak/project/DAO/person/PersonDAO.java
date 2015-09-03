package ua.dima.synyak.project.DAO.person;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.dima.synyak.project.DAO.AOP.annotation.Receiver;
import ua.dima.synyak.project.beans.person.Person;

/**
 * Created by root on 8/13/15.
 */
@Component(value = "personDAO")
public class PersonDAO implements IPersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ua.dima.synyak.project.DAO.session.Session session;

    public PersonDAO() {
        System.out.println(this);
    }

    @Override
    @Receiver
    public Person getPersonByLogin(String login) {
        Person person = null;
        person = (Person) session.getSession().createCriteria(Person.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();

        return person;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ua.dima.synyak.project.DAO.session.Session getSession() {
        return session;
    }

    public void setSession(ua.dima.synyak.project.DAO.session.Session session) {
        this.session = session;
    }

}
