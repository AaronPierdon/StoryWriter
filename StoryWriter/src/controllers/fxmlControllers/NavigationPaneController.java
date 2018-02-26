/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers.fxmlControllers;

import javafx.scene.layout.VBox;


public class NavigationPaneController {

    
    private VState vState;


    
    public NavigationPaneController(){
        vState = VState.UNCHANGED;
    }
    
    
    public VBox getNavContainer(){
        
        VBox navContainer = new VBox();
        
        return navContainer;
    }
    
    
    // Getters and Setters
    public void getVState(VState vState) {
        this.vState = vState;
    }

    public VState getVState() {
        return vState;
    }
    
    
    
    
    
    
}
