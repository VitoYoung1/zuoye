package bigwork;//通过年龄排序
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import java.util.*;  
public class ByAge extends JFrame {  
   
      
	Connection conn = null;  //略
    PreparedStatement ps = null;  
    ResultSet res = null;  
      
      
    JTable jtable;  //数据以表格的形式显示
    JScrollPane jscrollpane = new JScrollPane();  //滚动面板
      
    Vector columnNames = null; //自动增长的对象数组
    Vector rowData = null;  
      
    public ByAge() {  
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  //新面板
  
        columnNames = new Vector();  //添加文字
        columnNames.add("学号");  
        columnNames.add("姓名");  
        columnNames.add("性别");  
        columnNames.add("出生日期");  
        columnNames.add("电话");  
        rowData = new Vector();  
          
          
          
        try {  //以下为连接数据库具体代码之前有
            Class.forName("com.mysql.cj.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
            ps = conn.prepareStatement("SELECT * FROM studentinfo order by Birthday ");  
            res = ps.executeQuery();  
            while (res.next())  
            {  
                Vector hang = new Vector();  
                hang.add(res.getString(1));  
                hang.add(res.getString(2));  
                hang.add(res.getString(3));  
                hang.add(res.getString(4));  
                hang.add(res.getString(5));  
                rowData.add(hang);  
                  
            }  
            System.out.println("load  ok!");  
        }catch (Exception q){  
            q.printStackTrace();  
            System.out.println("go die");  
        }finally{  
            try{  
                res.close();  
                ps.close();  
                conn.close();  
                System.out.println("close ok");  
            }catch (SQLException o){  
                o.printStackTrace();  
                System.out.println("go die 2");  
            }  
        }  
          
          
          
          
        jtable = new JTable(rowData,columnNames);  //定义面板
        jscrollpane = new JScrollPane(jtable);  
          
        this.add(jscrollpane);  
        this.setTitle("按年龄排序显示学生信息(降序)");  //添加到面板
        this.setLayout(new GridLayout(2,5));  
        this.add(jpforbutton);  
        this.setLocation(300,300);  
        this.setSize(500,300);  
        this.setVisible(true);  
        this.setResizable(false);  
          
    }  
      
      
}  

