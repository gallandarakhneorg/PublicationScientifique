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
@DiscriminatorValue("Conference")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Conference extends Publication implements Serializable {

    @Column(nullable = true)
    private String ConferenceName;

    @Column(nullable = true)
    private Long Ranking;

    @Column
    private String Series;

    @Column(nullable = true)
    private String Pages;

    @Column(nullable = true)
    private Long Volume;

    @Column(nullable = true)
    private String Publisher;

    @Column(nullable = true)
    private String Organization;

    @Column(nullable = true)
    private String Editor;

    public Conference(String ConferenceName, Long Ranking, String Series, String Pages, Long Volume, String Publisher, String Organization, String Editor, Long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Long year, Long month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords,Set<Author> authors) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords,authors);
        this.ConferenceName = ConferenceName;
        this.Ranking = Ranking;
        this.Series = Series;
        this.Pages = Pages;
        this.Volume = Volume;
        this.Publisher = Publisher;
        this.Organization = Organization;
        this.Editor = Editor;
    }

    

    public Conference(String conferenceName, Long ranking, String series, String pages, Long volume, String publisher, String organization, String editor) {
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

    public Long getRanking() {
        return Ranking;
    }

    public void setRanking(Long ranking) {
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

    @Override
    public String toString() {
        return "Conference{" + "ConferenceName=" + ConferenceName + ", Ranking=" + Ranking + ", Series=" + Series + ", Pages=" + Pages + ", Volume=" + Volume + ", Publisher=" + Publisher + ", Organization=" + Organization + ", Editor=" + Editor + '}';
    }
    
    
}
