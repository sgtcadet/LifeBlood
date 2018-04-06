/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author howar
 */
@Entity
@Table (name = "hospital_address")
public class HospitalAddress extends Address{
    private String address_id;
    //DEFAULT CONSTRUCTOR
    
    
    public HospitalAddress(){super();}
    public HospitalAddress(String id, String street, String addressLine1, String addressLine2){super(street,addressLine1,addressLine2); this.address_id = id;}
    
    @Id
    @Column(name = "address_id")
    public String getAddressId(){return address_id;}
    public void setAddressId(String id){this.address_id = id;}

    @Override
    public String toString() {
        return super.toString() +" HospitalAddress{" + "address_id=" + address_id + '}';
    }
}
