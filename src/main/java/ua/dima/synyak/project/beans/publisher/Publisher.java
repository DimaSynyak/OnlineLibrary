package ua.dima.synyak.project.beans.publisher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by root on 8/13/15.
 */
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    public Publisher() {

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
