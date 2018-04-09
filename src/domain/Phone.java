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
public class Phone {
    private int id;
    private String phone1;
    private String phone2;
    
    public Phone(){}
    public Phone(int id, String phone1, String phone2) {
        this.id = id;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    public Phone( String phone1, String phone2) {
        //this.id = id;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", phone1=" + phone1 + ", phone2=" + phone2 + '}';
    }
    
    
    
}
