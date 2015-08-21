package ua.dima.synyak.project.beans.person;

import ua.dima.synyak.project.beans.person.enums.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by root on 8/13/15.
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id")
    private int person_id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String password;

    @Column(name = "role")
    private Role role;

    public Person() {

    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
