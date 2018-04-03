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

    @Override
    public void addBloodBank(BloodBank bloodBank) throws SQLException {
        //logger.info("in the addStudent(Student student) method in "+BloodBankSvcHibernateImpl.class.getName());
        
     if( isDuplicateId(bloodBank.getId())==true)             
           throw new SQLException("That record already exist");
        
       
        
        Session session = BloodBankSvcHibernateImpl.getSession(); //gets the session
        Transaction tranx =null; //transaction object
        
        
        try
        {
          // logger.warn("in try, may cause errors");
             tranx = session.beginTransaction();
             session.save(bloodBank);
             tranx.commit();
        }
        catch(HibernateException e)
        {
            
           
            if(tranx != null) tranx.rollback(); //roll back transation if error occured
             //logger.error("Hibernate insert error"+e.toString()+" in->"+StudentSvcHibernateImpl.class.getName());
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
        // logger.info("updateStudent(Student student) ");
//        if( isDuplicateId(student.getIdNumber())==true)             
//            throw new Exception("That record already exist");       
        Session session = getSession(); //gets the session
        Transaction tranx =null; //transaction object
        
        
        try
        {
           // logger.warn("Entering try may cause errors");
             tranx = session.beginTransaction();
             session.update(bloodBank);
            // session.
             tranx.commit();
        }
        catch(HibernateException e)
        {
            
         //  logger.error("Hibernate exception "+e.toString());
            if(tranx != null) tranx.rollback(); //roll back transation if error occured
            throw new HibernateException("Unable to store blood bank information "+e.toString());         
        }
         
        finally
        {           
            //session.flush();
            //session.close();                  
        }
    }
    @Override
    public List<BloodBank> getAllBloodBank() throws SQLException {
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
            
        }
         
         return bloobBankList;
    }
    @Override
    public void deleteBloodBank(BloodBank bloodBank) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean isDuplicateId(String id) throws HibernateException
    {
       
         
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
        }      
        
        return numDuplicate != 0;       
    }

    /*NEW IMPL*/
    
    @Override
    public void addBloodBank(BloodBankAddress bAddress) throws SQLException {
        //logger.info("in the addStudent(Student student) method in "+BloodBankSvcHibernateImpl.class.getName());
        System.out.println( "<< " + bAddress.getBloodBank().getId() + ">>");
     if( isDuplicateId(bAddress.getBloodBank().getId())==true)
       //if( isDuplicateId(bAddress.getId())==true)
           throw new SQLException("That record already exist");
        
       
        
        Session session = BloodBankSvcHibernateImpl.getSession(); //gets the session
        Transaction tranx =null; //transaction object
        
        
        try
        {
          // logger.warn("in try, may cause errors");
             tranx = session.beginTransaction();
             session.save(bAddress);
             tranx.commit();
        }
        catch(HibernateException e)
        {
            
           
            if(tranx != null) tranx.rollback(); //roll back transation if error occured
             //logger.error("Hibernate insert error"+e.toString()+" in->"+StudentSvcHibernateImpl.class.getName());
            throw new HibernateException("Unable to store blood bank information "+e.toString());         
        } 
        finally{           
           //closeSession();
            session.close();
        }
    }
}
