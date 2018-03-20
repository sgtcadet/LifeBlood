/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Hospital;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author howar
 */
public interface IHospitalService extends IService
{
    
    public final String NAME = "IHospitalService";
    
    public void addHospital(Hospital hospital) throws SQLException;
    
    public void updateHospital(Hospital hospital)throws SQLException;
    
    public List<Hospital> getAllHospital() throws SQLException;
    
    public void deleteHospital(Hospital hospital) throws SQLException;
}
