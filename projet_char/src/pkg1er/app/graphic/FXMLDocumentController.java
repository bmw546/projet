/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1er.app.graphic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javax.management.Query.value;

/**
 *
 * @author marc-etienne pepin
 */
public class FXMLDocumentController implements Initializable {
    
    
    // ==========================   Initialisation des labels  ==========================  
    @FXML
    private Label modele;
    
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
    private ImageView picture;
    
    @FXML
    private void search(ActionEvent event) {
    }
    @FXML
    private void back(ActionEvent event) {
    }
    @FXML
    private void next(ActionEvent event) {
    }
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    // ==========================   setteur de label  ==========================  
    public void setmodele(String model) {
        modele.setText(model);
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
    
    // ==========================   fin de setteur de label ========================== 
}
