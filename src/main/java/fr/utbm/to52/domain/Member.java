/**
 *
 */
package fr.utbm.to52.domain;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author To52
 *
 */
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
@Entity
public class Member implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_member",nullable=false, updatable=false)
    private long idMember;

    @OneToOne
    @JoinColumn(name="id_address", referencedColumnName="idAddress")
    private Address Addresss;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false)
    private String firstName;

    @Column
    private String linkImage;

    @Column
    private Date startDate;

    @Column(nullable=false)
    private String login;

    @Column(nullable=false)
    private String email;

    @Column
    private String session;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false,columnDefinition = "member_status")
    @Type( type = "pgsql_enum" )
    private Status status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
    private Set<Project> managerprojects = new HashSet<Project>(0);

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "member_project",
            joinColumns = { @JoinColumn(name = "idMember") },
            inverseJoinColumns = { @JoinColumn(name = "idProject") }
    )
    private Set<Project> projects = new HashSet<Project>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.member", cascade=CascadeType.ALL)
    private Set<Author> authors = new HashSet<Author>(0);


    public Member(long idMember, Address addresss, String lastName, String firstName, String linkImage, Date startDate, String login, String email, String session, Status status, Set<Project> projects, Set<Project> managerprojects, Set<Author> authors) {

        Addresss = addresss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.linkImage = linkImage;
        this.startDate = startDate;
        this.login = login;
        this.email = email;
        this.session = session;
        this.status = status;
        this.projects= projects;
        this.managerprojects=managerprojects;
        this.authors= authors;
    }

    public Member() {

    }


    public long getIdMember() {
        return idMember;
    }

    public void setIdMember(long idMember) {
        this.idMember = idMember;
    }

    public Address getAddresss() {
        return Addresss;
    }

    public void setAddresss(Address addresss) {
        Addresss = addresss;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLinkImage() {
        return linkImage;
    }


    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Project> getManagerprojects() {
        return managerprojects;
    }

    public void setManagerprojects(Set<Project> managerprojects) {
        this.managerprojects = managerprojects;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


    /**
     * @return the projects
     */
    public Set<Project> getProjects() {
        return this.projects;
    }

    /**
     * @param projects the participants to set
     */
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

}
