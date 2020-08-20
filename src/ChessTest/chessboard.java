package ChessTest;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.swing.BorderFactory;
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
import javax.swing.border.EtchedBorder;

import ChessClient.login.SignUp_ActionListener;

public  class chessboard  extends JFrame{

	 public chesspoint point[][];
	 public chesspiece chesspieces[];
	 static DataInputStream dis;
	 static DataOutputStream dos;
	 JLabel select;
	 int xjiange=598/8,yjiange=606/9,exjiange=xjiange/3,eyjiange=yjiange/3;
	 int mousecount=0;
	 int hisx=-1,hisy=-1,hisselectx=-1,hisselecty=-1;
	 String selectname="",selectchessname="",selectside;
	 String myside;
	 static chessuser myuser;
	 static JButton jb1,jb2,jb3,jbsend;
	 static JLabel beijing,muban,muban2,myimg,oppimg,myname,oppname,mylevel,opplevel,ready1,ready2,turn1,turn2;
	 static boolean turn=false;
	 static boolean isEnd=true;
	 static boolean isReady=false;
	 static JFrame jf;
	 static int seatnum;
	 static JPanel userPanel,chatPanel;
	 static JTextField enterField;
	 static JTextArea chatArea;
	 static boolean isBUSA=false;

	 
	 JPanel panel = new JPanel() {
  	   
	protected void paintComponent(Graphics g) {
	    ImageIcon icon = new ImageIcon("image\\qizi\\xqboard.gif");
	    Image img = icon.getImage();
	    g.drawImage(img, 0, 0, 700,
	      700, icon.getImageObserver());
	     this.setSize(700, 700);
	   }
	};


	
	class MyWindowListener extends WindowAdapter
	  {
	     public void windowClosing(WindowEvent e)//窗口正处在关闭过程中时调用
	     {
	    	 if(isEnd)
				{
			      jf.dispose();
			      try {
			    	    dos.writeUTF("11:");
			    	    dos.writeUTF("13:");
						dos.writeUTF("03:"+seatnum);									
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
				else
				{
					int n=JOptionPane.showConfirmDialog(jf, "当前正在游戏，确定退出比赛吗？");
					 if(n==0)
					 {
					    jf.dispose();
				           try {
				        	   dos.writeUTF("11:");
				        	   dos.writeUTF("13:");
				        	   dos.writeUTF("09:");	
							   dos.writeUTF("03:"+seatnum);						   
						   } catch (IOException e1) {
							// TODO 自动生成的 catch 块
							 e1.printStackTrace();
						   }
					 }
					 
				}
	     }
	 }
	
	
	static public class Exit_ActionListener implements ActionListener
	{
			public void actionPerformed(ActionEvent e)
		{
				if(isEnd)
				{
			      jf.dispose();
			      try {
			    	    dos.writeUTF("11:"); 
			    	    dos.writeUTF("13:");
						dos.writeUTF("03:"+seatnum);									
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
				else
				{
					int n=JOptionPane.showConfirmDialog(jf, "当前正在游戏，确定退出比赛吗？");
					 if(n==0)
					 {
					    jf.dispose();
				           try {
				        	   dos.writeUTF("11:");
				        	   dos.writeUTF("13:");
				        	   dos.writeUTF("09:");	
							   dos.writeUTF("03:"+seatnum);						   
						   } catch (IOException e1) {
							// TODO 自动生成的 catch 块
							 e1.printStackTrace();
						   }
					 }
					 
				}
			      
		}
	}
	static public class Ready_ActionListener implements ActionListener
	{
			public void actionPerformed(ActionEvent e)
		{
				    isReady=true;
				    jb1.setEnabled(false);
		          	jb3.setEnabled(true);
		          	ready2.setVisible(true);
		          	userPanel.repaint();
		          	try {
						dos.writeUTF("06:");									
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
		}
	}
	static public class Cancel_ActionListener implements ActionListener
	{
			public void actionPerformed(ActionEvent e)
		{
				   
		           isReady=false;	
		           jb1.setEnabled(true);
		           jb3.setEnabled(false);
		           ready2.setVisible(false);
		           userPanel.repaint();
		           try {
						dos.writeUTF("07:");									
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
		}
	}
	static public class Sendmsg_ActionListener implements ActionListener
	{
			public void actionPerformed(ActionEvent e)
		{			
				String msg="";
				if(!enterField.getText().equals(""))
				     { 
					     msg=enterField.getText();
					     enterField.setText("");
					     chatArea.append(myuser.name+"："+msg+"\n");
					     enterField.requestFocusInWindow();
				     }
		           try {
						dos.writeUTF("12:"+msg);									
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
	  if(e.getSource()==enterField)
	  {
		  String msg="";
			if(!enterField.getText().equals(""))
			     { 
				     msg=enterField.getText();
				     enterField.setText("");
				     chatArea.append(myuser.name+"："+msg+"\n");
				     enterField.requestFocusInWindow();
			     }
	           try {
					dos.writeUTF("12:"+msg);									
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
	  }
	 }
	}
	public class MoveListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		
			int x=e.getX();
			int y=e.getY();
			int selectx,selecty;
			
			if(x>=30&&x<=670&&y>=30&&y<=670)
			{
				int xnum,ynum,xmod,ymod;
			    xnum=(x-51)/xjiange;
				ynum=(y-47)/yjiange;
				xmod=(x-51)%xjiange;
				ymod=(y-47)%yjiange;
			  if(!((xmod<exjiange*2&&xmod>exjiange)||(ymod<eyjiange*2&&ymod>eyjiange)))
			  {
				x=rongcuox(x,xnum,xmod);
				y=rongcuoy(y,ynum,ymod);
				selectx=(x-51)/xjiange;
				selecty=(y-47)/yjiange;
				System.out.println(selectx+","+selecty);
				if(point[selectx][selecty].havechess) {System.out.println("选中 "+point[selectx][selecty].name+"  !他是真的");}
				if(!point[selectx][selecty].havechess) {System.out.println("选中 "+point[selectx][selecty].name+"  !他是假的");} 
				    if(mousecount==0) 
				    {
				       if(point[selectx][selecty].havechess)//选中一个棋子
				         {
				    	    panel.add(select);
					        select.setBounds(x-30, y-35, 60, 60);
					        panel.repaint();
				    	    selectname=point[selectx][selecty].name;
				    	    selectside=point[selectx][selecty].side;
				    	    hisselectx=selectx;
				    	    hisselecty=selecty;
				    	    mousecount=1;
				    	    System.out.println("选中了"+selectname+"！");				    	   
                             
				         }
				    }
				    else if(mousecount==1)
				    {
				    	   if(!point[selectx][selecty].havechess)//所行目的地没有棋子在
				    	   {
				    		   
				    		   if(turn&&(!isEnd)) 
				    		   {
				    			  chessrules rule = new chessrules(point,selectname,hisselectx,hisselecty,selectx,selecty,myside,isBUSA);
				    		      if(rule.canwalk)
				    		       {
				    	             int chessnum=-1;
				    	             selectchessname=changename(selectname);
				    	             chessnum=Integer.parseInt(selectchessname);
				    	             chesspieces[chessnum].setLocation(x-30,y-30);
						             point[hisselectx][hisselecty].havechess=false;
				   		             point[hisselectx][hisselecty].name="";
						             point[hisselectx][hisselecty].side="";
				   		             point[selectx][selecty].havechess=true;
						             point[selectx][selecty].name=selectname;
						             point[selectx][selecty].side=selectside;
						             selectname="";
				    	 	         mousecount=0;
				    	 	         panel.remove(select);
							         panel.repaint(); 
							         turn=false;
							         turn2.setVisible(false);
								     turn1.setVisible(true);
							         try {
								      	dos.writeUTF("01:"+chessnum+":"+hisselectx+":"+hisselecty+":"+selectx+":"+selecty);
						   	 	      }   catch (IOException e1) {
								      	// TODO 自动生成的 catch 块
								      	e1.printStackTrace();
							     	  }
				    		         }
				    		      else
				    		      {
				    			      mousecount=0;
				    		      }
				    	         }
				    		   }
				    	   else//所行目的地有棋子在
				    	   {
				    		   if(point[selectx][selecty].side.equals(selectside))//所在棋子是自己人
				    		   {
				    			   if(selectname==point[selectx][selecty].name)
				    			   {
				    				   mousecount=0;
				    			   }
				    			   else
				    			   {
				    			    selectname=point[selectx][selecty].name;
						    	    selectside=point[selectx][selecty].side;
						    	    hisselectx=selectx;
						    	    hisselecty=selecty;
						    	    mousecount=1;
				    			   }
						    	    
				    		   }
				    		   else//所在棋子是敌人
				    		   {
				    			   if(turn&&(!isEnd))
				    			   {
				    			   chessrules rule = new chessrules(point,selectname,hisselectx,hisselecty,selectx,selecty,myside,isBUSA);
				    			   if(rule.canwalk)
				    			   {
				    			      int chessnum=-1;
				    			      int chessnumate=-1;
					    	          selectchessname=changename(selectname);
					    	          chessnum=Integer.parseInt(selectchessname);
					    	          selectchessname=changename(point[selectx][selecty].name);
					    	          chessnumate=Integer.parseInt(selectchessname);					    	       
					    	          panel.remove(chesspieces[chessnumate]);
					    	          panel.repaint();
					    	          chesspieces[chessnum].setLocation(x-30,y-30);
							          point[hisselectx][hisselecty].havechess=false;
							          point[hisselectx][hisselecty].name="";
							          point[hisselectx][hisselecty].side="";
							          point[selectx][selecty].havechess=true;
							          point[selectx][selecty].name=selectname;
							          point[selectx][selecty].side=selectside;
							          selectname="";
					    	 	      mousecount=0;
					    	 	      panel.remove(select);
								      panel.repaint();
								      turn=false;	
								      turn2.setVisible(false);
								      turn1.setVisible(true);
								      try {
											dos.writeUTF("01:"+chessnum+":"+hisselectx+":"+hisselecty+":"+selectx+":"+selecty);
										} catch (IOException e1) {
											// TODO 自动生成的 catch 块
											e1.printStackTrace();
										}
								      if((myside.equals("red")&&chessnumate==20)||(myside.equals("black")&&chessnumate==4))
					    	          {
					    	        	  
					    	        	  try {
												dos.writeUTF("02:");
											} catch (IOException e1) {
												// TODO 自动生成的 catch 块
												e1.printStackTrace();
											}
					    	        	  JOptionPane.showMessageDialog(null, "恭喜你，你赢了！");
					    	        	  isEnd=true;
					    	        	  turn2.setVisible(false);
									      turn1.setVisible(false);
					    	        	  
					    	          }
								      
								      
				    			   }
				    			   }
				    		   }
				    	   }
				    	 
				      }
				   
			  }
			
			
		}
			
			
		}
		public void mouseEntered(MouseEvent e) {
		/**鼠标移到组件上方法时事件处理方法.**/}
		public void mouseExited(MouseEvent e) {
		/**鼠标移开组件时事件处理方法.**/}
		public void mousePressed(MouseEvent e) {
		/**鼠标在组件上按下(但没弹起)时事件处理方法.**/}
		public void mouseReleased(MouseEvent e) {
		/**鼠标在组件上弹起事件处理方法.**/}
		}
	
	
	
	public class myMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		
			int x=e.getX();
			int y=e.getY();
			
			if(x>=30&&x<=670&&y>=30&&y<=670)
			{
				int xnum,ynum,xmod,ymod;
			    xnum=(x-51)/xjiange;
				ynum=(y-47)/yjiange;
				xmod=(x-51)%xjiange;
				ymod=(y-47)%yjiange;
			  if(!((xmod<exjiange*2&&xmod>exjiange)||(ymod<eyjiange*2&&ymod>eyjiange)))
			  {
				x=rongcuox(x,xnum,xmod);
				y=rongcuoy(y,ynum,ymod);
				if((x==hisx&&y==hisy))
				{
				  
				    hisx=-1;
				    hisy=-1;
			        panel.remove(select);
			        panel.repaint();  
				   
				}
				else
				{
				   hisx=x;
				   hisy=y;
			       panel.add(select);
			       select.setBounds(x-30, y-35, 60, 60);
			       panel.repaint();
			       
				}
			  }
			
			
		}
			System.out.println("hisx="+hisx+"    hisy="+hisy);
			
			
		}
		public void mouseEntered(MouseEvent e) {
		/**鼠标移到组件上方法时事件处理方法.**/}
		public void mouseExited(MouseEvent e) {
		/**鼠标移开组件时事件处理方法.**/}
		public void mousePressed(MouseEvent e) {
		/**鼠标在组件上按下(但没弹起)时事件处理方法.**/}
		public void mouseReleased(MouseEvent e) {
		/**鼠标在组件上弹起事件处理方法.**/}
		}
	
	
	
	
	 int rongcuox(int x,int xnum,int xmod)
	{

		if(xmod<=exjiange)
		{
			x=51+xjiange*xnum;
		}
		if(xmod>=exjiange*2)
		{
			x=51+xjiange*(xnum+1);
		}
		return x;
	}
	
	 int rongcuoy(int y,int ynum,int ymod)
	{

		if(ymod<=eyjiange)
		{
			y=51+yjiange*ynum;
		}
		if(ymod>=eyjiange*2)
		{
		    y=51+yjiange*(ynum+1);
		}
		return y;
	}
	
	static String changename(String name)
	{
		String chessname="";
		if(name.equals("红车1"))chessname="0";
		if(name.equals("红车2"))chessname="8";
		if(name.equals("红马1"))chessname="1";
		if(name.equals("红马2"))chessname="7";
		if(name.equals("红相1"))chessname="2";
		if(name.equals("红相2"))chessname="6";
		if(name.equals("红仕1"))chessname="3";
		if(name.equals("红仕2"))chessname="5";
		if(name.equals("红帅"))chessname="4";
		if(name.equals("红炮1"))chessname="9";
		if(name.equals("红炮2"))chessname="10";
		if(name.equals("红兵1"))chessname="11";
		if(name.equals("红兵2"))chessname="12";
		if(name.equals("红兵3"))chessname="13";
		if(name.equals("红兵4"))chessname="14";
		if(name.equals("红兵5"))chessname="15";
		if(name.equals("黑车1"))chessname="16";
		if(name.equals("黑马1"))chessname="17";
		if(name.equals("黑象1"))chessname="18";
		if(name.equals("黑士1"))chessname="19";
		if(name.equals("黑将"))chessname="20";
		if(name.equals("黑士2"))chessname="21";
		if(name.equals("黑象2"))chessname="22";
		if(name.equals("黑马2"))chessname="23";
		if(name.equals("黑车2"))chessname="24";
		if(name.equals("黑炮1"))chessname="25";
		if(name.equals("黑炮2"))chessname="26";
		if(name.equals("黑兵1"))chessname="27";
		if(name.equals("黑兵2"))chessname="28";
		if(name.equals("黑兵3"))chessname="29";
		if(name.equals("黑兵4"))chessname="30";
		if(name.equals("黑兵5"))chessname="31";
		return chessname;
		
	}
	
	public void move(int chessnum,int startx,int starty,int endx,int endy)
	{
		int x,y;
		x=endx*xjiange+51;
		y=endy*yjiange+47;
		if(!point[endx][endy].havechess)//所行目的地没有棋子在
 	           {		    	
			     System.out.println("走到1了哦");
 	              chesspieces[chessnum].setLocation(x-30,y-30);
		          point[startx][starty].havechess=false;
		          point[startx][starty].name="";
		          point[startx][starty].side="";
		          point[endx][endy].havechess=true;
		          point[endx][endy].name=chesspieces[chessnum].name;
		          point[endx][endy].side=chesspieces[chessnum].side;
			      panel.repaint();  	
 	            }
		else 
		{	
			       int num=Integer.parseInt(changename(point[endx][endy].name));
			       System.out.println("num的数值为"+num);
			       panel.remove(chesspieces[num]); 
			       point[startx][starty].havechess=false;
			       point[startx][starty].name="";
			       point[startx][starty].side="";
			       chesspieces[chessnum].setLocation(x-30,y-30);
			       point[endx][endy].havechess=true;
			       point[endx][endy].name=chesspieces[chessnum].name;
			       point[endx][endy].side=chesspieces[chessnum].side;
				   panel.repaint();  	
	 	       
		}
	}
	public void lose()
	{
		JOptionPane.showMessageDialog(jf, "很遗憾，你输了。");
		isEnd=true;
		turn2.setVisible(false);
	    turn1.setVisible(false);
	}
	public void win()
	{
		JOptionPane.showMessageDialog(jf, "对方认输了，你赢了！");
		isEnd=true;
		turn2.setVisible(false);
	    turn1.setVisible(false);
	}
	public void gamestart()
	{
		if(turn)
		{
			turn2.setVisible(true);
		}else
		{
			turn1.setVisible(true);
		}
		isEnd=false;
		ready1.setVisible(false);
		ready2.setVisible(false);
		panel.add(chesspieces[0]);
        panel.add(chesspieces[1]);
        panel.add(chesspieces[2]);
        panel.add(chesspieces[3]);
        panel.add(chesspieces[4]);
        panel.add(chesspieces[5]);
        panel.add(chesspieces[6]);
        panel.add(chesspieces[7]);
        panel.add(chesspieces[8]);
        panel.add(chesspieces[9]);
        panel.add(chesspieces[10]);
        panel.add(chesspieces[11]);
        panel.add(chesspieces[12]);
        panel.add(chesspieces[13]);
        panel.add(chesspieces[14]);
        panel.add(chesspieces[15]);
        panel.add(chesspieces[16]);
        panel.add(chesspieces[17]);
        panel.add(chesspieces[18]);
        panel.add(chesspieces[19]);
        panel.add(chesspieces[20]);
        panel.add(chesspieces[21]);
        panel.add(chesspieces[22]); 
        panel.add(chesspieces[23]);
        panel.add(chesspieces[24]);
        panel.add(chesspieces[25]);
        panel.add(chesspieces[26]);
        panel.add(chesspieces[27]);
        panel.add(chesspieces[28]);
        panel.add(chesspieces[29]);
        panel.add(chesspieces[30]);
        panel.add(chesspieces[31]);
        userPanel.repaint();
		panel.repaint();
	}
	
	
	public chessboard(chessuser user,String getside,int seatnum)
	{
	   
		if(user.name.equals("BUSA"))
		{
			isBUSA=true;
		}
		addWindowListener(new MyWindowListener());
		this.seatnum=seatnum;
		jf=this;
		myuser=user;
		dis=myuser.dis;
		dos=myuser.dos;
		myside=getside;
		
		
		
		
		select = new JLabel();
		ImageIcon image = new ImageIcon("image\\qizi\\select.gif");
		image.setImage(image.getImage().getScaledInstance(60, 60,Image.SCALE_DEFAULT ));
		select.setIcon(image);
		
		myimg = new JLabel();
		ImageIcon image2 = new ImageIcon("image\\face\\"+myuser.imgnum+"-1.gif");
		image2.setImage(image2.getImage().getScaledInstance(40, 45,Image.SCALE_DEFAULT ));
		myimg.setIcon(image2);
		
		oppimg = new JLabel();
		ImageIcon image3 = new ImageIcon("image\\img\\noone.gif");
		image3.setImage(image3.getImage().getScaledInstance(40, 45,Image.SCALE_DEFAULT ));
		oppimg.setIcon(image3);
		
		ready1 = new JLabel();
		ready2 = new JLabel();
		ImageIcon image5 = new ImageIcon("image\\ready.png");
		image5.setImage(image5.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT ));
		ready1.setIcon(image5);
		ready2.setIcon(image5);
		
		turn1 = new JLabel();
		turn2 = new JLabel();
		ImageIcon img6 = new ImageIcon("image\\turn.png");
		img6.setImage(img6.getImage().getScaledInstance(195, 500,Image.SCALE_DEFAULT ));
		turn1.setIcon(img6);
		turn2.setIcon(img6);
		
		myname = new JLabel(myuser.name);
		oppname = new JLabel("");
		mylevel = new JLabel("");
		opplevel = new JLabel("");
		
		if(myuser.level.equals("1"))
		     {
		    	mylevel.setText("业余棋手一级");
		     }
		else if(myuser.level.equals("10"))
	     {
	    	    mylevel.setText("    棋圣       ");
	     }
		
		jb1 = new JButton("准备");
		jb2= new JButton("离开房间");
		jb3 = new JButton("取消准备");
		jbsend = new JButton("发送");
		chatArea = new JTextArea();
		enterField = new JTextField();
		chatArea.setEditable(false);
		jb1.setEnabled(false);
		jb3.setEnabled(false);
		beijing = new JLabel();
		ImageIcon image4 = new ImageIcon("image\\img\\gamehall.png");
		image4.setImage(image4.getImage().getScaledInstance(1200, 1000,Image.SCALE_DEFAULT ));
		beijing.setIcon(image4);
		muban = new JLabel();
		muban2 = new JLabel();
		ImageIcon img = new ImageIcon("image\\muban.jpg");
		img.setImage(img.getImage().getScaledInstance(1200, 1000,Image.SCALE_DEFAULT ));
		muban.setIcon(img);
		muban2.setIcon(img);
		userPanel = new JPanel();
		chatPanel = new JPanel();
		
		
     
		 point = new chesspoint[9][10];
		 for (int i = 0; i <= 8; i++) {  
	            for (int j = 0; j <= 9; j++) {  
	                point[i][j] = new chesspoint(""); 
	            }  
	        }  
		
		 chesspieces = new chesspiece[32];
		
		
		 chesspieces[0] = new chesspiece("红车1",myside);
		 chesspieces[1] = new chesspiece("红马1",myside);
		 chesspieces[2] = new chesspiece("红相1",myside);
		 chesspieces[3] = new chesspiece("红仕1",myside);
		 chesspieces[4] = new chesspiece("红帅",myside);
		 chesspieces[5] = new chesspiece("红仕2",myside);
		 chesspieces[6] = new chesspiece("红相2",myside);
		 chesspieces[7] = new chesspiece("红马2",myside);
		 chesspieces[8] = new chesspiece("红车2",myside);
		 chesspieces[9] = new chesspiece("红炮1",myside);
		 chesspieces[10] = new chesspiece("红炮2",myside);
		 chesspieces[11] = new chesspiece("红兵1",myside);
		 chesspieces[12] = new chesspiece("红兵2",myside);
		 chesspieces[13] = new chesspiece("红兵3",myside);
		 chesspieces[14] = new chesspiece("红兵4",myside);
		 chesspieces[15] = new chesspiece("红兵5",myside);
		 chesspieces[16] = new chesspiece("黑车1",myside);
		 chesspieces[17] = new chesspiece("黑马1",myside);
		 chesspieces[18] = new chesspiece("黑象1",myside);
		 chesspieces[19] = new chesspiece("黑士1",myside);
		 chesspieces[20] = new chesspiece("黑将",myside);
		 chesspieces[21] = new chesspiece("黑士2",myside);
		 chesspieces[22] = new chesspiece("黑象2",myside);
		 chesspieces[23] = new chesspiece("黑马2",myside);
		 chesspieces[24] = new chesspiece("黑车2",myside);
		 chesspieces[25] = new chesspiece("黑炮1",myside);
		 chesspieces[26] = new chesspiece("黑炮2",myside);
		 chesspieces[27] = new chesspiece("黑兵1",myside);
		 chesspieces[28] = new chesspiece("黑兵2",myside);
		 chesspieces[29] = new chesspiece("黑兵3",myside);
		 chesspieces[30] = new chesspiece("黑兵4",myside);
		 chesspieces[31] = new chesspiece("黑兵5",myside);
		
		if(myside.equals("black"))
		{
		turn=false;
		point[0][0].name="红车1";point[0][0].havechess=true;
		point[1][0].name="红马1";point[1][0].havechess=true;
		point[2][0].name="红相1";point[2][0].havechess=true;
		point[3][0].name="红仕1";point[3][0].havechess=true;
		point[4][0].name="红帅";point[4][0].havechess=true;
		point[5][0].name="红仕2";point[5][0].havechess=true;
		point[6][0].name="红相2";point[6][0].havechess=true;
		point[7][0].name="红马2";point[7][0].havechess=true;
		point[8][0].name="红车2";point[8][0].havechess=true;
		point[1][2].name="红炮1";point[1][2].havechess=true;
		point[7][2].name="红炮2";point[7][2].havechess=true;
		point[0][3].name="红兵1";point[0][3].havechess=true;
		point[2][3].name="红兵2";point[2][3].havechess=true;
		point[4][3].name="红兵3";point[4][3].havechess=true;
		point[6][3].name="红兵4";point[6][3].havechess=true;
		point[8][3].name="红兵5";point[8][3].havechess=true;
		point[0][9].name="黑车1";point[0][9].havechess=true;
		point[1][9].name="黑马1";point[1][9].havechess=true;
		point[2][9].name="黑象1";point[2][9].havechess=true;
		point[3][9].name="黑士1";point[3][9].havechess=true;
		point[4][9].name="黑将";point[4][9].havechess=true;
		point[5][9].name="黑士2";point[5][9].havechess=true;
		point[6][9].name="黑象2";point[6][9].havechess=true;
		point[7][9].name="黑马2";point[7][9].havechess=true;
		point[8][9].name="黑车2";point[8][9].havechess=true;
		point[1][7].name="黑炮1";point[1][7].havechess=true;
		point[7][7].name="黑炮2";point[7][7].havechess=true;
		point[0][6].name="黑兵1";point[0][6].havechess=true;
		point[2][6].name="黑兵2";point[2][6].havechess=true;
		point[4][6].name="黑兵3";point[4][6].havechess=true;
		point[6][6].name="黑兵4";point[6][6].havechess=true;
		point[8][6].name="黑兵5";point[8][6].havechess=true;
		point[0][0].side="red";
		point[1][0].side="red";
		point[2][0].side="red";
		point[3][0].side="red";
		point[4][0].side="red";
		point[5][0].side="red";
		point[6][0].side="red";
		point[7][0].side="red";
		point[8][0].side="red";
		point[1][2].side="red";
		point[7][2].side="red";
		point[0][3].side="red";
		point[2][3].side="red";
		point[4][3].side="red";
		point[6][3].side="red";
		point[8][3].side="red";
		point[0][9].side="black";
		point[1][9].side="black";
		point[2][9].side="black";
		point[3][9].side="black";
		point[4][9].side="black";
		point[5][9].side="black";
		point[6][9].side="black";
		point[7][9].side="black";
		point[8][9].side="black";
		point[1][7].side="black";
		point[7][7].side="black";
		point[0][6].side="black";
		point[2][6].side="black";
		point[4][6].side="black";
		point[6][6].side="black";
		point[8][6].side="black";
		}
		else
		{
			turn=true;
			point[0][0].name="黑车2";point[0][0].havechess=true;
			point[1][0].name="黑马2";point[1][0].havechess=true;
			point[2][0].name="黑象2";point[2][0].havechess=true;
			point[3][0].name="黑士2";point[3][0].havechess=true;
			point[4][0].name="黑将";point[4][0].havechess=true;
			point[5][0].name="黑士1";point[5][0].havechess=true;
			point[6][0].name="黑象1";point[6][0].havechess=true;
			point[7][0].name="黑马1";point[7][0].havechess=true;
			point[8][0].name="黑车1";point[8][0].havechess=true;
			point[1][2].name="黑炮2";point[1][2].havechess=true;
			point[7][2].name="黑炮1";point[7][2].havechess=true;
			point[0][3].name="黑兵5";point[0][3].havechess=true;
			point[2][3].name="黑兵4";point[2][3].havechess=true;
			point[4][3].name="黑兵3";point[4][3].havechess=true;
			point[6][3].name="黑兵2";point[6][3].havechess=true;
			point[8][3].name="黑兵1";point[8][3].havechess=true;
			point[0][9].name="红车2";point[0][9].havechess=true;
			point[1][9].name="红马2";point[1][9].havechess=true;
			point[2][9].name="红象2";point[2][9].havechess=true;
			point[3][9].name="红仕2";point[3][9].havechess=true;
			point[4][9].name="红帅";point[4][9].havechess=true;
			point[5][9].name="红仕1";point[5][9].havechess=true;
			point[6][9].name="红相1";point[6][9].havechess=true;
			point[7][9].name="红马1";point[7][9].havechess=true;
			point[8][9].name="红车1";point[8][9].havechess=true;
			point[1][7].name="红炮2";point[1][7].havechess=true;
			point[7][7].name="红炮1";point[7][7].havechess=true;
			point[0][6].name="红兵5";point[0][6].havechess=true;
			point[2][6].name="红兵4";point[2][6].havechess=true;
			point[4][6].name="红兵3";point[4][6].havechess=true;
			point[6][6].name="红兵2";point[6][6].havechess=true;
			point[8][6].name="红兵1";point[8][6].havechess=true;
			point[0][0].side="black";
			point[1][0].side="black";
			point[2][0].side="black";
			point[3][0].side="black";
			point[4][0].side="black";
			point[5][0].side="black";
			point[6][0].side="black";
			point[7][0].side="black";
			point[8][0].side="black";
			point[1][2].side="black";
			point[7][2].side="black";
			point[0][3].side="black";
			point[2][3].side="black";
			point[4][3].side="black";
			point[6][3].side="black";
			point[8][3].side="black";
			point[0][9].side="red";
			point[1][9].side="red";
			point[2][9].side="red";
			point[3][9].side="red";
			point[4][9].side="red";
			point[5][9].side="red";
			point[6][9].side="red";
			point[7][9].side="red";
			point[8][9].side="red";
			point[1][7].side="red";
			point[7][7].side="red";
			point[0][6].side="red";
			point[2][6].side="red";
			point[4][6].side="red";
			point[6][6].side="red";
			point[8][6].side="red";
		}
		
		
		
		this.setLayout(null); 
		panel.setLayout(null);
		userPanel.setLayout(null);
		chatPanel.setLayout(null);
		myname.setFont(new   java.awt.Font("宋体", 1, 20));
		oppname.setFont(new   java.awt.Font("宋体", 1, 20));
		ready1.setVisible(false);
		ready2.setVisible(false);
		turn1.setVisible(false);
		turn2.setVisible(false);
		chatArea.setLineWrap(true);
		JScrollPane jsp = new JScrollPane(chatArea);
		
		
		

		this.add(panel);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.pack();
		this.add(userPanel);
		this.add(chatPanel);
		this.add(muban2);
        this.add(beijing);
        
        userPanel.add(turn1);
        userPanel.add(turn2);
        userPanel.add(myimg);
        userPanel.add(oppimg);
        userPanel.add(myname);
        userPanel.add(oppname);
        userPanel.add(mylevel);
        userPanel.add(opplevel);
        userPanel.add(ready1);
        userPanel.add(ready2);
        userPanel.add(muban);
        
        chatPanel.add(jsp);
        chatPanel.add(enterField);
        chatPanel.add(jbsend);
        chatPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.
                createEtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.BLACK),
                BorderFactory.createLoweredBevelBorder()));
        

        
        
        
	    beijing.setBounds(0, 0, 1200,1000);
	    userPanel.setBounds(0,0, 195,1000);
	    muban2.setBounds(950,0, 260,1000);
	    chatPanel.setBounds(960,400, 240,450);
	    jsp.setBounds(5,5, 220,420);
	    enterField.setBounds(0,425, 170,25);
	    jbsend.setBounds(170,425, 60,25);
	    myimg.setBounds(75, 600, 50,50);
	    myname.setBounds(80, 580, 50,500);
	    mylevel.setBounds(55, 620, 90,200);
	    oppimg.setBounds(75, 150, 50,50);
	    oppname.setBounds(80, 130, 50,500);
	    opplevel.setBounds(55, 170, 90,200);
	    
	    ready1.setBounds(80, 50, 200,200);
	    ready2.setBounds(80, 500, 200,200);
	    muban.setBounds(0, 0, 1200,1000);
	    turn1.setBounds(0, 0, 195,500);
	    turn2.setBounds(0, 500, 195,500);
        
       
        jb1.setBounds(370, 870, 90, 40);
        jb2.setBounds(705, 870, 90, 40);
        jb3.setBounds(540, 870, 90, 40);
        
        ENTER_ActionListener eaction = new ENTER_ActionListener();
        enterField.addActionListener(eaction);
        Ready_ActionListener raction = new Ready_ActionListener();
        jb1.addActionListener(raction);
        Exit_ActionListener actionexit = new Exit_ActionListener();
	    jb2.addActionListener(actionexit);
	    Cancel_ActionListener caction = new Cancel_ActionListener();
	    jb3.addActionListener(caction);
		panel.setBounds(230, 150, 700,700);
		myMouseListener MouseApp = new myMouseListener();
		panel.addMouseListener(MouseApp);
		MoveListener Move = new MoveListener();
		panel.addMouseListener(Move);
		Sendmsg_ActionListener sendaction = new Sendmsg_ActionListener();
		jbsend.addActionListener(sendaction);
		
		
		
    
    
     
    this.setSize(1200, 1000);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setVisible(true);
    this.setTitle("棋盘");
    int windowWidth = this.getWidth(); //获得窗口宽
    int windowHeight = this.getHeight(); //获得窗口高
    Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
    Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
    int screenWidth = screenSize.width; //获取屏幕的宽
    int screenHeight = screenSize.height; //获取屏幕的高
    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
	}
	
}
