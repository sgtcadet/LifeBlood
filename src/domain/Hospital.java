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
@Table (name = "hospital")
public class Hospital 
{
    //Default constructor
    public Hospital(){}
    
    //Primary constructor
    public Hospital(String hostpitalId, String name, String[] address, String phone) {
        this.hostpitalId = hostpitalId;
        this.name = name;
        this.address = address; 
        this.phone = phone;
    }
    
    @Id
    @Column (name = "idhospital")
    private String hostpitalId;
    @Column (name = "name")
    private String name;
    
    //TODO ADD ANNOTATION FOR ADDRESS
    private String[] address;
    
    @Column (name = "phone")
    private String phone; //Hospital will have only one phone number
    
    
    /*
    * GETTERS
    **/
    public String getHospitalId(){ return this.hostpitalId;}
    public String getName(){ return this.name;}
    public String[] getAddress(){ return this.address;} //ARRAY OF STRINGS ADDRESSES
    public String getPhone() { return this.phone;}
    
    /*
    * SETTERS
    **/
    //TODO (1) validate these inputs
    public void setHospitalId(String h_id){ this.hostpitalId = h_id;}
    public void setName(String name){ this.name = name;}
    public void setAddress(String[] address){ 
        this.address = address;
        //THOUGHTS (1) is this needed?
        /*
        this.address[0] = address[0]; //Street
        this.address[1] = address[1]; //Address line 1
        this.address[2] = address[2]; //Address line 2
        */    
    }
    public void setPhone(String phone){ this.phone = phone;} //Hospital have only 1 number
}
