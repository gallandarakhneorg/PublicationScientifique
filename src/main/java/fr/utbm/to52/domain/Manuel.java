package fr.utbm.to52.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Manuel extends Publication implements Serializable {

    @Column
    private String Organization;

    @Column
    private String Edition;

    @Column
    private String Institution;

    @Column
    private String Number;

    public Manuel(long idPublication, PublicationType publicationType, String englishTitle, String frenchTitle, Date year, Date month, String note, String linkImage, String pdfLink, String issn, String anAbstract, String keyWords, Project project, Set<Author> authors, String organization, String edition, String institution, String number) {

        super(idPublication, publicationType, englishTitle, frenchTitle, year, month, note, linkImage, pdfLink, issn, anAbstract, keyWords, project, authors);
        Organization = organization;
        Edition = edition;
        Institution = institution;
        Number = number;
    }

    public Manuel(String organization, String edition, String institution, String number) {
        Organization = organization;
        Edition = edition;
        Institution = institution;
        Number = number;
    }

    public Manuel() {

    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        Organization = organization;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
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
        if (!(o instanceof Manuel)) return false;
        if (!super.equals(o)) return false;
        Manuel manuel = (Manuel) o;
        return Objects.equals(getOrganization(), manuel.getOrganization()) &&
                Objects.equals(getEdition(), manuel.getEdition()) &&
                Objects.equals(getInstitution(), manuel.getInstitution()) &&
                Objects.equals(getNumber(), manuel.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOrganization(), getEdition(), getInstitution(), getNumber());
    }
}
