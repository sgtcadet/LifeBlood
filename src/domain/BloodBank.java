/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author howar
 */
public class BloodBank 
{
    private String id;
    private String name;
    private String[] address;
    private String number; //Blood Bank will only have one (1) phone number
    
    //default constructor

    public BloodBank(){}

    /*
    * SETTERS
    */
    public void setNumber(String number) {this.number = number;}
    public void setName(String name) {this.name = name;}
    public void setId(String id) {this.id = id;}
    public void setAddress(String[] address) {this.address = address;}
    
    /*
    * GETTERS
    */
    public String getNumber() {return number;}
    public String getName() {return name;}
    public String getId() {return id;}
    public String[] getAddress() {return address;}
    
    

    public BloodBank(String id, String name, String[] address, String number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
    }
    
    
}
