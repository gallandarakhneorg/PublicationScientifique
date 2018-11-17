package fr.utbm.to52.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Conference extends Publication implements Serializable {

    @Column(nullable = false)
    private String ConferenceName;

    @Column(nullable = false)
    private long Ranking;

    @Column
    private String Series;

    @Column(nullable = false)
    private String Pages;

    @Column
    private long Volume;

    @Column
    private String Publisher;

    @Column
    private String Organization;

    @Column
    private String Editor;

    public Conference(long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Date year, Date month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Project project, Set<Author> authors, String conferenceName, long ranking, String series, String pages, long volume, String publisher, String organization, String editor) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, project, authors);
        ConferenceName = conferenceName;
        Ranking = ranking;
        Series = series;
        Pages = pages;
        Volume = volume;
        Publisher = publisher;
        Organization = organization;
        Editor = editor;
    }

    public Conference(String conferenceName, long ranking, String series, String pages, long volume, String publisher, String organization, String editor) {
        ConferenceName = conferenceName;
        Ranking = ranking;
        Series = series;
        Pages = pages;
        Volume = volume;
        Publisher = publisher;
        Organization = organization;
        Editor = editor;
    }

    public Conference() {

    }

    public String getConferenceName() {
        return ConferenceName;
    }

    public void setConferenceName(String conferenceName) {
        ConferenceName = conferenceName;
    }

    public long getRanking() {
        return Ranking;
    }

    public void setRanking(long ranking) {
        Ranking = ranking;
    }

    public String getSeries() {
        return Series;
    }

    public void setSeries(String series) {
        Series = series;
    }

    public String getPages() {
        return Pages;
    }

    public void setPages(String pages) {
        Pages = pages;
    }

    public long getVolume() {
        return Volume;
    }

    public void setVolume(long volume) {
        Volume = volume;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        Organization = organization;
    }

    public String getEditor() {
        return Editor;
    }

    public void setEditor(String editor) {
        Editor = editor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conference)) return false;
        if (!super.equals(o)) return false;
        Conference that = (Conference) o;
        return getRanking() == that.getRanking() &&
                getVolume() == that.getVolume() &&
                Objects.equals(getConferenceName(), that.getConferenceName()) &&
                Objects.equals(getSeries(), that.getSeries()) &&
                Objects.equals(getPages(), that.getPages()) &&
                Objects.equals(getPublisher(), that.getPublisher()) &&
                Objects.equals(getOrganization(), that.getOrganization()) &&
                Objects.equals(getEditor(), that.getEditor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getConferenceName(), getRanking(), getSeries(), getPages(), getVolume(), getPublisher(), getOrganization(), getEditor());
    }
}
