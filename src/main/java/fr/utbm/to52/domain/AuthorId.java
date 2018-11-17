package fr.utbm.to52.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AuthorId implements Serializable {

    @ManyToOne
    private Member member;

    @ManyToOne
    private Publication publication;

    public AuthorId(Member member, Publication publication) {
        this.member = member;
        this.publication = publication;
    }

    public AuthorId() {

    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorId)) return false;
        AuthorId authorId = (AuthorId) o;
        return Objects.equals(getMember(), authorId.getMember()) &&
                Objects.equals(getPublication(), authorId.getPublication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMember(), getPublication());
    }
}



