/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Date;

/**
 *
 * @author howar
 */
public class Receptionist extends Person{
    
    private String receptionistId;
    //default constructor
    public Receptionist(){super();}
    
    public Receptionist(String trn, String firstname, String lastname, String email, String gender, Date dob, String[] number, String[] address, String repId)
    {
        super(trn,firstname,lastname,email,gender,dob,number,address);
        setReceptionistId(repId);
    }
    
    public Receptionist(String trn, String firstname, String lastname, String email, String gender, Date dob, String[] number, String[] address)
    {
        super(trn,firstname,lastname,email,gender,dob,number,address);
        //setReceptionistId(donationId);
    }
    
    public void setReceptionistId(String id){ this.receptionistId = id;}
    public String getReceptionistId(){ return receptionistId;}
}
