package fr.utbm.to52.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import static javax.persistence.EnumType.STRING;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@DiscriminatorValue("Publication")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public  class Publication implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publication")
    private Long idPublication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publication_type", nullable = false)
    private PublicationType publicationType;

    @Column(nullable=false)
    private String englishTitle;

    @Column(nullable=true)
    private String frenchTitle;

    @Column(nullable=false)
    private Long year;

    @Column(nullable=false)
    private Long month;

    @Column(nullable=true)
    private String note;

    @Column(nullable=true)
    private String linkImage;

    @Column(nullable=true)
    private String pdfLink;

    @Column(nullable=true)
    private String issn;

    @Column(nullable=true)
    private String Abstract;

    @Column(nullable=true)
    private String keyWords;
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project", nullable = true)
    private Project project;  */

  
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publication" , cascade=CascadeType.ALL)
    //@JsonBackReference
    private Set<Author> authors = new HashSet<Author>(0);

    public Publication(Long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Long year, Long month, String note, String linkImage, String pdfLink, String issn, String Abstract, String keyWords /*, Project project */) {
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
        this.Abstract = Abstract;
        this.keyWords = keyWords;
       // this.project = project;
    }

    
    
    public Publication(Long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Long year, Long month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Set<Author> authors) {

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
        this.authors= authors;
    }

    public Publication() {


    }

    public Long getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(Long idPublication) {
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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
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
    /*
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    } */

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
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
    /*
    @Override
    public String toString() {
        return "Publication{" + "idPublication=" + idPublication + ", publicationType=" + publicationType + ", englishTitle=" + englishTitle + ", frenchTitle=" + frenchTitle + ", year=" + year + ", month=" + month + ", note=" + note + ", linkImage=" + linkImage + ", pdfLink=" + pdfLink + ", issn=" + issn + ", Abstract=" + Abstract + ", keyWords=" + keyWords + ", authors=" + authors + '}';
    } */
    
    
   
}
