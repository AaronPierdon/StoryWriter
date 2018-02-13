# GUI Specifications

<!-- toc -->

## Main Program GUI

The main program will be a javafx application that contains a BorderPane. All GUI’s and program content will be inside
the BorderPane, except on-the-spot dialogs like those for errors. Most of the GUI regions will present
static – non-changing - controls like buttons or text. For instance, the Top Tool Bar will always contain the buttons,
new, open, and save; however, the content pane may contain buttons and will most always contain text information unless
it’s blank. Each section is further explained after the following brief list.


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