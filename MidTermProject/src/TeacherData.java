
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aadi
 */
public class TeacherData {
   // Admin admin = Admin.getInstance();
    public List<Teacher>Teacherlist = new ArrayList<>();
     private static TeacherData teach;
    
    /**
     * Singleton Constructor
     */
    private TeacherData()
    {
        
    }
    /**
     * Method to form the object
     */
    public static TeacherData getTeachInstance()
    {
        if(teach==null)
        {
            teach = new TeacherData();
        }
        return teach;
    }
    
}
