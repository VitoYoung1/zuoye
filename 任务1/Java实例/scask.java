package bigwork;//�ɼ���ѯ
//ͬask
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class scask extends JFrame{
	
    
	JLabel jlnumber = new JLabel("ѧ�ţ�");  
	JLabel jlname = new JLabel("������"); 
    JLabel jlrequ = new JLabel("���޿Σ�");  
    JLabel jlelec = new JLabel("ѡ�޿Σ�");  
    JLabel jlsum = new JLabel("�ܷ֣�");  
    JLabel jlavg = new JLabel("ƽ����");  
      
    JTextField jtnumber = new JTextField("",20);  
    JLabel jname = new JLabel();  
    JLabel jrequ = new JLabel();  
    JLabel jelec = new JLabel();  
    JLabel jsum = new JLabel();
    JLabel javg = new JLabel(); 
      
    JButton buttonask = new JButton("��ѯ");  
   
      
      
    public scask() {  
    	JPanel jpnumber = new JPanel();  
        JPanel jpname = new JPanel();
        JPanel jprequ = new JPanel();
        JPanel jpelec = new JPanel();  
        JPanel jpsum = new JPanel();  
        JPanel jpavg = new JPanel();  
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));  
          
        jpnumber.add(jlnumber);  
        jpnumber.add(jtnumber);  
          
        jpname.add(jlname);  
        jpname.add(jname);  
          
        jprequ.add(jlrequ);  
        jprequ.add(jrequ);  
          
       
          
        jpelec.add(jlelec);  
        jpelec.add(jelec);  
          
        jpsum.add(jlsum);  
        jpsum.add(jsum);  
          
        jpavg.add(jlavg);  
        jpavg.add(javg);  

          
        jpforbutton.add(buttonask);  
   
          
        buttonask.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Connection conn = null;  
                ResultSet res = null;  
                Statement stat = null;  
                  
                String sql = "SELECT * FROM studentgrade;";  
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
                        if (res.getString(1).equals(jtnumber.getText()))  
                        {  
                            jname.setText(res.getString(2));  
                            jrequ.setText(res.getString(3));  
                            jelec.setText(res.getString(4));  
                            jsum.setText(res.getString(5));  
                            javg.setText(res.getString(6));  
                            break;  
                        }  
                    }  
                }catch (SQLException e1) {  
                    // TODO Auto-generated catch block  
                    e1.printStackTrace();  
                  
                  
            }  
                finally{  
                    try{  
                        conn.close();  
                    }catch(SQLException ar){  
                        ar.printStackTrace();  
                    }  
              
                }}}  
              
                );  
          

          
          
        this.setTitle("��ѯѧ���ɼ���Ϣ");  
        this.setLayout(new GridLayout(9,1));  
        this.add(jpnumber);  
        this.add(jpname);  
        this.add(jprequ);  
        this.add(jpelec);  
        this.add(jpsum); 
        this.add(jpavg); 
        this.add(jpforbutton);  
        this.setLocation(400,300);  
        this.setSize(350,300);  
        this.setVisible(true);  
          
          
    }  
}
