
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
public class CLO {
    private String CloNO;
    private String CloDetails;
    private List<Rubrics>RubList = new ArrayList<>();
    
    /**
     * Constructor to save the value
     */
    public CLO(String cloNo,String details)
    {
        this.CloNO = cloNo;
        this.CloDetails = details;
    }
    /**
     * Getter for the CLONO
     * @return Method return String (CloNo)
     */
    public String getCLONO()
    {
        return CloNO;
    }
    /**
     * Getter for the CLODetails
     * @return Method return String (CloDetails)
     */
    public String getCloDetails()
    {
        return CloDetails;
    }
    /**
     * Getter for RubList
     * @return method return RubList
     */
    public List<Rubrics>getRubList()
    {
      return RubList;      
    }
}
    
