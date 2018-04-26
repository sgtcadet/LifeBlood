/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Login;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;


/**
 * @author 
 */
public class AuthenticationSvcSocketImpl implements IAuthenticationSvc
{
    
      private ObjectOutputStream output; // output stream to server
      private ObjectInputStream input; // input stream from server
      private Socket client; // socket to communicate with server

      //class logger
      static private Logger logger = Logger.getLogger(AuthenticationSvcSocketImpl.class);

   
    @Override
    public Boolean sendCredentials(Login login) throws  Exception
    {
         logger.info("Attempting to send object to server");
         
         Boolean valid =false;      
         if(client==null)connectToServer();         
         if(client.isConnected()==false)connectToServer();
                 
                      
        try
        {
                      
          output.writeObject( login );//sends object to server 
          
          output.flush(); // flush data to output 
          
          logger.info("object sent to server");
          
        valid = ( Boolean ) input.readObject(); // read new message
          
          logger.info("object received from server");
          
          System.out.println("This was returend from server: " +valid);
          
        }
        catch(IOException e)
        {
            logger.warn("IOException throw "+ e);
            throw new IOException("Error communicating with server "+e);
            
        }
        catch(ClassNotFoundException e)
        {
            logger.warn("ClassNotFoundException throw "+ e);
            throw new ClassNotFoundException("Unknown Object Type "+e);
        }
        
        return valid;
        
    }
  
    
   /**utility method for connecting to server
     * 
     * @throws UnknownHostException
     * @throws IOException 
     */
   private void connectToServer() throws UnknownHostException, IOException
    {
        logger.info("attempting to connect to server");
        
        try
        {
         // create Socket to make connection to server
        client = new Socket(InetAddress.getLocalHost(), 8000 );
        
        logger.info("connection sucessful");
        
        logger.info("inatilizing streams");
        
        // set up input stream for objects
        input = new ObjectInputStream( client.getInputStream() );       
        
        // set up output stream for objects
        output = new ObjectOutputStream( client.getOutputStream() );  
        
        output.flush(); // flush output buffer to send header information
        
        logger.info("connection successfully closed");        
        
        }
        catch(UnknownHostException e)
        {
             logger.info("Host Unknown"+e);
            throw new UnknownHostException("Unknown Host Address "+e);
            
        }
        catch(IOException e)
        {
             logger.info("Error Connecting to server "+e);
            throw new IOException("Error Connecting to server "+e);
            
        }
    }//end of connectToServer()method
     
    
    @Override
    public void closeClientConnection() throws IOException
    {
        logger.info("attempting to close connection");
        try
        {
        if(output!=null)  output.close(); // close output stream
        if(input!=null)  input.close(); // close input stream       
        if(client!=null) client.close(); // close socket         
        logger.info("connection successfully closed");
        }
         catch(IOException e)
        {
            logger.info("Error Closing Connection "+e);
            throw new IOException("Error Closing Connection "+e);
        }
    }  
}//end of class definition
