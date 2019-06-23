package bigwork;
//通过姓名查询
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class askbyname extends JFrame{
	

    JLabel jlna = new JLabel("姓名：");  //JLabel类用于显示文本
    JLabel jlno = new JLabel("学号：");  
    JLabel jlsex = new JLabel("性别：");  
    JLabel jlbirthday = new JLabel("出生日期：");  
    JLabel jltel = new JLabel("电话：");  
      
    JTextField jtname = new JTextField("",20);  //编辑单行文本，设置长度
    JLabel jno = new JLabel();  
    JLabel jsex = new JLabel();  
    JLabel jbirthday = new JLabel();  
    JLabel jtel = new JLabel();  
      
    JButton buttonask = new JButton("查询");   //按钮添加
 
      
      
    public askbyname() {  
        JPanel jpnumber = new JPanel();  //创建新面板,是容器类用于存放
        JPanel jpname = new JPanel();  
        JPanel jpsex = new JPanel();  
        JPanel jpbirthday = new JPanel();  
        JPanel jptel = new JPanel();  
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
          
        jpnumber.add(jlna);  //将“学号”文字添加到新建面板
        jpnumber.add(jtname);  //添加单行文本
          
        jpname.add(jlno);  
        jpname.add(jno);  
          
        jpsex.add(jlsex);  
        jpsex.add(jsex);  
          
        jpbirthday.add(jlbirthday);  
        jpbirthday.add(jbirthday);  
          
        jptel.add(jltel);  
        jptel.add(jtel);  
          
        jpforbutton.add(buttonask);  
  
          
        buttonask.addActionListener(new ActionListener(){  //添加按钮实现的功能
            public void actionPerformed(ActionEvent e){  
                Connection conn = null;  //表示定义 Connection的对象rs，初值为空 
                ResultSet res = null;  //表示定义ResultSet的对象rs，初值为空
                Statement stat = null;   //表示定义Statement的对象rs，初值为空
                  
                String sql = "SELECT * FROM studentinfo;";  //表名为studentinfo
                try{  
                    Class.forName("com.mysql.cj.jdbc.Driver");   //加载驱动
                      
                }catch(Exception d){  
                    System.out.println("jdbc fall");  //加载失败
                    d.printStackTrace();  
                }  
                try{  
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
                    stat=conn.createStatement();  //将值赋给stat
                    res=stat.executeQuery(sql);  //res值为表名
                    while (res.next())  
                    {  
                        if (res.getString(2).equals(jtname.getText()))  
                        {  
                            jno.setText(res.getString(1));  //获取相应数值
                            jsex.setText(res.getString(3));  
                            jbirthday.setText(res.getString(4));  
                            jtel.setText(res.getString(5));  
  
                            break;  
                        }  
                    }  
                }catch (SQLException e1) {  
                    // TODO Auto-generated catch block  
                    e1.printStackTrace();  //查询失败
                  
                  
            }  
                finally{  
                    try{  
                        conn.close();  //完成操作后关闭
                    }catch(SQLException ar){  //关闭失败
                        ar.printStackTrace();  
                    }  
              
                }}}  
              
                );  

          
        this.setTitle("通过姓名查询学生信息");  //将以下信息添加到页面
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

