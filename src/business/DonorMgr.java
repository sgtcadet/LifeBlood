/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import domain.BloodBank;
import domain.Donor;
import java.util.List;
import services.IDonorService;

/**
 *
 * @author howar
 */
public class DonorMgr extends Manager{
    public void addDonor(Donor donor, BloodBank bloodBank) throws Exception
    {
        IDonorService donorSvc = (IDonorService) this.getService(IDonorService.NAME);
        donorSvc.addDonor(donor, bloodBank);
    }
    
    public void updateDonor (Donor donor) throws Exception
    {
        IDonorService donorSvc = (IDonorService) this.getService(IDonorService.NAME);
        donorSvc.updateDonor(donor);
    }
    
    public List<Donor> getAllDonor() throws Exception
    {
        IDonorService donorSvc = (IDonorService) this.getService(IDonorService.NAME);
        return donorSvc.getAllDonor();
    }
    
    public void deleteDonor(Donor donor) throws Exception
    {
        IDonorService donorSvc = (IDonorService) this.getService(IDonorService.NAME);
        donorSvc.deleteDonor(donor);
    }
}
