/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers;

import dataModel.Story;


public class MainController {
    
    // The data model that is a Story Object
    DataController dataController;
    
    // Constructor
    public MainController(DataController dataController){
        this.dataController = dataController;
    }
    
    
    
    // Performs pre-closing procedures
    public void exitApplication(){
        
    }
}
