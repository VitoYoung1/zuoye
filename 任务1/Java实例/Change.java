package bigwork;//�޸���Ϣ
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class Change extends JFrame{
	
    
    JLabel jlnumber = new JLabel("ѧ�ţ�");  //JLabel��������ʾ�ı�
    JLabel jlname = new JLabel("������");  
    JLabel jlsex = new JLabel("�Ա�");  
    JLabel jlbirthday = new JLabel("�������ڣ�");  
    JLabel jltel = new JLabel("�绰��");  
      
    JTextField jtnumber = new JTextField("",20);  //�༭�����ı������ó���
    JTextField jtname = new JTextField("",20);   
    JTextField jtsex = new JTextField("",20);  
    JTextField jtbirthday = new JTextField("",20);  
    JTextField jtel = new JTextField("",20);
    JTextField jtdisplay = new JTextField("",20); 
      
    JButton buttonchange = new JButton("�޸�");   //��ť���
      
      
    public Change() {  
        JPanel jpnumber = new JPanel();  //���������,�����������ڴ��

        JPanel jpname = new JPanel();  
        JPanel jpsex = new JPanel();  
        JPanel jpbirthday = new JPanel();  
        JPanel jptel = new JPanel(); 
        JPanel jpdisplay = new JPanel();
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
          
        jpnumber.add(jlnumber);  //����ѧ�š�������ӵ��½����
        jpnumber.add(jtnumber);  //��ӵ����ı�
          
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
    
          
        buttonchange.addActionListener(new ActionListener(){  //��
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
                                 jtdisplay.setText("�޸ĳɹ�");
                             } catch (SQLException g) {  
                                 // TODO Auto-generated catch block  
                                 g.printStackTrace();  
                                 jtdisplay.setText("�޸�ʧ��");
                             }try{  
                                 stat.close();  // //��ɲ�����ر�
                                 conn.close();  
                             }catch(SQLException ar){  
                                 ar.printStackTrace(); //�ر�ʧ��
                         }  
   
                             break;  
                         }  
                           
                     //change end  
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
               
                 }  
                   
             }  
               
               
         });  

           
         this.setTitle("�޸�ѧ����Ϣ");  //��ӵ����
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
