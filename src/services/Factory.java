/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author howar
 */
package services;

import java.io.FileInputStream;
import java.util.Properties;
import services.exceptions.ServiceLoadException;

public class Factory 
{
  public Factory(){}//constructor
  
  
  
  public IService getService(String serviceName) throws ServiceLoadException
    {
	try 
	{
	   Class <?> c = Class.forName(getImplName(serviceName));
	   return (IService)c.newInstance();
	} catch (Exception e) 
	{
	   throw new ServiceLoadException(serviceName + "not loaded: "+e.toString());
	}
    }

 
    private String getImplName (String serviceName) throws Exception
    {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("config/properties.txt");
        props.load(fis);
        fis.close();
        return props.getProperty(serviceName);
    }//--------------------
}