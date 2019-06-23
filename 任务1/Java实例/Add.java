package bigwork;//添加功能
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
import com.mysql.jdbc.Driver; 
public class Add extends JFrame{
	

    
    JLabel jlnumber = new JLabel("学号：");  //JLabel类用于显示文本
    JLabel jlname = new JLabel("姓名：");  
    JLabel jlsex = new JLabel("性别：");  
    JLabel jlbirthday = new JLabel("出生日期：");  
    JLabel jltel = new JLabel("电话：");  
      
    JTextField jtnumber = new JTextField("",20); //编辑单行文本，设置长度
    JTextField jtname = new JTextField("",20);  
    JTextField jtsex = new JTextField("",20);  
    JTextField jtbirthday = new JTextField("",20);  
    JTextField jttel = new JTextField("",20);  
    JTextField jtdisplay = new JTextField("",20); 
      
    JButton buttonadd = new JButton("添加");  //按钮添加

      
      
    public Add() {  
        JPanel jpnumber = new JPanel();  //创建新面板,是容器类用于存放
        JPanel jpname = new JPanel();  
        JPanel jpsex = new JPanel();  
        JPanel jpbirthday = new JPanel();  
        JPanel jptel = new JPanel();  
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
        JPanel jpdisplay = new JPanel(); 
          
        jpnumber.add(jlnumber);  //将“学号”文字添加到新建面板
        jpnumber.add(jtnumber);  //添加单行文本
          
        jpname.add(jlname);  //同上
        jpname.add(jtname);  //同上
          
        jpsex.add(jlsex);  //同上
        jpsex.add(jtsex);  //同上
          
        jpbirthday.add(jlbirthday);  //同上
        jpbirthday.add(jtbirthday);  //同上
          
        jptel.add(jltel);  //同上
        jptel.add(jttel);  //同上
        
        jpdisplay.add(jtdisplay);//同上
          
        jpforbutton.add(buttonadd);  //同上
    
          
        buttonadd.addActionListener(new ActionListener(){  //添加按钮实现的功能
            public void actionPerformed(ActionEvent e){  
                Connection conn = null;  //表示定义 Connection的对象rs，初值为空
                ResultSet res = null;  //表示定义ResultSet的对象rs，初值为空
                Statement stat = null; //表示定义Statement的对象rs，初值为空
                PreparedStatement ps=null;  //表示定义PreparedStatement的对象rs，初值为空
  
                String sqla = "SELECT * FROM studentinfo;";  //表名为studentinfo
                try{  
                    Class.forName("com.mysql.cj.jdbc.Driver");  //加载驱动
                      
                }catch(Exception d){  
                    System.out.println("jdbc fall");  //加载失败
                    d.printStackTrace();  
                }  
                try{  
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme"); //连接数据库的用户名和密码 
                    stat=conn.createStatement();  //将值赋给stat
                    res=stat.executeQuery(sqla);  //res值为表名
                   
                 
                            String sql = "insert into studentinfo values(?,?,?,?,?)";//防止盗取数据
                            ps=conn.prepareStatement(sql);
                            ps.setString(1,jtnumber.getText());  //将输入的数值插入到数据库的表中
                            ps.setString(2,jtname.getText());  
                            ps.setString(3,jtsex.getText());  
                            ps.setString(4,jtbirthday.getText());  
                            ps.setString(5,jttel.getText());  
  
                    ps.executeUpdate();   
                    
                    jtdisplay.setText("插入成功");//文本框显示插入成功
                        
                      
                    
                }catch (SQLException e1) {  //插入失败
                    // TODO Auto-generated catch block  
                	 e1.printStackTrace();  
                	 jtdisplay.setText("插入失败，请检查该学号是否已存在");//文本框显示插入失败
                  
                  
            }  
                finally{  
                    try{  
                        conn.close();  
                        System.out.println("MySQL 关闭成功");//完成操作后关闭
                    }catch(SQLException ar){ 
                        System.out.println("MySQL 关闭失败 "); //关闭失败
                        ar.printStackTrace();  
                    }  
              
                }}}  
              
                );  
          
         
          
          
        this.setTitle("添加学生个人信息");  //将以下信息添加到页面
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
