/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers.fxmlControllers;

import controllers.MainController;
import java.util.Timer;
import java.util.TimerTask;
import static javafx.application.ConditionalFeature.FXML;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;


public class FXMLController extends TimerTask{

 
    

    //Controllers that handle different parts of the main FXML application
    private MenuPaneController menuController;
    private NavigationPaneController navigationController;
    private ViewPaneController viewPaneController;
    private DetailsPaneController detailsController;
    
    // FXML Variables to manipulate the views
    @FXML protected VBox root;
    
    
    // Let's the run() method know if a view is being updated. If so,
    // no other view will be updated
    private boolean isViewUpdating;
    

    
    
    // MainController for so this controller can access the data and storage controllers
    MainController mainController;
    
    //Constructor
    public FXMLController(MainController mainController){
        isViewUpdating = false;
        this.mainController = mainController;
        
        iniControllers();

        
    }
    
    private void iniControllers(){
        menuController = new MenuPaneController();
        navigationController = new NavigationPaneController();
        viewPaneController = new ViewPaneController();
        detailsController = new DetailsPaneController();
    }
     
    
    public void displayApplication(){
        buildGUI();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(this, 0, 40);
        
    }
    
    
    private void buildGUI(){
          updateMenuBar();  
          updateNavigationPane();
          updateViewPane();
          updateDetailsPane();
    }
    
    
    // Updates the views
    private void updateMenuBar(){
        isViewUpdating = true;
        MenuBar updatedMenu = menuController.getViewNode();
        updatedMenu.setUseSystemMenuBar(true);
        root.getChildren().add(0, updatedMenu);
        isViewUpdating = false;
    }
    
    private void updateNavigationPane(){
        isViewUpdating = true;
        System.out.println("nav");
        isViewUpdating = false;
    }
    
    private void updateViewPane(){
        isViewUpdating = true;
        System.out.println("view");
        isViewUpdating = false;
    }
        
    private void updateDetailsPane(){
        isViewUpdating = true;
        System.out.println("details");
        isViewUpdating = false;
    }
    
    private void checkViewControllers(){
        
        // So run() won't call this function again until this function sets is
        // Updating to false.
        
        
        if(menuController.getVState() != VState.UNCHANGED){
            isViewUpdating = true;
            updateMenuBar();
            updateNavigationPane();
            updateViewPane();
            updateDetailsPane();
            isViewUpdating = false;
        } else if(navigationController.getVState() != VState.UNCHANGED){
            // Menu Bar doesn't really change, so don't bother updating it
            isViewUpdating = true;
            updateNavigationPane();
            updateViewPane();
            updateDetailsPane();
            isViewUpdating = false;
        } else if(viewPaneController.getVState() != VState.UNCHANGED){
            isViewUpdating = true;
            updateViewPane();
            updateDetailsPane();
            isViewUpdating = false;
        }

        
        isViewUpdating = false;
    }
    @Override
    public void run() {
        Platform.runLater(() -> {
            if(!isViewUpdating){
                checkViewControllers();
                
            }
        });
    }
}
