package bigwork;//查询功能
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class Ask extends JFrame{
	
    
    JLabel jlnumber = new JLabel("学号：");  //JLabel类用于显示文本
    JLabel jlname = new JLabel("姓名：");  
    JLabel jlsex = new JLabel("性别：");  
    JLabel jlbirthday = new JLabel("出生日期：");  
    JLabel jltel = new JLabel("电话：");  
      
    JTextField jtnumber = new JTextField("",20);  //编辑单行文本，设置长度
    JLabel jname = new JLabel();  //添加行
    JLabel jsex = new JLabel();  
    JLabel jbirthday = new JLabel();  
    JLabel jtel = new JLabel();  
      
    JButton buttonask = new JButton("查询");  //按钮添加
  
      
      
    public Ask() {  
        JPanel jpnumber = new JPanel();  //创建新面板,是容器类用于存放
        JPanel jpname = new JPanel();  
        JPanel jpsex = new JPanel();  
        JPanel jpbirthday = new JPanel();  
        JPanel jptel = new JPanel();  
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
          
        jpnumber.add(jlnumber);  //将“学号”文字添加到新建面板
        jpnumber.add(jtnumber);  //添加单行文本
          
        jpname.add(jlname);  //同上
        jpname.add(jname);  //同上
          
        jpsex.add(jlsex);  //同上
        jpsex.add(jsex);  //同上
          
        jpbirthday.add(jlbirthday);  //同上
        jpbirthday.add(jbirthday);  //同上
          
        jptel.add(jltel);  //同上
        jptel.add(jtel);  //同上
          
        jpforbutton.add(buttonask);  //同上（查询）

          
        buttonask.addActionListener(new ActionListener(){  //添加按钮实现的功能
            public void actionPerformed(ActionEvent e){  
                Connection conn = null;  //表示定义 Connection的对象rs，初值为空
                ResultSet res = null;  //表示定义ResultSet的对象rs，初值为空
                Statement stat = null;  //表示定义Statement的对象rs，初值为空
                  
                String sql = "SELECT * FROM studentinfo;";  //表名为studentinfo
                try{  
                    Class.forName("com.mysql.cj.jdbc.Driver");   //加载驱动
                      
                }catch(Exception d){  
                    System.out.println("jdbc fall");   //加载失败
                    d.printStackTrace();  
                }  
                try{  
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme"); //连接数据库的用户名和密码  
                    stat=conn.createStatement();  //将值赋给stat
                    res=stat.executeQuery(sql);  //res值为表名
                    while (res.next())  
                    {  
                        if (res.getString(1).equals(jtnumber.getText()))  
                        {  
                            jname.setText(res.getString(2));  //获取将相应的数值
                            jsex.setText(res.getString(3));  
                            jbirthday.setText(res.getString(4));  
                            jtel.setText(res.getString(5));  
  
                            break;  
                        }  
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
              
                }}}  
              
                );  
          

          
        this.setTitle("查询学生个人信息");   //将以下信息添加到页面
        this.setLayout(new GridLayout(9,1));  
        this.add(jpnumber);  
        this.add(jpname);  
        this.add(jpsex);  
        this.add(jpbirthday);  
        this.add(jptel);  
        this.add(jpforbutton);  
        this.setLocation(400,300);  
        this.setSize(350,300);  
        this.setVisible(true);  
          
          
    }  
}
