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

public class Project {

    /**
     *
     */

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private long idProject;

    @OneToOne
    @JoinColumn(name="id_manager", referencedColumnName="idMember")
    private Member manager;

    @Column(nullable=false)
    private String name;

    @Column
    private Date creationdate;

    @ManyToMany(mappedBy = "projects")
    private Set<Member> members = new HashSet<>();

    public Project(long idProject, Member manager, String name, Date creationdate) {
        this.idProject = idProject;
        this.manager = manager;
        this.name = name;
        this.creationdate = creationdate;
    }
    public Project() {

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
}
