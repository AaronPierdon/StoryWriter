/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers;

import controllers.fxmlControllers.FXMLController;



public class MainController {
    
    // This controller encapsulates and manages the data model
    DataController dataController;
    
    // Storage Controllers
    StorageController storageController;

    
    // Main FXML Controller
    FXMLController fxmlController;
    
    // Constructor
    public MainController(DataController dataController){
        this.dataController = dataController;
        this.storageController = new StorageController();
        
        // Pass a reference of this controller to the fxml controller
        // So the fxml controller can acces this.dataController and other controllers
        this.fxmlController = new FXMLController(this);
    }
    
    
    // Provides to caller, should be the main application, the fxml controller
    // For the main root BorderPane
    public FXMLController getFXMLController(){
        return this.fxmlController;
    }
    
    // Passes control the the fxml controllers and displays the main application
    public void startApplication(){}
    
    // Performs pre-closing procedures
    public void exitApplication(){
        
    }
}
