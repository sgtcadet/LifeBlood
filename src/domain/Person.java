/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

//import java.util.Date;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 *
 * @author howar
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable {
   
    private String trn;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    //private Date dob;
    //TODO Add Date , Number, and Address Annotation
    private Date dob;
    private Phone phone;
    private PersonAddress address;
    //Default constructor
    public Person(){}

    public Person(String trn, String firstname, String lastname, String email, String gender, Date dob, Phone number, PersonAddress address) {
        this.trn = trn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.phone = number;
        this.address = address;
    }
    public Person(String trn, String firstname, String lastname, String email, String gender, Date dob, PersonAddress address) {
        this.trn = trn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        //this.phone = number;
        this.address = address;
    }    
    /*
    * GETTERS
    */
    public Date getDob() {return dob;}
    @Column (name = "email")
    public String getEmail() {return email;}
    @Column (name ="firstname")
    public String getFirstname() {return firstname;}
    @Column (name = "lastname")
    public String getLastname() {return lastname;}
    @Column (name = "gender")
    public String getGender() {return gender;}
    @Id
    @Column (name ="trn")
    public String getTrn() {return trn;}
//    @OneToOne
    public Phone getPhone() {return phone;}
//    @OneToOne
    public PersonAddress getAddress() {return address;}
    /*
    * SETTERS
    */
    //TODO VALIDATE THESE INPUTS
    public void setDob(Date dob) {this.dob = dob;}
    public void setEmail(String email) {this.email = email;}
    public void setFirstname(String firstname) {this.firstname = firstname;}
    public void setGender(String gender) {this.gender = gender;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setTrn(String trn) {this.trn = trn;}
    public void setPhone(Phone number) {this.phone = number;}
    public void setAddress(PersonAddress address) { this.address = address;}

    
    
    
}
