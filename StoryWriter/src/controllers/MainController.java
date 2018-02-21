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
    SaveFileController saveController;
    LoadFileController loadController;
    
    // Main FXML Controller
    FXMLController fxmlController;
    
    // Constructor
    public MainController(DataController dataController){
        this.dataController = dataController;
        this.saveController = new SaveFileController();
        this.loadController = new LoadFileController();
        
        // Pass a reference of this controller to the fxml controller
        // So the fxml controller can acces this.dataController and other controllers
        this.fxmlController = new FXMLController(this);
    }
    
    
    
    // Performs pre-closing procedures
    public void exitApplication(){
        
    }
}
