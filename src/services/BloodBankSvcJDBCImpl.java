/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Address;
import domain.BloodBank;
import domain.BloodBankAddress;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author howar
 */
public class BloodBankSvcJDBCImpl extends ConnectionManager implements IBloodBankService{

    @Override
    public void addBloodBank(BloodBank bloodBank) throws SQLException {
        
        //TODO Review blood, bloodbank and bloodbank has blood relationship
        try{
            //conntecting to database
            this.connectToDatabase();
            
            //check query string
            String check_sql = "SELECT `idblood_bank` FROM `blood_bank` WHERE idblood_bank = ?";
            
            //prepaered statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(check_sql);
            
            //setting parems for statement
            pstmt.setString(1, bloodBank.getId());
            
            //result set to store result of the query when executed
            ResultSet rset = pstmt.executeQuery();
            
            //Stores the boolean value of what was reurned from the query execution 
            Boolean result = rset.next();
            
            if(result == true) //if this is true the object is already stored in the database
            {
                //notify user that the object is already in the database
                System.out.println("Error: " + bloodBank.getName() + " already exists!!");
            }//else no result was found add this object to the database
            else
            {
                //COMPLETED (2) Add allowMultiQueries=true to database string inorder to support multiple querys;
                //THOUGHTS (2) could this pose a security threat
//                String insertSQL = "INSERT INTO `blood_bank` (`idblood_bank`, `name`, `phone` ) VALUES(?,?,?);"
//                        + "INSERT INTO `blood_bank_address` (`blood_bank_idblood_bank`,`street`, `address_line_1`, `address_line_2`) VALUES (?,?,?,?)";
                 String insertSQL = "INSERT INTO `blood_bank_address` (`address_id`,`street`, `address_line_1`, `address_line_2`) VALUES (?,?,?,?);"
                         + "INSERT INTO `blood_bank` (`idblood_bank`, `name`, `phone`,`address_id` ) VALUES(?,?,?,?);"
                         ;
                //prepared statement
                PreparedStatement pstmtInsert = this.getConnection().prepareStatement(insertSQL);
                
                
                pstmtInsert.setString(1, bloodBank.getBloodBankAddress().getAddressId());
                pstmtInsert.setString(2, bloodBank.getBloodBankAddress().getStreet());
                pstmtInsert.setString(3, bloodBank.getBloodBankAddress().getAddressLine1());
                pstmtInsert.setString(4, bloodBank.getBloodBankAddress().getAddressLine2());
                pstmtInsert.setString(5, bloodBank.getId());
                pstmtInsert.setString(6, bloodBank.getName());
                pstmtInsert.setString(7, bloodBank.getNumber());
                pstmtInsert.setString(8, bloodBank.getBloodBankAddress().getAddressId());
                
                //Execute the sql statement
                pstmtInsert.executeUpdate();
                
                //Notifying users
                System.out.println(bloodBank.getName() + " => Blood Bank added!!");
                
            }
        }
        catch( SQLException ex)
        {
            throw new SQLException("Error: " + ex.toString() + "...");
        }finally{ close();}
    }

    @Override
    public void upDateBloodBank(BloodBank bloodBank) throws SQLException {
        try
        {
            //Connecting to database
            this.connectToDatabase();
            
            String checkSQL     = "SELECT `idblood_bank` FROM `blood_bank` WHERE `idblood_bank` = ? ;";
//            String updateSQL    = "UPDATE `blood_bank` SET `name` = ?, `phone` = ? WHERE `idblood_bank` = ? ;"
//                                + "UPDATE `blood_bank_address` SET `street` = ?, `address_line_1` = ?, `address_line_2` = ? WHERE `blood_bank_idblood_bank` = ?";
            String updateSQL    = "UPDATE `blood_bank` SET `name` = ?, `phone` = ? WHERE `idblood_bank` = ? ;"
                                + "UPDATE `blood_bank_address` SET `street` = ?, `address_line_1` = ?, `address_line_2` = ? WHERE `address_id` = ?";
            //preparing statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(checkSQL);
            
            //setting parms for check prepared statement
            pstmt.setString(1, bloodBank.getId());
            
            //result of query execution
            ResultSet rset = pstmt.executeQuery();
            
            //boolean value of query
            Boolean result = rset.next();
            
            if(!result) //if there was no result
            {
                System.out.println("Error: " + bloodBank.getId()+ " doesnt exists!");
            }
            else
            {
                PreparedStatement updatePstmt = this.getConnection().prepareStatement(updateSQL);
                
                updatePstmt.setString(1,bloodBank.getName());
                updatePstmt.setString(2,bloodBank.getNumber());
                updatePstmt.setString(3,bloodBank.getId()); 
                
                //address
                updatePstmt.setString(4,bloodBank.getBloodBankAddress().getStreet());
                updatePstmt.setString(5,bloodBank.getBloodBankAddress().getAddressLine1());
                updatePstmt.setString(6,bloodBank.getBloodBankAddress().getAddressLine2());
                updatePstmt.setString(7,bloodBank.getBloodBankAddress().getAddressId());
                
                updatePstmt.executeUpdate();
                
                System.out.println(bloodBank.getName() + " Bank updated!!");
            }
            
        }catch(SQLException ex){System.out.println("Error: " + bloodBank.getName() + " update error!!\n log: " + ex.toString());}finally{close();}
    }
    //TODO : display list
    @Override
    public List<BloodBank> getAllBloodBank() throws SQLException {
        List<BloodBank> displayList = new ArrayList();
        try
        {
            this.connectToDatabase();
            
            Statement stmt = this.getConnection().createStatement();
            //sql query
            String selectSql = "SELECT * FROM `blood_bank`;"
                                + "SELECT * FROM `blood_bank_address`;";
                                //set join string here
            ResultSet rs = stmt.executeQuery(selectSql);
            
            boolean result = rs.next();
            
            if(result == false)
            {
                System.out.println("Empty!!\n");
            }
            else
            {
                while(rs.next())
                {
                    BloodBank bloodBank = new BloodBank();
                    
                    bloodBank.setId(rs.getString("idblood_bank"));
                    bloodBank.setName(rs.getString("name"));
                    bloodBank.setNumber(rs.getString("phone"));
                    //bloodBank.getBloodBankAddress().setAddressId(rs.getString("address_id"));
                    
                    displayList.add(bloodBank);
                }
                System.out.println("Success!!!");
                //return displayList;
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Error: " + ex.toString() + " could not retreive list");
        }
        finally{
            close();
        }
        return displayList;
    }
    @Override
    public void deleteBloodBank(BloodBank bloodBank) throws SQLException {
        try
        {
            //connecting to Database
            this.connectToDatabase();
            
            //SQL query
            String checkSQL = "SELECT `idblood_bank` from `blood_bank` WHERE `idblood_bank`= ?";
            
            //prepared statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(checkSQL);
            
            //setting parems for query
            pstmt.setString(1,bloodBank.getId());
            //resultset to store result of query
            ResultSet rset = pstmt.executeQuery();
            
            //boolean value of the result
            Boolean result = rset.next();
            
            if(!result) // if no result was found the in the database
            {
                System.out.println("Error: No result found in the database!!");
            }
            else
            { //Delete 
                String deleteQuery = "DELETE  FROM `blood_bank` WHERE `idblood_bank` = ?;"
                                    + "DELETE  FROM `blood_bank_address` WHERE `address_id` = ? ;" ;
                
                //prepared statment
                PreparedStatement delPstmt = this.getConnection().prepareStatement(deleteQuery);
                //setting preparedStatement params
                delPstmt.setString(1,bloodBank.getId());
                delPstmt.setString(2,bloodBank.getBloodBankAddress().getAddressId());
                //executing statement
                delPstmt.executeUpdate();
                System.out.println(bloodBank.getName() + " Blood Bank deleted!!");
            }
            
        }catch(SQLException ex){System.out.println("Error: " + ex.toString() + ", could not delete Blood Bank!");}finally{close();}
    }
    
}
