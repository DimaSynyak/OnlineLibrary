package ua.dima.synyak.project.beans.author;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by root on 8/13/15.
 */
@Entity
@Table(name = "author")
public class Author {
    @Id
    private int id;

    @Column(name = "fio")
    private String name;

    private String birthday;

    public Author() {

    }

    public String getBirthday(String birthday) {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
