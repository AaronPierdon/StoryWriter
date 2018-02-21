/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers;

import dataModel.Story;


public class DataController {

    // The data model that is a Story object
    Story dataModel;
    
    public DataController(){
        this.dataModel = new Story();
    }
}
