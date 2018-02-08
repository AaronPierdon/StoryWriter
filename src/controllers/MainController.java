/*
 * Developer:  Aaron Pierdon
 * Date:       Jan 27, 2018
Expression licensePrefx is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.Description: This class/file
 */

package controllers;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import story.writer.GUI.AddCharacterForm;
import story.writer.GUI.AddEventForm;
import story.writer.GUI.AddLocationForm;
import story.writer.GUI.AddStoryForm;
import story.writer.GUI.AddThingForm;
import story.writer.GUI.MainForm;
import story.writer.StoryWriter;
import story.writer.dataModel.Story;


public class MainController implements Runnable{

    private boolean runProgram = false;
    private enum FormsState{
        MAIN, STORY, CHAR, EVENT, LOC, THING
    }
    
    private FormsState formsState;
    
    // The Data
    private Story story;
    

    
    // Forms
    private MainForm mainForm;
    private AddCharacterForm charForm;
    private AddEventForm eventForm;
    private AddLocationForm locForm;
    private AddThingForm thingForm;
    private AddStoryForm storyForm;
    
    // Controller for saving data
    private SaveFileController saveFileController;
     
    // Controller for loading data
    private LoadFileController loadFileController;
    
    // The thread the runs the program based on runProgram variable which 
    
    private Thread thisThread;
    
    int saveFormState;
    
    
    // Constructor
    public MainController(Story story, MainForm mainForm, AddStoryForm storyForm,
            AddCharacterForm charForm, AddEventForm eventForm, AddLocationForm locForm,
                AddThingForm thingForm){
        this.story = story;
        this.mainForm = mainForm;
        this.charForm = charForm;
        this.eventForm = eventForm;
        this.locForm = locForm;
        this.thingForm = thingForm;
        this.storyForm = storyForm;
        this.saveFileController = new SaveFileController();
        this.loadFileController = new LoadFileController();
        
        
        
        initForms();
        
        initController();
    }
    
    private void initForms(){ 
        
        // Add Action Listeners
        
        
        // Main Form
        MainActionListener mainFormListener = new MainActionListener();
        mainForm.addStoryListener(mainFormListener);
        mainForm.addCharacterListener(mainFormListener);
        mainForm.addEventListener(mainFormListener);
        mainForm.addLocationListener(mainFormListener);
        mainForm.addThingListener(mainFormListener);
        mainForm.addExitListener(mainFormListener);
        
        // Add Story Form
        AddStoryListener storyListener = new AddStoryListener();
        storyForm.addStoryListener(storyListener);
        
        
        // Add Char Form
        AddCharacterListener charListener = new AddCharacterListener();
        charForm.addListener(charListener);

        
                
    }
    
    private void initController(){
        
        // Start this.run() process if the thread program isn't already running
        if(thisThread == null && !runProgram){
            loadSaveFile();
            thisThread = new Thread(this);
            thisThread.start();
            
            // will call run() until runProgram == false
            runProgram = true;
            
            // This makes the program state MAIN, so show main form
            this.formsState = FormsState.MAIN;
            
        }
    }
    
    // Initilize the story object
    private void iniStory(){
        story = new Story();
        String fileURL = storyForm.getTargetFile().getAbsoluteFile().getAbsolutePath();
        
        // Set the name of the story object
        story.setName(fileURL.substring(fileURL.lastIndexOf("\\") + 1) + ".obj");
        // Set the url
        story.setPath(fileURL.substring(0, fileURL.lastIndexOf("\\") + 1));
       
    }
    
    // File Opener Method that fills this data structure
    public void loadSaveFile(){
        this.story = loadFileController.getSaveFile();
    }
    
    // File Saver method that saves this data structure
    public void saveFile(){
        
    }

    
    public void showSaveForm(){
        
        this.charForm.setVisible(false);
        this.eventForm.setVisible(false);
        this.locForm.setVisible(false);
        this.thingForm.setVisible(false);
        this.mainForm.setVisible(false);
                
        saveFormState = storyForm.showSaveDialog(null);
        
    }
    // Controls the visibility of the forms with added exception
    public void hideForms(JFrame exceptionForm){
        
        // If xForm.equals(exceptionForm) == true, set visible
        // If not, make it invisible, which is the output of the above equation
        
        // Fix //
            // Eventualy make this use an array and loop for each in the array
            // So you can have a set of forms that can be visible
        this.charForm.setVisible(charForm.equals(exceptionForm));
        this.eventForm.setVisible(eventForm.equals(exceptionForm));
        this.locForm.setVisible(locForm.equals(exceptionForm));
        this.thingForm.setVisible(thingForm.equals(exceptionForm));
        this.mainForm.setVisible(this.mainForm.equals(exceptionForm));
        this.storyForm.setVisible(false);
        
    }
    
    
    
    
    
    
    
    
    
    
    // This is the main program and will run until failure or user exits.
    @Override
    public void run() {
        
        System.out.println("love");
        
        while(runProgram){
            switch(this.formsState){
                case MAIN : {
                    // If story is not initilized, user can't add to a story
                    if(this.story == null){
                        this.mainForm.hideStoryControls(true);
                        this.mainForm.setVisible(true);
                    // There is a story initilized
                    } else {
                        this.mainForm.hideStoryControls(false);
                        hideForms(mainForm);
                    }
                    
                }
                    break;

                
                case STORY : {
                                
                        showSaveForm();
                        
                        // If the state of the save form returns 1, 
                        // That means the form was closed
                        // Return to main
                        if(saveFormState == 1){
                            formsState = FormsState.MAIN;
                        }
  
                    }
                    break;
                    
                case CHAR :{
                    hideForms(charForm);
                }
                    break;
                    
                    
                default:  {
                    
                    // Hide all
                    this.storyForm.setVisible(false);
                    this.charForm.setVisible(false);
                    this.eventForm.setVisible(false);
                    this.locForm.setVisible(false);
                    this.thingForm.setVisible(false);
                    
                    // Show main
                    this.mainForm.setVisible(true);
                }
            }
        }
        
    }
    
        
    
    
    // Action Listeners 
    
    // Main Form
   
    
    // Listener for the buttons on the main form
    public class MainActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            // Set up a temp button that is that which was clicked
            JButton button = (JButton) ae.getSource();
            System.out.println(button.getText());
            
            // Find out which button was clicked
            switch(button.getText()){
                case ("New Story"):
                {
                    formsState = FormsState.STORY;

                }
                    break;
                    
                case ("Add Character"):
                {
                    formsState = FormsState.CHAR;
                }
                    break;
                    
                case ("Add Event"):
                {
                    formsState = FormsState.EVENT;
                }
                
                case ("Add Location"):
                {
                    formsState = FormsState.LOC;
                }
                
                    break;
                    
                case ("Add Thing"):
                {
                    formsState = FormsState.THING;
                }
                
                    break;
                
                case ("Exit"):
                {
                    System.exit(0);
                }
                
                    break;
                
                    
                
                    
            }
        }
        
    }
    
    // AddStoryForm Listeners
    
   
    public class AddStoryListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            // If the user did not cancel
            
            
                if(!ae.getActionCommand().toLowerCase().contains("cancel")){
                
                    boolean saveSuccess = saveFileController.saveFile(
                        storyForm.getTargetFile());

                    if(!saveSuccess){
                        storyForm.showErrorDialog();
                    }else {
                        
                        
                        
                        // Instantiate the story
                        iniStory();
                        
                        
                        formsState = FormsState.MAIN;
                        
                        
                    }

                } else {
                    formsState = FormsState.MAIN;
                }
        }
        
        public void updateIni(){
            // Set the last saved path in config
                        File config = new File(StoryWriter.DEFAULTDIR + "storywriter.ini");
                        
                        // If the ini file exists, delete it
                        if(config.exists()){
                            config.delete();
                        }
                        
                        // Try to create a new ini file with the targetsavefile
                        // That was just saved
                        try{
                            
                            config.createNewFile();
                            BufferedWriter bw = new BufferedWriter(new FileWriter(config));
                            
                            // Make sure the file reference has .obj suffix
                            if(!storyForm.getTargetFile().getAbsoluteFile().toString().contains(".obj"))
                                bw.write(storyForm.getTargetFile().getAbsoluteFile().toString()
                                    + ".obj");
                            else
                                bw.write(storyForm.getTargetFile().getAbsoluteFile().toString());
                            
                            
                            bw.flush();
                            bw.close();
                        }catch(IOException e){
                            
                        }
        }
        

    }
    
    // Add character form
    public class AddCharacterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            JButton button = (JButton) e.getSource();
            String btnText = button.getText();
            
            if(btnText.toLowerCase().contains("add")){
                

                // Ensure all text areas have valid input
                if(isCharFormComplete()){
                    // Instantiate a character object with the input
                    story.writer.dataModel.StoryCharacter newChar = new
                            story.writer.dataModel.StoryCharacter();
                    
                    
                    // Add the new character to the story data structure
                    newChar.setName(charForm.getNameInput());
                    
                        // Extract comma-separated keywords from the string
                        // And add to the character ArrayList for keywords
                        String[] test = charForm.getKeywordInput().split(",");
                        ArrayList<String> words = new ArrayList<>();
                        for(String word : test){
                            words.add(word.trim());
                        }
                        
                    newChar.setKeywords(words);

                    // Clear the input fields of the character form
                    charForm.clearInputFields();
                    
                    
                    // Return control and visibility to the main form
                    formsState = FormsState.MAIN;
                }
                
                    
            } else if(btnText.toLowerCase().contains("cancel")){
                formsState = FormsState.MAIN;
            }
            
        }
        
        public boolean isCharFormComplete(){
            if(charForm.getNameInput().isEmpty() || 
                    charForm.getNameInput().length() <= 0)
                return false;
            if(charForm.getKeywordInput().isEmpty() ||
                    charForm.getKeywordInput().length() <= 0)
                return false;
            if(charForm.getDescriptionInput().isEmpty() || 
                    charForm.getDescriptionInput().length() <= 0)
                return false;
            
            
            return true;
        
            
        }
    }
        
}
    
    
    

