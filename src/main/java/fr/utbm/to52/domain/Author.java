package fr.utbm.to52.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@AssociationOverrides({
        @AssociationOverride(name = "id.member",
                joinColumns = @JoinColumn(name = "id_member")),
        @AssociationOverride(name = "id.publication",
                joinColumns = @JoinColumn(name = "id_publication")) })
public class Author implements Serializable {


    @EmbeddedId
    private AuthorId id = new AuthorId();

    @Column( nullable = false)
    private String orderAuthor;

    public Author(AuthorId id, String orderAuthor) {
        this.id = id;
        this.orderAuthor = orderAuthor;
    }

    public AuthorId getId() {
        return id;
    }

    public void setId(AuthorId id) {
        this.id = id;
    }

    @Transient
    public Member getMember() {
        return getId().getMember();
    }

    public void setMember(Member member) {
        getId().setMember(member);
    }

    @Transient
    public Publication getPublication() {
        return getId().getPublication();
    }

    public void setPublication(Publication publication) {
        getId().setPublication(publication);
    }

    public String getOrderAuthor() {
        return orderAuthor;
    }

    public void setOrderAuthor(String orderAuthor) {
        this.orderAuthor = orderAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getId(), author.getId()) &&
                Objects.equals(getOrderAuthor(), author.getOrderAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderAuthor());
    }
}

