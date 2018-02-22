/*
 * Developer:  Aaron Pierdon
 * Date:       Feb 8, 2018
 * Description:

 */

package storywriter;

import controllers.DataController;
import controllers.MainController;
import dataModel.Story;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Storywriter extends Application{

    // Where the .ini file is located and potentiall some story files.
    public static final String DEFAULTDIR = System.getProperty("user.home") +
            "\\documents\\storywriter";
    
    // An event handler that responds to the application window/stage being
    // Closed
    ApplicationCloser appCloser;
    
    
    // The main controller of the application
    private MainController mainController;
    
    // The controller that handles updating or retreiving from the data model
    private DataController dataController;
    
    
    
    // Program Entry Point
    @Override
    public void start(Stage stage) throws Exception{
        
        // Instantiate and initilize the controllers
        initializeComponents();
        
        // Set default close operation for the application which is an EventHandler
        stage.setOnCloseRequest(appCloser);
        
        
        // Get the root .fxml object/file and set as the primary stage's scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainFXML.fxml"));
        loader.setController(this.mainController.getFXMLController());
        VBox root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        // Control is now that of the main fxml controller by way of handling
        // Interaction withthe main fxml view and it's sub views
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    

    protected void initializeComponents(){
        this.dataController = new DataController();
        
        this.appCloser = new ApplicationCloser();
        
        this.mainController = new MainController(this.dataController);
        
        
    }
    
    
    
    // Inner class that handles the event of the application window being closed
    public class ApplicationCloser implements EventHandler<WindowEvent>{
        @Override 
        public void handle(WindowEvent event){
            mainController.exitApplication();
            System.exit(0);
        }
    }
}
