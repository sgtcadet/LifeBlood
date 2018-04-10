/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.Hibernate;

import domain.BloodBank;
import domain.Donor;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import services.HibernateBaseConfiguration;
import services.IDonorService;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
//import org.apache.log4j.Logger;

/**
 *
 * @author howar
 */
public class DonorSvcHibernateImpl extends HibernateBaseConfiguration implements IDonorService{
    
    //class logger
       private static Logger logger = Logger.getLogger(DonorSvcHibernateImpl.class);
    /**
     * Method for saving donor record to database
     * @param donor
     * @param bloodBank
     * @throws Exception 
     */

    @Override
    public void addDonor(Donor donor, BloodBank bloodBank) throws Exception {
       logger.info("in the addDonor(Donor donor, BloodBank bloodBank)  method in "+DonorSvcHibernateImpl.class.getName());
//        if( isDuplicateId(donor.getTrn())==true)     
//            //TODO add another entry intro theblood_blank_has_blood table with this user data
//           throw new Exception("That record already exist");
        
       
        
        Session session = DonorSvcHibernateImpl.getSession(); //gets the session
        Transaction tranx =null; //transaction object
        
        
        try
        {
           logger.warn("in try, may cause errors");
            
            if( isDuplicateId(donor.getTrn())==true)
            { //if donor exitst, add an entry into the blood_blank_has_blood table
                tranx = session.beginTransaction();
                
                
                session.save(donor);
                
                tranx.commit();
            }
            else{     
            
             tranx = session.beginTransaction();
             session.save(donor);
             
             //THOUGHTS : How will hibernate add donors to the bloodbank_has_blood table?
             // As this method is right now, it only adds a donor to the donor table :$ 
             
             
             tranx.commit();
            }
        }
        catch(HibernateException e)
        {
            
           
            if(tranx != null) tranx.rollback(); //roll back transation if error occured
             logger.error("Hibernate insert error"+e.toString()+" in->"+DonorSvcHibernateImpl.class.getName());
            throw new HibernateException("Unable to store Donor information "+e.toString());         
        }
         
        finally
        {           
           session.close();
        }
    }

    @Override
    public void updateDonor(Donor donor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Donor> getAllDonor() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDonor(Donor donor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean isDuplicateId(String trn) throws HibernateException
    {
       
         
         int numDuplicate = 0;//local variable for storing count value returned 
         Session session = getSession(); //gets the session         
             
             
        
         try
        {
              //using SQL query in Hibernate
              NativeQuery  nativeQuery = session.createNativeQuery("SELECT Count(*) AS Duplicates FROM donor WHERE trn = '" + trn + "'"); 
              numDuplicate = Integer.parseInt(nativeQuery.uniqueResult().toString()); //gets the result from query 
        }
        catch(HibernateException e)
        {
            
            throw new HibernateException("Unable to retreive Data"+e);         
        }
         
        finally
        {            
          
         //   closeSession();                 
        }      
        
        return numDuplicate != 0;       
    }
}
