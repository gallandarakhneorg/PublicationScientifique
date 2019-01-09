package fr.utbm.to52.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Book")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book extends Publication implements Serializable {

    @Column(nullable = true)
    private String Isbn;

    @Column(nullable = true)
    private String Series;

    @Column(nullable = true)
    private Long Volume;

    @Column(nullable = true)
    private String Publisher;

    @Column(nullable = true)
    private String Edition;

    public Book(String Isbn, String Series, Long Volume, String Publisher, String Edition, Long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Long year, Long month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords,Set<Author> authors) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords,authors);
        this.Isbn = Isbn;
        this.Series = Series;
        this.Volume = Volume;
        this.Publisher = Publisher;
        this.Edition = Edition;
    }

    

    public Book(String isbn, String series, Long volume, String publisher, String edition) {
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

    public Long getVolume() {
        return Volume;
    }

    public void setVolume(Long volume) {
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
