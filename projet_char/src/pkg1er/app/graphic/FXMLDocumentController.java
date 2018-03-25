/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1er.app.graphic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author marc-etienne pepin
 */
public class FXMLDocumentController implements Initializable {
    
    
    // ==========================   Initialisation des labels  ==========================  
    @FXML
    private Label modele;
    
    @FXML
    private Label modele2;
    
    @FXML
    private Label marque;
    
    @FXML
    private Label constructeur;
    
    @FXML
    private Label pays;
    
     @FXML
    private Label type;
    
    @FXML
    private Label moteur;
    
     @FXML
    private Label vitesse;
     
     @FXML
    private Label price;
    // ==========================  fin initialisation des label ==========================  
     @FXML
     private TextField text;
     
    @FXML
    private ImageView picture;
    
    @FXML
    private ListView couleur;
    
    @FXML
    private ListView<String> equipement;
    
    public static final ObservableList names = 
        FXCollections.observableArrayList();
    
    private Searcher searcher;
    

    @FXML
    private void search(ActionEvent event) {
        
        Car result = searcher.search(text.getText());
        ArrayList<String> temp;
        try{
            couleur.getItems().clear();
            equipement.getItems().clear();
            
            Image image = new Image(result.getPic().getBinaryStream());
            setmarque(result.getMakeName());
            setconstructeur(result.getMakeName());
            setmodele(result.getModelName());
            setpays(result.getCountryName());
            settype(result.getTypeName());
            setimage(image);
            setmoteur(result.getEngineType());
            setvitesse(result.getSpeed());
            setprix(result.getPrice());
            
            temp=result.getColor();
            
            for(String color:temp)
                setcouleur(color);
           
            
            temp=result.getOptions();
            
            for(String options:temp)
                setequipement(options);
            
        }
        catch (Exception ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @FXML
    private void back(ActionEvent event) {
        Car result = searcher.back();
        if(result==null)
           return;
        
        ArrayList<String> temp;
        try{
            couleur.getItems().clear();
            equipement.getItems().clear();
            
            Image image = new Image(result.getPic().getBinaryStream());
            setmarque(result.getMakeName());
            setconstructeur(result.getMakeName());
            setmodele(result.getModelName());
            setpays(result.getCountryName());
            settype(result.getTypeName());
            setimage(image);
            setmoteur(result.getEngineType());
            setvitesse(result.getSpeed());
            setprix(result.getPrice());
            
            temp=result.getColor();
            
            for(String color:temp)
                setcouleur(color);
           
            
            temp=result.getOptions();
            
            for(String options:temp)
                setequipement(options);
            
        }
        catch (Exception ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    @FXML
    private void next(ActionEvent event) {
       Car result = searcher.next();
       if(result==null)
           return;
       
        ArrayList<String> temp;
        try{
            couleur.getItems().clear();
            equipement.getItems().clear();
            
            Image image = new Image(result.getPic().getBinaryStream());
            setmarque(result.getMakeName());
            setconstructeur(result.getMakeName());
            setmodele(result.getModelName());
            setpays(result.getCountryName());
            settype(result.getTypeName());
            setimage(image);
            setmoteur(result.getEngineType());
            setvitesse(result.getSpeed());
            setprix(result.getPrice());
            
            temp=result.getColor();
            
            for(String color:temp)
                setcouleur(color);
           
            
            temp=result.getOptions();
            
            for(String options:temp)
                setequipement(options);
            
        }
        catch (Exception ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        searcher = new Searcher();
    }    
    
    
    // ==========================   setteur de label  ==========================  
    public void setmodele(String model) {
        modele.setText(model);
        modele2.setText(model);
    }
    
    public void setmarque(String marqu) {
        marque.setText(marqu);
    }
    
    public void setconstructeur(String builder) {
        constructeur.setText(builder);
    }
    
    public void setpays(String pay) {
        pays.setText(pay);
    }
    public void settype(String typ) {
        type.setText(typ);
    }
    public void setmoteur(String moteu) {
        moteur.setText(moteu);
    }
    public void setvitesse(String speed) {
        vitesse.setText(speed);
    }
    public void setprix(String prix) {
        price.setText(prix);
    }
    public void setimage(Image values){
        picture.setImage(values);
    }
    public void setcouleur(String couleurs){
        
        couleur.getItems().add(couleurs);
    }
    public void setequipement(String equipements){
        equipement.getItems().add(equipements);
        // source : https://stackoverflow.com/questions/32700005/javafx-listview-add-and-edit-element
        // source a supprimer avant fin du projet je la laissa la au cas shit happen durant l'execution
    }
    public void clearliste(){
        couleur.getItems().clear();
        equipement.getItems().clear();
    }
   
    // ==========================   fin de setteur de label ========================== 
    // ==========================   les tableaux =====================================
    
}
