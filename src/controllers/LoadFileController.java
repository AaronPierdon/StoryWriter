/*
 * Developer:  Aaron Pierdon
 * Date:       Jan 27, 2018
Expression licensePrefx is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.Description: This class/file
 */

package controllers;

import dataModel.Story;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import utility.fileUtility.Serializer;


public class LoadFileController {
    
    
    
    // Main entry point of interface...controller
    // Returns a loaded Story object or null
    
    // The currently or most recently loaded file's path
    private String currentFileURL;
    
    // Also has code the generates a config file if none is found
    public Story getSaveFile(){
        String config = getConfigFile();
        
        // Makes sure the config file exists
        if(config != null){
            // Make sure the config file has a reference to a file
            if(config.length() >
                "lastSaved = ".length()){
                // Load and return the Story from path in config
                return loadStory(config);
            }
            // config does not specify file, look for file in default
            else if(defaultSaveFileExists()){
                
                return loadStory();
            }
            
            // No save files exists return null instead of a Story
            else {
                return null;
            }
            
            
            
        // Config file does not exist... create it and return null
        // In place of a story object
        } else {
            makeNewConfigFile();
            return null;
        }

            
    }
    
    // Get the first line of the config file or null if not found
    private String getConfigFile(){
        File configFile = new File(Storywriter.DEFAULTDIR + "storywriter.ini");
        if(configFile.exists()){
            try{
                FileReader reader = new FileReader(configFile);
                BufferedReader bufReader = new BufferedReader(reader);
                
                try{
                    return bufReader.readLine();
                }catch(IOException ee){
                    return null;
                }
                
            }catch(FileNotFoundException e){
                return null;
            }

        } else {
            return null;
        }
        
    }
    
    // Returns true if the default directory has a save file
    private boolean defaultSaveFileExists(){
        // Search for the file
        
        return false;
        
        
    }
    
    
    // Makes a new config file in teh default directory
    private void makeNewConfigFile(){
        
        File dir = new File(StoryWriter.DEFAULTDIR);
        if(dir.exists() && (dir.isDirectory()) == true){
            File file = new File(StoryWriter.DEFAULTDIR + "storywriter.ini");
            try{
                FileWriter fw = new FileWriter(file);  
                
                fw.write("lastSave = \n");
                fw.flush();
                fw.close();
            }catch(IOException e){}
        } else {
            
            // Create the directory
            dir.mkdir();
            this.makeNewConfigFile();
        }

        
        
        
    }
    
    // Save File Found... Load it from default directory
    private Story loadStory(){
        Story tempStory = new Story();
        
        // try block
        try{
            tempStory = (Story) Serializer.deserialize(StoryWriter.DEFAULTDIR 
                + "default.obj");
            
            this.currentFileURL = StoryWriter.DEFAULTDIR + "default.obj";
            
            return tempStory;
                    
        }catch(Exception deSerialExc){
            return null;
        }

    }
    
    // Save File Found... Load it from specified path(deserialize)
    private Story loadStory(String fileURL){
        Story tempStory = new Story();
        
        // try block
        try{
            tempStory = (Story) Serializer.deserialize(fileURL);
            
            this.currentFileURL = fileURL;
            
            return tempStory;
                    
        }catch(Exception deSerialExc){
            return null;
        }
    }
            
            

}
