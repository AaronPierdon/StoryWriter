/*
 * Developers: Aaron Pierdon
 * Date: Feb 25, 2018
 * Description :
 * 
 */

package controllers.fxmlControllers;

    
    // Let's the TimerTask that is the main controller know when to update the view
    // Or extract input. There should be on of these in each sub-controller
    public enum VState {UNCHANGED, CHANGED, HASINPUT, NEEDSINPUT};
