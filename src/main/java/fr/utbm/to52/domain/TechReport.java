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
@DiscriminatorValue("TechReport")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TechReport extends Publication implements Serializable {

    @Column(nullable = true)
    private String Institution;

    @Column(nullable = true)
    private Long Number;

    public TechReport(String Institution, Long Number, long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, long year, long month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Set<Author> authors) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, authors);
        this.Institution = Institution;
        this.Number = Number;
    }

    

    public TechReport(String institution, Long number) {
        Institution = institution;
        Number = number;
    }

    public TechReport() {

    }

    public String getInstitution() {
        return Institution;
    }

    public void setInstitution(String institution) {
        Institution = institution;
    }

    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long number) {
        Number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechReport)) return false;
        if (!super.equals(o)) return false;
        TechReport that = (TechReport) o;
        return Objects.equals(getInstitution(), that.getInstitution()) &&
                Objects.equals(getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInstitution(), getNumber());
    }
}
