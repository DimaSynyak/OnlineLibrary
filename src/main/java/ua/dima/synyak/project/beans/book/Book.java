package ua.dima.synyak.project.beans.book;

import ua.dima.synyak.project.beans.author.Author;
import ua.dima.synyak.project.beans.genre.Genre;
import ua.dima.synyak.project.beans.publisher.Publisher;

import javax.persistence.*;

/**
 * Created by root on 8/13/15.
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "page_count")
    private int page_count;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publish_year")
    private int publish_year;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "genre_id", insertable = false, updatable = false)
    private int genre_id;

    @Column(name = "author_id", insertable = false, updatable = false)
    private int author_id;

    @Column(name = "publisher_id", insertable = false, updatable = false)
    private int publisher_id;

    @OneToOne(targetEntity = Genre.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @OneToOne(targetEntity = Author.class, fetch =FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @OneToOne(targetEntity = Publisher.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publish;

    public int getPublish_year() {
        return this.publish_year;
    }

    public void setPublish_year(int publish_year) {
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
}
