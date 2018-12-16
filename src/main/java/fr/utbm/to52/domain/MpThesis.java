/**
 *
 */
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

/**
 * @author To52
 *
 */
@Entity
@DiscriminatorValue("MpThesis")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MpThesis extends Publication implements Serializable {

    @Column(nullable = true)
    private String School;

    public MpThesis(String School, Long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Long year, Long month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Set<Author> authors) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, authors);
        this.School = School;
    }

    
    
    public MpThesis(String school) {
        School = school;
    }

    public MpThesis() {

    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MpThesis)) return false;
        if (!super.equals(o)) return false;
        MpThesis mpThesis = (MpThesis) o;
        return Objects.equals(getSchool(), mpThesis.getSchool());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSchool());
    }
}
