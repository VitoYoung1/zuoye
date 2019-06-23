package bigwork;//界面
import java.sql.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
public class Window {//主页面
	public static void main(String[] args){  
	       JFrame jframe = new JFrame("学生成绩管理系统") ; //window  //页面名字
	       Dimension d = new Dimension(400,300); //页面大小
	       Point p = new Point (850,250);  //页面弹出位置
	         
	       jframe.setSize(d);  //应用刚刚定义的大小位置
	       jframe.setLocation(p);  
	       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //右上角的x选项
	       jframe.setVisible(true);  //使其可见
	        
	       JLabel b1=new JLabel("个人信息");//个人信息栏
	       
	       JButton button1 = new JButton("添加");  //以下为按钮
	       JButton button2 = new JButton("修改");  
	       JButton button3 = new JButton("查询");  
	       JButton button4 = new JButton("删除");  
	       JButton button5 = new JButton("浏览");
	       
	       JLabel jlorder = new JLabel("排序："); //排序选项栏
	       JButton button6 = new JButton("学号");//以下为按钮
	       JButton button7 = new JButton("姓名");
	       JButton button8 = new JButton("年龄");
	      JButton button16 = new JButton("总分");
	 
	    
	       JLabel jlaskby = new JLabel("查询通过："); //查询选项栏
	       JButton button9 = new JButton("姓名");//以下为按钮
	       JButton button10 = new JButton("性别");
	       
	       JLabel b2=new JLabel("成绩信息");//成绩信息选项栏
	       JButton button11 = new JButton("添加");//以下为按钮 
	       JButton button12 = new JButton("修改");  
	       JButton button13 = new JButton("查询");  
	       JButton button14 = new JButton("删除");  
	       JButton button15 = new JButton("浏览");
	       
	         
	       FlowLayout flow = new FlowLayout(FlowLayout.LEFT,10,10);// 指定的左对齐水平和垂直间隙
	       FlowLayout flowa = new FlowLayout(FlowLayout.LEFT,1,3);
	       FlowLayout flowb = new FlowLayout(FlowLayout.LEFT,1,1);
	       GridLayout gridb =new GridLayout(1,3);//创建具有1行和3列数的网格布局
	       
	       JPanel panel = new JPanel(flow);//创建新面板,是容器类用于放按钮那些空间
	       
	       JPanel panelg = new JPanel(flowb);
	       
	       JPanel panela = new JPanel(flowa);
	       JPanel panelb = new JPanel(gridb);
	       
	       JPanel psc = new JPanel(flowb);
	       
	       panelg.add(b1);//以下为添加之前定义的按钮
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
	         
	  
	       
	       jframe.add(panel);  //将定义的面板容器添加到页面
	         
	       button1.addActionListener(new ActionListener(){  //此按钮实现Add类中编写的功能
	            public void actionPerformed(ActionEvent e){  
	                Add add = new Add();   
	  
	            }             
	        });  
	         
	       button2.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	                Change change = new Change();             
	            }             
	        });  
	         
	       button3.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	                Ask ask = new Ask();              
	            }             
	        });  
	         
	       button4.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	                Delete delete = new Delete();             
	            }             
	        });  
	         
	       button5.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	                Look look = new Look();           
	            }             
	        });  
	      
	       button6.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	                ByNo  no = new ByNo();             
	            }             
	        }); 
	       
	       button7.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	ByName na = new ByName();
	            }             
	        });  
	       button8.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	 ByAge  ag = new ByAge();           
	            }             
	        });  
	       button9.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	 askbyname  askna = new askbyname();           
	            }             
	        });  
	       button10.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	askbysex  askse = new askbysex();           
	            }             
	        });  
	      
	       button11.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	 scadd  sc = new scadd();           
	            }             
	        });  
	       
	       button12.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	 scchange  sch = new scchange();           
	            }             
	        });  
	       button13.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	 scask  sca = new scask();           
	            }             
	        });  
	      button14.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	 scdelete  scd = new scdelete();           
	            }             
	        });  
	       button15.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	 sclook  scl = new sclook();           
	            }             
	        });  
	     button16.addActionListener(new ActionListener(){  //同上
	            public void actionPerformed(ActionEvent e){  
	            	 bysum  su = new bysum();           
	            }             
	        });  
	  
	   }  
}
