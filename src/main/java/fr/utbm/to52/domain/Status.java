package fr.utbm.to52.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Status {

    @Id
    @Column(name="id_status",nullable=false)
    private String code;

    @Column(name="label",nullable=false)
    private String statusLabel;

    public Status(String code, String statusLabel) {
        this.code = code;
        this.statusLabel = statusLabel;
    }

    
    //Constructeur
    public Status()
    {
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Override
    public String toString() {
        return "Status{" + "code=" + code + ", statusLabel=" + statusLabel + '}';
    }
    
    
    
}
