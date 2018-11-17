package fr.utbm.to52.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book extends Publication implements Serializable {

    @Column(nullable = false)
    private String Isbn;

    @Column
    private String Series;

    @Column
    private String Volume;

    @Column
    private String Publisher;

    @Column
    private String Edition;

    public Book(long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Date year, Date month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Project project, Set<Author> authors, String isbn, String series, String volume, String publisher, String edition) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, project, authors);
        Isbn = isbn;
        Series = series;
        Volume = volume;
        Publisher = publisher;
        Edition = edition;
    }

    public Book(String isbn, String series, String volume, String publisher, String edition) {
        Isbn = isbn;
        Series = series;
        Volume = volume;
        Publisher = publisher;
        Edition = edition;
    }

    public Book() {

    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public String getSeries() {
        return Series;
    }

    public void setSeries(String series) {
        Series = series;
    }

    public String getVolume() {
        return Volume;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getSeries(), book.getSeries()) &&
                Objects.equals(getVolume(), book.getVolume()) &&
                Objects.equals(getPublisher(), book.getPublisher()) &&
                Objects.equals(getEdition(), book.getEdition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIsbn(), getSeries(), getVolume(), getPublisher(), getEdition());
    }
}
