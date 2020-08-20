package ChessTest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;





        public class signup extends JFrame
	{
		
		static JTextField numberField;
		static JTextField nameField;
		static JPasswordField passwordField1;
		static JPasswordField passwordField2;
		static JLabel jlabel1,jlabel2,jlabel3,jlabel4,jlabel5,jlabel6,jlabel7,pic;
		static JButton jb1,jb2;
		static JComboBox cb;
		static JPanel imgpanel;
		static String imgnum="1";
		JButton img[];

		
		static public class SignUp_ActionListener implements ActionListener
		{
				public void actionPerformed(ActionEvent e1)
			{
					
					
				String name,number,strpassword1,strpassword2,brigade;
				char[] password1,password2;
				name=nameField.getText();
				number=numberField.getText();
				password1=passwordField1.getPassword();
				password2=passwordField2.getPassword();
				strpassword1 = String.valueOf(password1);
				strpassword2 = String.valueOf(password2);
				if(name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "昵称不能为空！");
				}
				if(number.equals(""))
				{
					JOptionPane.showMessageDialog(null, "账号不能为空！");
				}
				if(strpassword1.equals(""))
				{
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}
				if(strpassword2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "验证密码不能为空！");
				}
				else
				{
                  if((new String(password1)).equals(new String(password2)))
                  {
                	 int count=0;
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
         	             
         	        
         	             while(rs.next()){
         	                    if(number.equals(rs.getString("id")))
         	                    {
         	                    	count++;
         	                    	JOptionPane.showMessageDialog(null, "该账号已被注册！");
         	                    	 numberField.setText("");
         	                    	
         	                    }
         	                    else  if(name.equals(rs.getString("name")))
        	                    {
        	                    	count++;
        	                    	JOptionPane.showMessageDialog(null, "该昵称已被注册！");
        	                    	nameField.setText("");
        	                    }          
         	             }
         	            
         	             
         	             rs.close();
         	             con.close();
         	             
         	           
         	         }
         	             catch(ClassNotFoundException e2) {   
         	             System.out.println("Sorry,can`t find the Driver!");   
                    e2.printStackTrace();   
         	             } catch(SQLException e2) {
         	             e2.printStackTrace();  
                    }catch (Exception e2) {
         	             e2.printStackTrace();
         	        }
                	  
                	  
                	  
                	  
                	   if(count==0)
                	   {
                	     mysqlin sqlin=new mysqlin();
					     sqlin.usesql("insert into user (id,name,password,img,level) values ('"+number+"','"+name+"','"+strpassword1+"',"+imgnum+",1)");
				         JOptionPane.showMessageDialog(null, "注册成功！");
                	   }
                  }	
                  else
                  {
                	  JOptionPane.showMessageDialog(null, "两次输入的密码不一致！");
                	  passwordField1.setText("");
                	  passwordField2.setText("");
                  }
			    }
			}
		}
		  public class selectimg implements ActionListener
		{
				 public void actionPerformed(ActionEvent e)
			{
				     String s="",s1="";
					 for(int i=1;i<=56;i++)
					 {
						  s=""+i;
						  s1="0"+i;
						  if(s1.equals(e.getActionCommand()))
					      {
					    	     ImageIcon image = new ImageIcon("image//face//"+i+"-1.gif");
								 image.setImage(image.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT ));
							     pic.setIcon(image);
							     pic.repaint();							
							     imgnum=""+i;
							     break;
					      }	
						  else if(s.equals(e.getActionCommand()))
					      {
					    	     ImageIcon image = new ImageIcon("image//face//"+i+"-1.gif");
								 image.setImage(image.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT ));
							     pic.setIcon(image);
							     pic.repaint();
							     imgnum=""+i;
							     break;
					      }					    		  				    				   
					 }													
			}
		}
			 public signup()
			{
		    pic = new JLabel();
		    ImageIcon image = new ImageIcon("image//face//1-1.gif");
		    image.setImage(image.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT ));
			pic.setIcon(image);	
			
			img = new JButton[60]; 
		    imgpanel = new JPanel();
		    numberField = new JTextField(12);
		    nameField = new JTextField(12);
			passwordField1 = new JPasswordField(13);
			passwordField2 = new JPasswordField(13);
			jlabel1 = new JLabel("昵称:");
	        jlabel2 = new JLabel("账号:");
	        jlabel4 = new JLabel("请输入您的密码:");
	        jlabel5 = new JLabel("请再次输入密码:");
	        jlabel3 = new JLabel("账号注册");
	        jlabel3.setFont(new   java.awt.Font("宋体", 1, 35));
	        jlabel6= new JLabel("头像");
		    jb1 = new JButton("注册");
		    
		    
		    selectimg actionselect = new selectimg();
		    for(int i=0;i<=55;i++)
		    {
		    	if(i>=0&&i<=8)
		    	{
		    	img[i]= new JButton("0"+(i+1));
		    	}
		    	else img[i]= new JButton(""+(i+1));
		    	img[i].setIcon(new ImageIcon("image//face//"+(i+1)+"-1.gif"));
		    	img[i].addActionListener(actionselect);
		    	imgpanel.add(img[i]);
		    }
		    this.setLayout(null);
		    
		    this.add(pic);
		    this.add(imgpanel);
		    this.add(nameField);
		    this.add(numberField);
		    this.add(passwordField1);
		    this.add(passwordField2);
		    this.add(jlabel1);
		    this.add(jlabel2);
		    this.add(jlabel3);
		    this.add(jlabel4);
		    this.add(jlabel5);
		    this.add(jlabel6);
		    this.add(jb1);
		    nameField.setBounds(140, 90, 85, 30);
		    pic.setBounds(650, 90, 100, 100);
		    numberField.setBounds(310, 90, 200, 30);
		    passwordField1.setBounds(250,150, 200, 30);
		    passwordField2.setBounds(250,200, 200, 30);
		    jlabel1.setBounds(100, 52, 100,100);
		    jlabel2.setBounds(270, 52, 100, 100);
		    jlabel3.setBounds(320, 20, 150, 50);
		    jlabel4.setBounds(150, 140, 150, 50);
		    jlabel5.setBounds(150, 190, 150, 50);
		    jlabel6.setBounds(663, 160, 150, 50);
		    jb1.setBounds(500,201,70, 40);
		    imgpanel.setBounds(20,250, 750, 600);
		    
		    SignUp_ActionListener actionSignUp = new SignUp_ActionListener();
		    jb1.addActionListener(actionSignUp);
		   
		 
		    
		     
		    this.setSize(800, 650);
		    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    this.setVisible(true);
		    this.setTitle("UserSignUp");
		    int windowWidth = this.getWidth(); //获得窗口宽
		    int windowHeight = this.getHeight(); //获得窗口高
		    Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		    Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		    int screenWidth = screenSize.width; //获取屏幕的宽
		    int screenHeight = screenSize.height; //获取屏幕的高
		    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
			}
		}
