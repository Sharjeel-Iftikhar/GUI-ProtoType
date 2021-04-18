
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
public class Courses {
    private String CourseTitle;
    private String Course_ID;
    private int Cred_Hrs;
    private String Dept;
    private List<Student>StdList = new ArrayList<>();
    private List<CLO>CloList = new ArrayList<>();
    public Courses(String title,String id,int CredHrs,String Dept)
    {
        this.CourseTitle = title;
        this.Course_ID = id;
        this.Cred_Hrs = CredHrs;
        this.Dept = Dept;
    }
 //   private static Courses course;
//    /**
//     * Singleton Constructor
//     */
//    private Courses()
//    {
//        
//    }
//    /**
//     * Method to form the new object
//     */
//    public static Courses getCourse()
//    {
//        if(course == null)
//        {
//            course = new Courses();
//            return course;
//        }
//        return course;
//    }
    /**
     * Getter for the StudentList
     * @return List of Students
     */
    public List<Student>getStdList()
    {
        return StdList;
    }
    /**
     * Getter for the CloList
     * @return List of CLO
     */
    public List<CLO>getCloList()
    {
        return CloList;
    }
    
    /**
     * Getter for the CourseTitle
     * @return return Title
     */
    public String getTitle()
    {
        return CourseTitle;
    }
    /**
     * Getter for the Course_ID
     * @return return ID
     */
    public String getID()
    {
        return Course_ID;
    }
    /**
     * Getter for the Cred_Hrs
     * @return return credHrs
     */
    public int getCredHrs()
    {
        return Cred_Hrs;
    }
    /**
     * Getter for the Dept
     * @return return dept
     */
    public String getDept()
    {
        return Dept;
    }
    /**
     * Setter for the Course_title
     * @param  String title
     */
    public void setTitle(String title)
    {
        this.CourseTitle = title;
    }
    /**
     * Setter for the Course_ID
     * @param  String id
     */
    public void setID(String id)
    {
        this.Course_ID = id;
    }
    /**
     * Setter for the CredHrs
     * @param  int hrs
     */
    public void setCrdHrs(int hrs)
    {
        this.Cred_Hrs = hrs;
    }
    /**
     * Setter for the Dept
     * @param  String dept
     */
    public void setDept(String dept)
    {
        this.Dept = dept;
    }
    /**
     * default constructor
     */
    public Courses()
    {
        
    }
    /**
     * Setter for the StdList
     * @param Student std
     */
    public void setStdList(List<Student>list )
    {
        StdList.addAll(list);
    }
}
