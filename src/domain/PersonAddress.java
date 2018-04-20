/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author howar
 */
@Entity
@Table(name ="donor_address")
public class PersonAddress extends Address implements Serializable{
    
//    private String address_id;
    private int id;
    
    private Donor donor;
    //private Person person;
    public PersonAddress() {
    }
//    public PersonAddress(String id, String street, String addressLine1, String addressLine2) {
//        super(street, addressLine1, addressLine2);
//        this.address_id = id;
//    }
    public PersonAddress(int id, String street, String addressLine1, String addressLine2) {
        super(street, addressLine1, addressLine2);
        this.id = id;
    }
    public PersonAddress(String street, String addressLine1, String addressLine2) {
        super(street, addressLine1, addressLine2);
    }
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trn")
    public Donor getDonor(){return donor;}
    public void setDonor(Donor donor){ this.donor = donor;}
    @Id
    @GeneratedValue
    public int getAddressId() {
//        return address_id;
        return id;
    }
    public void setAddressId(int address_id) {
//        this.address_id = address_id;
            this.id = address_id;
    }
    
}
