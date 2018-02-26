/*
 * Developers: Aaron Pierdon
 * Date: Feb 21, 2018
 * Description :
 * 
 */

package controllers.fxmlControllers;


public class DetailsPaneController {
    private VState vState;


    
    public DetailsPaneController(){
        vState = VState.UNCHANGED;
    }
    
    // Getters and Setters
    public void getVState(VState vState) {
        this.vState = vState;
    }

    public VState getVState() {
        return vState;
    }
}
