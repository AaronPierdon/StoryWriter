/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers.fxmlControllers;

import controllers.MainController;


public class FXMLController {

    //Controllers that handle different parts of the main FXML application
    private MenuPaneController menuController;
    private NavigationPaneController navigationController;
    private ViewPaneController viewPaneController;
    private DetailsPaneController detailsController;
    
    // MainController for so this controller can access the data and storage controllers
    MainController mainController;
    
    //Constructor
    public FXMLController(MainController mainController){
        this.mainController = mainController;
        
        menuController = new MenuPaneController();
        navigationController = new NavigationPaneController();
        viewPaneController = new ViewPaneController();
        detailsController = new DetailsPaneController();
        
    }
    
    
    
    protected void updateMenuBar(){
        
    }
}
