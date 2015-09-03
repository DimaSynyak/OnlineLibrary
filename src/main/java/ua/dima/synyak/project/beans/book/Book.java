package ua.dima.synyak.project.beans.book;

import ua.dima.synyak.project.beans.author.Author;
import ua.dima.synyak.project.beans.genre.Genre;
import ua.dima.synyak.project.beans.publisher.Publisher;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by root on 8/13/15.
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    private int id;

    @Column(name = "content")
    private byte[] content;

    @Column(name = "name")
    private String name;

    @Column(name = "page_count")
    private int page_count;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publish_year")
    private Date publish_year;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "genre_id", insertable = true, updatable = true)
    private int genre_id;

    @Column(name = "author_id", insertable = true, updatable = true)
    private int author_id;

    @Column(name = "publisher_id", insertable = true, updatable = true)
    private int publisher_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Genre genre;

    @OneToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Author author;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Publisher publish;

    public Date getPublish_year() {
        return this.publish_year;
    }

    public void setPublish_year(Date publish_year) {
        this.publish_year = publish_year;
    }

    public String getIsbn() {

        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPage_count() {

        return this.page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublish() {
        return publish;
    }

    public void setPublish(Publisher publish) {
        this.publish = publish;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
