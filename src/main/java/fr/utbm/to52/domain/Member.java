/**
 *
 */
package fr.utbm.to52.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author To52
 *
 */

@Entity
public class Member {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
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
    private String password;

    @Column(nullable=false)
    private String email;

    @Column
    private String session;

    @Column(nullable=false)
    private Status status;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "member_project",
            joinColumns = { @JoinColumn(name = "idMember") },
            inverseJoinColumns = { @JoinColumn(name = "idProject") }
    )
    Set<Project> projects = new HashSet<>();

    public Member(long idMember, Address addresss, String lastName, String firstName, String linkImage, Date startDate, String login, String password, String email, String session, Status status) {
        this.idMember = idMember;
        Addresss = addresss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.linkImage = linkImage;
        this.startDate = startDate;
        this.login = login;
        this.password = password;
        this.email = email;
        this.session = session;
        this.status = status;
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

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        password = passWord;
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

    public fr.utbm.to52.domain.Status getStatus() {
        return status;
    }

    public void setStatus(fr.utbm.to52.domain.Status status) {
        this.status = status;
    }

}
