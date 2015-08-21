package ua.dima.synyak.project.services;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * Created by root on 8/12/15.
 */
@Service
public class Param {
    private boolean login = false;

    public boolean isLogin() {
        return login;
    }

    @Secured("ROLE_USER")
    public void setLogin(boolean login) {
        this.login = login;
    }
}
