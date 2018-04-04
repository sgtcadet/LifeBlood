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
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author howar
 */
@Entity
@Table (name = "blood_bank_address")
public class BloodBankAddress extends Address{
    
    //private BloodBank bloodBank;
    private String address_id;
    //DEFAULT CONSTRUCTOR
    public BloodBankAddress(){super();}
    public BloodBankAddress(String id, String street, String addressLine1, String addressLine2){super(street,addressLine1,addressLine2); this.address_id = id;}
    @Id
    @Column(name = "address_id")
    public String getAddressId(){return address_id;}
    public void setAddressId(String id){this.address_id = id;}

    @Override
    public String toString() {
        return super.toString() +" BloodBankAddress{" + "address_id=" + address_id + '}';
    }
    
    
}
