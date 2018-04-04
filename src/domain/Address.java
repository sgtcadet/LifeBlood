/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author howar
 */
//@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Address {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private String id;
    
    private String street;
    private String addressLine1;
    private String addressLine2;
    
    //Default Constructor
    public Address(){}
    
    //Primary Constructor
    public Address(String street, String addressLine1, String addressLine2) {
        this.street = street;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }
    @Column (name = "street")
    public String getStreet() {return street;}
    @Column (name ="address_line_1")
    public String getAddressLine1() {return addressLine1;}
    @Column (name = "address_line_2")
    public String getAddressLine2() {return addressLine2;}
//    public String getId(){return id;}
  
    public void setStreet(String street) {this.street = street;}
    public void setAddressLine1(String addressLine1) {this.addressLine1 = addressLine1;}
    public void setAddressLine2(String addressLine2) {this.addressLine2 = addressLine2;}
//    public void setId(String id){this.id = id;}
}
