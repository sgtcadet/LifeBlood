/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Hospital;
import domain.HospitalAddress;
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
public class HospitalSvcJDBCImpl extends ConnectionManager implements IHospitalService{

    @Override
    public void addHospital(Hospital hospital) throws SQLException {
        try{
            //conntecting to database
            this.connectToDatabase();
            
            //check query string
            String check_sql = "SELECT idhospital FROM hospital WHERE idhospital = ?";
            
            //prepaered statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(check_sql);
            
            //setting parems for statement
            pstmt.setString(1, hospital.getHospitalId());
            
            //result set to store result of the query when executed
            ResultSet rset = pstmt.executeQuery();
            
            //Stores the boolean value of what was reurned from the query execution 
            Boolean result = rset.next();
            
            if(result == true) //if this is true the object is already stored in the database
            {
                //notify user that the object is already in the database
                System.out.println("Error: " + hospital.getName() + " already exists!!");
            }//else no result was found add this object to the database
            else
            {
                //COMPLETED (2) Add allowMultiQueries=true to database string inorder to support multiple querys;
                //THOUGHTS (2) could this pose a security threat
                String insertSQL = "INSERT INTO `hospital_address` (`address_id`,`street`, `address_line_1`, `address_line_2`) VALUES (?,?,?,?);"
                        + "INSERT INTO `hospital` (`idhospital`, `name`, `phone`,`address_id` ) VALUES(?,?,?,?);";
                
                //prepared statement
                PreparedStatement pstmtInsert = this.getConnection().prepareStatement(insertSQL);
                
                
                pstmtInsert.setString(1, hospital.getHospitalAddress().getAddressId());
                pstmtInsert.setString(2, hospital.getHospitalAddress().getStreet());
                pstmtInsert.setString(3, hospital.getHospitalAddress().getAddressLine1());
                pstmtInsert.setString(4, hospital.getHospitalAddress().getAddressLine2());
                pstmtInsert.setString(5, hospital.getHospitalId());
                pstmtInsert.setString(6, hospital.getName());
                pstmtInsert.setString(7, hospital.getPhone());
                pstmtInsert.setString(8, hospital.getHospitalAddress().getAddressId());
                
                //Execute the sql statement
                pstmtInsert.executeUpdate();
                
                //Notifying users
                System.out.println(hospital.getName() + " hospital added!!");
                //TODO (important) test this method
            }
        }
        catch( SQLException ex)
        {
            throw new SQLException("Error: " + ex.toString() + "...");
        }finally{ close();}
    }

    @Override
    public void updateHospital(Hospital hospital) throws SQLException {
        //COMPLETED (3) test update function
        try
        {
            //Connecting to database
            this.connectToDatabase();
            
            String checkSQL     = "SELECT `idhospital` FROM `hospital` WHERE `idhospital` = ? ;";
//            String updateSQL    = "UPDATE `hospital` SET `name` = ?, `phone` = ? WHERE `idhospital` = ? ;"
//                                + "UPDATE `hospital_address` SET `street` = ?, `address_line_1` = ?, `address_line_2` = ? WHERE `hospital_idhospital` = ?";
              String updateSQL = "UPDATE `hospital` SET `name` = ?, `phone` = ? WHERE `idhospital` = ? ;"
                                + "UPDATE `hospital_address` SET `street` = ?, `address_line_1` = ?, `address_line_2` = ? WHERE `address_id` = ?";
            //preparing statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(checkSQL);
            
            //setting parms for check prepared statement
            pstmt.setString(1, hospital.getHospitalId());
            
            //result of query execution
            ResultSet rset = pstmt.executeQuery();
            
            //boolean value of query
            Boolean result = rset.next();
            
            if(!result) //if there was no result
            {
                System.out.println("Error: " + hospital.getHospitalId() + " doesnt exists!");
            }
            else
            {
                PreparedStatement updatePstmt = this.getConnection().prepareStatement(updateSQL);
                
                updatePstmt.setString(1,hospital.getName());
                updatePstmt.setString(2,hospital.getPhone());
                updatePstmt.setString(3,hospital.getHospitalId()); 
                
                //address
                updatePstmt.setString(4,hospital.getHospitalAddress().getStreet());
                updatePstmt.setString(5,hospital.getHospitalAddress().getAddressLine1());
                updatePstmt.setString(6,hospital.getHospitalAddress().getAddressLine2());
                updatePstmt.setString(7,hospital.getHospitalAddress().getAddressId());
                
                updatePstmt.executeUpdate();
                
                System.out.println(hospital.getName() + " hospital updated!!");
            }
            
        }catch(SQLException ex){System.out.println("Error: " + hospital.getName() + " update error!!\n log: " + ex.toString());}finally{close();}
    }

    @Override
    public List<Hospital> getAllHospital() throws SQLException {
        // COMPLETED (4) test list function
        List<Hospital> displayList = new ArrayList();
        try
        {
            this.connectToDatabase();
            
            Statement stmt = this.getConnection().createStatement();
            //sql query
            String selectSql = "SELECT * FROM `hospital`;"
                                + "SELECT * FROM `hospital_address`;";
  
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
                    Hospital hospital = new Hospital();
                    HospitalAddress address= new HospitalAddress();
                    
                    hospital.setHospitalId(rs.getString("idhospital"));
                    hospital.setName(rs.getString("name"));
                    hospital.setPhone(rs.getString("phone"));
                    hospital.setAddress(address);
                    hospital.getHospitalAddress().setAddressId(rs.getString("address_id"));
                    hospital.getHospitalAddress().setStreet(rs.getString("street"));
                    hospital.getHospitalAddress().setAddressLine1(rs.getString("address_line_1"));
                    hospital.getHospitalAddress().setAddressLine2(rs.getString("address_line_2"));
                    
                    displayList.add(hospital);
                }
                System.out.println("Success!!!");
            }
            //TODO (IMPORTANT) TEST THIS METHOD
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
    public void deleteHospital(Hospital hospital) throws SQLException {
        // COMPLETED (5) complete and test delete function
        try
        {
            //connecting to Database
            this.connectToDatabase();
            
            //SQL query
            String checkSQL = "SELECT `idhospital` from `hospital` WHERE `idhospital`= ?";
            
            //prepared statement
            PreparedStatement pstmt = this.getConnection().prepareStatement(checkSQL);
            
            //setting parems for query
            pstmt.setString(1,hospital.getHospitalId());
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
                String deleteQuery = "DELETE  FROM `hospital` WHERE `idhospital` = ?;"
                        + "DELETE  FROM `hospital_address` WHERE `address_id` = ? ;";
                
                //prepared statment
                PreparedStatement delPstmt = this.getConnection().prepareStatement(deleteQuery);
                
                //setting preparedStatement params
                delPstmt.setString(1,hospital.getHospitalId());
                delPstmt.setString(2,hospital.getHospitalAddress().getAddressId());
                
                //executing statement
                delPstmt.executeUpdate();
                
                System.out.println(hospital.getName() + " deleted!!");
            }
            //TODO (IMPORTANT) TEST THIS METHOD
        }catch(SQLException ex){System.out.println("Error: " + ex.toString() + ", could not delete hospital!");}finally{close();}
    }
    
}
