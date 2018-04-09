/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author howar
 */
@Entity
@Table (name="receptionist")
public class Receptionist extends Person implements Serializable{
//    private BloodBank bloodBank;
//    //private PersonAddress address;
//    private String[] phone;
//    
//    public Receptionist(){super();}
//
//    public Receptionist(BloodBank bloodBank) {
//        this.bloodBank = bloodBank;
//    }
//
//    public Receptionist(BloodBank bloodBank, String trn, String firstname, String lastname, String email, String gender, Date dob, Phone number, PersonAddress address) {
//        super(trn, firstname, lastname, email, gender, dob, number, address);
//        this.bloodBank = bloodBank;
//    }
//    
//    public Receptionist(BloodBank bloodBank, String trn, String firstname, String lastname, String email, String gender, Date dob, String[] number, PersonAddress address) {
//        super(trn, firstname, lastname, email, gender, dob, address);
//        this.bloodBank = bloodBank;
//        this.phone = number;
//    }
//
//    @OneToOne
//    public BloodBank getBloodBank() {return bloodBank;}
//    public void setBloodBank(BloodBank bloodBank) {this.bloodBank = bloodBank;}
//    @OneToOne
//    public String[] getNumber(){return phone;}
//    public void SetNumber( String[] num){this.phone = num;}
   
}
