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
//public class BloodBankAddress{
    @Id @GeneratedValue( generator = "newGenerator") 
    @GenericGenerator( name ="newGenerator" , strategy="foreign",parameters ={ @Parameter( value = "bloodBank", name = "property")})
    //@Column (name ="idblood_bank")
    private String idblood_bank;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idblood_bank")
    private BloodBank bloodBank; //virtual Entity Framework
    
    //DEFAULT CONSTRUCTOR
    public BloodBankAddress(){super();}
    /*GETTERS*/
    public String getId(){return idblood_bank;}
    public BloodBank getBloodBank(){return bloodBank;}
    /*SETTERS*/
    public void setId(String id){this.idblood_bank = id;}
    public void setBloodBank(BloodBank bank){this.bloodBank = bank;}
    
    
}
