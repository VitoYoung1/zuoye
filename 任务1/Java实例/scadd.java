package bigwork;//成绩添加
//同add
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

import com.mysql.jdbc.Driver; 
public class scadd extends JFrame{
	
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
      
    JButton buttonadd = new JButton("添加");  

      
      
    public scadd() { 
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
          
        jpforbutton.add(buttonadd);  
    
          
        buttonadd.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Connection conn = null;  
                ResultSet res = null;  
                Statement stat = null; 
                PreparedStatement ps=null;  
                  
                String sqla = "SELECT * FROM studentgrade;";  
                try{  
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                      
                }catch(Exception d){  
                    System.out.println("jdbc fall");  
                    d.printStackTrace();  
                }  
                try{  
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
                    stat=conn.createStatement();  
                    res=stat.executeQuery(sqla);  
                   
                 
                            String sql = "insert into studentgrade values(?,?,?,?,?,?)";
                            ps=conn.prepareStatement(sql);
                            ps.setString(1,jtnumber.getText()); 
                            ps.setString(2,jtname.getText());  
                            ps.setString(3,jtrequ.getText());  
                            ps.setString(4,jtelec.getText());  
                            ps.setString(5,jtsum.getText());  
                            ps.setString(6,jtavg.getText());  
  
                    ps.executeUpdate();   
                    
                    jtdisplay.setText("插入成功");
                        
                      
                    
                }catch (SQLException e1) {  
                    // TODO Auto-generated catch block  
                	 e1.printStackTrace();  
                	 jtdisplay.setText("插入失败，请检查该学学生是否已存在");
                  
                  
            }  
                finally{  
                    try{  
                        conn.close();  
                        System.out.println("MySQL 关闭成功");
                    }catch(SQLException ar){ 
                        System.out.println("MySQL 关闭失败 "); 
                        ar.printStackTrace();  
                    }  
              
                }}}  
              
                );  
          
          

          
        this.setTitle("添加学生成绩信息");  
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
