/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author howar
 */
@Entity
@Table (name = "hospital")
public class Hospital 
{
    private String hostpitalId;
    private String name;
    //TODO ADD ANNOTATION FOR ADDRESS
    private String phone; //Hospital will have only one phone number
    private HospitalAddress address;
    
    
    //Default constructor
    public Hospital(){}
    
    //Primary constructor
    public Hospital(String hostpitalId, String name,  String phone, HospitalAddress address) {
        this.hostpitalId = hostpitalId;
        this.name = name;
        this.phone = phone;
        this.address = address; 
    }
    
    
    
    
    /*
    * GETTERS
    **/
    @Column (name = "phone")
    public String getPhone() { return this.phone;}
    @Column (name = "name")
    public String getName(){ return this.name;}
    @Id
    @Column (name = "idhospital")
    public String getHospitalId(){ return this.hostpitalId;}
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id") //hibernate should generate this column
    public HospitalAddress getHospitalAddress(){ return address;} //ARRAY OF STRINGS ADDRESSES
    
    
    /*
    * SETTERS
    **/
    public void setHospitalId(String h_id){ this.hostpitalId = h_id;}
    public void setName(String name){ this.name = name;}
    public void setAddress(HospitalAddress address){this.address = address;}  
    public void setPhone(String phone){ this.phone = phone;} //Hospital have only 1 number

    @Override
    public String toString() {
        return "Hospital{" + "hostpitalId=" + hostpitalId + ", name=" + name + ", phone=" + phone + ", address=" + address + '}';
    }
    
    
}
