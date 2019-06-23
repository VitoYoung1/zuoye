package bigwork;//成绩修改
//同ask
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class scchange extends JFrame{
	
    
	JLabel jlnumber = new JLabel("学号：");  
	JLabel jlname = new JLabel("姓名："); 
    JLabel jlrequ = new JLabel("必修课：");  
    JLabel jlelec = new JLabel("选修课：");  
    JLabel jlsum = new JLabel("总分：");  
    JLabel jlavg = new JLabel("平均分");  
      
    JTextField jtnumber = new JTextField("",20);  
    JTextField jtname = new JTextField("",20);  
    JTextField jtrequ= new JTextField("",20);  
    JTextField jtelec = new JTextField("",20);  
    JTextField jtsum = new JTextField("",20);  
    JTextField jtavg = new JTextField("",20);  
    JTextField jtdisplay = new JTextField("",20); 
      
    JButton buttonchange = new JButton("修改");  

      
      
    public scchange() {  
    	JPanel jpnumber = new JPanel();  
        JPanel jpname = new JPanel();
        JPanel jprequ = new JPanel();
        JPanel jpelec = new JPanel();  
        JPanel jpsum = new JPanel();  
        JPanel jpavg = new JPanel(); 
        
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
        JPanel jpdisplay = new JPanel();
        
        jpnumber.add(jlnumber);  
        jpnumber.add(jtnumber);  
          
        jpname.add(jlname);  
        jpname.add(jtname);  
          
        jprequ.add(jlrequ);  
        jprequ.add(jtrequ);  
          
       
          
        jpelec.add(jlelec);  
        jpelec.add(jtelec);  
          
        jpsum.add(jlsum);  
        jpsum.add(jtsum);  
          
        jpavg.add(jlavg);  
        jpavg.add(jtavg);  
        
        jpdisplay.add(jtdisplay);
          
        jpforbutton.add(buttonchange);  
    
          
        buttonchange.addActionListener(new ActionListener(){  
        	 public void actionPerformed(ActionEvent e){  
                 String number = jtnumber.getText();  
                 String name = jtname.getText();  
                 String requ = jtrequ.getText();  
                 String elec = jtelec.getText();  
                 String sum = jtsum.getText(); 
                 String avg = jtavg.getText();  
                   
                 Connection conn = null;  
                 ResultSet res = null;  
                 Statement stat = null;  
                   
                 String sql = "SELECT * FROM studentgrade;";  
                 try{  
                     Class.forName("com.mysql.cj.jdbc.Driver");  
                       
                 }catch(Exception d){  
                     System.out.println("jdbc fall");  
                     d.printStackTrace();  
                 }  
                 try{  
                     conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
                     stat=conn.createStatement();  
                     res=stat.executeQuery(sql);  
                     while (res.next())  
                     {  
                         //change  
                         if (res.getString(1).equals(jtnumber.getText()))  
                         {  
                        	
              
                               
                             String sql2="UPDATE studentgrade SET name='"+name+"'  WHERE no='"+jtnumber.getText()+"'";  
                             String sql3="UPDATE studentgrade SET requ='"+requ+"'  WHERE no='"+jtnumber.getText()+"'";  
                             String sql4="UPDATE studentgrade SET elec='"+elec+"'  WHERE no='"+jtnumber.getText()+"'";  
                             String sql5="UPDATE studentgrade SET sum='"+sum+"'  WHERE no='"+jtnumber.getText()+"'";
                             String sql6="UPDATE studentgrade SET avg='"+avg+"'  WHERE no='"+jtnumber.getText()+"'";  
                             try {  
                                 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
                                 stat=conn.createStatement();  
                                 stat.executeUpdate(sql2);  
                                 stat.executeUpdate(sql3);  
                                 stat.executeUpdate(sql4);  
                                 stat.executeUpdate(sql5);  
                                 stat.executeUpdate(sql6);  
                                 jtdisplay.setText("修改成功");
                             } catch (SQLException g) {  
                                 // TODO Auto-generated catch block  
                                 g.printStackTrace();  
                                 jtdisplay.setText("修改失败");
                             }try{  
                                 stat.close();  
                                 conn.close();  
                             }catch(SQLException ar){  
                                 ar.printStackTrace();  
                         }  
   
                             break;  
                         }  
                           
                     //change end  
                     }  
                 }catch (SQLException e1) {  
                     // TODO Auto-generated catch block  
                     e1.printStackTrace();  
                   
                   
             }  
                 finally{  
                     try{  
                         conn.close();  
                     }catch(SQLException ar){  
                         ar.printStackTrace();  
                     }  
               
                 }  
                   
             }  
               
               
         });  
           

           
         this.setTitle("修改学生成绩信息");  
         this.setLayout(new GridLayout(9,1));  
         this.add(jpnumber);  
         this.add(jpname);  
         this.add(jprequ);  
         this.add(jpelec);  
         this.add(jpsum); 
         this.add(jpavg); 
         this.add(jpforbutton);
         this.add(jpdisplay); 
         this.setLocation(400,300);  
         this.setSize(350,300);  
         this.setVisible(true);  
           
           
     }  
}
