
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
public class Student {
    private String FirstName;
    private String LastName;
    private String Reg_No;
    private String Gender;
  //  private List<Courses>CourList = new ArrayList<>();
    
    /**
     * Constructor to initialize (save)values
     */
    public Student(String fname,String lname,String regNo,String gender)
    {
        this.FirstName = fname;
        this.LastName = lname;
        this.Reg_No = regNo;
        this.Gender = gender;
    }
    /**
     * Default Constructor
     */
    public Student()
    {
        
    }
    
    /**
     * Getter for FName
     * @return method return String
     */
    public String getFirstName()
    {
        return FirstName;
    }
    /**
     * Getter for lastName
     * @return method return String
     */
    public String getLasttName()
    {
        return LastName;
    }
    /**
     * Getter for Reg_No
     * @return method return String
     */
    public String getReg_No()
    {
        return Reg_No;
    }
    /**
     * Getter for Gender
     * @return method return String
     */
    public String getGender()
    {
        return Gender;
    }
    /**
     * Setter for the FirstName
     * @param String fName
     */
    public void setFirstName(String fName)
    {
        this.FirstName = fName;
    }
    /**
     * Setter for the LastName
     * @param String lName
     */
    public void setLastName(String lName)
    {
        this.LastName = lName;
    }
    /**
     * Setter for the Reg_No
     * @param String regno
     */
    public void setRegNo(String regno)
    {
        this.Reg_No= regno;
    }
    /**
     * Setter for the Gender
     * @param String gender
     */
    public void setGender(String gender)
    {
        this.Gender = gender;
    }
    
//    public List<Courses> getCourse()
//    {
//        return CourList;
//    }
}
