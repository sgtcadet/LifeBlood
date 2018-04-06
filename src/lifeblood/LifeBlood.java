/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifeblood;

import business.BloodBankMgr;
import domain.Address;
import domain.BloodBank;
import domain.BloodBankAddress;
import domain.Donor;
import domain.Hospital;
import domain.HospitalAddress;
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
        /*****************************
        *     BLOOD BANK INSTANCE
        ****************************/
//        BloodBankAddress bAddress = new BloodBankAddress("1","8 Stennette Street","Port Maria", "St. St.Mary");
//        BloodBank bBank = new BloodBank("KPH8","St Mary Jubilee","994-7845",bAddress); //new BloodBank("KPH2","Kingston Public",bAddress,"998-7845");
//        /*JDBC Implementation*/
//        //BloodBankSvcJDBCImpl b = new BloodBankSvcJDBCImpl();
//        /*Hibernate Implementation*/
//        BloodBankSvcHibernateImpl b = new BloodBankSvcHibernateImpl();
//        BloodBankMgr bankMrg = new BloodBankMgr();
//        List<BloodBank> bBankList = new ArrayList(); 

        /**********************************
         *      HOSPITAL INSTANCE 
         * ********************************/
        HospitalAddress hAddress = new HospitalAddress("1","7 Update Street","Port Maria", "St. St.Mary");
        Hospital hospital = new Hospital("PM08","Port Update Hospital","994-7412",hAddress); //new BloodBank("KPH2","Kingston Public",bAddress,"998-7845");
        /*JDBC Implementation*/
        HospitalSvcJDBCImpl h = new HospitalSvcJDBCImpl();
        /*Hibernate Implementation*/
        //BloodBankSvcHibernateImpl b = new BloodBankSvcHibernateImpl();
        //BloodBankMgr bankMrg = new BloodBankMgr();
        //List<BloodBank> bBankList = new ArrayList()
    
        
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
            
            /****************
             * HOSPITAL IMPL
             * */
            //h.addHospital(hospital);
            //h.updateHospital(hospital);
//            List<Hospital> hospitals = new ArrayList();
//            hospitals = h.getAllHospital();
//            
//            Iterator<Hospital> hosItor = hospitals.iterator();
//            while (hosItor.hasNext()){System.out.println(hosItor.next().toString());}
//            for(Hospital hos : hospitals)
//            {
//                System.out.println(hos.toString());
//            }
              h.deleteHospital(hospital);
            /**********************
             * BLOOD BANK TEST
             **********************/
                //bankMrg.addBloodBank(bBank);
                //b.addBloodBank(bBank);
                //bankMrg.upDateBloodBank(bBank);
                  //bBankList = bankMrg.getAllBloodBank();
//                 
//                Iterator<BloodBank> bBankIter = bBankList.iterator();
//        
//                while(bBankIter.hasNext())
//                { 
//                    System.out.println("Printing: " + bBankIter.next().toString());
//                    //System.out.println("Name: " + bBankIter.);
//                }
                //bankMrg.deleteBloodBank(bBank);
                //b.deleteBloodBank(bBank);
            
        }
        catch(SQLException ex)
        { 
            System.out.println("Error (PRESENTATION): " + ex.toString() + "...");
        }catch (Exception e)
        {
            Logger.getLogger(LifeBlood.class.getName()).log(Level.SEVERE, null, e);
        }



    }
    
}
