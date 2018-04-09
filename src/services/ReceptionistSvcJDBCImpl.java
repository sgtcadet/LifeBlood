/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.BloodBank;
import domain.PersonAddress;
import domain.Receptionist;
import java.sql.Date;
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
public class ReceptionistSvcJDBCImpl extends ConnectionManager implements IReceptionistService{

    @Override
    public void addReceptionist(Receptionist receptionist, BloodBank bloodBank) throws SQLException {
        try{
            //conntecting to database
            this.connectToDatabase();
            
           
                //Check if person donated already
                String checkSql = "SELECT `trn` FROM `receptionist` WHERE `trn` = ? ";
                
                //prepaered statement
                PreparedStatement checkPstmt = this.getConnection().prepareStatement(checkSql);
                
                //setting parems for statement
                checkPstmt.setString(1, receptionist.getTrn());
                
                //result set to store result of the query when executed
                ResultSet checkRset = checkPstmt.executeQuery();
                
                
                //Stores the boolean value of what was reurned from the query execution 
                Boolean checkResult = checkRset.next();
                
                if(checkResult == true) //if user already a receptionist deny
                {
                
                    System.out.println(receptionist.getFirstname() + " " + receptionist.getLastname() + " already a receptionist");
                }
                else
                { //else if user hasnt already donated, add their personal data to the person table and allow them to donate
//                    String newPersonSQL = "INSERT INTO `receptionist` (`trn`,`firstname`,`lastname`,`email`,`gender`,`dob`,`blood_bank_idblood_bank`) VALUES (?,?,?,?,?,?,?);"
//                            + "INSERT INTO `address` (`trn`,`street`, `address_line_1`, `address_line_2`) VALUES (?,?,?,?);"
//                            + "INSERT INTO `phone` (`trn`,`phone_number_1`,`phone_number_2`) VALUES (?,?,?);";
                  String newPersonSQL ="INSERT INTO `address` (`street`, `address_line_1`, `address_line_2`) VALUES (?,?,?);"
                            + "INSERT INTO `phone` (`phone_number_1`,`phone_number_2`) VALUES (?,?);"
                          +"INSERT INTO `receptionist` (`trn`,`firstname`,`lastname`,`email`,`gender`,`dob`,`blood_bank_idblood_bank`) VALUES (?,?,?,?,?,?,?);";         
                    
//                    //prepared statement
//                    PreparedStatement pstmtNewInsert = this.getConnection().prepareStatement(newPersonSQL);
//                    
//                    pstmtNewInsert.setString(1, receptionist.getAddress().getStreet());   //street
//                    pstmtNewInsert.setString(2, receptionist.getAddress().getAddressLine1());   //address line 1
//                    pstmtNewInsert.setString(3, receptionist.getAddress().getAddressLine2());
//                    
//                    String [] phone = receptionist.getNumber();
//                    pstmtNewInsert.setString(4, phone[0]);   //phone 1
//                    pstmtNewInsert.setString(5, phone[1]);   //phone 2
//                    
//                    
//                    //Setting params
//                    pstmtNewInsert.setString(6,receptionist.getTrn());
//                    pstmtNewInsert.setString(7, receptionist.getFirstname());
//                    pstmtNewInsert.setString(8, receptionist.getLastname());
//                    pstmtNewInsert.setString(9, receptionist.getEmail());
//                    pstmtNewInsert.setString(10, receptionist.getGender());
//                    pstmtNewInsert.setDate(11, (Date) receptionist.getDob());
//                    pstmtNewInsert.setString(12, bloodBank.getId());
//                    
//                    
//                    //address INSERT PARAMS
//                    //pstmtNewInsert.setString(8, receptionist.getTrn());
//                       //address line 2
//                    
//                    //phone INSERT PARAMS
//                    //pstmtNewInsert.setString(12, receptionist.getTrn());
//                    
// 
//                    pstmtNewInsert.executeUpdate();
//                    
//                    System.out.println(receptionist.getFirstname() + " " + receptionist.getLastname() + " => Receptionist added!!");
                }
            //}
        }
        catch( SQLException ex)
        {
            throw new SQLException("Error: " + ex.toString() + "...");
        }finally{ close();}
    }

    @Override
    public void updateReceptionist(Receptionist receptionist) throws SQLException {
        try
        {
            //Connecting to database
            this.connectToDatabase();
            
            String checkSQL     = "SELECT `trn` FROM `receptionist` WHERE `trn` = ? ;";
            String updateSQL    = "UPDATE `receptionist` SET `firstname` = ?,`lastname` = ? ,`email` = ?,`gender` = ?,`dob` =? WHERE `trn` = ?;"
                    + "UPDATE `address` SET `street` = ? , `address_line_1` = ?, `address_line_2`= ? WHERE `trn` = ?;"
                    + "UPDATE `phone` SET  `phone_number_1` = ?,`phone_number_2` = ? WHERE `trn` = ?;";
                                
            
            //preparing statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(checkSQL);
            
            //setting parms for check prepared statement
            pstmt.setString(1, receptionist.getTrn());
            
            //result of query execution
            ResultSet rset = pstmt.executeQuery();
            
            //boolean value of query
            Boolean result = rset.next();
            
            if(!result) //if there was no result
            {
                System.out.println("Error: " + receptionist.getFirstname()+ " doesnt exists!");
            }
            else
            {
                PreparedStatement updatePstmt = this.getConnection().prepareStatement(updateSQL);
                
                    //person
                    updatePstmt.setString(1, receptionist.getFirstname());
                    updatePstmt.setString(2, receptionist.getLastname());
                    updatePstmt.setString(3, receptionist.getEmail());
                    updatePstmt.setString(4, receptionist.getGender());
                    updatePstmt.setDate(5, (Date) receptionist.getDob());
                    updatePstmt.setString(6, receptionist.getTrn());
                    
                    //person address
                    
                    //address
//                    String [] address = receptionist.getAddress();
//                    updatePstmt.setString(7, address[0]);   //street
//                    updatePstmt.setString(8, address[1]);   //address line 1
//                    updatePstmt.setString(9, address[2]);   //address line 2
                    updatePstmt.setString(9, receptionist.getAddress().getStreet());   //street
                    updatePstmt.setString(10, receptionist.getAddress().getAddressLine1());   //address line 1
                    updatePstmt.setString(11, receptionist.getAddress().getAddressLine2());   //address line 2
                    updatePstmt.setString(10, receptionist.getTrn());
                    
                    
                    //phone
//                    String [] phone = receptionist.getNumber();
//                    updatePstmt.setString(11, phone[0]);   //phone 1
//                    updatePstmt.setString(12, phone[1]);   //phone 2
//                    updatePstmt.setString(13, receptionist.getTrn());
//                    
                    
                updatePstmt.executeUpdate();
                
                System.out.println(receptionist.getFirstname()+ " Receptionist updated!!");
            }
            
        }catch(SQLException ex){System.out.println("Error: " + receptionist.getFirstname()+ " update error!!\n log: " + ex.toString());}finally{close();}
    }

    @Override
    public List<Receptionist> listAllReceptionist() throws SQLException {
        List<Receptionist> displayList = new ArrayList();
        try
        {
            this.connectToDatabase();
            
            Statement stmt = this.getConnection().createStatement();
            //sql query
            String selectSql = "SELECT * FROM `receptionist`;";
                    //+ "SELECT * FROM `address` WHERE trn";
                                //+ "SELECT * FROM `blood_bank_address`;";
                                //TODO Modify here
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
                    Receptionist receptionist = new Receptionist();
                    
//                    receptionist.getTrn();
//                    receptionist.getFirstname();
//                    receptionist.getLastname();
//                    receptionist.getNumber();
//                    receptionist.getAddress();
//                    
                    displayList.add(receptionist);
                }
                System.out.println("Success!!!");
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
    public void deleteReceptionist(Receptionist receptionist) throws SQLException {
        try
        { //TODO Test this method
            //connecting to Database
            this.connectToDatabase();
            
            //SQL query
            String checkSQL = "SELECT `trn` from `receptionist` WHERE `trn`= ?";
            
            //prepared statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(checkSQL);
            
            //setting parems for query
            pstmt.setString(1,receptionist.getTrn());
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
                String deleteQuery = "DELETE FROM `receptionist` WHERE `trn` = ?;"
                        + "DELETE FROM `address` WHERE `trn` = ?;"
                        + "DELETE FROM `phone` WHERE `trn`= ?;";
                                    
                
                //prepared statment
                PreparedStatement delPstmt = this.getConnection().prepareStatement(deleteQuery);
                
                //setting preparedStatement params
                delPstmt.setString(1,receptionist.getTrn());
                delPstmt.setString(2,receptionist.getTrn());
                delPstmt.setString(3,receptionist.getTrn());
         
                
                
                //executing statement
                delPstmt.executeUpdate();
                
                System.out.println(receptionist.getFirstname()+ " receptionist deleted!!");
            }
            
        }catch(SQLException ex){System.out.println("Error: " + ex.toString() + ", could not delete!");}finally{close();}
    }
    
}
