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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Benoit
 */
public class Searcher {
    
    private ResultSet searchResult;
    
    public ResultSet search(String searched){
        
        DataSource ds = new DataSource();
        
        ResultSet firstCar;
        
        searchResult = ds.search(searched);
        
        
        
        try{
            searchResult.first();
            firstCar = pullCar(searchResult.getInt("SerialNB"));
            return firstCar;
        }
        catch (Exception ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        return null;
        
    }
    
    public ResultSet pullCar(int serialNB){
    
        DataSource ds = new DataSource();
        
        ResultSet carData = ds.pullCar(serialNB);
        
        
        
        return carData;
    }
    
}
