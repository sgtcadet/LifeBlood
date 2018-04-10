/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author howar
 */
@Entity
@Table(name="donor_phone")
public class Phone implements Serializable {
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
    
    
    @Id
    @Column(name="trn")
    public int getId() {return id;}
    @Column(name= "phone_number_1")
    public String getPhone1() {return phone1;}
    @Column (name="phone_number_2")
    public String getPhone2() {return phone2;}
    
    public void setPhone1(String phone1) {this.phone1 = phone1;}
    public void setPhone2(String phone2) {this.phone2 = phone2;}
    public void setId(int id) {this.id = id;}
    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", phone1=" + phone1 + ", phone2=" + phone2 + '}';
    }
    
    
    
}
