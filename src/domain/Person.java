/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

//import java.util.Date;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 *
 * @author howar
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @Column (name ="trn")
    private String trn;
    
    @Column (name ="firstname")
    private String firstname;
    
    @Column (name = "lastname")
    private String lastname;
    
    @Column (name = "email")
    private String email;
    
    @Column (name = "gender")
    private String gender;
    //private Date dob;
    //TODO Add Date , Number, and Address Annotation
    private Date dob;
    private String[] number;
    private String[] address;
    
    //Default constructor
    public Person(){}

    public Person(String trn, String firstname, String lastname, String email, String gender, Date dob, String[] number, String[] address) {
        this.trn = trn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.number = number;
        this.address = address;
    }
    
    /*
    * GETTERS
    */
    public String[] getAddress() {return address;}
    public Date getDob() {return dob;}
    public String getEmail() {return email;}
    public String getFirstname() {return firstname;}
    public String getLastname() {return lastname;}
    public String getGender() {return gender;}
    public String[] getNumber() {return number;}
    public String getTrn() {return trn;}

    /*
    * SETTERS
    */
    //TODO VALIDATE THESE INPUTS
    public void setAddress(String[] address) {this.address = address;}
    public void setDob(Date dob) {this.dob = dob;}
    public void setEmail(String email) {this.email = email;}
    public void setFirstname(String firstname) {this.firstname = firstname;}
    public void setGender(String gender) {this.gender = gender;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setNumber(String[] number) {this.number = number;}
    public void setTrn(String trn) {this.trn = trn;}
    
    
    
}
