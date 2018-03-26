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
    
    public Car search(String searched){
        
        DataSource ds = new DataSource();
        
        Car firstCar;
        
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
    
    public Car next(){
        try{
            if(!searchResult.isLast()){
                searchResult.next();
                Car nextCar=pullCar(searchResult.getInt("SerialNB"));

                return nextCar;
            }
        }
        catch (Exception ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public Car back(){
        try{
            if(!searchResult.isFirst()){
                searchResult.previous();
                Car previousCar=pullCar(searchResult.getInt("SerialNB"));
                return previousCar;

            }
            
                }
        catch (Exception ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public Car pullCar(int serialNB){
    
        DataSource ds = new DataSource();
        
        ResultSet carData = ds.pullCar(serialNB);
        
        boolean isPart;
        
        try{
            carData.first();
            Car pulledCar = new Car(carData.getInt("SerialNB"),carData.getString("ModelName"),carData.getString("MakeName"), carData.getString("CountryName"), carData.getString("TypeName"),carData.getString("EngineName"), carData.getString("EngineType"), carData.getString("ModelSpeed"), carData.getString("CarPrice"),carData.getBlob("CarPicture"));
            do{
                isPart = false;
                
                
                for(int i = 0; i< pulledCar.getColor().size();i++){
                   
                    if(pulledCar.getColor().get(i).equals(carData.getString("ColorName"))){
                        
                        isPart = true;
                        break;
                    }
                }
                
                if (isPart == false){
                    pulledCar.addColor(carData.getString("ColorName"));

                }
                 
            }while(carData.next());
            
            carData.first();
            
            do{
                isPart = false;
                
                
                for(int i = 0; i< pulledCar.getOptions().size();i++){
                    
                    if (pulledCar.getOptions().get(i).equals(carData.getString("OptionName"))){
                        
                        isPart = true;
                        break;
                    }
                }
                if (isPart == false){ 
                    pulledCar.addOption(carData.getString("OptionName"));

                }
            }while(carData.next());
            
            return pulledCar;
        }
        catch (Exception ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return null;
    }
    
}