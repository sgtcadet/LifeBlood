/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Address;
import domain.BloodBank;
import domain.BloodBankAddress;
import domain.Donor;
import domain.Hospital;
import domain.HospitalAddress;
import domain.Person;
//import domain.Receptionist;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author howar
 */
public abstract class HibernateBaseConfiguration {
    private static final Configuration CONFIG = new Configuration(); //Used to read in the Hibernate configuration
    //private static final Configuration CONFIG = new Configuration(); 
    private static SessionFactory sessionFactory = null; //A factory for acquiring Hibernate Sessions
    
     
    /**gets session for Hibernate
     * 
     * @return SessionFactory
     * @throws HibernateException 
     */
    private static SessionFactory getSessionFactory () throws HibernateException
    {
        if(sessionFactory == null)
        {
            try
            {
                //Configure hibernate using xml file
                CONFIG.configure("hibernate.cfg.xml");
                
                //add annotated classes
                //CONFIG.addAnnotatedClass(Person.class);
                CONFIG.addAnnotatedClass(BloodBank.class);
                CONFIG.addAnnotatedClass(BloodBankAddress.class);
                //CONFIG.addAnnotatedClass(Hospital.class);
                //CONFIG.addAnnotatedClass(HospitalAddress.class);
//                CONFIG.addAnnotatedClass(Donor.class);
//                CONFIG.addAnnotatedClass(Receptionist.class);
//                CONFIG.addAnnotatedClass(Address.class);         
                
                
                //build the sessionFactory
                sessionFactory = CONFIG.buildSessionFactory();
                
            }catch(HibernateException ex){ throw new HibernateException("Unable to configure session"+ex.toString());}
            
        }
        return sessionFactory;
    }
    
    /** utility method for getting session factory
     * 
     * @return 
     */
    protected static Session getSession()throws HibernateException
    {
        sessionFactory = getSessionFactory(); 
        
        return (sessionFactory != null) ? sessionFactory.openSession() : null; //opens & retuns the session
    }
    
    protected static void closeSession() throws HibernateException
    {
        sessionFactory.close();
        //StandardServiceRegistryBuilder.destroy(sessionFactory.getSessionFactoryOptions().getServiceRegistry());
    }
}
