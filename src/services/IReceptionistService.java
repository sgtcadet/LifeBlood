/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Receptionist;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author howar
 */
public interface IReceptionistService extends IService
{
    public final String NAME = "IReceptionistService";
    
    public void addReceptionist(Receptionist receptionist) throws SQLException;
    
    public void updateReceptionist(Receptionist receptionist) throws SQLException;
    
    public List<Receptionist> listAllReceptionist() throws SQLException;
    
    public void deleteReceptionist(Receptionist receptionist) throws SQLException;
    
}
