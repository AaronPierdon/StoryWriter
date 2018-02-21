
# Controller Specifications


## 1. MainController

  1. Encapsulates all other controllers.
 
## 2. DataController
  
  1. Has a reference to the data model (a Story object).
  2. Has methods that get/set values and objects in the story object.

## 3. StorageController

  1. Handles the saving or loading a Story object.
    1. Will serialize object and the save to file.
    2. Will deserialize object from a file and populate the data model with the contents.
  2. Gets a MainController object when a method is invoked so the StorageController can access the data controller nested in the MainController.
  3. Returns to MainController a value that represents a success or failure of saving the file.
  
## 4. MainFXMLController

  1. Controlls the view of the main .fxml file/BorderPane.
  2. Gets a a MainController object when MainFXML controller is invoked via method call or constructor.
    1. The MainController object provides access to the nested DataController and thus the data model.
  2. Has controllers that load and handle the .fxml files that make up the entire Program.
    1. Each sub-FXMLController will handle one .fxml file and the actions generated from the interaction with that .fxml file's GUI.

## 5. MenuBarController
  
  1. Controls the view of the MenuBar.fxml and handles any events that are invoked via the MenuBar interface.
  2. Has a MainFXMLController that can be used to populate the applications root BorderPane's TOP node as well as request other view-oriented procedures that are handles by the MainFXMLController.
  
## 6. NavigationPaneController

  1. Controls the view of the ViewPaneController.fxml and handles any events that are invoked via the ViewPaneController interface.
  2. Has a MainFXMLController that can be used to populate the applications root BorderPane's LEFT node as well as request other view-oriented procedures that are handled by the MainFXMLController.
  
## 7. ViewPaneController

  1. Controls the view of the NavigationPane.fxml and handles any events that are invoked via the NavigationPane interface.
  2. Has a MainFXMLController that can be used to populate the applications root BorderPane's CENTER node as well as request other view-oriented procedures that are handled by the MainFXMLController.

## 8. DetailsPaneController

  1. Controls the view of the DetailsPaneController.fxml and handles any events that are invoked via the DetailsPaneController interface.
  2. Has a MainFXMLController that can be used to populate the applications root BorderPane's RIGHT node as well as request other view-oriented procedures that are handled by the MainFXMLController.
