/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifeblood;

import domain.BloodBank;
import domain.Donor;
import domain.Hospital;
import java.sql.Date;
import java.sql.SQLException;
//import java.util.Date;
import services.HospitalSvcJDBCImpl;
import services.BloodBankSvcJDBCImpl;
import services.DonorSvcJDBCImpl;

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
        
        
        /*HOSPITAL*/
        String[] address = new String[3];
        address[0] = "Roadside District";
        address[1] = "Islington P,O";
        address[2] = "St.Mary";
        Hospital h = new Hospital("SM01","St. Mary Hospital",address,"994-8579");
        HospitalSvcJDBCImpl hImp = new HospitalSvcJDBCImpl();
        
        //Blood bank
        String[] bAddress = {"86 Wickham Ave", "Kingston 5", "St. Andrew"};
        BloodBank bBank = new BloodBank("KN03","Newell Jr",bAddress,"998-7845");
        BloodBankSvcJDBCImpl b = new BloodBankSvcJDBCImpl();
         
        //Donor
        String[] phone = {"123-232-2312", "876-582-6714"}; 
        //TODO fix Date output format
        Date date = new Date(95,12,03);
        Donor d = new Donor("123-234-232","Lucien", "Grant","Lucien@email.com", "Male", date, phone, address);
        DonorSvcJDBCImpl dr = new DonorSvcJDBCImpl();
        try{
            
            /*HOSPITAL TEST*/
            
                //hImp.addHospital(h);
                //hImp.updateHospital(h);
                //hImp.getAllHospital();
                //hImp.deleteHospital(h);
            
            /*BlOOD BANK TEST*/
                //b.addBloodBank(bBank);
                //b.upDateBloodBank(bBank);
                //b.getAllBloodBank();
                //b.deleteHospital(bBank);
                
            /*DONOR*/
            //dr.addDonor(d, bBank);
            //dr.updateDonor(d);
            //dr.getAllDonor();
            dr.deleteDonor(d);
        }catch(SQLException ex){ System.out.println("Error adding hospital: " + ex.toString() + "...");}



    }
    
}
