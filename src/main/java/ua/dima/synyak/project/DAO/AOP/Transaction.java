package ua.dima.synyak.project.DAO.AOP;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by root on 9/2/15.
 */
@Component
@Aspect
public class Transaction {

    @Autowired
    private ua.dima.synyak.project.DAO.session.Session session;

    @Autowired
    private SessionFactory sessionFactory;

    public Transaction() {
        System.out.println(this);
    }

    @Pointcut(value = "execution(* *(..))")
    private void daoMethods(){
    };

    @Before(value = "daoMethods() && @annotation(ua.dima.synyak.project.DAO.AOP.annotation.Transaction)")
    private void startTransaction()  {
        session.setSession(sessionFactory.openSession());
        session.getSession().beginTransaction();
    }

    @AfterThrowing(value = "daoMethods() && @annotation(ua.dima.synyak.project.DAO.AOP.annotation.Transaction)")
    private void daoThrowing(){
        if (session.getSession() != null && session.getSession().isOpen()) {
            session.getSession().getTransaction().rollback();
            session.getSession().close();
        }
    }

    @AfterReturning(value = "daoMethods() && @annotation(ua.dima.synyak.project.DAO.AOP.annotation.Transaction)")
    private void closeTransactoin(){
        if (session.getSession() != null && session.getSession().isOpen()){
            session.getSession().getTransaction().commit();
            session.getSession().close();
        }
    }


    @Before(value = "daoMethods() && @annotation(ua.dima.synyak.project.DAO.AOP.annotation.Receiver)")
    private void startReceive()  {
        session.setSession(sessionFactory.openSession());
        System.out.println(this);
    }

    @AfterThrowing(value = "daoMethods() && @annotation(ua.dima.synyak.project.DAO.AOP.annotation.Receiver)")
    private void daoThrowingReceive(){
        if (session.getSession() != null && session.getSession().isOpen()) {
            session.getSession().close();
        }
    }

    @AfterReturning(value = "daoMethods() && @annotation(ua.dima.synyak.project.DAO.AOP.annotation.Receiver)")
    private void closeReceiver(){
        if (session.getSession() != null && session.getSession().isOpen()){
            session.getSession().close();
        }
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
