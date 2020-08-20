package ChessTest;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


	public  class login extends JFrame 
	{
		static JTextField numberField;
		static JPasswordField passwordField;
		static JLabel jlabel1,jlabel2,jlabel3,beijing,jlogin;
		static JButton jb1,jb2,jb3;
		static hall loginhall;
		static chessuser myuser;
		static DataInputStream dis;
		static DataOutputStream dos;
		static String name,id,imgnum,level;
		static hall myhall;
		static int Mycount=0;
		static JFrame jf;
		static public class LoginExit_ActionListener implements ActionListener
		{
				 public void actionPerformed(ActionEvent e1)
			{
				System.exit(0);
			}
		}
		static public class SignUp_ActionListener implements ActionListener
		{
				public void actionPerformed(ActionEvent e)
			{
				new signup();
			}
		}
		public class MouseAdp implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			String struserpassword;
			String number;
			char[] userpassword;
			int count=0;
			
			
			 number=numberField.getText();
			 userpassword=passwordField.getPassword();
			 struserpassword=String.valueOf(userpassword);
			 Connection con;
	         String driver = "com.mysql.jdbc.Driver";
	         String url = "jdbc:mysql://198.13.35.150:3306/chess";
	         String user = "admin";
	         String password = "feng";
	         try {
	             Class.forName(driver);
	             con = DriverManager.getConnection(url,user,password);
	             Statement statement = con.createStatement();
	             String sql2="select *from user";
	             ResultSet rs = statement.executeQuery(sql2);
	             
	            
	            if(number.equals(""))
					{
						JOptionPane.showMessageDialog(jf, "�˺Ų���Ϊ�գ�");
					}
				if(struserpassword.equals(""))
					{
						JOptionPane.showMessageDialog(jf, "���벻��Ϊ�գ�");
					}
	             while(rs.next()){
	            if(number.equals(rs.getString("id")))
	            {   
	         
	            	count++;
                   if(struserpassword.equals(rs.getString("password")))
                      {
                	         JOptionPane.showMessageDialog(jf,"��¼�ɹ���");
                	         id=rs.getString("id");
                	         name=rs.getString("name");
                	         imgnum=rs.getString("img");
                	         level=rs.getString("level");
                	         MyThread1 clientThread = new MyThread1(); 
                	         clientThread.start();  
                	         do
                	         {
                	         }while(Mycount==0);
                	         myhall = new hall(myuser);
                	         Mycount=2;             	         
                	         jf.dispose();
                      }
                   else
                   {
                      JOptionPane.showMessageDialog(jf, "��������������");
                      passwordField.setText("");
                     }
	               }
	             }
	            
	             if((count==0&&(!number.equals("")))&&(!struserpassword.equals("")))
	             {
	            	 JOptionPane.showMessageDialog(jf,"��������˺Ų����ڣ�����������");
	            	 numberField.setText("");
	            	 passwordField.setText("");
	             }
	             rs.close();
	             con.close();
	             
	           
	         }
	             catch(ClassNotFoundException e1) {   
	             System.out.println("Sorry,can`t find the Driver!");   
           e1.printStackTrace();   
	             } catch(SQLException e1) {
	             e1.printStackTrace();  
           }catch (Exception e1) {
	             e1.printStackTrace();
	        }
	
	        }
		public void mouseEntered(MouseEvent e) {
	/**����Ƶ�����Ϸ���ʱ�¼�������.**/}
		public void mouseExited(MouseEvent e) {
	/**����ƿ����ʱ�¼�������.**/}
		public void mousePressed(MouseEvent e) {
	/**���������ϰ���(��û����)ʱ�¼�������.**/}
		public void mouseReleased(MouseEvent e) {
	/**���������ϵ����¼�������.**/}
	      }
		
		
		public login()
		{
		jf=this;
		beijing = new JLabel();
		ImageIcon image = new ImageIcon("image\\beijing.jpg");
		image.setImage(image.getImage().getScaledInstance(1344, 756,Image.SCALE_DEFAULT ));
		beijing.setIcon(image);
		
		jlogin = new JLabel();
		ImageIcon image2 = new ImageIcon("image\\login.png");
		image2.setImage(image2.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT ));
		jlogin.setIcon(image2);
		
	    numberField = new JTextField(12);
		passwordField = new JPasswordField(13);
		jlabel1 = new JLabel("�ʺ�");
        jlabel2 = new JLabel("����");
        jlabel3 = new JLabel("��������֮�����ս");
        jlabel3.setFont(new   java.awt.Font("����", 1, 60));
        jlabel3.setForeground(Color.white);
	    jb2 = new JButton("�˳�");
	    jb3 = new JButton("ע��");
	    jlabel1.setForeground(Color.WHITE);
	    jlabel2.setForeground(Color.white);	    
	    this.setLayout(null);	    
	    this.add(numberField);
	    this.add(passwordField);
	    this.add(jlabel1);
	    this.add(jlabel2);
	    this.add(jlabel3);
	    this.add(jb2);
	    this.add(jb3);
	    this.add(jlogin);
	    this.add(beijing);
	    numberField.setBounds(405, 365, 200, 30);
	    passwordField.setBounds(405, 435, 200, 30);
	    jlabel1.setBounds(355, 330, 100,100);
	    jlabel2.setBounds(355, 400, 100, 100);
	    jlabel3.setBounds(220, 50, 800, 300);
	    jb2.setBounds(875,700,75,30);
	    jb3.setBounds(770,700,75,30);
	    jlogin.setBounds(-40,-113,500,400);
	    beijing.setBounds(0,-20,1000,800);
	    
	    MouseAdp  actionlogin = new MouseAdp();
	    jlogin.addMouseListener(actionlogin);
	    SignUp_ActionListener actionSignUp = new SignUp_ActionListener();
	    jb3.addActionListener(actionSignUp);
	    LoginExit_ActionListener actionExit = new LoginExit_ActionListener();
	    jb2.addActionListener(actionExit);
	    
	    
	     
	    this.setSize(1000, 800);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setVisible(true);
	    this.setTitle("�й�����Ver1.0");
	    int windowWidth = this.getWidth(); //��ô��ڿ�
	    int windowHeight = this.getHeight(); //��ô��ڸ�
	    Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
	    Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
	    int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
	    int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
	    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		}
		class MyThread1 extends Thread
		{
			
			private boolean run = true;
		    public MyThread1() {
		   
	                 try{      		
	                      Socket s = new Socket("198.13.35.150", 8888);
                          try { 
                		      
            	              dis = new DataInputStream(s.getInputStream());
                              dos = new DataOutputStream(s.getOutputStream());                               
                              dos.writeUTF(name+":"+imgnum+":"+level); 
                              dos.writeUTF("14:"+name+"�ѵ�¼��");
                              myuser = new chessuser(id,name,imgnum,dis,dos,level); 

  	                       	
                              }
                          catch (IOException ex) 
                             {
                                 
                             }

		            }

	            catch(Exception e) {}
	                 Mycount=1;
		    }
		    public void run()
		    {
		    	 int pos;
	    	     String type="";
	    	     do {
	    	    	  System.out.println("�ڵȴ���..");
	    	     }while(Mycount!=2);
	    	     try {
			        while(run)
	   		           {
	                            String msg="";                
				                msg=dis.readUTF();
				                System.out.println(msg);
	        	                pos=msg.indexOf(":");
	        	                type = msg.substring(0,pos);
	        	               if(type.equals("00"))//�����ź�
	     	                      {
	        	    	     
	     	    	                  msg=msg.substring(pos+1);
	     	    	                  String name,imgnum1="";
	     	    	                  int seatnum;
	     	    	                  StringTokenizer stMsg = new StringTokenizer(msg,":");	
	    				              name = stMsg.nextToken();
	    				              imgnum1 = stMsg.nextToken();
	    				              seatnum = Integer.parseInt(stMsg.nextToken());
	    				              myhall.se[seatnum].setIcon(new ImageIcon("image//face//"+imgnum1+"-1.gif"));  
	    				              myhall.se[seatnum].repaint();
	    				              myhall.sn[seatnum].setText(name);
	    				              myhall.sn[seatnum].repaint();
	    				              myhall.seat[seatnum].issit=true;
	    				              myhall.seat[seatnum].name=name;
	     	                       }	
	        	               else if(type.equals("01"))//�����ź�
	     	                      {       	    	     
	     	    	                  msg=msg.substring(pos+1);
	     	    	                  int chessnum,startx,starty,endx,endy;
	     	    	                  StringTokenizer stMsg = new StringTokenizer(msg,":");	
	    				              chessnum = Integer.parseInt(stMsg.nextToken());
	    				              startx = Integer.parseInt(stMsg.nextToken());
	    				              starty = Integer.parseInt(stMsg.nextToken());
	    				              endx = Integer.parseInt(stMsg.nextToken());
	    				              endy = Integer.parseInt(stMsg.nextToken());
	    				              myhall.myboard.move(chessnum,8-startx,9-starty,8-endx,9-endy);
	    				              myhall.myboard.turn=true;
	    				              myhall.myboard.turn2.setVisible(true);
	    				              myhall.myboard.turn1.setVisible(false);
	     	                       }
	        	               else if(type.equals("02"))//��Ϸ����ź�
	     	                      {       	    	     
	        	            	        myhall.myboard.lose();
	     	                      }
	        	               else if(type.equals("03"))//�뿪�����ź�
	     	                      {       
	        	            	         int seatnum;
	        	            	         msg=msg.substring(pos+1);
	        	            	         seatnum=Integer.parseInt(msg);
	        	            	         myhall.se[seatnum].setIcon(new ImageIcon("image//img//noone.gif"));  
		    				             myhall.se[seatnum].repaint();
		    				             myhall.sn[seatnum].setText("");
		    				             myhall.sn[seatnum].repaint();
		    				             myhall.seat[seatnum].issit=false;
		    				             myhall.seat[seatnum].name="";

	     	                      }
	        	               else if(type.equals("04"))//���ӵ�����λ������
	     	                      {       
	        	            	         String oppname;
	        	            	         msg=msg.substring(pos+1);
	        	            	         oppname=msg;
	        	            	         myuser.oppname=oppname;
	        	            	         myhall.myboard.jb1.setEnabled(true);
	     	                      }
	        	               else if(type.equals("05"))//������������ȥ����һ��
	     	                      {       	        	            	        
	        	            	         myuser.oppname="";
	        	            	         myhall.myboard.jb1.setEnabled(false);
	        	            	         myhall.myboard.jb3.setEnabled(false);
	     	                      }
	        	               else if(type.equals("06"))//�Է�׼����
	     	                      {       	        	            	        
	        	            	         myhall.myboard.ready1.setVisible(true);
	        	            	         myhall.myboard.userPanel.repaint();
	     	                      }
	        	               else if(type.equals("07"))//�Է�ȡ��׼����
	     	                      {       	        	            	        
	        	            	         myhall.myboard.ready1.setVisible(false);
	        	            	         myhall.myboard.userPanel.repaint();
	     	                      }
	        	               else if(type.equals("08"))//��Ϸ��ʼ�ź�
	     	                      {       
	        	            	         myhall.myboard.gamestart();	        	       
	        	            	         myhall.myboard.jb1.setEnabled(false);
	        	            	         myhall.myboard.jb3.setEnabled(false);
	     	                      }
	        	               else if(type.equals("09"))//�Է�����
	     	                      {       
	        	            	          myhall.myboard.win();	        	       	        	            	         
	     	                      }
	        	               else if(type.equals("10"))//ˢ�¶Է�ͷ�����ֺ͵ȼ�
	     	                      {       
	        	            	          msg=msg.substring(pos+1);	        	            	      
	     	    	                      String name,imgnum,level;
	     	    	                      StringTokenizer stMsg = new StringTokenizer(msg,":");	
	    				                  name = stMsg.nextToken();
	    				                  imgnum = stMsg.nextToken();
	    				                  level = stMsg.nextToken();
	    				                  myhall.myboard.oppname.setText(name);
	    				                  ImageIcon image2 = new ImageIcon("image\\face\\"+imgnum+"-1.gif");
	    				          		  image2.setImage(image2.getImage().getScaledInstance(40, 45,Image.SCALE_DEFAULT ));
	    				          		  myhall.myboard.oppimg.setIcon(image2);
	    				          		     if(level.equals("1"))
	    				          		     {
	    				          		    	 myhall.myboard.opplevel.setText("ҵ������һ��");
	    				          		     }
	    				          		      else if(myuser.level.equals("10"))
	    				          	          {
	    				          		    	  myhall.myboard.opplevel.setText("    ��ʥ       "); 
	    				          	         }
	    				          		  myhall.myboard.userPanel.repaint();
	     	                      }
	        	                else if(type.equals("11"))//ˢ�¶Է�ͷ�����ֺ͵ȼ�
	     	                      {       
	        	                	      myhall.myboard.oppname.setText("");
	        	                	      ImageIcon image3 = new ImageIcon("image\\img\\noone.gif");
	        	                		  image3.setImage(image3.getImage().getScaledInstance(40, 45,Image.SCALE_DEFAULT ));
	        	                		  myhall.myboard.oppimg.setIcon(image3);	    				          		  
	    				          		  myhall.myboard.opplevel.setText("");
	    				          		  myhall.myboard.userPanel.repaint();
	     	                      }
	        	               else if(type.equals("12"))//�Է����͹�������Ϣ
	     	                      {       
	        	            	        msg=msg.substring(pos+1);
	        	            	        String fromname="",hismsg="";
	        	            	        StringTokenizer stMsg = new StringTokenizer(msg,":");	
	        	            	        hismsg = stMsg.nextToken();
	    				                fromname = stMsg.nextToken();
	    				                myhall.myboard.chatArea.append(fromname+"��"+hismsg+"\n");
	     	                      }
	        	               else if(type.equals("13"))//�뿪��λ��Ϣ-�Ƿ�����λ״̬��ʼ��
	     	                      {       
	        	            	       myhall.haveseat=false; 
	     	                      }
	        	               else if(type.equals("14"))//��¼������Ϣ�Լ�������Ϣ
	     	                      {       
	        	            	        msg=msg.substring(pos+1); 
	        	            	        myhall.textarea.append(msg+"\n");
	     	                      }
	        	               
		                 }   
	    	           }
			        catch (IOException ex) 
	                   {
	                       
	                  }
		        }
	   
		   
	    
		}
	 
	}
	
	

