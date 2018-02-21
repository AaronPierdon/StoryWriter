# GUI Specifications

<!-- toc -->

## Main Program GUI

The main program will be a javafx application that contains a BorderPane. 

1. The top node will be a menu structrure. 

2. The left-most or navigation node will host a tree structure that can be clicked and expanded to represent the data model that is the story. 

3. The center node will be the view pane. 

    1. This will contain dynaimc content based on what is selected or even, not selected, in the navigation pane. 

4. The right-most or details pane will contain information about something at all times. 
    1. This "something" can be the path to the current story's file, the name of the story, the details of the currently selected node in the navigation pane's tree structure, or the currently selected element in the view pane.


## Main GUI Areas that Go In Main Program’s BorderPane

1. Top Tool Bar
2. Main Controls for the program
3. Navigation Pane

    An interactable tree structure representing the story and its objects.

4. Content Pane

    Contains information or lists of interactable objects depending on 2 things:
        * What is selected in the navigation bar.
        * What – if anything – is selected in the Content Pane.

5.  Details Pane

    Contains details either about the content pane or a selected item.



![Main GUI](/gui-examples/main-gui.jpg)
