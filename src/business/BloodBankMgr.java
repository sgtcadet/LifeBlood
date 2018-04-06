/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import domain.BloodBank;
import java.util.List;
import services.IBloodBankService;

/**
 *
 * @author howar
 */
public class BloodBankMgr extends Manager{
    
    /**
     * business method for adding student
     * @param bloodBank
     * @throws java.lang.Exception
     *  
     */
    //@throws ServiceLoadException
    //@throws SQLException
    
    public void addBloodBank(BloodBank bloodBank) throws Exception
    {
        IBloodBankService bloodBankSvc = (IBloodBankService) this.getService(IBloodBankService.NAME);
        bloodBankSvc.addBloodBank(bloodBank);
    }
    public void upDateBloodBank(BloodBank bloodBank) throws Exception
    {
        IBloodBankService bloodBankSvc = (IBloodBankService) this.getService(IBloodBankService.NAME);
        bloodBankSvc.upDateBloodBank(bloodBank);
    }
    public void deleteBloodBank(BloodBank bloodBank) throws Exception
    {
        IBloodBankService bloodBankSvc = (IBloodBankService) this.getService(IBloodBankService.NAME);
        bloodBankSvc.deleteBloodBank(bloodBank);
    }
    public List<BloodBank> getAllBloodBank() throws Exception
    {
        IBloodBankService bloodBankSvc = (IBloodBankService) this.getService(IBloodBankService.NAME);
        return bloodBankSvc.getAllBloodBank();
    }
}
