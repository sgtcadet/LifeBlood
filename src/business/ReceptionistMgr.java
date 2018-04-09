/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import domain.BloodBank;
import domain.Receptionist;
import services.IReceptionistService;

/**
 *
 * @author howar
 */
public class ReceptionistMgr extends Manager{
    /**
     * Business method for adding Receptionist
     * @param receptionist
     * @param bloodBank
     * @throws java.lang.Exception
     * 
     * */
    
    public void addReceptionist(Receptionist receptionist, BloodBank bloodBank) throws Exception
    {
        IReceptionistService receptionistSvc = (IReceptionistService) this.getService(IReceptionistService.NAME);
        receptionistSvc.addReceptionist(receptionist, bloodBank);
    }
    
     
    
}
