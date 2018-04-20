/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

//import java.util.Date;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author howar
 */
@Entity
@Table (name = "donor")
public class Donor extends Person
{
    private String bloodType; 
    //default constructor
    public Donor(){ super();}
    //public Donor(String bloodType){this.bloodType = bloodType;}
    public Donor(String bloodType, String trn, String firstname, String lastname, String email, String gender, Date dob, Phone number, PersonAddress address) {
        super(trn, firstname, lastname, email, gender, dob, number, address);
        this.bloodType = bloodType;
    }
    public Donor(String bloodType, String trn, String firstname, String lastname, String email, String gender, Date dob) {
        super(trn, firstname, lastname, email, gender, dob);
        this.bloodType = bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    @Column (name = "blood_type")
    public String getBloodType(){return bloodType;}
    //NOTE: 
    /**
     * If there are more than one children associated 
     * with the same parent, Hibernate will throw a 
     * org.hibernate.exception.ConstraintViolationException.
     * @return 
     */
    @OneToOne(mappedBy = "donor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Override
    public PersonAddress getAddress()
    {
        return super.getAddress();
    }
    
    @OneToOne(mappedBy = "donor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Override
    public Phone getPhone()
    {
        return super.getPhone();
    }
    
//    @Override
//    public void setAddress(PersonAddress address)
//    {
//        address.setDonor(this);
//        //this.setAddress(address);
//    }
    
}
