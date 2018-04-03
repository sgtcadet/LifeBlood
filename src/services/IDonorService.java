/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.BloodBank;
import domain.Donor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author howar
 */
public interface IDonorService extends IService
{
    public final String NAME = "IDonorService";
    
    public void addDonor(Donor donor, BloodBank bloodBank) throws Exception;
    
    public void updateDonor(Donor donor) throws Exception;
    
    public List<Donor> getAllDonor() throws Exception;
    
    public void deleteDonor(Donor donor) throws Exception;
    
}
