/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.proyectojar;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 *
 * @author joshz
 */
public class App extends Application {
    private static Scene scene;
    /**
     *
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Carpool");
        try{
            Image logo = new Image(getClass().getResourceAsStream("/com/espol/projectojar/files/carpool_logo.png"));
            stage.getIcons().add(logo);
        }catch(Exception e){
        }
        scene = new Scene(loadFXML("iniciosesion"));
        stage.setScene(scene);
        stage.show();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     *
     * @param rootNode
     */
    public static void changeRoot(Parent rootNode) {
        scene.setRoot(rootNode);
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(); 
    }
}
