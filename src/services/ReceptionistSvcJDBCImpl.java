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
public class ReceptionistSvcJDBCImpl extends ConnectionManager implements IReceptionistService{

    @Override
    public void addReceptionist(Receptionist receptionist) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateReceptionist(Receptionist receptionist) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Receptionist> listAllReceptionist() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteReceptionist(Receptionist receptionist) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
