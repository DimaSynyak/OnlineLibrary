package ua.dima.synyak.project.DAO.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by root on 9/2/15.
 */
@Configuration
public class Config {

    @Bean
    public SessionFactory sessionFactory(){
        return new AnnotationConfiguration().configure().buildSessionFactory();
    }
}
