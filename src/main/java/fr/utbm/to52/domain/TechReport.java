package fr.utbm.to52.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class TechReport extends Publication implements Serializable {

    @Column
    private String Institution;

    @Column
    private String Number;

    public TechReport(long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Date year, Date month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Project project, Set<Author> authors, String institution, String number) {
        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, project, authors);
        Institution = institution;
        Number = number;
    }

    public TechReport(String institution, String number) {
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

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
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
