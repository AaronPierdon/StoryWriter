# Requirements

<!-- toc -->

## Top Level Requirements

A program that helps a user write, organize, and analyze a story.

## General Requirements

### Main Program

An application window and thread that maintains all other views – to be placed inside the application window as panes,
like navigation, content area, top toolbar, and the details pane.

### Data Entry

A program that provides a user with a set of data entry forms for inputting new elements in the story, like characters.
The user should be able to save these inputs permanently. The user should be able to navigate the story and find and
read information about objects that have been input, like characters.

### Story Editor

A program that provides a user with a text editor. The story will be organized in chapter objects, each of which is
like a mini-document. The user should be able to save this typed input. The user should also be able to navigate the
story and find, read, and edit the typed input.

### Data Mining

A program that parses the story structures, both the text-based and object based - like chapter content and character
lists, respectively. The result of this parsing will take a dynamic and very cool form. The form will be a tube or line.
This line will be the timeline of the story based on the chronology of event objects the user input or, by default, the
sequencing of chapters. A user can zoom in on this line. This line transforms into a pipeline with icons floating above
and around it with lines pinpointing those icons, point of origin. These icons could be characters or events. The points
of origins are where the program has parsed information about those objects and understands at which points on the timeline
they are active. This generates a requirement for data entry. A user must either specify that an object is relevant or
active in all chapters, or he or she must select the chapters that object is active in.

Also, as a use zooms in and sees objects that are active at different points in the timeline, there will also be lines
between other objects with which a selected object is associated. This needs work.

## Requirements for Each Program Section

### Main Program Requirements

1. Views (Refer to GUI specifications document for more info on the views)
    1. Top Toolbar
    2. Navigation Pane
    3. Content Area
    4. Details Pane
2. Data
    1. Default Directory
    2. Initialization File in Default Directory
    3. Last Saved Item
    4. A story object
3. Controllers
    1. Main Controller
    2. Load Story File Controller
    3. Save Story File Controller

### Data Entry Requirements

1. Views (Refer to GUI specifications document for more info on the views)
    1. Create new story
    2. Open story
    3. Save story dialog
    4. Add/Edit character
    5. Add/Edit Event
    6. Add/Edit Location
    7. Add/Edit Thing
    8. Add/Edit ToDo
2. Data
    1. A story object
3. Controllers
    1. Main Controller

### Story Editor Requirements

1. Views (Refer to GUI specifications document for more info on the views)
    1. Text Editor
2. Data
    1. A Story Object
3. Controllers
    1. Main Controller

### Data Mining Requirements

1. Not important currently; more to come.
