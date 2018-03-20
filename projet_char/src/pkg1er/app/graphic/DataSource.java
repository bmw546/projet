/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1er.app.graphic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benoit
 */
public class DataSource {
    
    public ResultSet search(String string){
       
        Connection conn;
        
        
       
       try{
           
           Class.forName("com.mysql.jdbc.Driver"); 
           
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/carcatalog","root","");
            
            String query = "SELECT `SerialNB` FROM `car` WHERE `CarDescription` LIKE '%?%' "; 
            PreparedStatement stat=conn.prepareStatement(query); 
            
            stat.setString(1,string);
            
            ResultSet result = stat.executeQuery();
            
            while(result.next())
                System.out.println(result.getInt("SerialNB"));
            
            conn.close();
            
            return result;
         
       }
       catch (SQLException ex) {
            //Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
       catch (ClassNotFoundException ex) {
            //Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return null;
    }
    
    public ResultSet pullCar(int nb){
       
        Connection conn;
        
        ResultSet result = null;
       
       try{
           
           Class.forName("com.mysql.jdbc.Driver"); 
           
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/carcatalog","root","");
            
            String query = "SELECT * FROM `car` JOIN `model` ON `car`.`Model`= `model`.`ModelID` JOIN `color_car` ON `car`.`SerialNB`=`color_car`.`CarID` "
                    + "JOIN `color` ON `color`.`ColorID`=`color_car`.`ColorID` JOIN `options_car` ON `car`.`SerialNB`=`options_car`.`CarID` "
                    + "JOIN `options` ON `options`.`OptionID`=`options_car`.`OptionID` JOIN `type` ON `type`.`TypeID`= `model`.`Type` "
                    + "JOIN `engine` ON `engine`.`EngineID`= `model`.`Engine` JOIN `make` ON `make`.`MakeID`= `model`.`Make` "
                    + "JOIN `country` ON `make`.`Country`= `country`.`CountryID` WHERE `SerialNB`=?"; 
            PreparedStatement stat=conn.prepareStatement(query); 
            
            stat.setInt(1,nb);
            
            result = stat.executeQuery();
            
            while(result.next())
                System.out.println(result.getInt("SerialNB"));
            
            conn.close();
         
       }
       catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
       catch (ClassNotFoundException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return result;
    }
    
}
