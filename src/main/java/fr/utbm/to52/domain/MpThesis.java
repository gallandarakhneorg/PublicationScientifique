/**
 *
 */
package fr.utbm.to52.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author To52
 *
 */
@Entity
public class MpThesis extends Publication implements Serializable {

    @Column(nullable = false)
    private String School;

    public MpThesis(long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Date year, Date month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Project project, Set<Author> authors, String school) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, project, authors);
        School = school;
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
