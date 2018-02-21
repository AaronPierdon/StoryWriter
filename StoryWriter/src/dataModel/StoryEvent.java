/*
 * Developer:  Aaron Pierdon
 * Date:       Feb 7, 2018
 * Description:

 */

package dataModel;

import java.util.ArrayList;


public class StoryEvent {
    
    private String name;
    private String description;
    
    private ArrayList<String> charKeywords;
    private ArrayList<String> eventKeywords;
    private ArrayList<String> locationKeywords;
    private ArrayList<String> thingKeywords;
    private ArrayList<String> otherKeywords;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCharKeywords(ArrayList<String> charKeywords) {
        this.charKeywords = charKeywords;
    }

    public void setEventKeywords(ArrayList<String> eventKeywords) {
        this.eventKeywords = eventKeywords;
    }

    public void setLocationKeywords(ArrayList<String> locationKeywords) {
        this.locationKeywords = locationKeywords;
    }

    public void setThingKeywords(ArrayList<String> thingKeywords) {
        this.thingKeywords = thingKeywords;
    }

    public void setOtherKeywords(ArrayList<String> otherKeywords) {
        this.otherKeywords = otherKeywords;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getCharKeywords() {
        return charKeywords;
    }

    public ArrayList<String> getEventKeywords() {
        return eventKeywords;
    }

    public ArrayList<String> getLocationKeywords() {
        return locationKeywords;
    }

    public ArrayList<String> getThingKeywords() {
        return thingKeywords;
    }

    public ArrayList<String> getOtherKeywords() {
        return otherKeywords;
    }

}
