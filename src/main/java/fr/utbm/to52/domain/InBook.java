package fr.utbm.to52.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class InBook extends Publication {

    @Column(nullable = false)
    private String Chapter;

    @Column
    private String Pages;

    @Column
    private String Volume;

    @Column
    private String Series;

    @Column
    private String Edition;

    @Column
    private String Publisher;

    public InBook(long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Date year, Date month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Project project, Set<Author> authors, String chapter, String pages, String volume, String series, String edition, String publisher) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, project, authors);
        Chapter = chapter;
        Pages = pages;
        Volume = volume;
        Series = series;
        Edition = edition;
        Publisher = publisher;
    }

    public InBook(String chapter, String pages, String volume, String series, String edition, String publisher) {
        Chapter = chapter;
        Pages = pages;
        Volume = volume;
        Series = series;
        Edition = edition;
        Publisher = publisher;
    }

    public InBook() {

    }

    public String getChapter() {
        return Chapter;
    }

    public void setChapter(String chapter) {
        Chapter = chapter;
    }

    public String getPages() {
        return Pages;
    }

    public void setPages(String pages) {
        Pages = pages;
    }

    public String getVolume() {
        return Volume;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getSeries() {
        return Series;
    }

    public void setSeries(String series) {
        Series = series;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InBook)) return false;
        if (!super.equals(o)) return false;
        InBook inBook = (InBook) o;
        return Objects.equals(getChapter(), inBook.getChapter()) &&
                Objects.equals(getPages(), inBook.getPages()) &&
                Objects.equals(getVolume(), inBook.getVolume()) &&
                Objects.equals(getSeries(), inBook.getSeries()) &&
                Objects.equals(getEdition(), inBook.getEdition()) &&
                Objects.equals(getPublisher(), inBook.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getChapter(), getPages(), getVolume(), getSeries(), getEdition(), getPublisher());
    }
}
