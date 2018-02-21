/**
 * Developer:       Aaron Pierdon
 * 
 * Description:     Abstract class that can be directly called to serialize an 
 *                  object.
 * 
 * Date:            9/13/2017
 */
package utility.fileUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public abstract class Serializer{
    

    
    //uses a directory location referenced by saveTarget to serialize the 
    //object parameter and save it to an .object file.
    public static void serialize(String saveTarget, Object object, Boolean overwrite){
     
        
            try{
            File file = new File(saveTarget);
            
            if(file.exists()){
                if(overwrite == true){
                    System.out.println("Overwriting File");
                    file.delete();
                    FileOutputStream fs = new FileOutputStream(saveTarget);
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    
                        os.writeObject(object);
                        os.flush();
                        os.close();
                }
                
            }else{
                System.out.println("Writing New File");
                FileOutputStream fs = new FileOutputStream(saveTarget);
                ObjectOutputStream os = new ObjectOutputStream(fs);
                
                os.writeObject(object);
                os.flush();
                os.close();
            }

            

         
            
        }catch(Exception e){
        }

    }
    
    //uses a directory location referenced by savetarget to find and 
    //deserialize an object in the .object file pointed to by that saveTarget 
    //reference. Returns Object. Caller must provide the directory + the filename +
    //fileType. Also, the caller must cast the returned object to the 
    //appropriate type.
    public static Object deserialize(String saveTarget){
        
        try{
            FileInputStream fs = new FileInputStream(saveTarget);
            ObjectInputStream os = new ObjectInputStream(fs);

            return os.readObject();
            
        }catch(Exception e){
            return null;
        }
    }
    

    
}
