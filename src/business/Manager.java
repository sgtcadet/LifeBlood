/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import services.Factory;
import services.IService;
import services.exceptions.ServiceLoadException;

/**
 *
 * @author howar
 */
public class Manager {
    
    private Factory factory = new Factory();
    
    protected IService getService(String serviceName) throws ServiceLoadException {
        return factory.getService(serviceName);
    }
}
