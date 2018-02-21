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
  

  

