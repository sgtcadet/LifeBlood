/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.Hibernate;

import domain.Hospital;
import domain.HospitalAddress;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author howar
 */
//public class HospitalSvcHibernateImplTest {
//    Hospital hospital = new Hospital();
//    HospitalAddress address = new HospitalAddress();
//    HospitalSvcHibernateImpl instance = new HospitalSvcHibernateImpl();
//    public HospitalSvcHibernateImplTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of addHospital method, of class HospitalSvcHibernateImpl.
//     */
//    @Test
//    public void testAddHospital() throws Exception {
//        System.out.println("addHospital");
////        Hospital hospital = null;
////        HospitalSvcHibernateImpl instance = new HospitalSvcHibernateImpl();
////        instance.addHospital(hospital);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//        try{
//        address.setAddressId("7");
//        address.setStreet("Hospital Street");
//        address.setAddressLine1("Address Line 1");
//        address.setAddressLine2("Address Line 2");
//        hospital.setHospitalId("abc");
//        hospital.setName("Hospital Name");
//        hospital.setPhone("1234567");
//        hospital.setAddress(address);
//        instance.addHospital(hospital);
//        }catch(Exception e){ fail("The test case because of: " + e.toString());}
//    }
//
//    /**
//     * Test of updateHospital method, of class HospitalSvcHibernateImpl.
//     */
//    @Test
//    public void testUpdateHospital() throws Exception {
//        System.out.println("updateHospital");
////        Hospital hospital = null;
////        HospitalSvcHibernateImpl instance = new HospitalSvcHibernateImpl();
////        instance.updateHospital(hospital);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//         try{
//            address.setAddressId("7");
//            address.setStreet("Hospital up Street");
//            address.setAddressLine1("Address up Line 1");
//            address.setAddressLine2("Address up Line 2");
//            hospital.setHospitalId("abc");
//            hospital.setName("Hospital Updated Name");
//            hospital.setPhone("741852963");
//            hospital.setAddress(address);
//            instance.updateHospital(hospital);
//        }catch(Exception e){ fail("The test case because of: " + e.toString());}
//    }
//
//    /**
//     * Test of getAllHospital method, of class HospitalSvcHibernateImpl.
//     */
//    @Test
//    public void testGetAllHospital() throws Exception {
//        System.out.println("getAllHospital");
////        HospitalSvcHibernateImpl instance = new HospitalSvcHibernateImpl();
////        List<Hospital> expResult = null;
////        List<Hospital> result = instance.getAllHospital();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//        List<Hospital> result = null;
//        try
//        {
//            result = instance.getAllHospital();
//        }catch(Exception e){fail("The test failed because of:" + e.toString());}
//        assertNotNull(result);
//    }
//
//    /**
//     * Test of deleteHospital method, of class HospitalSvcHibernateImpl.
//     */
//    @Test
//    public void testDeleteHospital() throws Exception {
//        System.out.println("deleteHospital");
////        Hospital hospital = null;
////        HospitalSvcHibernateImpl instance = new HospitalSvcHibernateImpl();
////        instance.deleteHospital(hospital);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//try{
//        address.setAddressId("7");
////        address.setStreet("Hospital Street");
////        address.setAddressLine1("Address Line 1");
////        address.setAddressLine2("Address Line 2");
//        hospital.setHospitalId("abc");
////        hospital.setName("Hospital Name");
////        hospital.setPhone("1234567");
//        hospital.setAddress(address);
//        instance.deleteHospital(hospital);
//        }catch(Exception e){ fail("The test case because of: " + e.toString());}
//    }
//    
//}
