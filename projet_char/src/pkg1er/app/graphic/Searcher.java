/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1er.app.graphic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benoit
 */
public class Searcher {
    
    private ResultSet searchResult;
    
    public ResultSet search(String searched){
        
        DataSource ds = new DataSource();
        
        ResultSet firstCar = null;
        
        searchResult = ds.search(searched);
        
        try{
            searchResult.next();
            firstCar = pullCar(searchResult.getInt("SerialNB"));
        }
        catch (Exception ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        return firstCar;
        
    }
    
    public ResultSet pullCar(int serialNB){
    
        DataSource ds = new DataSource();
        
        ResultSet carData = ds.pullCar(serialNB);
        
        return carData;
    }
    
}
