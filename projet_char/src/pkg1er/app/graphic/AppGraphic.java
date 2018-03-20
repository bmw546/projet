/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1er.app.graphic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author marc-etienne pepin
 */
public class AppGraphic extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Recherche une voiture");
        stage.show();
        
        /*
        Parent root2 = FXMLLoader.load(getClass().getResource("balblablabla.fxml"));
        
        Scene scene2 = new Scene(root2);
        
        stage.setScene(scene2);
        stage.show();
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        DataSource test = new DataSource();
        
        test.pullCar(1);
    }
    
}
