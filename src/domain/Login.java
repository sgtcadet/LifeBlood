/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;



/**represents a login object
 * 
 * @author
 */
public class Login implements Serializable
{
    String username;   
    String password;
    String group;

    
    
    
    public Login(){}//default constructor
    
     public String getPassword() 
     {
        return password;
     }

    public String getUsername() 
    {
        return username;
    }
    
     public void setPassword(String password) 
     {
        this.password = password;
     }

    public void setUsername(String username) 
    {
        this.username = username;
    }
    
    
       public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    
    
    public Boolean isValid()
    {
        if(this.password.equals("")) return false;
        if(this.username.equals("")) return false;
        if(this.group.equals("")) return false;

        
        return true;
    }
    
    
}
