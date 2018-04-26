/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifeblood;

import business.BloodBankMgr;
import business.DonorMgr;
import business.ReceptionistMgr;
import domain.Address;
import domain.BloodBank;
import domain.BloodBankAddress;
import domain.Donor;
import domain.Hospital;
import domain.HospitalAddress;
import domain.PersonAddress;
import domain.Phone;
import domain.Receptionist;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.application.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import java.util.Date;
import services.HospitalSvcJDBCImpl;
import services.BloodBankSvcJDBCImpl;
import services.Hibernate.BloodBankSvcHibernateImpl;
import services.Hibernate.DonorSvcHibernateImpl;
import services.Hibernate.HospitalSvcHibernateImpl;
import services.ReceptionistSvcJDBCImpl;

/**
 *
 * @author howar
 */
public class LifeBlood {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        //try {
            //blood bank temp
//        BloodBank bloodBank = new BloodBank();
//        bloodBank.setId("KPH8");
//        Date donorDate = new Date(1995,12,03);
//        PersonAddress donorAddress = new PersonAddress("Street","address line 1", "address line 2");
//        Phone donorPhone = new Phone("1234873", "1234313");
//        Donor donor = new Donor("A-pos","116-852-894","Howard","Grant","hgrant@yahoo.com","Male",donorDate);
//        donor.setAddress(donorAddress);
//        donor.setPhone(donorPhone);
    BloodBankMgr bloodBankMgr = new BloodBankMgr();
    BloodBankAddress address = new BloodBankAddress();
    BloodBank bloodBank = new BloodBank();
    //
    address.setAddressId("16");
    address.setStreet("Blood Bank Street");
    address.setAddressLine1("Address Line 1");
    address.setAddressLine2("Address Line 2");
    bloodBank.setId("12345");
    bloodBank.setName("Blood Bank Name");
    bloodBank.setNumber("1234567");
    bloodBank.setBloodBankAddress(address);
//    bloodBankMgr.addBloodBank(bloodBank);
    List<BloodBank> bBankList = new ArrayList();
        try{
//            DonorMgr donorMgr = new DonorMgr();
//            donorMgr.addDonor(donor, bloodBank);
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
            BloodBankMgr bBankMgr = (BloodBankMgr)context.getBean("bloodBankMgr"); 
            //bBankMgr.addBloodBank(bloodBank);
            
            bBankList = bBankMgr.getAllBloodBank();
            Iterator<BloodBank> stdIter = bBankList.iterator();
            int counter = 0;
            while(stdIter.hasNext())
            { 
                System.out.println(stdIter.next().toString());
                counter++;
            }
            System.out.println("Counter value {" + counter + "}");
        }catch(Exception e){ System.out.println("Presentation Error: " + e.toString());}
//    
    /**
 * Springs FAIL
 */
//        try{
//        ApplicationContext context = (ApplicationContext) new ClassPathXmlApplicationContext(new String[] {"config.xml"});
//        BloodBankMgr bloodBankMgr = (BloodBankMgr) context.getBean("bloodBankMgr"); 
//        bloodBankMgr.addBloodBank(bloodBank);
//        }catch(Exception e){}
//        } catch (Exception ex) {
//            Logger.getLogger(LifeBlood.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
}
