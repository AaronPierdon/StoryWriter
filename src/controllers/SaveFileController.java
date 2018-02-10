/*
 * Developer:  Aaron Pierdon
 * Date:       Jan 27, 2018
 * Description:

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
