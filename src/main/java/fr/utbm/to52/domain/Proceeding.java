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
@DiscriminatorValue("Proceeding")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proceeding extends Publication implements Serializable {

    @Column(nullable = true)
    private String Editor;

    @Column(nullable = true)
    private String Volume;

    @Column(nullable = true)
    private String Series;

    @Column(nullable = true)
    private String Organization;

    @Column(nullable = true)
    private String Publisher;

    public Proceeding(String Editor, String Volume, String Series, String Organization, String Publisher, Long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Long year, Long month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Set<Author> authors) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, authors);
        this.Editor = Editor;
        this.Volume = Volume;
        this.Series = Series;
        this.Organization = Organization;
        this.Publisher = Publisher;
    }

    

    public Proceeding(String editor, String volume, String series, String organization, String publisher) {
        Editor = editor;
        Volume = volume;
        Series = series;
        Organization = organization;
        Publisher = publisher;
    }

    public Proceeding() {

    }

    public String getEditor() {
        return Editor;
    }

    public void setEditor(String editor) {
        Editor = editor;
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

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        Organization = organization;
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
        if (!(o instanceof Proceeding)) return false;
        if (!super.equals(o)) return false;
        Proceeding that = (Proceeding) o;
        return Objects.equals(getEditor(), that.getEditor()) &&
                Objects.equals(getVolume(), that.getVolume()) &&
                Objects.equals(getSeries(), that.getSeries()) &&
                Objects.equals(getOrganization(), that.getOrganization()) &&
                Objects.equals(getPublisher(), that.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEditor(), getVolume(), getSeries(), getOrganization(), getPublisher());
    }
}
