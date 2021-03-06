package fr.utbm.to52.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PublicationType implements Serializable {

    @Id
    @Column(name="id_publication_type",nullable=false)
    private String code;

    @Column(nullable=false)
    private String publicationType;

    /*@Column(nullable = true)
    private String kind; */

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicationType")
    private Set<Publication> publications = new HashSet<Publication>(0); */
    /*
    public PublicationType(String code, String publicationType, String kind, Set<Publication> publications) {
        this.code = code;
        this.publicationType = publicationType;
        //this.kind = kind;
        this.publications= publications;
    } */

    public PublicationType(String code, String publicationType) {
        this.code = code;
        this.publicationType = publicationType;
    }
    
    
    
    public PublicationType(){}
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }
/*
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    } 
    
    
    public Set<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }  */

    @Override
    public String toString() {
        return "PublicationType{" + "code=" + code + ", publicationType=" + publicationType + '}';
    }
    
    

}


