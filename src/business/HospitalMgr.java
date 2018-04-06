/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import domain.Hospital;
import java.util.List;
import services.IHospitalService;

/**
 *
 * @author howar
 */
public class HospitalMgr extends Manager{
    
    public void addHospital(Hospital hospital) throws Exception{
        IHospitalService bloodBankSvc = (IHospitalService) this.getService(IHospitalService.NAME);
        bloodBankSvc.addHospital(hospital);
    }
    
    public void updateHospital(Hospital hospital)throws Exception{
        IHospitalService bloodBankSvc = (IHospitalService) this.getService(IHospitalService.NAME);
        bloodBankSvc.updateHospital(hospital);
    }
    
    public List<Hospital> getAllHospital() throws Exception{
        IHospitalService hospitalSvc = (IHospitalService) this.getService(IHospitalService.NAME);
        return hospitalSvc.getAllHospital();
    }
    
    public void deleteHospital(Hospital hospital) throws Exception{
        IHospitalService bloodBankSvc = (IHospitalService) this.getService(IHospitalService.NAME);
        bloodBankSvc.deleteHospital(hospital);
    }
}
