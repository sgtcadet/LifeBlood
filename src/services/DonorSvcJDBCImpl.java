/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.BloodBank;
import domain.Donor;
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
public class DonorSvcJDBCImpl extends ConnectionManager implements IDonorService{

    @Override
    public void addDonor(Donor donor, BloodBank bloodBank) throws SQLException {
        try{
            //conntecting to database
            this.connectToDatabase();
            
           
                //Check if person donated already
                String checkSql = "SELECT `trn` FROM `donor` WHERE `trn` = ? ";
                
                //prepaered statement
                PreparedStatement checkPstmt = this.getConnection().prepareStatement(checkSql);
                
                //setting parems for statement
                checkPstmt.setString(1, donor.getTrn());
                
                //result set to store result of the query when executed
                ResultSet checkRset = checkPstmt.executeQuery();
                
                
                //Stores the boolean value of what was reurned from the query execution 
                Boolean checkResult = checkRset.next();
                
                if(checkResult == true) //if user already donated allow them to donate again (only add their trn n blood bank id)
                    //NOTE - in the future a time constraint can be implemented
                {
                //THOUGHTS (2) could this pose a security threat
                    String insertSQL = "INSERT INTO `blood_bank_has_donor` (`blood_bank_idblood_bank`,`donor_trn`) VALUES (?,?);";
//                        + "INSERT INTO `blood_bank` (`idblood_bank`, `name`, `phone` ) VALUES(?,?,?);"
//                        + "INSERT INTO `blood_bank_address` (`blood_bank_idblood_bank`,`street`, `address_line_1`, `address_line_2`) VALUES (?,?,?,?)";
                
                    //TODO (2) review the relation with donor and person as it relates to data entry in the database
                    // along with the abilitiy to donatINSERT INTO `blood_bank_has_donor` (`blood_bank_idblood_bank`,`donor_trn`) VALUES (?,?);e one to many times

                    //prepared statement
                    PreparedStatement pstmtInsert = this.getConnection().prepareStatement(insertSQL);
                    pstmtInsert.setString(1, donor.getTrn());
                    pstmtInsert.setString(2, bloodBank.getId());

                    //Execute the sql statement
                    pstmtInsert.executeUpdate();

                    //Notifying users
                    System.out.println(donor.getFirstname() + " " + donor.getLastname() + " => Donor added!!");
                }
                else
                { //else if user hasnt already donated, add their personal data to the person table and allow them to donate
                    String newPersonSQL = "INSERT INTO `donor` (`trn`,`firstname`,`lastname`,`email`,`gender`,`dob`,`blood_type`) VALUES (?,?,?,?,?,?,?);"
                            + "INSERT INTO `address` (`trn`,`street`, `address_line_1`, `address_line_2`) VALUES (?,?,?,?);"
                            + "INSERT INTO `phone` (`trn`,`phone_number_1`,`phone_number_2`) VALUES (?,?,?);"
                            + "INSERT INTO `blood_bank_has_donor` (`blood_bank_idblood_bank`,`donor_trn`) VALUES (?,?);";
                    
                    //prepared statement
                    PreparedStatement pstmtNewInsert = this.getConnection().prepareStatement(newPersonSQL);
                    
                    //Setting params
                    pstmtNewInsert.setString(1, donor.getTrn());
                    pstmtNewInsert.setString(2, donor.getFirstname());
                    pstmtNewInsert.setString(3, donor.getLastname());
                    pstmtNewInsert.setString(4, donor.getEmail());
                    pstmtNewInsert.setString(5, donor.getGender());
                    pstmtNewInsert.setDate(6, (Date) donor.getDob());
                    pstmtNewInsert.setString(7, donor.getBloodType());
                    
                    
                    //address INSERT PARAMS
                    pstmtNewInsert.setString(8, donor.getTrn());
                    
                    String [] address = donor.getAddress();
                    pstmtNewInsert.setString(9, address[0]);   //street
                    pstmtNewInsert.setString(10, address[1]);   //address line 1
                    pstmtNewInsert.setString(11, address[2]);   //address line 2
                    
                    //phone INSERT PARAMS
                    pstmtNewInsert.setString(12, donor.getTrn());
                    
                    String [] phone = donor.getNumber();
                    pstmtNewInsert.setString(13, phone[0]);   //phone 1
                    pstmtNewInsert.setString(14, phone[1]);   //phone 2
                   
                    
                    //Blodd bank donor
                    pstmtNewInsert.setString(15, bloodBank.getId());
                    pstmtNewInsert.setString(16, donor.getTrn());
                    
                    
                    pstmtNewInsert.executeUpdate();
                    
                    System.out.println(donor.getFirstname() + " " + donor.getLastname() + " => New Donor added!!");
                }
            //}
        }
        catch( SQLException ex)
        {
            throw new SQLException("Error: " + ex.toString() + "...");
        }finally{ close();}
    }

    @Override
    public void updateDonor(Donor donor) throws SQLException {
        try
        {
            //Connecting to database
            this.connectToDatabase();
            
            String checkSQL     = "SELECT `trn` FROM `donor` WHERE `trn` = ? ;";
            String updateSQL    = "UPDATE `donor` SET `firstname` = ?,`lastname` = ? ,`email` = ?,`gender` = ?,`dob` =? WHERE `trn` = ?;"
                    + "UPDATE `address` SET `street` = ? , `address_line_1` = ?, `address_line_2`= ? WHERE `trn` = ?;"
                    + "UPDATE `phone` SET  `phone_number_1` = ?,`phone_number_2` = ? WHERE `trn` = ?;";
                                
            
            //preparing statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(checkSQL);
            
            //setting parms for check prepared statement
            pstmt.setString(1, donor.getTrn());
            
            //result of query execution
            ResultSet rset = pstmt.executeQuery();
            
            //boolean value of query
            Boolean result = rset.next();
            
            if(!result) //if there was no result
            {
                System.out.println("Error: " + donor.getFirstname()+ " doesnt exists!");
            }
            else
            {
                PreparedStatement updatePstmt = this.getConnection().prepareStatement(updateSQL);
                
                    //person
                    updatePstmt.setString(1, donor.getFirstname());
                    updatePstmt.setString(2, donor.getLastname());
                    updatePstmt.setString(3, donor.getEmail());
                    updatePstmt.setString(4, donor.getGender());
                    updatePstmt.setDate(5, (Date) donor.getDob());
                    updatePstmt.setString(6, donor.getTrn());
                    
                    //person address
                    
                    //address
                    String [] address = donor.getAddress();
                    updatePstmt.setString(7, address[0]);   //street
                    updatePstmt.setString(8, address[1]);   //address line 1
                    updatePstmt.setString(9, address[2]);   //address line 2
                    updatePstmt.setString(10, donor.getTrn());
                    
                    
                    //phone
                    String [] phone = donor.getNumber();
                    updatePstmt.setString(11, phone[0]);   //phone 1
                    updatePstmt.setString(12, phone[1]);   //phone 2
                    updatePstmt.setString(13, donor.getTrn());
                    
                    
                updatePstmt.executeUpdate();
                
                System.out.println(donor.getFirstname()+ " Donor updated!!");
            }
            
        }catch(SQLException ex){System.out.println("Error: " + donor.getFirstname()+ " update error!!\n log: " + ex.toString());}finally{close();}
    }

    @Override
    public List<Donor> getAllDonor() throws SQLException {
        List<Donor> displayList = new ArrayList();
        try
        {
            this.connectToDatabase();
            
            Statement stmt = this.getConnection().createStatement();
            //sql query
            String selectSql = "SELECT * FROM `donor`;";
                                //+ "SELECT * FROM `blood_bank_address`;";
  
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
                    Donor donor = new Donor();
                    
                    donor.getTrn();
                    donor.getFirstname();
                    donor.getLastname();
                    donor.getNumber();
                    donor.getAddress();
                    
                    displayList.add(donor);
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
    public void deleteDonor(Donor donor) throws SQLException {
        try
        { //TODO Test this method
            //connecting to Database
            this.connectToDatabase();
            
            //SQL query
            String checkSQL = "SELECT `trn` from `donor` WHERE `trn`= ?";
            
            //prepared statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(checkSQL);
            
            //setting parems for query
            pstmt.setString(1,donor.getTrn());
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
                String deleteQuery = "DELETE FROM `blood_bank_has_donor` WHERE `donor_trn` = ?;"
                        + "DELETE FROM `address` WHERE `trn` = ?;"
                        + "DELETE FROM `phone` WHERE `trn`= ?;"
                        + "DELETE  FROM `donor` WHERE `trn` = ? ;";
                                    
                
                //prepared statment
                PreparedStatement delPstmt = this.getConnection().prepareStatement(deleteQuery);
                
                //setting preparedStatement params
                delPstmt.setString(1,donor.getTrn());
                delPstmt.setString(2,donor.getTrn());
                delPstmt.setString(3,donor.getTrn());
                delPstmt.setString(4,donor.getTrn());
                
                
                //executing statement
                delPstmt.executeUpdate();
                
                System.out.println(donor.getFirstname()+ " Donation(s) deleted!!");
            }
            
        }catch(SQLException ex){System.out.println("Error: " + ex.toString() + ", could not delete Donation!");}finally{close();}
    }
    
}
