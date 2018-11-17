/**
 *
 */
package fr.utbm.to52.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author To52
 *
 */
@Entity
public class Project implements Serializable {

    /**
     *
     */

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_project",nullable=false, updatable=false)
    private long idProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_member", nullable = false)
    private Member manager;

    @Column(nullable=false)
    private String name;

    @Column
    private Date creationdate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private Set<Publication> publications = new HashSet<Publication>(0);

    @ManyToMany(mappedBy = "projects")
    private Set<Member> members = new HashSet<>();

    public Project(long idProject, Member manager, String name, Date creationdate) {
        this.manager = manager;
        this.name = name;
        this.creationdate = creationdate;
    }
    public Project() {

    }
    public Project(long idProject, Member manager, String name, Date creationdate, Set<Member> members, Set<Publication> publications) {
        this.manager = manager;
        this.name = name;
        this.creationdate = creationdate;
        this.members= members;
        this.publications= publications;
    }

    public long getIdProject() {

        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public Member getManager() {
        return manager;
    }

    public void setManager(Member manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }

}
