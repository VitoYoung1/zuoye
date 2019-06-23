package bigwork;//通过性别查询
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  

import javax.swing.*;  

import java.util.*;  
public class askbysex extends JFrame {  
   
  
	Connection conn = null;  //表示定义 Connection的对象rs，初值为空 
    PreparedStatement ps = null;  //表示定义ResultSet的对象rs，初值为空
    ResultSet res = null;  //表示定义Statement的对象rs，初值为空
    
    JButton buttongirl = new JButton("女");  //新建男女按钮
    JButton buttonboy = new JButton("男");
    
    JTable jtable; //将数据以表格的形式显示给用户
    JTable jtable1;  
    JScrollPane jscrollpane = new JScrollPane();  // 滚动面板
    
    Vector columnNames = null;  //定义自动增长的对象数组
    Vector rowData = null; 
      
    public askbysex() { 
    	JPanel jpsex = new JPanel(); //定义面板
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
  
        columnNames = new Vector();  //添加文字到对象数组
        columnNames.add("学号");  
        columnNames.add("姓名");  
        columnNames.add("性别");  
        columnNames.add("出生日期");  
        columnNames.add("电话");  
        rowData = new Vector();  
          
        jpsex.add(buttongirl); //添加到面板
        jpsex.add(buttonboy); 
        
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");  //加载驱动
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
            ps = conn.prepareStatement("select * from studentinfo"); 
            res = ps.executeQuery();  
            while (res.next())  
            {  
                Vector hang = new Vector();  //获取相应数值
                hang.add(res.getString(1));  
                hang.add(res.getString(2));  
                hang.add(res.getString(3));  
                hang.add(res.getString(4));  
                hang.add(res.getString(5));  
                rowData.add(hang);  
                  
            }  
            System.out.println("load  ok!");  //成功
        }catch (Exception q){  
            q.printStackTrace();  
            System.out.println("go die");  //失败
        }finally{  
            try{  
                res.close();  
                ps.close();  
                conn.close();  
                System.out.println("close ok");  //成功关闭数据库
            }catch (SQLException o){  
                o.printStackTrace();  
                System.out.println("go die 2");  //关闭失败
            }  
        }  
          
        
jtable = new JTable(rowData,columnNames);  //将数据以表格的形式显示
jscrollpane = new JScrollPane(jtable);        //滚动面板
        
buttongirl.addActionListener(new ActionListener(){  //按钮实现功能
    public void actionPerformed(ActionEvent e){  
        girl g = new girl();              
    }             
});      

buttonboy.addActionListener(new ActionListener(){  //同上
    public void actionPerformed(ActionEvent e){  
        boy b = new boy();              
    }             
}); 


        
        this.add(jpsex);//添加到面板
        this.add(jscrollpane); 
        this.setTitle("通过性别查询学生信息");  
        this.setLayout(new GridLayout(3,5));  
        this.add(jpforbutton);  
        this.setLocation(300,300);  
        this.setSize(500,300);  
        this.setVisible(true);  
        this.setResizable(false);  
          
    }  
    
      
}  

