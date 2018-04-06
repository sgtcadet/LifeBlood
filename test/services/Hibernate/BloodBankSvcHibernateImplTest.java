/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.Hibernate;

import domain.BloodBank;
import domain.BloodBankAddress;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author howar
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BloodBankSvcHibernateImplTest {
    BloodBank bloodBank = new BloodBank();
    BloodBankAddress address = new BloodBankAddress();
    BloodBankSvcHibernateImpl instance = new BloodBankSvcHibernateImpl();
    
    public BloodBankSvcHibernateImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addBloodBank method, of class BloodBankSvcHibernateImpl.
     */
    @Test
    public void AtestAddBloodBank() throws Exception {
        System.out.println("addBloodBank");
//        BloodBank bloodBank = null;
//        BloodBankSvcHibernateImpl instance = new BloodBankSvcHibernateImpl();
//        instance.addBloodBank(bloodBank);
        try{
        address.setAddressId("9");
        address.setStreet("Blood Bank Street");
        address.setAddressLine1("Address Line 1");
        address.setAddressLine2("Address Line 2");
        bloodBank.setId("123");
        bloodBank.setName("Blood Bank Name");
        bloodBank.setNumber("1234567");
        bloodBank.setBloodBankAddress(address);
        instance.addBloodBank(bloodBank);
        }catch(Exception e){ fail("The test case because of: " + e.toString());}
        // COMPLETED review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of upDateBloodBank method, of class BloodBankSvcHibernateImpl.
     */
    @Test
    public void BtestUpDateBloodBank() throws Exception {
        System.out.println("upDateBloodBank");
//        BloodBank bloodBank = null;
//        BloodBankSvcHibernateImpl instance = new BloodBankSvcHibernateImpl();
        try{
        address.setAddressId("9");
        address.setStreet("Blood Bank Updated Street");
        address.setAddressLine1("Address Updated Line 1");
        address.setAddressLine2("Address Updated Line 2");
        bloodBank.setId("123");
        bloodBank.setName("Blood Bank Updated Name");
        bloodBank.setNumber("789456123");
        bloodBank.setBloodBankAddress(address);
        instance.upDateBloodBank(bloodBank);
        }catch(Exception e){ fail("The test case because of: " + e.toString());}
        // COMPLETED review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllBloodBank method, of class BloodBankSvcHibernateImpl.
     */
    @Test
    public void CtestGetAllBloodBank() throws Exception {
        System.out.println("getAllBloodBank");
        //BloodBankSvcHibernateImpl instance = new BloodBankSvcHibernateImpl();
//        List<BloodBank> expResult = null;
//        List<BloodBank> result = instance.getAllBloodBank();
//        assertEquals(expResult, result);
        List<BloodBank> result = null;
        try
        {
            result = instance.getAllBloodBank();
        }catch(Exception e){fail("The test failed because of:" + e.toString());}
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deleteBloodBank method, of class BloodBankSvcHibernateImpl.
     */
    @Test
    public void DtestDeleteBloodBank() throws Exception {
        System.out.println("deleteBloodBank");
        try
        {
            bloodBank.setId("123");
            instance.deleteBloodBank(bloodBank);
        }catch(Exception e){ fail("The test failed because: " + e.toString());}
        
        // COMPLETED review the generated test code and remove the default call to fail.
        
    }
    
}
