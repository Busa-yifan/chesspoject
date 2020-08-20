package ChessClient;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ChessClient.chessboard.ENTER_ActionListener;
import ChessClient.chessboard.MyWindowListener;
import ChessClient.chessboard.Sendmsg_ActionListener;



public  class hall extends JFrame 
	{
		static JTextField numberField;
		static JPasswordField passwordField;
		static JLabel jlabel1,jlabel2,jlabel3,beijing,deskpic;
	    JLabel de[];
		JButton se[];
		JLabel sn[];
		static DataInputStream dis;
	    static DataOutputStream dos;
	    static chessuser myuser;
	    static Seat seat[];
	    static chessboard myboard;
	    static JFrame jf;
	    static boolean haveseat=false;
	    static JPanel msgPanel;
        static JTextArea textarea;
        static JTextField sendField;
        static JLabel qqph;
        static JButton jbsend;
        
        
        
        
        static public class Sendmsg_ActionListener implements ActionListener
    	{
    			public void actionPerformed(ActionEvent e)
    		{			
    				String msg="";
    				if(!sendField.getText().equals(""))
    				     { 
    					     msg=sendField.getText();
    					     sendField.setText("");
    					     textarea.append(myuser.name+"："+msg+"\n");
    					     sendField.requestFocusInWindow();
    				     }
    		           try {
    						dos.writeUTF("14:"+myuser.name+"："+msg);									
    					} catch (IOException e1) {
    						// TODO 自动生成的 catch 块
    						e1.printStackTrace();
    					}
    		}
    	}
    	static public class ENTER_ActionListener implements ActionListener
    	{
    	public void actionPerformed(ActionEvent e)
    	 {
    	  if(e.getSource()==sendField)
    	  {
    		  String msg="";
    			if(!sendField.getText().equals(""))
    			     { 
    				     msg=sendField.getText();
    				     sendField.setText("");
    				     textarea.append(myuser.name+"："+msg+"\n");
    				     sendField.requestFocusInWindow();
    			     }
    	           try {
    					dos.writeUTF("14:"+myuser.name+"："+msg);									
    				} catch (IOException e1) {
    					// TODO 自动生成的 catch 块
    					e1.printStackTrace();
    				}
    	  }
    	 }
    	}
	   
	    class MyWindowListener extends WindowAdapter
		  {
		     public void windowClosing(WindowEvent e)//窗口正处在关闭过程中时调用
		     {
		    	 try {
					dos.writeUTF("88:");
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}		    	  
		     }
		 }
		static public class gamestart0 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {
					    if(!seat[0].issit)
					    {
					    	myboard= new chessboard(myuser,"red",0);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":0");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }
						     seat[0].issit=true;
						     seat[0].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[1].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[1].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart1 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {
					    if(!seat[1].issit)
					    {
					    	myboard= new chessboard(myuser,"black",1);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":1");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[1].issit=true;
						     seat[1].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[0].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[0].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart2 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {
					    if(!seat[2].issit)
					    {
					    	myboard= new chessboard(myuser,"red",2);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":2");								

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[2].issit=true;
						     seat[2].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[3].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[3].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart3 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {
			      
					    if(!seat[3].issit)
					    {
					    	myboard= new chessboard(myuser,"black",3);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":3");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[3].issit=true;
						     seat[3].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[2].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[2].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart4 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {					 
					 if(!haveseat)
					 {
					    if(!seat[4].issit)
					    {
					    	myboard= new chessboard(myuser,"red",4);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":4");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[4].issit=true;
						     seat[4].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[5].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[5].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart5 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {			      
					    if(!seat[5].issit)
					    {
					    	myboard= new chessboard(myuser,"black",5);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":5");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[5].issit=true;
						     seat[5].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[4].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[4].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart6 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {			      
					    if(!seat[6].issit)
					    {
					    	myboard= new chessboard(myuser,"red",6);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":6");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[6].issit=true;
						     seat[6].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[7].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[7].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart7 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {		      
					    if(!seat[7].issit)
					    {
					    	myboard= new chessboard(myuser,"black",7);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":7");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[7].issit=true;
						     seat[7].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[6].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[6].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart8 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {			      
					    if(!seat[8].issit)
					    {
					    	myboard= new chessboard(myuser,"red",8);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":8");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[8].issit=true;
						     seat[8].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[9].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[9].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart9 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {			      
					    if(!seat[9].issit)
					    {
					    	myboard= new chessboard(myuser,"black",9);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":9");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[9].issit=true;
						     seat[9].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[8].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[8].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart10 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {
					 if(!haveseat)
					 {			      
					    if(!seat[10].issit)
					    {
					    	myboard= new chessboard(myuser,"red",10);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":10");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[10].issit=true;
						     seat[10].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[11].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[11].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart11 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {
					 if(!haveseat)
					 {			    
					    if(!seat[11].issit)
					    {
					    	myboard= new chessboard(myuser,"black",11);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":11");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[11].issit=true;
						     seat[11].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[10].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[10].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart12 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {			     
					    if(!seat[12].issit)
					    {
					    	myboard= new chessboard(myuser,"red",12);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":12");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[12].issit=true;
						     seat[12].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[13].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[13].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart13 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {		     
					    if(!seat[13].issit)
					    {
					    	myboard= new chessboard(myuser,"black",13);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":13");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[13].issit=true;
						     seat[13].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[12].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[12].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart14 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					if(!haveseat)
					{
					 if(!seat[14].issit)
					    {
					    	myboard= new chessboard(myuser,"red",14);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":14");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[14].issit=true;
						     seat[14].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[15].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[15].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					}
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart15 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {
					  if(!seat[15].issit)
					    {
					    	myboard= new chessboard(myuser,"black",15);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":15");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[15].issit=true;
						     seat[15].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[14].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[14].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart16 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {
					 if(!haveseat)
					 {			      
					    if(!seat[16].issit)
					    {
					    	myboard= new chessboard(myuser,"red",16);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":16");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[16].issit=true;
						     seat[16].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[17].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[17].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      } 
		static public class gamestart17 extends JFrame implements ActionListener
		{
			
				 public void actionPerformed(ActionEvent e1)
			      {	
					 if(!haveseat)
					 {			      
					    if(!seat[17].issit)
					    {
					    	myboard= new chessboard(myuser,"black",17);	
						     try {
								 dos.writeUTF("00:"+myuser.name+":"+myuser.imgnum+":17");

							   } catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							   }	
						     seat[17].issit=true;
						     seat[17].name=myuser.name;
						     haveseat=true;
					    }
					    else  JOptionPane.showMessageDialog(null,"该座位有人了！");
					    if(seat[16].issit)
					    {
					    	  try {
								dos.writeUTF("04:"+myuser.name+":"+seat[16].name);
								dos.writeUTF("10:"+myuser.name+":"+myuser.imgnum+":"+myuser.level);
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					    }
					 }
					 else JOptionPane.showMessageDialog(null,"你已经在一个座位上了！");
				  }				
	      }
		
			 
		 
		
		public hall(chessuser myuser)
		{
		 
		 jf=this;
		 addWindowListener(new MyWindowListener());
		 this.myuser=myuser;
		 this.dis=myuser.dis;
		 this.dos=myuser.dos;
		 seat=new Seat[18];
		 se=new JButton[18];
		 sn=new JLabel[18];
         de=new JLabel[9];
		 for(int i=0;i<=17;i++)
		 {
			 se[i]=new JButton();
			 se[i].setIcon(new ImageIcon("image//img//noone.gif"));
			 sn[i]=new JLabel("");
			 sn[i].setForeground(Color.WHITE);
			 seat[i] = new Seat();
			 this.add(sn[i]);
			 this.add(se[i]);
		 }
		 for(int i=0;i<=8;i++)
		 {
			 de[i]=new JLabel("");
			 de[i].setIcon(new ImageIcon("image//img//xqnoone.gif"));
			 this.add(de[i]);
		 }
        

		beijing = new JLabel();
		ImageIcon image = new ImageIcon("image\\img\\gamehall.png");
		image.setImage(image.getImage().getScaledInstance(1200, 800,Image.SCALE_DEFAULT ));
		beijing.setIcon(image);
		
		qqph = new JLabel();
		ImageIcon image2 = new ImageIcon("image\\img\\boy1.gif");
		image2.setImage(image2.getImage().getScaledInstance(230, 350,Image.SCALE_DEFAULT ));
		qqph.setIcon(image2);
		
		msgPanel = new JPanel();
		textarea = new JTextArea(20,20);
		textarea.setLineWrap(true);
		textarea.setEditable(false);
		JScrollPane jsp = new JScrollPane(textarea);
		sendField = new JTextField(12);
		jbsend = new JButton("发送");
		

		
		

		
		
		

        this.add(msgPanel);
        msgPanel.add(qqph);
        msgPanel.add(jsp);
        msgPanel.add(sendField);
        msgPanel.add(jbsend);
		this.add(beijing);
		ENTER_ActionListener eaction = new ENTER_ActionListener();
        sendField.addActionListener(eaction);
		Sendmsg_ActionListener sendaction = new Sendmsg_ActionListener();
		jbsend.addActionListener(sendaction);
		
		msgPanel.setBounds(970, 0, 230,800);
	    beijing.setBounds(0, 0, 1000,800);
	    se[8].setBounds(380, 385, 40,45);
	    se[9].setBounds(510, 385, 40,45);
	    de[4].setBounds(440, 380, 53,53);
	    sn[8].setBounds(380, 430, 50,30);
	    sn[9].setBounds(510, 430, 50,30);
	    
	    se[6].setBounds(80, 385, 40,45);
	    se[7].setBounds(210, 385, 40,45);
	    sn[6].setBounds(80, 430, 50,30);
	    sn[7].setBounds(210, 430, 50,30);
	    de[3].setBounds(140, 380, 53,53);
	    
	    se[10].setBounds(680, 385, 40,45);
	    se[11].setBounds(810, 385, 40,45);
	    sn[10].setBounds(680, 430, 50,30);
	    sn[11].setBounds(810, 430, 50,30);
	    de[5].setBounds(740, 380, 53,53);
	    
	    se[4].setBounds(680, 185, 40,45);
	    se[5].setBounds(810, 185, 40,45);
	    de[2].setBounds(740, 180, 53,53);
	    sn[4].setBounds(380, 230, 50,30);
	    sn[5].setBounds(510, 230, 50,30);
	    
	    se[0].setBounds(80, 185, 40,45);
	    se[1].setBounds(210, 185, 40,45);
	    sn[0].setBounds(80, 230, 50,30);
	    sn[1].setBounds(210, 230, 50,30);
	    de[0].setBounds(140, 180, 53,53);
	    
	    se[2].setBounds(380, 185, 40,45);
	    se[3].setBounds(510, 185, 40,45);
	    de[1].setBounds(440, 180, 53,53);
	    sn[2].setBounds(380, 230, 50,30);
	    sn[3].setBounds(510, 230, 50,30);
	    
	    se[14].setBounds(380, 585, 40,45);
	    se[15].setBounds(510, 585, 40,45);
	    de[7].setBounds(440, 580, 53,53);
	    sn[14].setBounds(380, 630, 50,30);
	    sn[15].setBounds(510, 630, 50,30);
	    
	    se[12].setBounds(80, 585, 40,45);
	    se[13].setBounds(210, 585, 40,45);
	    sn[12].setBounds(80, 630, 50,30);
	    sn[13].setBounds(210, 630, 50,30);
	    de[6].setBounds(140, 580, 53,53);
	    
	    se[16].setBounds(680, 585, 40,45);
	    se[17].setBounds(810, 585, 40,45);
	    sn[16].setBounds(680, 630, 50,30);
	    sn[17].setBounds(810, 630, 50,30);
	    de[8].setBounds(740, 580, 53,53);
	    
	    
	    
	
	    gamestart0 gs0 = new gamestart0();
	    gamestart1 gs1 = new gamestart1();
	    gamestart2 gs2 = new gamestart2();
	    gamestart3 gs3 = new gamestart3();
	    gamestart4 gs4 = new gamestart4();
	    gamestart5 gs5 = new gamestart5();
	    gamestart6 gs6 = new gamestart6();
	    gamestart7 gs7 = new gamestart7();
	    gamestart8 gs8 = new gamestart8();
	    gamestart9 gs9 = new gamestart9();
	    gamestart10 gs10 = new gamestart10();
	    gamestart11 gs11 = new gamestart11();
	    gamestart12 gs12 = new gamestart12();
	    gamestart13 gs13 = new gamestart13();
	    gamestart14 gs14 = new gamestart14();
	    gamestart15 gs15 = new gamestart15(); 
	    gamestart16 gs16 = new gamestart16();
	    gamestart17 gs17 = new gamestart17();
	    
	    se[0].addActionListener(gs0);
	    se[1].addActionListener(gs1);
	    se[2].addActionListener(gs2);
	    se[3].addActionListener(gs3);
	    se[4].addActionListener(gs4);
	    se[5].addActionListener(gs5);
	    se[6].addActionListener(gs6);
	    se[7].addActionListener(gs7);
	    se[8].addActionListener(gs8);
	    se[9].addActionListener(gs9);
	    se[10].addActionListener(gs10);
	    se[11].addActionListener(gs11);
	    se[12].addActionListener(gs12);
	    se[13].addActionListener(gs13);
	    se[14].addActionListener(gs14);
	    se[15].addActionListener(gs15);
	    se[16].addActionListener(gs16);
	    se[17].addActionListener(gs17);
	    
	    
	     
	    this.setSize(1200, 800);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setVisible(true);
	    this.setTitle("游戏大厅");
	    int windowWidth = this.getWidth(); //获得窗口宽
	    int windowHeight = this.getHeight(); //获得窗口高
	    Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
	    Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
	    int screenWidth = screenSize.width; //获取屏幕的宽
	    int screenHeight = screenSize.height; //获取屏幕的高
	    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
	    
	    
		}
		


		
	}