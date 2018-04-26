/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Login;
import java.io.IOException;
import java.net.UnknownHostException;


/**
 *
 * @author 
 */
public interface IAuthenticationSvc extends IService 
{
    
    
	/**name of IAuthenticationSvc Service, used as a reference for 
	 * Retrieving the service when loading dynamically 
	 * from file*/
	public final String NAME = "IAuthenticationSvc";
        
        
     /**connects to server and and process
         * login actions
         * 
         * @param login
         * @return
         * @throws UnknownHostException
         * @throws IOException
         * @throws ClassNotFoundException
         * @throws InvalidLoginException 
         */   
     public Boolean sendCredentials(Login login) throws Exception;
    
    
     /**closes client connection
      * 
      * @throws IOException 
      */
     public void closeClientConnection() throws IOException;
    
}
