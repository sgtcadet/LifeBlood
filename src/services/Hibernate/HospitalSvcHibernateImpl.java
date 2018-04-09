/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.Hibernate;

import domain.Hospital;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import services.HibernateBaseConfiguration;
import services.IHospitalService;

/**
 *
 * @author howar
 */
public class HospitalSvcHibernateImpl extends HibernateBaseConfiguration implements IHospitalService{
    //class logger
    //private static Logger logger = Logger.getLogger(HospitalSvcHibernateImpl.class);
    @Override
    public void addHospital(Hospital hospital) throws SQLException {
        
        System.out.println("Add Hospital");
        //logger.info("in the addHospital(Hospital hospital) method in "+HospitalSvcHibernateImpl.class.getName());
//        
        if( isDuplicateId(hospital.getHospitalId())==true)             
            throw new SQLException("That record already exist");
        else
            System.out.println("wanna Add Hospital");
//
//
        Session session = HospitalSvcHibernateImpl.getSession(); //gets the session
        Transaction tranx = null; //transaction object
//
//
        try
        {
           //logger.warn("in try, may cause errors");
             tranx = session.beginTransaction();
             session.save(hospital);
             tranx.commit();
        }
        catch(HibernateException e)
        {


            if(tranx != null) tranx.rollback(); //roll back transation if error occured
            //logger.error("Hibernate insert error"+e.toString()+" in->"+HospitalSvcHibernateImpl.class.getName());
            throw new HibernateException("Unable to store hospital information "+e.toString());         
        }
        finally
        {           
           //closeSession();
            session.close();
        }
        
        //TODO(IMPORTANT) HIBERNATE TEST THIS METHOD
    }

    @Override
    public void updateHospital(Hospital hospital) throws SQLException {
//        logger.info("updateHospital(Hospital hospital) ");
////        if( isDuplicateId(student.getIdNumber())==true)             
////            throw new Exception("That record already exist");       
//        Session session = getSession(); //gets the session
//        Transaction tranx =null; //transaction object
//        
//        
//        try
//        {
//            logger.warn("Entering try may cause errors");
//             tranx = session.beginTransaction();
//             session.update(hospital);
//            // session.
//             tranx.commit();
//        }
//        catch(HibernateException e)
//        {
//            
//           logger.error("Hibernate exception "+e.toString());
//            if(tranx != null) tranx.rollback(); //roll back transation if error occured
//            throw new HibernateException("Unable to update hospital information "+e.toString());         
//        }
//        finally
//        {           
//            //session.flush();
//            session.close();                  
//        }
        //TODO (IMPORTANT) HIBERNATE TEST THIS METHOD
    }

    @Override
    public List<Hospital> getAllHospital() throws SQLException {
//        logger.info("getAllHospital() ");
//         List<Hospital> hospitalList = new ArrayList<>();
//        
//         Session  session = getSession(); //gets the session            
//        
//         try
//        {
//              NativeQuery  nativeQuery= session.createNativeQuery("SELECT * FROM hostpital").addEntity(Hospital.class); 
//              hospitalList = nativeQuery.list();
//             
//        }
//        catch(Exception e)
//        {
//          System.out.println("e--"+e.toString());
            throw new HibernateException("Unable to retreive Data: ");//+e.toString());         
//        }
//        finally
//        {  
//         // closeSession();
//            session.close();     
//        }
//        return hospitalList;
        //TODO (IMPORTANT) HIBERNATE TEST THIS METHOD
    }

    @Override
    public void deleteHospital(Hospital hospital) throws SQLException {
//        if( isDuplicateId(hospital.getHospitalId())==true){             
//            System.out.println("Found!!");
//            
//            Session session = HospitalSvcHibernateImpl.getSession(); //gets the session
//            Transaction tranx = null; //transaction object
//            
//            try{
//                tranx = session.beginTransaction();
//                
//                session.delete(hospital);
//                
//                tranx.commit();
//            }catch(HibernateException e){
//                if(tranx != null) tranx.rollback(); //roll back transation if error occured
//                logger.error("Hibernate insert error"+e.toString()+" in->"+HospitalSvcHibernateImpl.class.getName());
//                throw new HibernateException("Unable to delete blood bank information "+e.toString());
//            }finally{session.close();}
//        }
//        else
//        {
//            throw new SQLException("That record is not found exist");
//        }
        //TODO (IMPORTANT) HIBERNATE TEST THIS METHOD
    }
    private boolean isDuplicateId(String id) throws HibernateException{
  
         int numDuplicate = 0;//local variable for storing count value returned 
         Session session = getSession(); //gets the session         
          
        
         try
        {
//            numDuplicate = 0;//local variable for storing count value returned 
//            session = getSession(); //gets the session
              //using SQL query in Hibernate
            NativeQuery  nativeQuery = session.createNativeQuery("SELECT Count(*) AS Duplicates FROM hospital WHERE idhospital = '" + id + "'"); 
            numDuplicate = Integer.parseInt(nativeQuery.uniqueResult().toString()); //gets the result from query 
        }
        catch(HibernateException e)
        {
            
            throw new HibernateException("Unable to retreive Data"+e);         
        }
         
        finally
        {            
          
         //   closeSession(); 
            //session.close();
        }      
        
        return numDuplicate != 0;       
    }
}
