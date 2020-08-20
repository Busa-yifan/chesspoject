package ChessClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;


public class chessClient{

	static DataInputStream dis;
	static DataOutputStream dos;
    static chessuser myuser;
    static hall myhall;
	 
	   public chessClient(chessuser myuser) 
	     { 	 
		   this.myuser=myuser;
    	 
    	    try{      		
    	          Socket s = new Socket("127.0.0.1", 8888);
	                  try { 
	                	  
	                	     int pos;
	      		    	     String type="";
	            	            dis = new DataInputStream(s.getInputStream());
                                dos = new DataOutputStream(s.getOutputStream()); 
                                dos.writeUTF(this.myuser.name);
                                while(true)
                	    		{
                                      String msg="";                
             					      msg=dis.readUTF();
             		        	      pos=msg.indexOf(":");
             		        	      type = msg.substring(0,pos);
             		        	     if(type.equals("00"))
          		        	              {
          		        	    	           msg=msg.substring(pos+1);
          		        	    	           String name,imgnum;
          		        	    	           StringTokenizer stMsg = new StringTokenizer(msg,":");	
          		       				           name = stMsg.nextToken();
          		       				           imgnum = stMsg.nextToken();
          		       				           myhall.pl1.setIcon(new ImageIcon("image//face//"+imgnum+"-1.gif"));  
          		       				           myhall.pl1.repaint();
          		       				    
          		        	             }	                             	           	            	                    	                                          
                   	            }
	                       }
                       catch (IOException ex) 
                           {
                                 Logger.getLogger(chessClient.class.getName()).log(Level.SEVERE, null, ex);
                            }
    		   }

    	     catch(Exception e) {}
    	   
          }
	   DataInputStream getDis()
	   {
		   return dis;
	   }
	   DataOutputStream getDos()
	   {
		   return dos;
	   }
	   void sethall(hall myhall)
	   {
		   this.myhall=myhall;
	   }
	
}
