package bigwork;//修改信息
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class Change extends JFrame{
	
    
    JLabel jlnumber = new JLabel("学号：");  //JLabel类用于显示文本
    JLabel jlname = new JLabel("姓名：");  
    JLabel jlsex = new JLabel("性别：");  
    JLabel jlbirthday = new JLabel("出生日期：");  
    JLabel jltel = new JLabel("电话：");  
      
    JTextField jtnumber = new JTextField("",20);  //编辑单行文本，设置长度
    JTextField jtname = new JTextField("",20);   
    JTextField jtsex = new JTextField("",20);  
    JTextField jtbirthday = new JTextField("",20);  
    JTextField jtel = new JTextField("",20);
    JTextField jtdisplay = new JTextField("",20); 
      
    JButton buttonchange = new JButton("修改");   //按钮添加
      
      
    public Change() {  
        JPanel jpnumber = new JPanel();  //创建新面板,是容器类用于存放

        JPanel jpname = new JPanel();  
        JPanel jpsex = new JPanel();  
        JPanel jpbirthday = new JPanel();  
        JPanel jptel = new JPanel(); 
        JPanel jpdisplay = new JPanel();
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
          
        jpnumber.add(jlnumber);  //将“学号”文字添加到新建面板
        jpnumber.add(jtnumber);  //添加单行文本
          
        jpname.add(jlname);  
        jpname.add(jtname);  
          
        jpsex.add(jlsex);  
        jpsex.add(jtsex);  
          
        jpbirthday.add(jlbirthday);  
        jpbirthday.add(jtbirthday);  
          
        jptel.add(jltel);  
        jptel.add(jtel); 
        
        jpdisplay.add(jtdisplay);
          
        jpforbutton.add(buttonchange);  
    
          
        buttonchange.addActionListener(new ActionListener(){  //略
        	 public void actionPerformed(ActionEvent e){  
                 String number = jtnumber.getText();  
                 String name = jtname.getText();  
                 String sex = jtsex.getText();  
                 String birthday = jtbirthday.getText();  
                 String tel = jtel.getText();  
                   
                 Connection conn = null;  
                 ResultSet res = null;  
                 Statement stat = null;  
                   
                 String sql = "SELECT * FROM studentinfo;";  
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
                        	
              
                               
                             String sql2="UPDATE studentinfo SET Name='"+name+"'  WHERE No='"+jtnumber.getText()+"'";  
                             String sql3="UPDATE studentinfo SET Sex='"+sex+"'  WHERE No='"+jtnumber.getText()+"'";  
                             String sql4="UPDATE studentinfo SET Birthday='"+birthday+"'  WHERE No='"+jtnumber.getText()+"'";  
                             String sql5="UPDATE studentinfo SET Tel='"+tel+"'  WHERE No='"+jtnumber.getText()+"'";  
                             try {  
                                 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
                                 stat=conn.createStatement();  
                                 stat.executeUpdate(sql2);  
                                 stat.executeUpdate(sql3);  
                                 stat.executeUpdate(sql4);  
                                 stat.executeUpdate(sql5);  
                                 jtdisplay.setText("修改成功");
                             } catch (SQLException g) {  
                                 // TODO Auto-generated catch block  
                                 g.printStackTrace();  
                                 jtdisplay.setText("修改失败");
                             }try{  
                                 stat.close();  // //完成操作后关闭
                                 conn.close();  
                             }catch(SQLException ar){  
                                 ar.printStackTrace(); //关闭失败
                         }  
   
                             break;  
                         }  
                           
                     //change end  
                     }  
                 }catch (SQLException e1) {  //查询失败
                     // TODO Auto-generated catch block  
                     e1.printStackTrace();  
                   
                   
             }  
                 finally{  
                     try{  
                         conn.close();  //完成操作后关闭
                     }catch(SQLException ar){  
                         ar.printStackTrace();  //关闭失败
                     }  
               
                 }  
                   
             }  
               
               
         });  

           
         this.setTitle("修改学生信息");  //添加到面版
         this.setLayout(new GridLayout(9,1));  
         this.add(jpnumber);  
         this.add(jpname);  
         this.add(jpsex);  
         this.add(jpbirthday);  
         this.add(jptel);  
         this.add(jpforbutton);
         this.add(jpdisplay); 
         this.setLocation(400,300);  
         this.setSize(350,300);  
         this.setVisible(true);  
           
           
     }  
}
