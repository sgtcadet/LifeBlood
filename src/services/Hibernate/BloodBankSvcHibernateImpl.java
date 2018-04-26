/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.Hibernate;

import domain.BloodBank;
import domain.BloodBankAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import services.HibernateBaseConfiguration;
import services.IBloodBankService;

/**
 *
 * @author howar
 */
public class BloodBankSvcHibernateImpl  extends HibernateBaseConfiguration implements IBloodBankService{
    //class logger
    private static Logger logger = Logger.getLogger(BloodBankSvcHibernateImpl.class);
    
   
    @Override
    public void addBloodBank(BloodBank bloodBank) throws SQLException {
//        BasicConfigurator.configure();
        logger.info("in the addBloodBank(BloodBank bloodBank) method in "+BloodBankSvcHibernateImpl.class.getName());
        
        if( isDuplicateId(bloodBank.getId())==true)             
            throw new SQLException("That record already exist");



        Session session = BloodBankSvcHibernateImpl.getSession(); //gets the session
        Transaction tranx = null; //transaction object


        try
        {
           logger.warn("in try, may cause errors");
             tranx = session.beginTransaction();
             session.save(bloodBank);
             tranx.commit();
        }
        catch(HibernateException e)
        {


            if(tranx != null) tranx.rollback(); //roll back transation if error occured
            logger.error("Hibernate insert error"+e.toString()+" in->"+BloodBankSvcHibernateImpl.class.getName());
            throw new HibernateException("Unable to store blood bank information "+e.toString());         
        }
        finally
        {           
           //closeSession();
            session.close();
        }
    }
    @Override
    public void upDateBloodBank(BloodBank bloodBank) throws SQLException {
//        BasicConfigurator.configure();
         logger.info("in the upDateBloodBank(BloodBank bloodBank) methodin "+BloodBankSvcHibernateImpl.class.getName());
//        if( isDuplicateId(student.getIdNumber())==true)             
//            throw new Exception("That record already exist");       
        Session session = getSession(); //gets the session
        Transaction tranx =null; //transaction object
        
        
        try
        {
            logger.warn("Entering try may cause errors");
             tranx = session.beginTransaction();
             session.update(bloodBank);
            // session.
             tranx.commit();
        }
        catch(HibernateException e)
        {
            
           logger.error("Hibernate exception "+e.toString());
            if(tranx != null) tranx.rollback(); //roll back transation if error occured
            throw new HibernateException("Unable to update blood bank information "+e.toString());         
        }
        finally
        {           
            //session.flush();
           session.close();                  
        }
    }
    //COMPLETED : fix list display
    @Override
    public List<BloodBank> getAllBloodBank() throws SQLException {
//        BasicConfigurator.configure();
        logger.info("in the getAllBloodBank() method in "+BloodBankSvcHibernateImpl.class.getName());
         List<BloodBank> bloobBankList = new ArrayList<>();
        
         Session  session = getSession(); //gets the session            
        
         try
        {
              NativeQuery  nativeQuery= session.createNativeQuery("SELECT * FROM blood_bank").addEntity(BloodBank.class); 
              bloobBankList = nativeQuery.list();
             
        }
        catch(Exception e)
        {
          System.out.println("e--"+e.toString());
            throw new HibernateException("Unable to retreive Data"+e.toString());         
        }
        finally
        {  
         // closeSession();
            session.close();     
        }
        return bloobBankList;
    }
    @Override
    public void deleteBloodBank(BloodBank bloodBank) throws SQLException {
//        BasicConfigurator.configure();
        if( isDuplicateId(bloodBank.getId())==true){             
            System.out.println("Found!!");
            
            Session session = BloodBankSvcHibernateImpl.getSession(); //gets the session
            Transaction tranx = null; //transaction object
            
            try{
                tranx = session.beginTransaction();
                
                session.delete(bloodBank);
                
                tranx.commit();
            }catch(HibernateException e){
                if(tranx != null) tranx.rollback(); //roll back transation if error occured
                logger.error("Hibernate insert error"+e.toString()+" in->"+BloodBankSvcHibernateImpl.class.getName());
                throw new HibernateException("Unable to delete blood bank information "+e.toString());
            }finally{session.close();}
        }
        else
        {
            throw new SQLException("That record is not found exist");
        }
    }
    private boolean isDuplicateId(String id) throws HibernateException{
  
         int numDuplicate = 0;//local variable for storing count value returned 
         Session session = getSession(); //gets the session         
             
             
        
         try
        {
              //using SQL query in Hibernate
              NativeQuery  nativeQuery = session.createNativeQuery("SELECT Count(*) AS Duplicates FROM blood_bank WHERE idblood_bank = '" + id + "'"); 
              numDuplicate = Integer.parseInt(nativeQuery.uniqueResult().toString()); //gets the result from query 
        }
        catch(HibernateException e)
        {
            
            throw new HibernateException("Unable to retreive Data"+e);         
        }
         
        finally
        {            
          
         //   closeSession(); 
            session.close();
        }      
        
        return numDuplicate != 0;       
    }

}
