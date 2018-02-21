/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers;

import dataModel.Story;


public class MainController {
    
    // This controller encapsulates and manages the data model
    DataController dataController;
    
    // Constructor
    public MainController(DataController dataController){
        this.dataController = dataController;
    }
    
    
    
    // Performs pre-closing procedures
    public void exitApplication(){
        
    }
}
