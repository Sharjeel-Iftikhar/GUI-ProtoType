
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aadi
 */
public class Teacher {
    private String TName;
    private String email;
    private String Password;
    private String CNIC;
    private List<Courses>AssCourses = new ArrayList<>();
    
    /**
     * Constructor to save the info
     * @param String tName
     * @param  String  email
     * @param String password
     * @param Strig CNIC
     */
    public Teacher(String tName,String email,String password,String cnic)
    {
        this.TName = tName;
        this.email = email;
        this.Password = password;
        this.CNIC = cnic;
    }
    /**
     * Getter for the TName
     * @return method return String (TName)
     */
    public String getTName()
    {
         return TName;
    }
        /**
     * Getter for the email
     * @return method return String (email)
     */
    public String getEmail()
    {
         return email;
    }
        /**
     * Getter for the password
     * @return method return String (password)
     */
    public String getPassword()
    {
         return Password;
    }
        /**
     * Getter for the CNIC
     * @return method return String (CNCI)
     */
    public String getCNIC()
    {
         return CNIC;
    }
    /**
     * Getter for the CourseList
     * @return List of Courses
     */
    public List<Courses>getCList()
    {
        return AssCourses;
    }
    public Teacher()
    {
        
    }
}
