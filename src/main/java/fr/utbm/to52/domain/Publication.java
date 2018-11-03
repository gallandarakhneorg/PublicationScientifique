package fr.utbm.to52.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Publication implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publication")
    private long idPublication;

    @Column
    private PublicationType publicationType;

    @Column(nullable=false)
    private String englishTitle;

    @Column(nullable=false)
    private String frenchTitle;

    @Column(nullable=false)
    private Date year;

    @Column(nullable=false)
    private Date month;

    @Column(nullable=false)
    private String note;

    @Column(nullable=false)
    private String linkImage;

    @Column(nullable=false)
    private String pdfLink;

    @Column(nullable=false)
    private String issn;

    @Column(nullable=false)
    private String Abstract;

    @Column(nullable=false)
    private String keyWords;

    public Publication(long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Date year, Date month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords) {
        this.idPublication = idPublication;
        this.publicationType = publicationType;
        this.englishTitle = englishTitle;
        this.frenchTitle = frenchTitle;
        this.year = year;
        this.month = month;
        this.note = note;
        this.linkImage = linkImage;
        this.pdfLink = pdfLink;
        this.issn = issn;
        Abstract = anAbstract;
        this.keyWords = keyWords;
    }

    public Publication() {


    }

    public long getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(long idPublication) {
        this.idPublication = idPublication;
    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(PublicationType publicationType) {
        this.publicationType = publicationType;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getFrenchTitle() {
        return frenchTitle;
    }

    public void setFrenchTitle(String frenchTitle) {
        this.frenchTitle = frenchTitle;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication that = (Publication) o;
        return getIdPublication() == that.getIdPublication() &&
                getPublicationType() == that.getPublicationType() &&
                Objects.equals(getEnglishTitle(), that.getEnglishTitle()) &&
                Objects.equals(getFrenchTitle(), that.getFrenchTitle()) &&
                Objects.equals(getYear(), that.getYear()) &&
                Objects.equals(getMonth(), that.getMonth()) &&
                Objects.equals(getNote(), that.getNote()) &&
                Objects.equals(getLinkImage(), that.getLinkImage()) &&
                Objects.equals(getPdfLink(), that.getPdfLink()) &&
                Objects.equals(getIssn(), that.getIssn()) &&
                Objects.equals(getAbstract(), that.getAbstract()) &&
                Objects.equals(getKeyWords(), that.getKeyWords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPublication(), getPublicationType(), getEnglishTitle(), getFrenchTitle(), getYear(), getMonth(), getNote(), getLinkImage(), getPdfLink(), getIssn(), getAbstract(), getKeyWords());
    }
}
