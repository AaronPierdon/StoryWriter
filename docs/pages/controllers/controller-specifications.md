
# Controller Specifications


## 1. MainController
    Encapsulates FXML, Data, and Storage Controllers.
  
        1. MainFXMLController
            This controller builds and handles events from the main view. This
            controller extends TimerTask to monitor the state of sub-views and 
            to update the dataModel when needed. This controller therefore needs to
            to be passed a MainController, which has access to the data model.

            The order of updating the view during the run() method, menu bar, will be navigation,
            details, view pane, and then details. Only one view can be updated at once, so set 
            a boolean to true for isUpdatingView.

                MainFXMLController encapuslates:

                1. MenuPaneController
                    1. Builds and handles events from the MenuPane.fxml view.
                    2. Has state variables: systemTimeLastChanged
                2. NavigationPaneController
                    1. Builds and handles events from the NavigationPane.fxml view.
                    2. Has state variables: systemTimeLastChanged
                3. ViewPaneController
                    1. Builds and handles events from the ViewPane.fxml view.
                    2. Has state variables: systemTimeLastChanged
                4. DetaisPaneController
                    1. Builds and handles events from the Deatils.fxml view.
                    2. Has state variables: systemTimeLastChanged
            
        

        2. DataController
            1. Encapsulates the data model and controls access to it.

        3. StorageController
            1. Gets a MainController so it can access the data model.
            2. Is responsible for serializing and/or deserializing objects
            and making sure they are saved/load to/from files from the local
            file system.



