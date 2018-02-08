/*
 * Developer:  Aaron Pierdon
 * Date:       Jan 27, 2018
Expression licensePrefx is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.Description: This class/file
 */

package controllers;

import java.io.File;
import java.io.IOException;


public class SaveFileController {

    
    
    public boolean saveFile(File targetFile){
        try{
            System.out.println(targetFile.getAbsoluteFile() + ".obj");
            
            
            return targetFile.createNewFile();
        }catch(IOException e){
            return false;
        }
            

    }
}
