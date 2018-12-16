package fr.utbm.to52.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
/*@AssociationOverrides({
        @AssociationOverride(name = "id.member",
                joinColumns = @JoinColumn(name = "id_member")),
        @AssociationOverride(name = "id.publication",
                joinColumns = @JoinColumn(name = "id_publication")) }) */
public class Author implements Serializable {


    @EmbeddedId
    private AuthorId id;
    
    //@JsonManagedReference
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="fk_publication", insertable=false, updatable = false)
    private Publication publication;
    
    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name="fk_member", insertable=false, updatable = false)
    private Member member;
    
    @Column( nullable = false)
    private String orderAuthor;

    public Author() {
    }

    public Author(Publication p, Member m, String orderAuthor) {
        this.id = new AuthorId(p.getIdPublication(),m.getIdMember());
        this.publication = p;
        this.member = m;
        this.orderAuthor = orderAuthor;
        
        p.getAuthors().add(this);
        m.getAuthors().add(this);
    }
    
    
    
    public Author(AuthorId id, Publication publication, Member member, String orderAuthor) {
        this.id = id;
        this.publication = publication;
        this.member = member;
        this.orderAuthor = orderAuthor;
    }

    public AuthorId getId() {
        return id;
    }

    public void setId(AuthorId id) {
        this.id = id;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getOrderAuthor() {
        return orderAuthor;
    }

    public void setOrderAuthor(String orderAuthor) {
        this.orderAuthor = orderAuthor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.publication);
        hash = 79 * hash + Objects.hashCode(this.member);
        hash = 79 * hash + Objects.hashCode(this.orderAuthor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.orderAuthor, other.orderAuthor)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.publication, other.publication)) {
            return false;
        }
        if (!Objects.equals(this.member, other.member)) {
            return false;
        }
        return true;
    }
    
    
    
   
}