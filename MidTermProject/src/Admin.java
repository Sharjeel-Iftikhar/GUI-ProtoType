

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aadi
 */
import java.util.*;
import javax.swing.JOptionPane;
public class Admin {
    private String userName;
    private String passWord;
    private List<Courses>CourseList = new ArrayList<>();
    private List<Teacher>TeachList = new ArrayList<>();
    private static Admin admin;
   
    /**
     * Singleton constructor
     */
    private Admin()
    {
        
    }
    /**
     * Method to create the object
     */
    public static Admin getInstance()
    {
        if(admin==null)
        {
            admin = new Admin();
            return admin;
        }
        return admin;
    }
    /**
     * Getter for the Admin UserName
     * @return return String userName
     */
    public String getUserName()
    {
        return userName;
    }
    /**
     * Getter for the  Admin Password
     * @return return String password
     */
    public String getPassWord()
    {
        return passWord;
    }
    /**
     * Setter for username
     * @param String user
     */
    public void setUserName(String uss)
    {
        this.userName = uss;
    }
    /**
     * Setter for Password
     * @param String pass
     */
    public void setPassword(String pass)
    {
        this.passWord = pass;
    }
    /**
     * Getter for the CourseList
     * @return List of Courses
     */
    public List<Courses>getCList()
    {
        return CourseList;
    }
    /**
     * Getter for the TeacherList
     * @return List of Teachers
     */
    public List<Teacher>getTeachList()
    {
        return TeachList;
    }
    
    
    /**
     * Method to add a course
     * @param Courses c
     */
    public boolean addCourse(Courses c)
    {
       boolean flag;
       CourseList.add(c);
        //this.getCList().add(c);
        flag=true;
        return flag;
    }
    /**
     * Method to Edit the Course
     * @param String course_ID
     * @param Courses c
     */
    public boolean editCourse(String course_id,Courses c)
    {
        boolean flag=false;
        int size = this.getCList().size();
        for(int i=0;i<size;i++)
        {
            if(course_id.equals(this.getCList().get(i).getID()))
            {
                this.getCList().set(i, c);
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Method to delete the course
     * @param String course_id
     */
    public boolean deleteCourse(String course_id)
    {
        boolean flag=false;
        int size = this.getCList().size();
        for(int i=0;i<size;i++)
        {
            if(course_id.equals(this.getCList().get(i).getID()))
            {
                this.getCList().remove(i);
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Method to Add Student in the course
     * @param Student std
     * @param String course_Id
     */
    public boolean addStd(Student std,String course_id)
    {
        boolean flag = false;
         int size = this.getCList().size();
        for(int i=0;i<size;i++)
        {
            if(course_id.equals(this.getCList().get(i).getID()))
            {       
                this.getCList().get(i).getStdList().add(std);
                  flag = true;
            }
        }
        return flag;
    }
    /**
     * Method to Edit the Student info
     * @param String Reg-NO
     * @param Student st
     */
    public boolean editStd(Student st,String regno)
    {
        boolean flag = false;
        int size = this.getCList().size();
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<CourseList.get(i).getStdList().size();j++)
            {
                if(regno.equals(CourseList.get(i).getStdList().get(j).getReg_No()))
                {
                    CourseList.get(i).getStdList().set(j, st);
                    flag = true;
                }
            }
        }
        return flag;
    }
    /**
     * Method to add teacher and assign course
     * @param Teacher tech
     */
    public boolean AssignTeacher(String cour)
    {
        Courses  course = new Courses();
        boolean flag  = false;
        for(int j=0;j<CourseList.size();j++)
        {
            if(cour.equals(CourseList.get(j).getID()))
            {
                 
                course.setID(CourseList.get(j).getID());
                course.setCrdHrs(CourseList.get(j).getCredHrs());
                course.setDept(CourseList.get(j).getDept());
                course.setTitle(CourseList.get(j).getTitle());
                course.setStdList(CourseList.get(j).getStdList());
                
            }
            
        }
        int s = admin.getTeachList().size();
        for(int i=0;i<admin.getTeachList().size();i++)
        {
            //if(cnic.equals(admin.getTeachList().get(i).getCNIC()))
            //{
                if(TeachList.get(i).getCList().isEmpty())
                {
                    TeachList.get(i).getCList().add(course);
                    flag=true;
                    return flag;
                  //  addTeacherinfo();
                }
                else
                {
                    for(int k=0;k<TeachList.get(i).getCList().size();k++)
                    {
                      if(cour.equals(TeachList.get(i).getCList().get(k).getID()))
                      {
                          flag = false;
                        //  
                          s = s+1;
                          break;
                          
                      }
                      else
                      {
                       TeachList.get(i).getCList().add(course); 
                       flag = true;
                       return flag;
                      
                      }
                    }
                    break;
                }
            //}
        }   
        return flag;
    }
    /**
     * Method to add CLo in course
     * @param String courseId
     */
    public boolean AddClo(String course,CLO clo)
    {
        boolean flag = false;
        for(int i=0;i<CourseList.size();i++)
        {
            if(course.equals(CourseList.get(i).getID()))
            {
                CourseList.get(i).getCloList().add(clo);
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Method to Edit CLo of course
     * @param String courseId
     * @param CLO clO
     * @param String CLONO
     */
    public boolean EDitClo(String course,CLO clo,String CLONO)
    {
        boolean flag = false;
        for(int i=0;i<CourseList.size();i++)
        {
            if(course.equals(CourseList.get(i).getID()))
            {
                for(int j=0;j<CourseList.get(i).getCloList().size();j++)
                {
                    if(CLONO.equals(CourseList.get(i).getCloList().get(j).getCLONO()))
                    {
                        CourseList.get(i).getCloList().set(j, clo);
                        flag = true;
                    }
                }
                
            }
        }
        return flag;
    }
    /**
     * method to delete CLO
     * @param String CLO-No
     */
    public boolean deleteCLO(String CLONO)
    {
        boolean flag = false;
        for(int i=0;i<CourseList.size();i++)
        {
            for(int j=0;j<CourseList.get(i).getCloList().size();j++)
            {
                if(CLONO.equals(CourseList.get(i).getCloList().get(j).getCLONO()))
                {
                    CourseList.get(i).getCloList().remove(j);
                    flag = true;
                }
            }
        }
        return flag;
    }
}
