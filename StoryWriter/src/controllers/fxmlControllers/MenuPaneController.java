/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers.fxmlControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.fxml.FXMLLoader;

public class MenuPaneController {

    private VState vState;

    public void getVState(VState vState) {
        this.vState = vState;
    }

    // Getters and Setters
    public VState getVState() {
        return vState;
    }
    
    public MenuPaneController(){
        vState = VState.UNCHANGED;
    }
    
    protected MenuBar getViewNode(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuBar.fxml"));
        
        loader.setController(this);
        
        try{
            MenuBar menuBar = loader.load();
            return menuBar;
        }catch(IOException e){}
        
        return null;
    }
    
    // Handlers
    
    @FXML protected void newFile(){
    
    }
    
    @FXML protected void openFile(){
    
    }
    
    @FXML protected void quit(){
    
    }
    
    @FXML protected void openCreator(){
    
    }
    
    @FXML protected void openWriter(){
    
    }
    
    @FXML protected void openAnalysis(){
    
    }
}
