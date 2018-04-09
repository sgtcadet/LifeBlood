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
public class PersonAddress extends Address{
    private String address_id;
    public PersonAddress() {
    }
    public PersonAddress(String id, String street, String addressLine1, String addressLine2) {
        super(street, addressLine1, addressLine2);
        this.address_id = id;
    }
    public PersonAddress(String street, String addressLine1, String addressLine2) {
        super(street, addressLine1, addressLine2);
    }
    public String getAddressId() {
        return address_id;
    }
    public void setAddressId(String address_id) {
        this.address_id = address_id;
    }
    
}
