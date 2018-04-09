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
//import java.util.Date;
import services.HospitalSvcJDBCImpl;
import services.BloodBankSvcJDBCImpl;
import services.Hibernate.BloodBankSvcHibernateImpl;
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
    
    //TODO (MAIN) Check application database contraints
    public static void main(String[] args) {
        /*****************************
        *     BLOOD BANK INSTANCE
        ****************************/
        BloodBankAddress bAddress = new BloodBankAddress("5","8 Stennette Street","Port Maria", "St. St.Mary");
        BloodBank bBank = new BloodBank("KPH7","St Mary Jubilee","994-7845",bAddress); //new BloodBank("KPH2","Kingston Public",bAddress,"998-7845");
//        /*JDBC Implementation*/
        BloodBankSvcJDBCImpl b = new BloodBankSvcJDBCImpl();
//        /*Hibernate Implementation*/
//        BloodBankSvcHibernateImpl b = new BloodBankSvcHibernateImpl();
        //BloodBankMgr bankMrg = new BloodBankMgr();
//        List<BloodBank> bBankList = new ArrayList(); 

        /**********************************
         *      HOSPITAL INSTANCE 
         * ********************************/
//        HospitalAddress hAddress = new HospitalAddress("1","7 Update Street","Port Maria", "St. St.Mary");
//        Hospital hospital = new Hospital("PM08","Port Update Hospital","994-7412",hAddress); //new BloodBank("KPH2","Kingston Public",bAddress,"998-7845");
//        /*JDBC Implementation*/
//        //HospitalSvcJDBCImpl h = new HospitalSvcJDBCImpl();
//        /*Hibernate Implementation*/
//        HospitalSvcHibernateImpl h = new HospitalSvcHibernateImpl();

    
        
        /*
        *RECEPTIONSIT
        */
//        String[] rAddress = {"Naqti", "Kingston 5", "Naboo"};
        PersonAddress pAddress = new PersonAddress("Roadside District","Islington P.O.","St.Mary");
//        String[] rphone = {"475-879-7845", "147-689-123"}; 
////        //TODO fix Date output format
        Date rdate = new Date(1,1,1);
          
//        Receptionist r = new Receptionist(bBank, "123-456-789", "Howard", "Grant", "howardg@email.com", "Male", rdate, rphone, pAddress);
////        ReceptionistSvcJDBCImpl rnist = new ReceptionistSvcJDBCImpl();
//        ReceptionistMgr recepMgr = new ReceptionistMgr();
        //r.setTrn("123-987-655");
        /**
         * DONOR
         */
        Phone phone = new Phone("575-9874","789-4271");
        Donor donor = new Donor("A-Pos", "147-7852-852", "Darth", "Doe", "email@email.com", "Male", rdate,phone, pAddress);
        /**
             * DONOR MANAGER
             */
            DonorMgr manDonor = new DonorMgr();
        try{
            //b.deleteBloodBank(bBank);
            //bankMrg.addBloodBank(bBank);
           //System.out.println("***TRN"+ donor.getTrn()+"}***");
//            recepMgr.addReceptionist(r, bBank);
              //manDonor.addDonor(donor, bBank);
              
              manDonor.updateDonor(donor);
//              List<Donor> donors = new ArrayList();
//              donors = manDonor.getAllDonor();
//            for (Donor element : donors) {
//                System.out.println(element.toString() + "-->");
//            }
                    //manDonor.deleteDonor(donor);
//                /**
//                 * TEST BLOCK
//                 */
//                 ArrayList al = new ArrayList();
//
//                  // add elements to the array list
//                  al.add("C");
//                  al.add("A");
//                  al.add("E");
//                  al.add("B");
//                  al.add("D");
//                  al.add("F");
//
//                  // Use iterator to display contents of al
//                  System.out.print("Original contents of al: ");
//                  Iterator itr = al.iterator();
//
//                  while(itr.hasNext()) {
//                     Object elements = itr.next();
//                     System.out.print(elements + " ");
//                  }
           
        }
        catch(SQLException ex)
        { 
            System.out.println("Error (PRESENTATION): " + ex.toString() + "...");
        }
        catch (Exception e)
        {
            Logger.getLogger(LifeBlood.class.getName()).log(Level.SEVERE, null, e);
        }



    }
    
}
