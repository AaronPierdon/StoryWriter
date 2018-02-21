/*
 * Developer:  Aaron Pierdon
 * Date:       Feb 8, 2018
 * Description:

 */

package storywriter;

import javafx.application.Application;
import javafx.stage.Stage;


public class Storywriter extends Application{

    // Where the .ini file is located and potentiall some story files.
    public static final String DEFAULTDIR = System.getProperty("user.home") +
            "\\documents\\storywriter";
    
    
    @Override
    public void start(Stage stage) throws Exception{
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
