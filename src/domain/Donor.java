/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

//import java.util.Date;

import java.sql.Date;


/**
 *
 * @author howar
 */
public class Donor extends Person
{
    
    private String donationId; //this is an auto Incremented column in the database
    //default constructor
    public Donor(){ super();}
    
    public Donor(String trn, String firstname, String lastname, String email, String gender, Date dob, String[] number, String[] address, String donationId)
    {
        super(trn,firstname,lastname,email,gender,dob,number,address);
        setDonationId(donationId);
    }
    
    public Donor(String trn, String firstname, String lastname, String email, String gender, Date dob, String[] number, String[] address)
    {
        super(trn,firstname,lastname,email,gender,dob,number,address);
        //setDonationId(donationId);
    }
    
    public void setDonationId(String donationId){this.donationId = donationId;}
    //TODO Remove this method
    //public String getDonationId(){return donationId;}
    
}
