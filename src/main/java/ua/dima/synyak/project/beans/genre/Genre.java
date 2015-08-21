package ua.dima.synyak.project.beans.genre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by root on 8/13/15.
 */
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    private int id;
    private String name;

    public Genre() {

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
