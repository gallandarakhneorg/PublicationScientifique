/**
 *
 */
package fr.utbm.to52.domain;

import javax.persistence.*;

/**
 * @author To52
 *
 */

@Entity
public class Address {

    /**
     *
     */

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private long idAddress;

    @Column(nullable=false)
    private String city;

    @Column(nullable=false)
    private String zipcode;

    public Address(long idAddress, String city, String zipcode) {
        this.idAddress = idAddress;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Address() {

    }

    public long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(long idAddress) {
        this.idAddress = idAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
