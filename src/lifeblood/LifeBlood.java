/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifeblood;

import domain.Address;
import domain.BloodBank;
import domain.BloodBankAddress;
import domain.Donor;
import domain.Hospital;
import domain.Receptionist;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.Date;
import services.HospitalSvcJDBCImpl;
import services.BloodBankSvcJDBCImpl;
import services.DonorSvcJDBCImpl;
import services.Hibernate.BloodBankSvcHibernateImpl;
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
        
        List<BloodBank> bBankList = new ArrayList();
        /*
        *HOSPITAL
        */
//        String[] address = new String[3];
//        address[0] = "Roadside District";
//        address[1] = "Islington P,O";
//        address[2] = "St.Mary";
//        Hospital h = new Hospital("SM01","St. Mary Hospital",address,"994-8579");
//        HospitalSvcJDBCImpl hImp = new HospitalSvcJDBCImpl();
        
        /*
        *BLOOD BANK
        */
        //String[] bAddress = {"7 Spanish Town Road", "Kingston 2", "St. Andrew"};
        BloodBankAddress bAddress = new BloodBankAddress("2","7 Spanish Town Rd","Kingston 2", "St. Andrew");
        BloodBank bBank = new BloodBank("KPH2","Kingston Central","997-1478",bAddress); //new BloodBank("KPH2","Kingston Public",bAddress,"998-7845");
        
        
//        bBank.setId("KPH2");
//        bBank.setName("Kingston Public");
//        bBank.setNumber("998-7845");
//        //bAddress.setId(bBank.getId());
//        //bAddress.setBloodBank(bBank);
////        bAddress.getBloodBank().setId("KPH2");
////        bAddress.getBloodBank().setName("Kingston Public");
////        bAddress.getBloodBank().setNumber("998-7845");
//        //bAddress.setId("KPH2");
//        bAddress.setStreet("7 Spanish Town Road");
//        bAddress.setAddressLine1("Kingston 2");
//        bAddress.setAddressLine2("St. Andrew");
        //bAddress.setBloodBank(bBank);
        
        
       
        //BloodBankSvcJDBCImpl b = new BloodBankSvcJDBCImpl();
        BloodBankSvcHibernateImpl b = new BloodBankSvcHibernateImpl();
         
        /*
        *DONOR
        */
//        String[] phone = {"876-459-0414", "876-582-6714"}; 
//        //TODO fix Date output format
//        Date date = new Date(95,12,03);
//        Donor d = new Donor("123-234-232","Howard", "Grant","Lucien@email.com", "Male", date, phone, address, "A Pos");
//        DonorSvcJDBCImpl dr = new DonorSvcJDBCImpl();
        
        /*
        *RECEPTIONSIT
        */
//        String[] rAddress = {"Naqti", "Kingston 5", "Naboo"};
//        String[] rphone = {"475-879-7845", "147-689-123"}; 
//        //TODO fix Date output format
//        Date rdate = new Date(96,12,03);
//        Receptionist r = new Receptionist("123-234-232","Darth", "Mall","dstar@email.com", "Male", rdate, rphone, rAddress, "O Pos");
//        ReceptionistSvcJDBCImpl rnist = new ReceptionistSvcJDBCImpl();
        try{
            
            /*HOSPITAL TEST*/
            
                //hImp.addHospital(h);
                //hImp.updateHospital(h);
                //hImp.getAllHospital();
                //hImp.deleteHospital(h);
            
            /*BLOOD BANK TEST*/
                //b.addBloodBank(bBank);
                //b.addBloodBank(bAddress);
                //b.upDateBloodBank(bBank);
                  bBankList = b.getAllBloodBank();
                  System.out.println("PRINTING: ");
//                  for(BloodBank bank : bBankList)
//                  {
//                      bank.toString();
//                      //System.out.println("Name: " + bank.getName() + "\nId: " + bank.getId());
//                  }
                Iterator<BloodBank> bBankIter = bBankList.iterator();
        
                while(bBankIter.hasNext())
                { 
                    System.out.println("Printing: " + bBankIter.next().toString());
                    //System.out.println("Name: " + bBankIter.);
                }
                //b.deleteBloodBank(bBank);
                
            /*DONOR*/
            //dr.addDonor(d, bBank);
            //dr.updateDonor(d);
            //dr.getAllDonor();
            //dr.deleteDonor(d);
            
            /*RECEPTIONIST*/
            //rnist.addReceptionist(r, bBank);
            //rnist.updateReceptionist(r);
            //rnist.listAllReceptionist();
            //rnist.deleteReceptionist(r);
        }catch(SQLException ex){ System.out.println("Error (PRESENTATION): " + ex.toString() + "...");}



    }
    
}
