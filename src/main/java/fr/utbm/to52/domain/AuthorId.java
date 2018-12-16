package fr.utbm.to52.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;

@Embeddable
public class AuthorId implements Serializable {

                @Column(name = "fk_publication")
		protected Long idPublication;

		@Column(name = "fk_member")
		protected Long idMember;

		public AuthorId() {
			
		}

    public AuthorId(Long idPublication, Long idMember) {
        this.idPublication = idPublication;
        this.idMember = idMember;
    }
		
		
                
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((idPublication == null) ? 0 : idPublication.hashCode());
			result = prime * result
					+ ((idMember == null) ? 0 : idMember.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			
			AuthorId other = (AuthorId) obj;
			
			if (idPublication == null) {
				if (other.idPublication != null)
					return false;
			} else if (!idPublication.equals(other.idPublication))
				return false;
			
			if (idMember == null) {
				if (other.idMember != null)
					return false;
			} else if (!idMember.equals(other.idMember))
				return false;
			
			return true;
		}

    public Long getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(Long idPublication) {
        this.idPublication = idPublication;
    }

    public Long getIdMember() {
        return idMember;
    }

    public void setIdMember(Long idMember) {
        this.idMember = idMember;
    }

     
}

