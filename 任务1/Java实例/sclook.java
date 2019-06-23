package bigwork;//浏览
//同look
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import java.util.*;  
public class sclook extends JFrame {  
   
      
	Connection conn = null;  
    PreparedStatement ps = null;  
    ResultSet res = null;  
      

      
    JTable jtable;  
    JScrollPane jscrollpane = new JScrollPane();  
      
    Vector columnNames = null;  
    Vector rowData = null;  
      
    public sclook() {  
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
  
        columnNames = new Vector();  
        columnNames.add("学号");  
        columnNames.add("姓名");  
        columnNames.add("必修课");  
        columnNames.add("选修课");  
        columnNames.add("总分"); 
        columnNames.add("平均分");  
        rowData = new Vector();  
          
    
          
          
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
            ps = conn.prepareStatement("SELECT * FROM studentgrade");  
            res = ps.executeQuery();  
            while (res.next())  
            {  
                Vector hang = new Vector();  
                hang.add(res.getString(1));  
                hang.add(res.getString(2));  
                hang.add(res.getString(3));  
                hang.add(res.getString(4));  
                hang.add(res.getString(5)); 
                hang.add(res.getString(6)); 
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
          
          
          
          
        jtable = new JTable(rowData,columnNames);  
        jscrollpane = new JScrollPane(jtable);  
          
        this.add(jscrollpane);  
        this.setTitle("浏览学生成绩信息");  
        this.setLayout(new GridLayout(2,5));  
        this.add(jpforbutton);  
        this.setLocation(300,300);  
        this.setSize(500,300);  
        this.setVisible(true);  
        this.setResizable(false);  
          
    }  
      
      
}  