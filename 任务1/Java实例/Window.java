package bigwork;//����
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class Window {//��ҳ��
	public static void main(String[] args){  
	       JFrame jframe = new JFrame("ѧ���ɼ�����ϵͳ") ; //window  //ҳ������
	       Dimension d = new Dimension(400,300); //ҳ���С
	       Point p = new Point (850,250);  //ҳ�浯��λ��
	         
	       jframe.setSize(d);  //Ӧ�øոն���Ĵ�Сλ��
	       jframe.setLocation(p);  
	       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //���Ͻǵ�xѡ��
	       jframe.setVisible(true);  //ʹ��ɼ�
	        
	       JLabel b1=new JLabel("������Ϣ");//������Ϣ��
	       
	       JButton button1 = new JButton("���");  //����Ϊ��ť
	       JButton button2 = new JButton("�޸�");  
	       JButton button3 = new JButton("��ѯ");  
	       JButton button4 = new JButton("ɾ��");  
	       JButton button5 = new JButton("���");
	       
	       JLabel jlorder = new JLabel("����"); //����ѡ����
	       JButton button6 = new JButton("ѧ��");//����Ϊ��ť
	       JButton button7 = new JButton("����");
	       JButton button8 = new JButton("����");
	      JButton button16 = new JButton("�ܷ�");
	 
	    
	       JLabel jlaskby = new JLabel("��ѯͨ����"); //��ѯѡ����
	       JButton button9 = new JButton("����");//����Ϊ��ť
	       JButton button10 = new JButton("�Ա�");
	       
	       JLabel b2=new JLabel("�ɼ���Ϣ");//�ɼ���Ϣѡ����
	       JButton button11 = new JButton("���");//����Ϊ��ť 
	       JButton button12 = new JButton("�޸�");  
	       JButton button13 = new JButton("��ѯ");  
	       JButton button14 = new JButton("ɾ��");  
	       JButton button15 = new JButton("���");
	       
	         
	       FlowLayout flow = new FlowLayout(FlowLayout.LEFT,10,10);// ָ���������ˮƽ�ʹ�ֱ��϶
	       FlowLayout flowa = new FlowLayout(FlowLayout.LEFT,1,3);
	       FlowLayout flowb = new FlowLayout(FlowLayout.LEFT,1,1);
	       GridLayout gridb =new GridLayout(1,3);//��������1�к�3���������񲼾�
	       
	       JPanel panel = new JPanel(flow);//���������,�����������ڷŰ�ť��Щ�ռ�
	       
	       JPanel panelg = new JPanel(flowb);
	       
	       JPanel panela = new JPanel(flowa);
	       JPanel panelb = new JPanel(gridb);
	       
	       JPanel psc = new JPanel(flowb);
	       
	       panelg.add(b1);//����Ϊ���֮ǰ����İ�ť
	       panelg.add(button1);  
	       panelg.add(button2);  
	       panelg.add(button3);  
	       panelg.add(button4);  
	       panelg.add(button5);
	       panel.add(panelg);
	       
	       
	       panela.add(jlorder);
	       panela.add(button6);
	       panela.add(button7);
	       panela.add(button8);
	      panela.add(button16);
	     
	       panel.add(panela);
	       
	       panelb.add(jlaskby);
	       panelb.add(button9);
	       panelb.add(button10);
	       panel.add(panelb);
	       
	   
	       
	       psc.add(b2);
	       psc.add(button11);
	       psc.add(button12);  
	       psc.add(button13);  
	       psc.add(button14);  
	       psc.add(button15);
	       panel.add(psc);
	         
	  
	       
	       jframe.add(panel);  //����������������ӵ�ҳ��
	         
	       button1.addActionListener(new ActionListener(){  //�˰�ťʵ��Add���б�д�Ĺ���
	            public void actionPerformed(ActionEvent e){  
	                Add add = new Add();   
	  
	            }             
	        });  
	         
	       button2.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	                Change change = new Change();             
	            }             
	        });  
	         
	       button3.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	                Ask ask = new Ask();              
	            }             
	        });  
	         
	       button4.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	                Delete delete = new Delete();             
	            }             
	        });  
	         
	       button5.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	                Look look = new Look();           
	            }             
	        });  
	      
	       button6.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	                ByNo  no = new ByNo();             
	            }             
	        }); 
	       
	       button7.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	ByName na = new ByName();
	            }             
	        });  
	       button8.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	 ByAge  ag = new ByAge();           
	            }             
	        });  
	       button9.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	 askbyname  askna = new askbyname();           
	            }             
	        });  
	       button10.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	askbysex  askse = new askbysex();           
	            }             
	        });  
	      
	       button11.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	 scadd  sc = new scadd();           
	            }             
	        });  
	       
	       button12.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	 scchange  sch = new scchange();           
	            }             
	        });  
	       button13.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	 scask  sca = new scask();           
	            }             
	        });  
	      button14.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	 scdelete  scd = new scdelete();           
	            }             
	        });  
	       button15.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	 sclook  scl = new sclook();           
	            }             
	        });  
	     button16.addActionListener(new ActionListener(){  //ͬ��
	            public void actionPerformed(ActionEvent e){  
	            	 bysum  su = new bysum();           
	            }             
	        });  
	  
	   }  
}
