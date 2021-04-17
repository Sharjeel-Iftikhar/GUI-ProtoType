
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aadi
 */
import javax.swing.table.DefaultTableModel;
public class AdminMenuForm extends javax.swing.JFrame {
    Admin admin = Admin.getInstance();
    Student st;
    Courses course;
    DefaultTableModel model;
    List<String>list= new ArrayList<>();
/**
 * method to clear the textFields
 */
    public void Clear() {
        TitleField.setText("");
        IDField.setText("");
        textField7.setText("");
        textField8.setText("");
    }
    /**
     * Method to add rows in table
     */
    public void addRow()
    {
        
        this.model = new DefaultTableModel();
        model.addColumn("Title");
        model.addColumn("Course_ID");
        model.addColumn("Cred_Hrs");
        model.addColumn("Dept");
        jTable1.setModel(model);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int size = admin.getCList().size();
         Object rowData[] = new Object[4];
         for(int i=0;i<size;i++)
         {
             rowData[0] = admin.getCList().get(i).getTitle();
             rowData[1] = admin.getCList().get(i).getID();
             rowData[2] = admin.getCList().get(i).getCredHrs();
             rowData[3] = admin.getCList().get(i).getDept();
             model.addRow(rowData);
         }
    }
     public void ViewAll()
    {
        
        this.model = new DefaultTableModel();
        model.addColumn("Sr.No");
        model.addColumn("Title");
        model.addColumn("Course_ID");
        model.addColumn("Cred_Hrs");
        model.addColumn("Dept");
        jTable3.setModel(model);
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int size = admin.getCList().size();
         Object rowData[] = new Object[5];
         for(int i=0;i<size;i++)
         {
             rowData[0] = i+1;
             rowData[1] = admin.getCList().get(i).getTitle();
             rowData[2] = admin.getCList().get(i).getID();
             rowData[3] = admin.getCList().get(i).getCredHrs();
             rowData[4] = admin.getCList().get(i).getDept();
             model.addRow(rowData);
         }
    }
     public void addTeacherinfo()
     {
        String cnic = TECNIC.getSelectedItem();
          this.model = new DefaultTableModel();
                        model.addColumn("TeacherName");
                        model.addColumn("CNIC");
                        model.addColumn("Email");
                        model.addColumn("Password");
                        model.addColumn("Course");
                        TeacherAddTable.setModel(model);
                        DefaultTableModel model = (DefaultTableModel) TeacherAddTable.getModel();
                        Object rowData[] = new Object[5];
                        for(int i=0;i<admin.getTeachList().size();i++)
                {
                    if(cnic.equals(admin.getTeachList().get(i).getCNIC()))
                    {
                      for(int t=0;t<admin.getTeachList().get(i).getCList().size();t++)
                       {
                         rowData[0] = admin.getTeachList().get(i).getTName();
                         rowData[1] = admin.getTeachList().get(i).getCNIC();
                         rowData[2] = admin.getTeachList().get(i).getEmail();
                         rowData[3] = admin.getTeachList().get(i).getPassword();
                         rowData[4] = admin.getTeachList().get(i).getCList().get(t).getID();
                         model.addRow(rowData);
                       }
                    }
                }
     }
    /**
     * Method to Clear Students panel
     */
     public void ClearStd()
     {
        FnameField.setText("");
        LastNameField.setText("");
        RegNoField.setText("");
        jRadioButton1.removeAll();
     }
     
     public void disapper()
     {
         ADDPANEL.setVisible(false);
//         courseIDLbL.setVisible(false);
//         choice3.setVisible(false);
//         CLOLBL.setVisible(false);
//         textField2.setVisible(false);
//         label25.setVisible(false);
//         //jTextArea1.setVisible(false);
//         button13.setVisible(false);
//         jTable7.setVisible(false);
         EDITBTN.setVisible(false);
         DELETEBTN.setVisible(false);
         jPanel7.setVisible(false);
         textField3.setVisible(false);
            
//         textArea1.setVisible(false);
         
     }
     public void AddAppear()
     {
          ADDPANEL.setVisible(true);
         courseIDLbL.setVisible(true);
         textField2.setVisible(true);
         choice3.setVisible(true);
         CLOLBL.setVisible(true);
         label25.setVisible(true);
         textArea1.setVisible(true);
         button13.setVisible(true);
     }
     
     public void AddCLOTable()
     {
         String course = choice3.getSelectedItem();
         this.model = new DefaultTableModel();
                 model.addColumn("Course-ID");
                 model.addColumn("CLO-NO");
                 model.addColumn("Details");
                 CLOTABLE.setModel(model);
                 DefaultTableModel model = (DefaultTableModel) CLOTABLE.getModel();
                Object rowData[] = new Object[3];
                 Courses co =new Courses();
//                 int size=co.getCloList().size();
//                 JOptionPane.showMessageDialog(null, size);
                 for(int i=0;i<admin.getCList().size();i++)
                 {
                    if(course.equals(admin.getCList().get(i).getID()))
                    {
                        for(int j=0;j<admin.getCList().get(i).getCloList().size();j++)
                        {
                            rowData[0] = admin.getCList().get(i).getID();
                            rowData[1] = admin.getCList().get(i).getCloList().get(j).getCLONO();
                            rowData[2] = admin.getCList().get(i).getCloList().get(j).getCloDetails();
                            model.addRow(rowData);
                        }
                    }
                 }
     }
     
     public void SaveData()
     {
         String SaveID=SaveDataChoice.getSelectedItem();
         try
         {
             FileWriter obj = new FileWriter("course.txt");
             String line = "";
             boolean flag = false;
             if(admin.getCList().isEmpty())
             {
                 JOptionPane.showMessageDialog(null,"File is Empty...");
             }
             else
             {
                 for(int i=0;i<admin.getCList().size();i++)
                 {
                     if(SaveID.equals(admin.getCList().get(i).getID()))
                     {
                         line = line + admin.getCList().get(i).getTitle()+"-";
                      line = line + admin.getCList().get(i).getDept()+"-";
                       line = line + admin.getCList().get(i).getCredHrs()+"-";
                     line = line + admin.getCList().get(i).getID()+"/";
                     //}
                     
                     if(! (admin.getCList().get(i).getCloList().isEmpty()) )
                     {
                         for(int j=0;j<admin.getCList().get(i).getCloList().size();j++)
                     {
                     
                     line = line + admin.getCList().get(i).getCloList().get(j).getCLONO()+"+";
                     line = line + admin.getCList().get(i).getCloList().get(j).getCloDetails()+"/";
                     }
                     }
                     if(  !(admin.getCList().get(i).getStdList().isEmpty() ) )
                     {
                        for(int k=0;k<admin.getCList().get(i).getStdList().size();k++)
                     {
                     line = line + admin.getCList().get(i).getStdList().get(k).getFirstName()+":";
                     line = line + admin.getCList().get(i).getStdList().get(k).getLasttName()+":";
                     line = line + admin.getCList().get(i).getStdList().get(k).getReg_No()+":";
                     line = line + admin.getCList().get(i).getStdList().get(k).getGender()+":"+"\n";
                     } 
                     }
                     
                 }
//                     obj.write(line);
//                     obj.flush();
//                     obj.close();
                 }
                 obj.write(line);
                     obj.flush();
                     obj.close();
                 
                 
               JOptionPane.showMessageDialog(null,"File saved successfuly!!!");
             }
         }
         catch(Exception ex)
         {
            // throw e;
         }
     }
     
     
     
    /**
     * Creates new form AdminMenuForm
     */
    public AdminMenuForm() {
        initComponents();
        disapper();
        this.setLocationRelativeTo(null);
        MainPanel.setSelectedIndex(-1);
        String uss = admin.getUserName();
        String []arr = uss.split(".uet");
        UserNameLBL.setText(arr[0]);
        SaveDataChoice.setVisible(false);
        button1.setVisible(false);
       // list1.setVisible(false);
        
//        try
//        {
//            FileReader obj = new FileReader("course.txt");
//            BufferedReader bf = new BufferedReader(obj);
//            String line = "0";
//            while(line!=null)
//            {
//                line = bf.readLine();
//                String[]arry = line.split("/");
//                int size = arry.length;
//                if(size==1)
//                {
//                    String []arr1 =arry[0].split("-");
//                    String title = arr1[0];
//                    String dep = arr1[1];
//                    String cre = arr1[2];
//                    int credH = Integer.parseInt(cre);
//                    String ID = arr1[3];
//                    course = new Courses(title,ID,credH,dep);
//                    admin.getCList().add(course);
//                    
//                }
//               else if(size==2)
//                {
//                    String []arr1 =arry[0].split("-");
//                    String []arr2 = arry[1].split("+");
//                    String title = arr1[0];
//                    String dep = arr1[1];
//                    String cre = arr1[2];
//                    int credH = Integer.parseInt(cre);
//                    String ID = arr1[3];
//                    course = new Courses(title,ID,credH,dep);
//                    admin.getCList().add(course);
////                    String fname = arr2[0];
////                    String lname = arr2[1];
////                    String regno = arr2[2];
////                    String gender = arr2[3];
////                    st = new Student(fname,lname,regno,gender);
////                    for(int i=0;i<admin.getCList().size();i++)
////                    {
////                        if(ID.equals(admin.getCList().get(i).getID()))
////                        {
////                            admin.getCList().get(i).getStdList().add(st);
////                        }
////                    }
//                }
//                bf.close();
//                obj.close();
//            }
//        }
//        catch(Exception ex)
//        {
//            
//        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        UserNameLBL = new java.awt.Label();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SaveDataChoice = new java.awt.Choice();
        button1 = new java.awt.Button();
        MenuPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ManageCourseBTN = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ManageTEACHERBTN = new java.awt.Button();
        jPanel5 = new javax.swing.JPanel();
        ManageSTUDENTBTN = new java.awt.Button();
        jLabel4 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JTabbedPane();
        ManageCoursePanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        CreatePnel = new javax.swing.JPanel();
        IDField = new java.awt.TextField();
        label6 = new java.awt.Label();
        TitleField = new java.awt.TextField();
        textField7 = new java.awt.TextField();
        textField8 = new java.awt.TextField();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        button5 = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        EditPanel = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        textField1 = new java.awt.TextField();
        label3 = new java.awt.Label();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();
        button15 = new java.awt.Button();
        ViewAll = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        AddCloLBL = new javax.swing.JLabel();
        EDitCLOLBL = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        EDITBTN = new java.awt.Button();
        DELETEBTN = new java.awt.Button();
        jScrollPane10 = new javax.swing.JScrollPane();
        CLOTABLE = new javax.swing.JTable();
        textField3 = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        ADDPANEL = new javax.swing.JPanel();
        button13 = new java.awt.Button();
        label25 = new java.awt.Label();
        textArea1 = new java.awt.TextArea();
        CLOLBL = new java.awt.Label();
        textField2 = new java.awt.TextField();
        choice3 = new java.awt.Choice();
        courseIDLbL = new java.awt.Label();
        ManageTeacherPanel = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        label17 = new java.awt.Label();
        label19 = new java.awt.Label();
        button4 = new java.awt.Button();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TeacherAddTable = new javax.swing.JTable();
        label26 = new java.awt.Label();
        CourseChoice = new java.awt.Choice();
        TeacherNAmeChoice = new java.awt.Choice();
        TECNIC = new java.awt.Choice();
        jPanel8 = new javax.swing.JPanel();
        label24 = new java.awt.Label();
        TNameField1 = new java.awt.TextField();
        label27 = new java.awt.Label();
        CNICField1 = new java.awt.TextField();
        label28 = new java.awt.Label();
        EmailField1 = new java.awt.TextField();
        PassField1 = new java.awt.TextField();
        label29 = new java.awt.Label();
        button9 = new java.awt.Button();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        UNASSIGNPANEL = new javax.swing.JPanel();
        label21 = new java.awt.Label();
        label22 = new java.awt.Label();
        label23 = new java.awt.Label();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        UNASSIGNBTN = new java.awt.Button();
        TeacherChoice = new java.awt.Choice();
        CourseID = new java.awt.Choice();
        ManageStudentsPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        AddStdPanel = new javax.swing.JPanel();
        label5 = new java.awt.Label();
        FnameField = new java.awt.TextField();
        LastNameField = new java.awt.TextField();
        label10 = new java.awt.Label();
        RegNoField = new java.awt.TextField();
        label11 = new java.awt.Label();
        label12 = new java.awt.Label();
        choice1 = new java.awt.Choice();
        label13 = new java.awt.Label();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        button8 = new java.awt.Button();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        EDitPAnel = new javax.swing.JPanel();
        label14 = new java.awt.Label();
        SearchREGField = new java.awt.TextField();
        label15 = new java.awt.Label();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        jLabel3 = new javax.swing.JLabel();
        ViewALLPAnel = new javax.swing.JPanel();
        label16 = new java.awt.Label();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        choice2 = new java.awt.Choice();
        button14 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 85, 85));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("                 Admin's Page");

        UserNameLBL.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        UserNameLBL.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sign-out-50.png"))); // NOI18N
        jLabel6.setText("Log Out");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cross-mark-48.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-save-48.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        SaveDataChoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveDataChoiceMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SaveDataChoiceMousePressed(evt);
            }
        });

        button1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        button1.setLabel("SAVE");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                        .addComponent(SaveDataChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserNameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(236, 236, 236))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaveDataChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(UserNameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(13, 13, 13))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, -1));

        MenuPanel.setBackground(new java.awt.Color(238, 217, 217));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-course-assign-50 (2).png"))); // NOI18N

        ManageCourseBTN.setBackground(new java.awt.Color(31, 85, 85));
        ManageCourseBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        ManageCourseBTN.setForeground(new java.awt.Color(255, 255, 255));
        ManageCourseBTN.setLabel("Manage Courses");
        ManageCourseBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageCourseBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ManageCourseBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(ManageCourseBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-teacher-50.png"))); // NOI18N

        ManageTEACHERBTN.setBackground(new java.awt.Color(31, 85, 85));
        ManageTEACHERBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        ManageTEACHERBTN.setForeground(new java.awt.Color(255, 255, 255));
        ManageTEACHERBTN.setLabel("Manage Teachers");
        ManageTEACHERBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageTEACHERBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ManageTEACHERBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addComponent(ManageTEACHERBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ManageSTUDENTBTN.setBackground(new java.awt.Color(31, 85, 85));
        ManageSTUDENTBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        ManageSTUDENTBTN.setForeground(new java.awt.Color(255, 255, 255));
        ManageSTUDENTBTN.setLabel("Manage Students");
        ManageSTUDENTBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageSTUDENTBTNActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-student-registration-50.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ManageSTUDENTBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 11, Short.MAX_VALUE))
            .addComponent(ManageSTUDENTBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(MenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 93, 224, 461));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });

        CreatePnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreatePnelMouseEntered(evt);
            }
        });

        label6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label6.setText("Title");

        label7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label7.setText("Course-ID");

        label8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label8.setText("Cred-Hors");

        label9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label9.setText("Depat.");

        button5.setBackground(new java.awt.Color(31, 85, 85));
        button5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setLabel("ADD");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title ", "Course-ID", "Cred-Hours", "Depart."
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CreatePnelLayout = new javax.swing.GroupLayout(CreatePnel);
        CreatePnel.setLayout(CreatePnelLayout);
        CreatePnelLayout.setHorizontalGroup(
            CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePnelLayout.createSequentialGroup()
                .addGroup(CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CreatePnelLayout.createSequentialGroup()
                        .addGroup(CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CreatePnelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        CreatePnelLayout.setVerticalGroup(
            CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePnelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(CreatePnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(CreatePnelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("     Create    ", CreatePnel);

        label2.setBackground(new java.awt.Color(31, 85, 85));
        label2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("              EDIT COURSE");

        label3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label3.setText("Enter ID");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Course-ID", "Cred-Hrs", "Depart."
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        button6.setBackground(new java.awt.Color(31, 85, 85));
        button6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setLabel("DELETE");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button7.setBackground(new java.awt.Color(31, 85, 85));
        button7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        button7.setForeground(new java.awt.Color(255, 255, 255));
        button7.setLabel("EDIT");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button15.setBackground(new java.awt.Color(31, 85, 85));
        button15.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        button15.setForeground(new java.awt.Color(255, 255, 255));
        button15.setLabel("OK");
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditPanelLayout = new javax.swing.GroupLayout(EditPanel);
        EditPanel.setLayout(EditPanelLayout);
        EditPanelLayout.setHorizontalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPanelLayout.createSequentialGroup()
                .addGroup(EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditPanelLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EditPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        EditPanelLayout.setVerticalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EditPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(button15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("    Edit or Delete    ", EditPanel);

        ViewAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewAllMouseEntered(evt);
            }
        });

        label4.setBackground(new java.awt.Color(31, 85, 85));
        label4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("     DETILS OF ALL COURSES");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sr.No", "Title", "Course-ID", "Cred-HRs", "Depart."
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout ViewAllLayout = new javax.swing.GroupLayout(ViewAll);
        ViewAll.setLayout(ViewAllLayout);
        ViewAllLayout.setHorizontalGroup(
            ViewAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewAllLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewAllLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        ViewAllLayout.setVerticalGroup(
            ViewAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewAllLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("     View All    ", ViewAll);

        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(30, 83, 83));

        AddCloLBL.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        AddCloLBL.setForeground(new java.awt.Color(255, 255, 255));
        AddCloLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-add-property-64 (3).png"))); // NOI18N
        AddCloLBL.setText("ADD");
        AddCloLBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddCloLBLMousePressed(evt);
            }
        });

        EDitCLOLBL.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        EDitCLOLBL.setForeground(new java.awt.Color(255, 255, 255));
        EDitCLOLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-edit-64 (1).png"))); // NOI18N
        EDitCLOLBL.setText("EDIT");
        EDitCLOLBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EDitCLOLBLMousePressed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(30, 83, 83));

        EDITBTN.setBackground(new java.awt.Color(30, 83, 83));
        EDITBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        EDITBTN.setForeground(new java.awt.Color(255, 255, 255));
        EDITBTN.setLabel("EDIT");
        EDITBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITBTNActionPerformed(evt);
            }
        });

        DELETEBTN.setBackground(new java.awt.Color(30, 83, 83));
        DELETEBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        DELETEBTN.setForeground(new java.awt.Color(255, 255, 255));
        DELETEBTN.setLabel("DELETE");
        DELETEBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEBTNActionPerformed(evt);
            }
        });

        CLOTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(CLOTABLE);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(EDITBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(DELETEBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EDITBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(DELETEBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        textField3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        textField3.setForeground(new java.awt.Color(255, 51, 51));
        textField3.setText("CLO-NO to edit or Delete");
        textField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textField3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textField3MouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-search-50.png"))); // NOI18N

        ADDPANEL.setBackground(new java.awt.Color(30, 83, 83));

        button13.setBackground(new java.awt.Color(30, 83, 83));
        button13.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        button13.setForeground(new java.awt.Color(255, 255, 255));
        button13.setLabel("ASSIGN");
        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button13ActionPerformed(evt);
            }
        });

        label25.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        label25.setForeground(new java.awt.Color(255, 255, 255));
        label25.setText("CLO DETAILS");

        CLOLBL.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        CLOLBL.setForeground(new java.awt.Color(255, 255, 255));
        CLOLBL.setText("CLO-NO");

        courseIDLbL.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        courseIDLbL.setForeground(new java.awt.Color(255, 255, 255));
        courseIDLbL.setText("Course-ID");

        javax.swing.GroupLayout ADDPANELLayout = new javax.swing.GroupLayout(ADDPANEL);
        ADDPANEL.setLayout(ADDPANELLayout);
        ADDPANELLayout.setHorizontalGroup(
            ADDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADDPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ADDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ADDPANELLayout.createSequentialGroup()
                        .addComponent(courseIDLbL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(choice3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ADDPANELLayout.createSequentialGroup()
                        .addComponent(CLOLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADDPANELLayout.createSequentialGroup()
                        .addComponent(label25, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ADDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        ADDPANELLayout.setVerticalGroup(
            ADDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADDPANELLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(ADDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(choice3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseIDLbL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(ADDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CLOLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(ADDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADDPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(AddCloLBL)
                .addGap(112, 112, 112)
                .addComponent(EDitCLOLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddCloLBL)
                        .addComponent(EDitCLOLBL))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADDPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 414, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("    Manage CLO's Of Course ", jPanel14);

        javax.swing.GroupLayout ManageCoursePanelLayout = new javax.swing.GroupLayout(ManageCoursePanel);
        ManageCoursePanel.setLayout(ManageCoursePanelLayout);
        ManageCoursePanelLayout.setHorizontalGroup(
            ManageCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageCoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        ManageCoursePanelLayout.setVerticalGroup(
            ManageCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageCoursePanelLayout.createSequentialGroup()
                .addGap(0, 109, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MainPanel.addTab("tab1", ManageCoursePanel);

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N

        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
        });

        label17.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label17.setText("TeacherName");

        label19.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label19.setText("  Course");

        button4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        button4.setLabel("ASSIGN");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        TeacherAddTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "TeacherName", "Email", "Password", "Title 4", "Title 5"
            }
        ));
        jScrollPane7.setViewportView(TeacherAddTable);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        label26.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label26.setText("   CNIC");

        CourseChoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CourseChoiceMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CourseChoiceMousePressed(evt);
            }
        });

        TeacherNAmeChoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TeacherNAmeChoiceMousePressed(evt);
            }
        });

        TECNIC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TECNICMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CourseChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(TeacherNAmeChoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TECNIC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(35, 35, 35)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TeacherNAmeChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TECNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(CourseChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("      ASSIGN     ", jPanel11);

        jPanel8.setBackground(new java.awt.Color(26, 92, 129));

        label24.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label24.setForeground(new java.awt.Color(255, 255, 255));
        label24.setText("TeacherName");

        label27.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label27.setForeground(new java.awt.Color(255, 255, 255));
        label27.setText("   CNIC");

        CNICField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CNICField1MousePressed(evt);
            }
        });

        label28.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label28.setForeground(new java.awt.Color(255, 255, 255));
        label28.setText("   Email");

        label29.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label29.setForeground(new java.awt.Color(255, 255, 255));
        label29.setText("  Password");

        button9.setBackground(new java.awt.Color(26, 92, 129));
        button9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        button9.setForeground(new java.awt.Color(255, 255, 255));
        button9.setLabel("ADD");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(26, 92, 129));

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(jTable7);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label28, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TNameField1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(CNICField1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(PassField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmailField1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CNICField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PassField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jTabbedPane3.addTab("   ADD  TEACHER ", jPanel8);

        UNASSIGNPANEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UNASSIGNPANELMouseEntered(evt);
            }
        });

        label21.setBackground(new java.awt.Color(31, 85, 85));
        label21.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        label21.setForeground(new java.awt.Color(255, 255, 255));
        label21.setText("      Delete Course");

        label22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label22.setText("  TeacherName");

        label23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label23.setText("Course-ID");

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "TeacherName", "Course-ID", "UserName", "Paswword", "CNIC"
            }
        ));
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable8MouseEntered(evt);
            }
        });
        jScrollPane8.setViewportView(jTable8);

        UNASSIGNBTN.setBackground(new java.awt.Color(31, 85, 85));
        UNASSIGNBTN.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        UNASSIGNBTN.setForeground(new java.awt.Color(255, 255, 255));
        UNASSIGNBTN.setLabel("   UNASSIGN");
        UNASSIGNBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNASSIGNBTNActionPerformed(evt);
            }
        });

        TeacherChoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TeacherChoiceMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TeacherChoiceMousePressed(evt);
            }
        });

        CourseID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CourseIDMousePressed(evt);
            }
        });

        javax.swing.GroupLayout UNASSIGNPANELLayout = new javax.swing.GroupLayout(UNASSIGNPANEL);
        UNASSIGNPANEL.setLayout(UNASSIGNPANELLayout);
        UNASSIGNPANELLayout.setHorizontalGroup(
            UNASSIGNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UNASSIGNPANELLayout.createSequentialGroup()
                .addGroup(UNASSIGNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UNASSIGNPANELLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UNASSIGNPANELLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGroup(UNASSIGNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TeacherChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(CourseID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UNASSIGNPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
            .addGroup(UNASSIGNPANELLayout.createSequentialGroup()
                .addGap(368, 680, Short.MAX_VALUE)
                .addComponent(UNASSIGNBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        UNASSIGNPANELLayout.setVerticalGroup(
            UNASSIGNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UNASSIGNPANELLayout.createSequentialGroup()
                .addGroup(UNASSIGNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UNASSIGNPANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UNASSIGNPANELLayout.createSequentialGroup()
                        .addGroup(UNASSIGNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TeacherChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(UNASSIGNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(UNASSIGNBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("     UNASSIGN    ", UNASSIGNPANEL);

        javax.swing.GroupLayout ManageTeacherPanelLayout = new javax.swing.GroupLayout(ManageTeacherPanel);
        ManageTeacherPanel.setLayout(ManageTeacherPanelLayout);
        ManageTeacherPanelLayout.setHorizontalGroup(
            ManageTeacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        ManageTeacherPanelLayout.setVerticalGroup(
            ManageTeacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageTeacherPanelLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.addTab("tab3", ManageTeacherPanel);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane2MousePressed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label5.setForeground(new java.awt.Color(102, 102, 102));
        label5.setText("FirstName");

        label10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label10.setForeground(new java.awt.Color(102, 102, 102));
        label10.setText("LastName");

        label11.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label11.setForeground(new java.awt.Color(102, 102, 102));
        label11.setText("REG-NO");

        label12.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label12.setForeground(new java.awt.Color(102, 102, 102));
        label12.setText("Courses");

        choice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choice1MouseEntered(evt);
            }
        });

        label13.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label13.setForeground(new java.awt.Color(102, 102, 102));
        label13.setText("Gender");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("MALE");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("FEMALE");

        button8.setBackground(new java.awt.Color(31, 85, 85));
        button8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        button8.setForeground(new java.awt.Color(255, 255, 255));
        button8.setLabel("ADD");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.No", "FirstName", "Reg-No", "Course", "Gender"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddStdPanelLayout = new javax.swing.GroupLayout(AddStdPanel);
        AddStdPanel.setLayout(AddStdPanelLayout);
        AddStdPanelLayout.setHorizontalGroup(
            AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStdPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddStdPanelLayout.createSequentialGroup()
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddStdPanelLayout.createSequentialGroup()
                        .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RegNoField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AddStdPanelLayout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton2)
                                .addGap(24, 24, 24))
                            .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AddStdPanelLayout.setVerticalGroup(
            AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStdPanelLayout.createSequentialGroup()
                .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddStdPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddStdPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddStdPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddStdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2))
                            .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddStdPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("      ADD      ", AddStdPanel);

        EDitPAnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EDitPAnelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EDitPAnelMousePressed(evt);
            }
        });

        label14.setBackground(new java.awt.Color(31, 85, 85));
        label14.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label14.setForeground(new java.awt.Color(255, 255, 255));
        label14.setText("         EDITOR DELETE");

        label15.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        label15.setText("Enter Reg-No");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sr.No", "FirstName", "LastName", "Reg-No", "Course", "Gender"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        button2.setBackground(new java.awt.Color(31, 85, 85));
        button2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("DELETE");

        button3.setBackground(new java.awt.Color(31, 85, 85));
        button3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("EDIT");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-search-50.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout EDitPAnelLayout = new javax.swing.GroupLayout(EDitPAnel);
        EDitPAnel.setLayout(EDitPAnelLayout);
        EDitPAnelLayout.setHorizontalGroup(
            EDitPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EDitPAnelLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchREGField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EDitPAnelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(EDitPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EDitPAnelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EDitPAnelLayout.createSequentialGroup()
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        EDitPAnelLayout.setVerticalGroup(
            EDitPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EDitPAnelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EDitPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchREGField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EDitPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(EDitPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("   EDIT OR DELETE  ", EDitPAnel);

        ViewALLPAnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewALLPAnelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewALLPAnelMousePressed(evt);
            }
        });

        label16.setBackground(new java.awt.Color(31, 85, 85));
        label16.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        label16.setForeground(new java.awt.Color(255, 255, 255));
        label16.setText("                DETAILS OF ALL STUDENTS");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.No", "FirstName", "LastName", "Reg-No", "Course", "Gender"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        choice2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choice2MouseEntered(evt);
            }
        });

        button14.setBackground(new java.awt.Color(31, 85, 85));
        button14.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        button14.setForeground(new java.awt.Color(255, 255, 255));
        button14.setLabel("OK");
        button14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewALLPAnelLayout = new javax.swing.GroupLayout(ViewALLPAnel);
        ViewALLPAnel.setLayout(ViewALLPAnelLayout);
        ViewALLPAnelLayout.setHorizontalGroup(
            ViewALLPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ViewALLPAnelLayout.createSequentialGroup()
                .addGroup(ViewALLPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewALLPAnelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE))
                    .addGroup(ViewALLPAnelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ViewALLPAnelLayout.setVerticalGroup(
            ViewALLPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewALLPAnelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewALLPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label16, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(choice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("   VIEW ALL   ", ViewALLPAnel);

        javax.swing.GroupLayout ManageStudentsPanelLayout = new javax.swing.GroupLayout(ManageStudentsPanel);
        ManageStudentsPanel.setLayout(ManageStudentsPanelLayout);
        ManageStudentsPanelLayout.setHorizontalGroup(
            ManageStudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageStudentsPanelLayout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        ManageStudentsPanelLayout.setVerticalGroup(
            ManageStudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageStudentsPanelLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.addTab("tab2", ManageStudentsPanel);

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -20, 900, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManageCourseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageCourseBTNActionPerformed
        // TODO add your handling code here:
        MainPanel.setSelectedIndex(0);
        choice1.removeAll();
        choice2.removeAll();
        CourseChoice.removeAll();
        SaveDataChoice.setVisible(false);

    }//GEN-LAST:event_ManageCourseBTNActionPerformed

    private void ManageTEACHERBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageTEACHERBTNActionPerformed
        // TODO add your handling code here:
       MainPanel.setSelectedIndex(1);
       choice1.removeAll();
        choice2.removeAll();
        int size = admin.getCList().size();
        for(int i=0;i<size;i++)
        {
            list.add(admin.getCList().get(i).getID());
        }
        
       

    }//GEN-LAST:event_ManageTEACHERBTNActionPerformed

    private void ManageSTUDENTBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageSTUDENTBTNActionPerformed
        // TODO add your handling code here:
        MainPanel.setSelectedIndex(2);
        //choice1.removeAll();
        //choice2.removeAll();
        CourseChoice.removeAll();
        
         

       
        
    }//GEN-LAST:event_ManageSTUDENTBTNActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        String title = TitleField.getText();
        String id = IDField.getText();
        String cred = textField7.getText();
        int CredHrs = Integer.parseInt(cred);
        String dept = textField8.getText();
        course= new Courses(title,id,CredHrs,dept);
        if(button5.getLabel().equals("ADD"))
        {
            boolean flag=admin.addCourse(course);
        if(flag==true)
        {
            addRow();
        }
        }
        else if(button5.getLabel().equals("Update"))
        {
            
        String id1 = textField1.getText();
        String tit = TitleField.getText();
        String idd = IDField.getText();
        String creed = textField7.getText();
        int CredHr = Integer.parseInt(creed);
        String deptt = textField8.getText();
        course= new Courses(tit,idd,CredHr,deptt);
        boolean flag = admin.editCourse(id1, course);
        if(flag==true)
        {
            JOptionPane.showMessageDialog(null,"Updated >>");
            addRow();
            button5.setLabel("ADD");
        }
        }
        
         Clear();
    }//GEN-LAST:event_button5ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // TODO add your handling code here:
        String fname = FnameField.getText();
        String Lname = LastNameField.getText();
        String reg = RegNoField.getText();
        String course = choice1.getSelectedItem();
        String gender;
        if(jRadioButton1.isSelected())
        {
            gender = "MALE";
        }
        else
        {
            gender = "FEMALE";
        }
        st = new Student(fname,Lname,reg,gender);
        if(button8.getLabel().equals("ADD"))
        {
            boolean flag = admin.addStd(st, course);
        
        if(flag==true)
        {
            JOptionPane.showMessageDialog(null,"Student Added  ");
        this.model = new DefaultTableModel();
        model.addColumn("Sr.No");
        model.addColumn("FirstName");
        model.addColumn("Reg_No");
        model.addColumn("Course");
        model.addColumn("Gender");
        jTable4.setModel(model);
         DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
         Object rowData[] = new Object[5];
         int i=0;
             rowData[0] = i+1;
             rowData[1] = fname;
             rowData[2] = reg;
             rowData[3] = course;
             rowData[4] = gender;
             model.addRow(rowData);
        
        }
        }
        else if(button8.getLabel().equals("Update"))
        {
            String rgg = SearchREGField.getText();
            String f = FnameField.getText();
        String L = LastNameField.getText();
        String re = RegNoField.getText();
        String cour = choice1.getSelectedItem();
        String gend;
        if(jRadioButton1.isSelected())
        {
            gend = "MALE";
        }
        else
        {
            gend = "FEMALE";
        }
        st = new Student(f,L,re,gend);
            
           boolean flag=admin.editStd(st, rgg);
           
           if(flag==true)
           {
                JOptionPane.showMessageDialog(null,"Student Updated ");
        this.model = new DefaultTableModel();
        model.addColumn("Sr.No");
        model.addColumn("FirstName");
        model.addColumn("Reg_No");
        model.addColumn("Course");
        model.addColumn("Gender");
        jTable4.setModel(model);
         DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
         Object rowData[] = new Object[5];
         int i=0;
             rowData[0] = i+1;
             rowData[1] = fname;
             rowData[2] = reg;
             rowData[3] = course;
             rowData[4] = gender;
             model.addRow(rowData);
           }
           button8.setLabel("ADD");
           AddStdPanel.setVisible(true);
        }
        ClearStd();
        
    }//GEN-LAST:event_button8ActionPerformed

    private void jTabbedPane2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTabbedPane2MousePressed

    private void button14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button14ActionPerformed
        // TODO add your handling code here:
        String course = choice2.getSelectedItem();
        for(int i=0;i<admin.getCList().size();i++)
        {
            if(course.equals(admin.getCList().get(i).getID()))
            {
                //JOptionPane.showMessageDialog(null,admin.getCList().get(i).getStdList().size());
                 this.model = new DefaultTableModel();
        model.addColumn("Sr.No");
        model.addColumn("FirstName");
        model.addColumn("Reg_No");
        model.addColumn("Course");
        model.addColumn("Gender");
        jTable6.setModel(model);
         DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
         Object rowData[] = new Object[5];
         for(int j=0;j<admin.getCList().get(i).getStdList().size();j++)
         {
             rowData[0] = j+1;
             rowData[1] = admin.getCList().get(i).getStdList().get(j).getFirstName();
             rowData[2] = admin.getCList().get(i).getStdList().get(j).getReg_No();
             rowData[3] = admin.getCList().get(i).getID();
             rowData[4] = admin.getCList().get(i).getStdList().get(j).getGender();
             model.addRow(rowData);
                     
         }
            }
        }
    }//GEN-LAST:event_button14ActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
       String regno = SearchREGField.getText();
       int size = admin.getCList().size();
       for(int i=0;i<size;i++)
        {
            for(int j=0;j<admin.getCList().get(i).getStdList().size();j++)
            {
                if(regno.equals(admin.getCList().get(i).getStdList().get(j).getReg_No()))
                {
                 this.model = new DefaultTableModel();  
                    model.addColumn("Sr.No");
                    model.addColumn("FirstName");
                    model.addColumn("LastName");
                    model.addColumn("Reg_No");
                    model.addColumn("Course");
                    model.addColumn("Gender");
                  jTable5.setModel(model);
                  DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
                  Object rowData[] = new Object[6];
                  rowData[0] = j+1;
                  rowData[1] = admin.getCList().get(i).getStdList().get(j).getFirstName();
                  rowData[2] = admin.getCList().get(i).getStdList().get(j).getLasttName();
                  rowData[3] = admin.getCList().get(i).getStdList().get(j).getReg_No();
                  rowData[4] = admin.getCList().get(i).getID();
                  rowData[5] = admin.getCList().get(i).getStdList().get(j).getGender();
                  model.addRow(rowData);
                }
            }
        }
    }//GEN-LAST:event_jLabel3MousePressed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        button5.setLabel("Update");
        CreatePnel.setVisible(true);
        textField1.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
       
    }//GEN-LAST:event_button7ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        String id = textField1.getText();
        boolean  flag=admin.deleteCourse(id);
        if(flag==true)
        {
            JOptionPane.showMessageDialog(null, "Deleted  ...");
            textField1.setText("");
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            model2.setRowCount(0);
        }
        
    }//GEN-LAST:event_button6ActionPerformed

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        // TODO add your handling code here:
      //ViewAll();
      disapper();
    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        // TODO add your handling code here:
         String id = textField1.getText();
         for(int i=0;i<admin.getCList().size();i++)
         {
             if(id.equals(admin.getCList().get(i).getID()))
             {
                  this.model = new DefaultTableModel();
                 model.addColumn("Title");
                 model.addColumn("Course_ID");
                 model.addColumn("Cred_Hrs");
                 model.addColumn("Dept");
                 jTable2.setModel(model);
                 DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                 Object rowData[] = new Object[4];
                 rowData[0] = admin.getCList().get(i).getTitle();
                 rowData[1] = admin.getCList().get(i).getID();
                 rowData[2] = admin.getCList().get(i).getCredHrs();
                 rowData[3] = admin.getCList().get(i).getDept();
                 model.addRow(rowData);
             }
         }
    }//GEN-LAST:event_button15ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        button8.setLabel("Update");
        AddStdPanel.setVisible(true);
    }//GEN-LAST:event_button3ActionPerformed

    private void EDitPAnelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDitPAnelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_EDitPAnelMousePressed

    private void ViewALLPAnelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewALLPAnelMousePressed
        // TODO add your handling code here:     
    }//GEN-LAST:event_ViewALLPAnelMousePressed

    private void EDitPAnelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDitPAnelMouseEntered
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_EDitPAnelMouseEntered

    private void ViewALLPAnelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewALLPAnelMouseEntered
        // TODO add your handling code here:
       DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);
        SearchREGField.setText(""); 
    }//GEN-LAST:event_ViewALLPAnelMouseEntered

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
       
        String tname = TeacherNAmeChoice.getSelectedItem();
        String cnic = TECNIC.getSelectedItem();
        String cour = CourseChoice.getSelectedItem();
        boolean flag = admin.AssignTeacher(cour);
        JOptionPane.showMessageDialog(null,flag); 
        if(flag==false)
        {
         JOptionPane.showMessageDialog(null,"Course Already Assigned");   
        }
        else
        {
            addTeacherinfo();
            int size = admin.getCList().size();
            for(int i=0;i<size;i++)
            {
                int leh = admin.getTeachList().get(i).getCList().get(i).getStdList().size();
                 JOptionPane.showMessageDialog(null,+size+ "size of Std in curse");
            }
        }


        CourseChoice.removeAll();
        //JOptionPane.showMessageDialog(null, list.size());
        for (int i = 0; i < list.size(); i++) {
            if (cour.equals(list.get(i))) {
               // JOptionPane.showMessageDialog(null, "List matched");
                list.remove(i);
                
            }
        }
        
    }//GEN-LAST:event_button4ActionPerformed

    private void AddCloLBLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCloLBLMousePressed
        // TODO add your handling code here:
        AddAppear();
        int size = admin.getCList().size();
        for(int i=0;i<size;i++)
        {
            
            choice3.add(admin.getCList().get(i).getID());
        }
    }//GEN-LAST:event_AddCloLBLMousePressed

    private void button13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button13ActionPerformed
        // TODO add your handling code here:
        jPanel7.setVisible(true);
        CLOTABLE.setVisible(true);
        EDITBTN.setVisible(false);
        DELETEBTN.setVisible(false);
        String course = choice3.getSelectedItem();
        String CLOno = textField2.getText();
        String details = textArea1.getText();
        CLO clo =new CLO(CLOno,details);
        if(button13.getLabel().equals("ASSIGN"))
        {
            boolean flag=admin.AddClo(course, clo);
        if(flag == true)
        {
             AddCLOTable();
        }
        }
        else if(button13.getLabel().equals("Update"))
        {
            String cou = choice3.getSelectedItem();
            String no = textField2.getText();
            String det = textArea1.getText();
             String CLONO = textField3.getText();
            CLO cl = new CLO(no,det);
            boolean flag=admin.EDitClo(cou, cl, CLONO);
            if(flag==true)
            {
                AddCLOTable();
                //textField3.setText("");
            }
        }
        
    }//GEN-LAST:event_button13ActionPerformed

    private void EDitCLOLBLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDitCLOLBLMousePressed
        // TODO add your handling code here:
         jPanel7.setVisible(true);
         textField3.setVisible(true);
        CLOTABLE.setVisible(true);
        EDITBTN.setVisible(true);
        DELETEBTN.setVisible(true);
        ADDPANEL.setVisible(false);
        button13.setLabel("Update");
        AddCLOTable();
        textField2.setText("");
        textArea1.setText("");
        
    }//GEN-LAST:event_EDitCLOLBLMousePressed

    private void EDITBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITBTNActionPerformed
        // TODO add your handling code here:
        ADDPANEL.setVisible(true);
        DELETEBTN.setVisible(false);
        EDITBTN.setVisible(false);
        String CLONO = textField3.getText();
        button13.setLabel("Update");
        
    }//GEN-LAST:event_EDITBTNActionPerformed

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel14MouseEntered

    private void CreatePnelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePnelMouseEntered
        // TODO add your handling code here:
        choice3.removeAll();
    }//GEN-LAST:event_CreatePnelMouseEntered

    private void textField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField3MouseClicked
        // TODO add your handling code here:
        textField3.setText("");
    }//GEN-LAST:event_textField3MouseClicked

    private void textField3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField3MouseExited
        // TODO add your handling code here:
      
    }//GEN-LAST:event_textField3MouseExited

    private void DELETEBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEBTNActionPerformed
        // TODO add your handling code here:
        String CLONO = textField3.getText();
       boolean flag=admin.deleteCLO(CLONO);
       if(flag==true)
       {
           JOptionPane.showMessageDialog(null, "CLO Deleted ");
            textField3.setText("");
            AddAppear();
       }
        
    }//GEN-LAST:event_DELETEBTNActionPerformed

    private void ViewAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewAllMouseEntered
        // TODO add your handling code here:
        ViewAll();
    }//GEN-LAST:event_ViewAllMouseEntered

    private void UNASSIGNPANELMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UNASSIGNPANELMouseEntered
        // TODO add your handling code here:
         CourseChoice.removeAll();
//        int size=admin.getTeachList().size();
//        for(int i=0;i<size;i++)
//        {
//            TeacherChoice.add(admin.getTeachList().get(i).getTName());
//        }
//        String techNm = TeacherChoice.getSelectedItem();
//        for(int j=0;j<size;j++)
//        {
//            if(techNm.equals(admin.getTeachList().get(j).getTName()))
//            {
//                CourseID.add(admin.getTeachList().get(j).getCList().get(j).getID());
//            }
//        }
    }//GEN-LAST:event_UNASSIGNPANELMouseEntered

    private void CourseChoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseChoiceMouseEntered
        // TODO add your handling code here:
       //List<String>list= new ArrayList<>();
        
    }//GEN-LAST:event_CourseChoiceMouseEntered

    private void choice1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice1MouseEntered
        // TODO add your handling code here:
        int size = admin.getCList().size();
        for(int i=0;i<size;i++)
        {
           if(choice1.getItemCount()<size)
           {
            choice1.add(admin.getCList().get(i).getID());
           // choice2.add(admin.getCList().get(i).getID());
           }
        }
    }//GEN-LAST:event_choice1MouseEntered

    private void choice2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice2MouseEntered
        // TODO add your handling code here:
         int size = admin.getCList().size();
        for(int i=0;i<size;i++)
        {
           if(choice2.getItemCount()<size)
           {
            choice2.add(admin.getCList().get(i).getID());
           }
        }
    }//GEN-LAST:event_choice2MouseEntered

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        // TODO add your handling code here:
        TeacherChoice.removeAll();
        CourseID.removeAll();
        
    }//GEN-LAST:event_jPanel11MouseEntered

    private void TeacherChoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherChoiceMouseEntered
        // TODO add your handling code here:
        
//        int size=admin.getTeachList().size();
//        for(int i=0;i<size;i++)
//        {
//            if(TeacherChoice.getItemCount()<size)
//            {
//            TeacherChoice.add(admin.getTeachList().get(i).getTName());
//            }
//        }
//        String techNm = TeacherChoice.getSelectedItem();
//        for(int i=0;i<admin.getCList().size();i++)
//        {
//            for(int j=0;j<size;j++)
//            {
//                if(techNm.equals(admin.getTeachList().get(j).getTName()))
//                {
//                    CourseID.add(admin.getCList().get(i).getID());
//                }
//            }
//        }
        
    }//GEN-LAST:event_TeacherChoiceMouseEntered

    private void CourseChoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseChoiceMousePressed
        // TODO add your handling code here:
         
        for(int j=0;j<list.size();j++)
        {
            if(CourseChoice.getItemCount()<list.size())
            {
            CourseChoice.add(list.get(j));
            }
        }
    }//GEN-LAST:event_CourseChoiceMousePressed

    private void UNASSIGNBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNASSIGNBTNActionPerformed
        // TODO add your handling code here:
        String Tname = TeacherChoice.getSelectedItem();
        String id = CourseID.getSelectedItem();
        for(int i=0;i<admin.getTeachList().size();i++)
        {
            if(Tname.equals(admin.getTeachList().get(i).getTName()))
            {
             for(int j=0;j<admin.getTeachList().get(i).getCList().size();j++)
             {
                 if(id.equals(admin.getTeachList().get(i).getCList().get(j).getID()))
                 {
                     JOptionPane.showMessageDialog(null,"Unassiging " + admin.getTeachList().get(i).getCList().get(j).getID());
                     admin.getTeachList().get(i).getCList().remove(j);
                   
                     DefaultTableModel model = (DefaultTableModel) TeacherAddTable.getModel();
                     model.setRowCount(0);
                 }
             }
            }
        }
        int size = admin.getCList().size();
        for(int z=0;z<size;z++)
        {
            list.add(admin.getCList().get(z).getID());
        }
    }//GEN-LAST:event_UNASSIGNBTNActionPerformed

    private void TeacherChoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherChoiceMousePressed
        // TODO add your handling code here:
        int size=admin.getTeachList().size();
        for(int i=0;i<size;i++)
        {
            if(TeacherChoice.getItemCount()<size)
            {
            TeacherChoice.add(admin.getTeachList().get(i).getTName());
            }
        }
       CourseID.removeAll();
    }//GEN-LAST:event_TeacherChoiceMousePressed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        // TODO add your handling code here:
        String tn = TNameField1.getText();
        String cnix =CNICField1.getText();
        String ema = EmailField1.getText();
        String pas= PassField1.getText();
        Teacher teach = new Teacher(tn,ema,pas,cnix);
        admin.getTeachList().add(teach);
        
         this.model = new DefaultTableModel();
                 model.addColumn("Teacher Name");
                 model.addColumn("CNIC");
                 model.addColumn("Email");
                 model.addColumn("Pssword");
                 jTable7.setModel(model);
                 DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
                 Object rowData[] = new Object[4];
                 for(int i=0;i<admin.getTeachList().size();i++)
                 {
                 rowData[0] = admin.getTeachList().get(i).getTName();
                 rowData[1] = admin.getTeachList().get(i).getCNIC();
                 rowData[2] = admin.getTeachList().get(i).getEmail();
                 rowData[3] = admin.getTeachList().get(i).getPassword();
                 model.addRow(rowData);
                 }
                 TeacherNAmeChoice.removeAll();
    }//GEN-LAST:event_button9ActionPerformed

    private void CNICField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CNICField1MousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_CNICField1MousePressed

    private void TeacherNAmeChoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherNAmeChoiceMousePressed
        // TODO add your handling code here:
         for(int i=0;i<admin.getTeachList().size();i++)
         {
             if(TeacherNAmeChoice.getItemCount()<admin.getTeachList().size())
             {
             TeacherNAmeChoice.add(admin.getTeachList().get(i).getTName());
             }
         }
         TECNIC.removeAll();
    }//GEN-LAST:event_TeacherNAmeChoiceMousePressed

    private void TECNICMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TECNICMousePressed
        // TODO add your handling code here:
        String tname=TeacherNAmeChoice.getSelectedItem();
         for(int i=0;i<admin.getTeachList().size();i++)
         {
             if(tname.equals(admin.getTeachList().get(i).getTName()))
             {
                 if(TECNIC.getItemCount()<1)
                 {
                 TECNIC.add(admin.getTeachList().get(i).getCNIC());
                 }
             }
         }
    }//GEN-LAST:event_TECNICMousePressed

    private void CourseIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseIDMousePressed
        // TODO add your handling code here:
        int size=admin.getTeachList().size();
        String techNm = TeacherChoice.getSelectedItem();
        for(int i=0;i<admin.getCList().size();i++)
        {
            for(int j=0;j<size;j++)
            {
                if(techNm.equals(admin.getTeachList().get(j).getTName()))
                {
                    CourseID.add(admin.getCList().get(i).getID());
                }
            }
        }
    }//GEN-LAST:event_CourseIDMousePressed

    private void jTable8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseEntered
        // TODO add your handling code here:
         String Tname = TeacherChoice.getSelectedItem();
        String id = CourseID.getSelectedItem();
         for(int i=0;i<admin.getTeachList().size();i++)
        {
            if(Tname.equals(admin.getTeachList().get(i).getTName()))
            {
             for(int j=0;j<admin.getTeachList().get(i).getCList().size();j++)
             {
                 if(id.equals(admin.getTeachList().get(i).getCList().get(j).getID()))
                 {
                      DefaultTableModel model2 = (DefaultTableModel) jTable8.getModel();
                      Object rowData[] = new Object[5];
                      rowData[0] = admin.getTeachList().get(i).getTName();
                      rowData[1] = admin.getTeachList().get(i).getEmail();
                      rowData[2] = admin.getTeachList().get(i).getPassword();
                      rowData[3] = admin.getTeachList().get(i).getCNIC();
                      rowData[4] = admin.getTeachList().get(i).getCList().get(j).getID();
                      model2.addRow(rowData);
                     
                   
                     DefaultTableModel model = (DefaultTableModel) TeacherAddTable.getModel();
                     model.setRowCount(0);
                 }
             }
            }
        }
        
    }//GEN-LAST:event_jTable8MouseEntered

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
    //    SaveData();
        System.exit(0);
        
        
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        // TODO add your handling code here:
       SaveDataChoice.setVisible(true);
       ViewAll.setVisible(true);
       button1.setVisible(true);
      // list1.setVisible(true);
       
      
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
         SaveDataChoice.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void SaveDataChoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveDataChoiceMousePressed
        // TODO add your handling code here:
        if( !(admin.getCList().isEmpty()) )
        {
            for(int i=0;i<admin.getCList().size();i++)
            {
                if( !((admin.getCList().get(i).getCloList().isEmpty())&& (admin.getCList().get(i).getStdList().isEmpty()) ))
                {
                    if(SaveDataChoice.getItemCount() < admin.getCList().size())
                    {
                        SaveDataChoice.add(admin.getCList().get(i).getID());
                    }
                }
            }
        }
    }//GEN-LAST:event_SaveDataChoiceMousePressed

    private void SaveDataChoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveDataChoiceMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SaveDataChoiceMouseExited

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        SaveData();
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new AdminMenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADDPANEL;
    private javax.swing.JLabel AddCloLBL;
    private javax.swing.JPanel AddStdPanel;
    private java.awt.Label CLOLBL;
    private javax.swing.JTable CLOTABLE;
    private java.awt.TextField CNICField1;
    private java.awt.Choice CourseChoice;
    private java.awt.Choice CourseID;
    private javax.swing.JPanel CreatePnel;
    private java.awt.Button DELETEBTN;
    private java.awt.Button EDITBTN;
    private javax.swing.JLabel EDitCLOLBL;
    private javax.swing.JPanel EDitPAnel;
    private javax.swing.JPanel EditPanel;
    private java.awt.TextField EmailField1;
    private java.awt.TextField FnameField;
    private java.awt.TextField IDField;
    private java.awt.TextField LastNameField;
    private javax.swing.JTabbedPane MainPanel;
    private java.awt.Button ManageCourseBTN;
    private javax.swing.JPanel ManageCoursePanel;
    private java.awt.Button ManageSTUDENTBTN;
    private javax.swing.JPanel ManageStudentsPanel;
    private java.awt.Button ManageTEACHERBTN;
    private javax.swing.JPanel ManageTeacherPanel;
    private javax.swing.JPanel MenuPanel;
    private java.awt.TextField PassField1;
    private java.awt.TextField RegNoField;
    private java.awt.Choice SaveDataChoice;
    private java.awt.TextField SearchREGField;
    private java.awt.Choice TECNIC;
    private java.awt.TextField TNameField1;
    private javax.swing.JTable TeacherAddTable;
    private java.awt.Choice TeacherChoice;
    private java.awt.Choice TeacherNAmeChoice;
    private java.awt.TextField TitleField;
    private java.awt.Button UNASSIGNBTN;
    private javax.swing.JPanel UNASSIGNPANEL;
    private java.awt.Label UserNameLBL;
    private javax.swing.JPanel ViewALLPAnel;
    private javax.swing.JPanel ViewAll;
    private java.awt.Button button1;
    private java.awt.Button button13;
    private java.awt.Button button14;
    private java.awt.Button button15;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private java.awt.Button button8;
    private java.awt.Button button9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private java.awt.Choice choice3;
    private java.awt.Label courseIDLbL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label19;
    private java.awt.Label label2;
    private java.awt.Label label21;
    private java.awt.Label label22;
    private java.awt.Label label23;
    private java.awt.Label label24;
    private java.awt.Label label25;
    private java.awt.Label label26;
    private java.awt.Label label27;
    private java.awt.Label label28;
    private java.awt.Label label29;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.TextArea textArea1;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField7;
    private java.awt.TextField textField8;
    // End of variables declaration//GEN-END:variables
}
