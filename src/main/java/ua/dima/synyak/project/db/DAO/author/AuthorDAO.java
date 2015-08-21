package ua.dima.synyak.project.db.DAO.author;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.dima.synyak.project.beans.person.Person;
import ua.dima.synyak.project.db.util.HibernateUtil;

/**
 * Created by root on 8/13/15.
 */
public class AuthorDAO implements IAuthorDAO {

//    public Person getPersonByLogin(String login) {
//        Session session = null;
//        Person person = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            person = (Person) session.createCriteria(Person.class)
//                    .add(Restrictions.eq("login", login))
//                    .uniqueResult();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            if (session != null && session.isOpen()){
//                session.close();
//            }
//        }
//        return person;
//    }
}
