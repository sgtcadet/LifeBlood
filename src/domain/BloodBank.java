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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author howar
 */
@Entity
@Table( name = "blood_bank" )
public class BloodBank 
{
    private String idblood_bank;
    private String name;
    private String number; //Blood Bank will only have one (1) phone number
    private BloodBankAddress address;
    //default constructor
    public BloodBank(){}
    //PRIMARY CONSTRUCTORS
    public BloodBank(String id, String name, String number,BloodBankAddress address) {
        this.idblood_bank = id;
        this.name = name;
        this.number = number;
        this.address = address;
    }
    public void setNumber(String number) {this.number = number;}
    public void setName(String name) {this.name = name;}
    public void setId(String id) {this.idblood_bank = id;}
    public void setBloodBankAddress(BloodBankAddress address){ this.address = address;}

    @Column (name = "phone")
    public String getNumber() {return number;}
    @Column (name = "name")
    public String getName() {return name;}
    @Id
    @Column (name = "idblood_bank")
    public String getId() {return idblood_bank;}
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id") //hibernate should generate this column
    public BloodBankAddress getBloodBankAddress(){ return address;}
}
    
    

