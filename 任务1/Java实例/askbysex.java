package bigwork;//ͨ���Ա��ѯ
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  

import javax.swing.*;  

import java.util.*;  
public class askbysex extends JFrame {  
   
  
	Connection conn = null;  //��ʾ���� Connection�Ķ���rs����ֵΪ�� 
    PreparedStatement ps = null;  //��ʾ����ResultSet�Ķ���rs����ֵΪ��
    ResultSet res = null;  //��ʾ����Statement�Ķ���rs����ֵΪ��
    
    JButton buttongirl = new JButton("Ů");  //�½���Ů��ť
    JButton buttonboy = new JButton("��");
    
    JTable jtable; //�������Ա�����ʽ��ʾ���û�
    JTable jtable1;  
    JScrollPane jscrollpane = new JScrollPane();  // �������
    
    Vector columnNames = null;  //�����Զ������Ķ�������
    Vector rowData = null; 
      
    public askbysex() { 
    	JPanel jpsex = new JPanel(); //�������
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
  
        columnNames = new Vector();  //������ֵ���������
        columnNames.add("ѧ��");  
        columnNames.add("����");  
        columnNames.add("�Ա�");  
        columnNames.add("��������");  
        columnNames.add("�绰");  
        rowData = new Vector();  
          
        jpsex.add(buttongirl); //��ӵ����
        jpsex.add(buttonboy); 
        
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");  //��������
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme");  
            ps = conn.prepareStatement("select * from studentinfo"); 
            res = ps.executeQuery();  
            while (res.next())  
            {  
                Vector hang = new Vector();  //��ȡ��Ӧ��ֵ
                hang.add(res.getString(1));  
                hang.add(res.getString(2));  
                hang.add(res.getString(3));  
                hang.add(res.getString(4));  
                hang.add(res.getString(5));  
                rowData.add(hang);  
                  
            }  
            System.out.println("load  ok!");  //�ɹ�
        }catch (Exception q){  
            q.printStackTrace();  
            System.out.println("go die");  //ʧ��
        }finally{  
            try{  
                res.close();  
                ps.close();  
                conn.close();  
                System.out.println("close ok");  //�ɹ��ر����ݿ�
            }catch (SQLException o){  
                o.printStackTrace();  
                System.out.println("go die 2");  //�ر�ʧ��
            }  
        }  
          
        
jtable = new JTable(rowData,columnNames);  //�������Ա�����ʽ��ʾ
jscrollpane = new JScrollPane(jtable);        //�������
        
buttongirl.addActionListener(new ActionListener(){  //��ťʵ�ֹ���
    public void actionPerformed(ActionEvent e){  
        girl g = new girl();              
    }             
});      

buttonboy.addActionListener(new ActionListener(){  //ͬ��
    public void actionPerformed(ActionEvent e){  
        boy b = new boy();              
    }             
}); 


        
        this.add(jpsex);//��ӵ����
        this.add(jscrollpane); 
        this.setTitle("ͨ���Ա��ѯѧ����Ϣ");  
        this.setLayout(new GridLayout(3,5));  
        this.add(jpforbutton);  
        this.setLocation(300,300);  
        this.setSize(500,300);  
        this.setVisible(true);  
        this.setResizable(false);  
          
    }  
    
      
}  

