package bigwork;//删除成绩
//同Delete
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
public class scdelete extends JFrame {  
   
    JLabel jlnumber = new JLabel("学号：");  
    
    JTextField jtnumber = new JTextField("",20); 
    JTextField jtdisplay = new JTextField("",20); 
      
    JButton buttondelete = new JButton("删除");  
      
      
    public scdelete() {  
        JPanel jpnumber = new JPanel(); 
        JPanel jpdisplay = new JPanel();
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
          
        jpnumber.add(jlnumber);  
        jpnumber.add(jtnumber);
        jpdisplay.add(jtdisplay);
          
        jpforbutton.add(buttondelete);  
          
        buttondelete.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String number = jtnumber.getText();  
                  
                Connection conn = null;  
                ResultSet res = null;  
                Statement stat = null;  
                String sql = "DELETE FROM studentgrade WHERE no='"+number+"'";  
                  
                try{  
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                }catch(Exception a){  
                    a.printStackTrace();  
                }  
                try{  
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
                    stat = conn.createStatement();  
                    stat.executeUpdate(sql);  
                    jtdisplay.setText("删除成功");
                }catch(SQLException h){  
                    h.printStackTrace();  
                    jtdisplay.setText("删除失败");
                      
                }finally{  
                    try{  
                        conn.close();  
                        System.out.println("close success!");  
                    }catch(SQLException j){  
                        System.out.println("close go die!");  
                        j.printStackTrace();  
                    }  
                      
                }  
                  
            }  
              
              
        });  

          
          
        this.setTitle("删除学生成绩信息");  
        this.setLayout(new GridLayout(9,1));  
        this.add(jpnumber);  
        this.add(jpforbutton);  
        this.add(jpdisplay); 
        this.setLocation(400,300);  
        this.setSize(350,300);  
        this.setVisible(true);  
          
          
    }  
      
      

}
