/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author howar
 */
@Entity
@Table( name = "blood_bank" )
public class BloodBank 
{
    @Id
    @Column( name = "idblood_bank")
    private String idblood_bank;
    
    @Column( name = "name")
    private String name;
    
    @Column ( name = "phone")
    private String number; //Blood Bank will only have one (1) phone number
    
    //default constructor
    public BloodBank(){}
    //PRIMARY CONSTRUCTORS
    public BloodBank(String id, String name, String number) {
        this.idblood_bank = id;
        this.name = name;
        this.number = number;
    }
    /*
    * SETTERS
    */
    public void setNumber(String number) {this.number = number;}
    public void setName(String name) {this.name = name;}
    public void setId(String id) {this.idblood_bank = id;}
    /*
    * GETTERS
    */
    public String getNumber() {return number;}
    public String getName() {return name;}
    public String getId() {return idblood_bank;}
}
    
    

