package bigwork;//��ӹ���
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
import com.mysql.jdbc.Driver; 
public class Add extends JFrame{
	

    
    JLabel jlnumber = new JLabel("ѧ�ţ�");  //JLabel��������ʾ�ı�
    JLabel jlname = new JLabel("������");  
    JLabel jlsex = new JLabel("�Ա�");  
    JLabel jlbirthday = new JLabel("�������ڣ�");  
    JLabel jltel = new JLabel("�绰��");  
      
    JTextField jtnumber = new JTextField("",20); //�༭�����ı������ó���
    JTextField jtname = new JTextField("",20);  
    JTextField jtsex = new JTextField("",20);  
    JTextField jtbirthday = new JTextField("",20);  
    JTextField jttel = new JTextField("",20);  
    JTextField jtdisplay = new JTextField("",20); 
      
    JButton buttonadd = new JButton("���");  //��ť���

      
      
    public Add() {  
        JPanel jpnumber = new JPanel();  //���������,�����������ڴ��
        JPanel jpname = new JPanel();  
        JPanel jpsex = new JPanel();  
        JPanel jpbirthday = new JPanel();  
        JPanel jptel = new JPanel();  
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
        JPanel jpdisplay = new JPanel(); 
          
        jpnumber.add(jlnumber);  //����ѧ�š�������ӵ��½����
        jpnumber.add(jtnumber);  //��ӵ����ı�
          
        jpname.add(jlname);  //ͬ��
        jpname.add(jtname);  //ͬ��
          
        jpsex.add(jlsex);  //ͬ��
        jpsex.add(jtsex);  //ͬ��
          
        jpbirthday.add(jlbirthday);  //ͬ��
        jpbirthday.add(jtbirthday);  //ͬ��
          
        jptel.add(jltel);  //ͬ��
        jptel.add(jttel);  //ͬ��
        
        jpdisplay.add(jtdisplay);//ͬ��
          
        jpforbutton.add(buttonadd);  //ͬ��
    
          
        buttonadd.addActionListener(new ActionListener(){  //��Ӱ�ťʵ�ֵĹ���
            public void actionPerformed(ActionEvent e){  
                Connection conn = null;  //��ʾ���� Connection�Ķ���rs����ֵΪ��
                ResultSet res = null;  //��ʾ����ResultSet�Ķ���rs����ֵΪ��
                Statement stat = null; //��ʾ����Statement�Ķ���rs����ֵΪ��
                PreparedStatement ps=null;  //��ʾ����PreparedStatement�Ķ���rs����ֵΪ��
  
                String sqla = "SELECT * FROM studentinfo;";  //����Ϊstudentinfo
                try{  
                    Class.forName("com.mysql.cj.jdbc.Driver");  //��������
                      
                }catch(Exception d){  
                    System.out.println("jdbc fall");  //����ʧ��
                    d.printStackTrace();  
                }  
                try{  
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme"); //�������ݿ���û��������� 
                    stat=conn.createStatement();  //��ֵ����stat
                    res=stat.executeQuery(sqla);  //resֵΪ����
                   
                 
                            String sql = "insert into studentinfo values(?,?,?,?,?)";//��ֹ��ȡ����
                            ps=conn.prepareStatement(sql);
                            ps.setString(1,jtnumber.getText());  //���������ֵ���뵽���ݿ�ı���
                            ps.setString(2,jtname.getText());  
                            ps.setString(3,jtsex.getText());  
                            ps.setString(4,jtbirthday.getText());  
                            ps.setString(5,jttel.getText());  
  
                    ps.executeUpdate();   
                    
                    jtdisplay.setText("����ɹ�");//�ı�����ʾ����ɹ�
                        
                      
                    
                }catch (SQLException e1) {  //����ʧ��
                    // TODO Auto-generated catch block  
                	 e1.printStackTrace();  
                	 jtdisplay.setText("����ʧ�ܣ������ѧ���Ƿ��Ѵ���");//�ı�����ʾ����ʧ��
                  
                  
            }  
                finally{  
                    try{  
                        conn.close();  
                        System.out.println("MySQL �رճɹ�");//��ɲ�����ر�
                    }catch(SQLException ar){ 
                        System.out.println("MySQL �ر�ʧ�� "); //�ر�ʧ��
                        ar.printStackTrace();  
                    }  
              
                }}}  
              
                );  
          
         
          
          
        this.setTitle("���ѧ��������Ϣ");  //��������Ϣ��ӵ�ҳ��
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
