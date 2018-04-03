/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.BloodBank;
import domain.BloodBankAddress;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author howar
 */
public interface IBloodBankService extends IService
{
    
    public final String NAME = "IBloodBankService";
    
    public void addBloodBank(BloodBank bloodBank) throws SQLException;
    
    public void addBloodBank(BloodBankAddress bloodBank) throws SQLException;
    
    public void upDateBloodBank(BloodBank bloodBank) throws SQLException;
    
    public List<BloodBank> getAllBloodBank() throws SQLException;
    
    public void deleteBloodBank(BloodBank bloodBank) throws SQLException;
}
