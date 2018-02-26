/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers.fxmlControllers;


public class ViewPaneController {
    private VState vState;

    
    public ViewPaneController(){
        vState = VState.UNCHANGED;
    }
    
        
    // Getters and Setters
    public void setVState(VState vState) {
        this.vState = vState;
    }

    public VState getVState() {
        return vState;
    }
}
