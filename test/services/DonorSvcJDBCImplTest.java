/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.BloodBank;
import domain.BloodBankAddress;
import domain.Donor;
import domain.PersonAddress;
import domain.Phone;
import java.sql.Date;
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
public class DonorSvcJDBCImplTest {
    BloodBankAddress bAddress = new BloodBankAddress("21","8 Street name","Kingston", "St. Andrew");
    BloodBank bBank = new BloodBank("KPH7","Jubilee","994-7845",bAddress);
    Phone phone = new Phone("575-310","459-0414");
    Date rdate = new Date(1,1,1);
    PersonAddress pAddress = new PersonAddress("bloodBankInstance();\n" +
"Roadside District","Islington P.O.","St.Mary");
    Donor donor = new Donor("o-Pos", "114-168-852", "Howard", "Grant", "hgrant@email.com", "Male", rdate,phone, pAddress);
    DonorSvcJDBCImpl instance = new DonorSvcJDBCImpl();
    BloodBankSvcJDBCImpl bloodBankInstance = new BloodBankSvcJDBCImpl();
    public DonorSvcJDBCImplTest() {
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
     * Test of addDonor method, of class DonorSvcJDBCImpl.
     */
    @Test
    public void AtestAddDonor() throws Exception {
        System.out.println("addDonor");
//        Donor donor = null;
//        BloodBank bloodBank = null;
//        DonorSvcJDBCImpl instance = new DonorSvcJDBCImpl();
//        instance.addDonor(donor, bloodBank);
        try{
            bloodBankInstance.addBloodBank(bBank);
            instance.addDonor(donor, bBank);
        }catch(Exception e){ fail("The test because of " + e.toString());}
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updateDonor method, of class DonorSvcJDBCImpl.
     */
    @Test
    public void BtestUpdateDonor() throws Exception {
//        System.out.println("updateDonor");
//        Donor donor = null;
//        DonorSvcJDBCImpl instance = new DonorSvcJDBCImpl();
//        instance.updateDonor(donor);
        try{
            donor.setFirstname("Firstname updated");
            donor.setLastname("Lastname updated");
            donor.getAddress().setStreet("Street Updated");
            donor.getPhone().setPhone1("123-456");
            instance.updateDonor(donor);
            // TODO review the generated test code and remove the default call to fail.
            
        }catch (Exception e){fail("The test because of " + e.toString());}
    }

    /**
     * Test of getAllDonor method, of class DonorSvcJDBCImpl.
     */
    @Test
    public void CtestGetAllDonor() throws Exception {
        List<Donor> result = null;
        try
        {
            result = instance.getAllDonor();
        }catch(Exception e){fail("The test failed because of:" + e.toString());}
        assertNotNull(result);
    }

    /**
     * Test of deleteDonor method, of class DonorSvcJDBCImpl.
     */
    @Test
    public void DtestDeleteDonor() throws Exception {
//        System.out.println("deleteDonor");
//        Donor donor = null;
//        DonorSvcJDBCImpl instance = new DonorSvcJDBCImpl();
//        instance.deleteDonor(donor);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        try
        {
            donor.setTrn("114-168-852");
            instance.deleteDonor(donor);
            bloodBankInstance.deleteBloodBank(bBank);
        }catch(Exception e){ fail("The test failed because: " + e.toString());}
    }
    
}
