package ua.dima.synyak.project.DAO.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by root on 9/2/15.
 */
@Component(value = "session")
//@Scope(value = "singleton")
public class Session {
    private org.hibernate.Session session;

    public Session() {
        System.out.println(this);
    }

    public org.hibernate.Session getSession() {
        return session;
    }

    public void setSession(org.hibernate.Session session) {
        this.session = session;
    }
}
