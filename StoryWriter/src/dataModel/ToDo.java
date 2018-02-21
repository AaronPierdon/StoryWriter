/*
 * Developer:  Aaron Pierdon
 * Date:       Feb 8, 2018
 * Description: This class provides functionality to store a set of textual
 * notes that can help a user to create on-the-spot notes or a list of tasks
 * to complete concerning writing/creating the story.
 * 
 * 
 */

package dataModel;

import java.util.ArrayList;


public class ToDo {
    
    // Allows a user to optionally specify a number that represents 
    // the order in which this ToDo should be placed. A 1 would mean it is next.
    // a 0 would mean it's gonna be last on the stack of ToDo's
    private int sequence;
    private String name;
    
    // What is the ToDo task?
    private String description;
    
    // Optional keywords for dynamic story helper editing, content filling 
    // notification, and - at least - a way to see dynamic info. For instance,
    // if the user has selected a character "Harry," the details pane
    // will show a list of clicable ToDo objects associated with that character.
    private ArrayList<String> charKeywords;
    private ArrayList<String> eventKeywords;
    private ArrayList<String> locationKeywords;
    private ArrayList<String> thingKeywords;
    private ArrayList<String> otherKeywords;
}
