package bigwork;//��ѯ����
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class Ask extends JFrame{
	
    
    JLabel jlnumber = new JLabel("ѧ�ţ�");  //JLabel��������ʾ�ı�
    JLabel jlname = new JLabel("������");  
    JLabel jlsex = new JLabel("�Ա�");  
    JLabel jlbirthday = new JLabel("�������ڣ�");  
    JLabel jltel = new JLabel("�绰��");  
      
    JTextField jtnumber = new JTextField("",20);  //�༭�����ı������ó���
    JLabel jname = new JLabel();  //�����
    JLabel jsex = new JLabel();  
    JLabel jbirthday = new JLabel();  
    JLabel jtel = new JLabel();  
      
    JButton buttonask = new JButton("��ѯ");  //��ť���
  
      
      
    public Ask() {  
        JPanel jpnumber = new JPanel();  //���������,�����������ڴ��
        JPanel jpname = new JPanel();  
        JPanel jpsex = new JPanel();  
        JPanel jpbirthday = new JPanel();  
        JPanel jptel = new JPanel();  
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
          
        jpnumber.add(jlnumber);  //����ѧ�š�������ӵ��½����
        jpnumber.add(jtnumber);  //��ӵ����ı�
          
        jpname.add(jlname);  //ͬ��
        jpname.add(jname);  //ͬ��
          
        jpsex.add(jlsex);  //ͬ��
        jpsex.add(jsex);  //ͬ��
          
        jpbirthday.add(jlbirthday);  //ͬ��
        jpbirthday.add(jbirthday);  //ͬ��
          
        jptel.add(jltel);  //ͬ��
        jptel.add(jtel);  //ͬ��
          
        jpforbutton.add(buttonask);  //ͬ�ϣ���ѯ��

          
        buttonask.addActionListener(new ActionListener(){  //��Ӱ�ťʵ�ֵĹ���
            public void actionPerformed(ActionEvent e){  
                Connection conn = null;  //��ʾ���� Connection�Ķ���rs����ֵΪ��
                ResultSet res = null;  //��ʾ����ResultSet�Ķ���rs����ֵΪ��
                Statement stat = null;  //��ʾ����Statement�Ķ���rs����ֵΪ��
                  
                String sql = "SELECT * FROM studentinfo;";  //����Ϊstudentinfo
                try{  
                    Class.forName("com.mysql.cj.jdbc.Driver");   //��������
                      
                }catch(Exception d){  
                    System.out.println("jdbc fall");   //����ʧ��
                    d.printStackTrace();  
                }  
                try{  
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student"+  "?serverTimezone=GMT%2B8","root","gaoruiboisme"); //�������ݿ���û���������  
                    stat=conn.createStatement();  //��ֵ����stat
                    res=stat.executeQuery(sql);  //resֵΪ����
                    while (res.next())  
                    {  
                        if (res.getString(1).equals(jtnumber.getText()))  
                        {  
                            jname.setText(res.getString(2));  //��ȡ����Ӧ����ֵ
                            jsex.setText(res.getString(3));  
                            jbirthday.setText(res.getString(4));  
                            jtel.setText(res.getString(5));  
  
                            break;  
                        }  
                    }  
                }catch (SQLException e1) {  //��ѯʧ��
                    // TODO Auto-generated catch block  
                    e1.printStackTrace();  
                  
                  
            }  
                finally{  
                    try{  
                        conn.close();  //��ɲ�����ر�
                    }catch(SQLException ar){  
                        ar.printStackTrace();  //�ر�ʧ��
                    }  
              
                }}}  
              
                );  
          

          
        this.setTitle("��ѯѧ��������Ϣ");   //��������Ϣ��ӵ�ҳ��
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
