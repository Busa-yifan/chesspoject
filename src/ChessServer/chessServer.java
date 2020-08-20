package ChessServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;



public class chessServer {
	private Vector<User> userList = new Vector<User>();
    static String send="";
    static ServerSeat seat[];


  
  public static void main(String args[])
  {   
	   chessServer server = new chessServer();
	   System.out.println("服务端开启成功！");
	   server.waitConnect();
  }
  public chessServer()
  {
	  seat = new ServerSeat[18];
       for(int i=0;i<=17;i++)
       {
    	   seat[i]=new ServerSeat();
       }
  }
  public void waitConnect(){
		try{
			ServerSocket ss = new ServerSocket(8888);
			while (true) {
				Socket s = ss.accept();
				String send;
				String name="",imgnum="",level="";
				int pos;
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				send=dis.readUTF();
				pos=send.indexOf(":");
 	            name = send.substring(0,pos);
 	            
 	            send = send.substring(pos+1);
 	            StringTokenizer stMsg = new StringTokenizer(send,":");	
	            imgnum = stMsg.nextToken();
	            level = stMsg.nextToken();
				System.out.println(name+"已登录！");
				User user = new User(name,imgnum,level,dis, dos);
				userList.add(user);
				//创建用户线程
				UserThread userThread = new UserThread(user);
				userThread.start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
  class UserThread extends Thread{
		private User user = null;
		private boolean run = true;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private String name="";
		
		public UserThread(User user) {
			super();
			this.user = user;
			dis = user.getDis();
			dos = user.getDos();
			name = user.getName();
			   for(int i=0;i<=17;i++)
			   {
				   try {
				     if(seat[i].issit)
				         {
					          dos.writeUTF("00:"+seat[i].name+":"+seat[i].imgnum+":"+i);				 
				          }
				         }
				     catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						} 
			   }
			
		}

		public void run(){
			
			try{
				String send=null;
				int pos;
	    	    String type="";
				while(run)
				    {
                           send=dis.readUTF();	
                           System.out.println("捕捉到"+name+"的信息:"+send+"!  正在处理信息...");
                           pos=send.indexOf(":");
	        	           type = send.substring(0,pos);
	        	             if(type.equals("00")||type.equals("03"))
	        	             {
					              sendtoAlluser(send);
					                  if(type.equals("00"))
					                  {
					                	  send=send.substring(pos+1);
					                      String imgnum;
					                      int seatnum;
					                	  StringTokenizer stMsg = new StringTokenizer(send,":");	
		    				              name = stMsg.nextToken();
		    				              imgnum = stMsg.nextToken();
		    				              seatnum = Integer.parseInt(stMsg.nextToken());
		    				              seat[seatnum].issit=true;
		    				              seat[seatnum].name=name;
		    				              seat[seatnum].imgnum=imgnum;
		    				                  
					                  }
					                  else if(type.equals("03"))
					                  {
					                	  send=send.substring(pos+1);
					                      String imgnum;
					                      int seatnum;
					                	  StringTokenizer stMsg = new StringTokenizer(send,":");	
		    				              seatnum = Integer.parseInt(stMsg.nextToken());		    				              
		    				              if((seatnum%2==0&&seat[seatnum+1].issit)||(seatnum%2!=0&&seat[seatnum-1].issit))
		    				              {
		    				                   for(int i=0;i<userList.size();i++)
				        			                {
				        			                    if(userList.get(i).getName().equals(seat[seatnum].name))
				        			                      {
				        			            	          for(int j=0;j<userList.size();j++)
				        			            	                {
				        			            	                 	 if(userList.get(j).getName().equals(userList.get(i).oppname)) 
				        			            	                 	 {		
				        			            	                 		    DataOutputStream udos=userList.get(j).getDos();          
				        					        						    udos.writeUTF("05:");
				        			            	                 	        userList.get(j).oppname="";
				        			            	                 	 }
				        			            	                 	 
				        			            	                 }
				        			            	          userList.get(i).oppname="";
				        			            	          userList.get(i).isReady=false;
				        			                       }
				        			                   }
					                         }
		    				              seat[seatnum].issit=false;
		    				              seat[seatnum].name="";
		    				              seat[seatnum].imgnum="";
					                  
	        	                        }
	        	             }
	        	             else if(type.equals("01")||type.equals("02"))
	        	             {
	        	            	 sendtoOpp(send);
	        	             }
	        	             else if(type.equals("04"))
			                  {
	        	            	  String fname="",fimgnum="",flevel="";//10端口要用的更新变量
			                	  send=send.substring(pos+1);
			                      String player1,player2;
			                      String imgnum;
			                	  StringTokenizer stMsg = new StringTokenizer(send,":");	
			                	  player1 = stMsg.nextToken();
			                	  player2 = stMsg.nextToken();
				                		   for(int i=0;i<userList.size();i++)
				        			       {				        			    	 
				        			    	   if(userList.get(i).getName().equals(player2))
				        			    	   {
				        			    		   userList.get(i).oppname=player1;
				        			    		   DataOutputStream udos=userList.get(i).getDos();          
				        						   udos.writeUTF("04:"+player1);
				        						   fname=userList.get(i).name;
				        						   fimgnum=userList.get(i).imgnum;
				        						   flevel=userList.get(i).level;
				        						      
				        			    	   }
				        	                }
				                		   for(int i=0;i<userList.size();i++)
				                		   {
				                		       if(userList.get(i).getName().equals(player1))
			        			    	       {
			        			    		       userList.get(i).oppname=player2;
			        			    		       DataOutputStream udos=userList.get(i).getDos();				        			    		      
			        			    		       udos.writeUTF("04:"+player2);
			        			    		       udos.writeUTF("10:"+fname+":"+fimgnum+":"+flevel);
			        			    	        }
			                                }
				            
				        	       }
	        	             else if(type.equals("06"))
			                  {
			                	  user.isReady=true;				                    				              
			                	  for(int i=0;i<userList.size();i++)
			   			            {
			   			    	       if(userList.get(i).getName().equals(user.oppname))
			   			    	             {
			   			    	    	         if(userList.get(i).isReady)
			   			    	    	         {
			   	                                     DataOutputStream udos=userList.get(i).getDos();          
			   					                     udos.writeUTF("08:");
			   					                     dos.writeUTF("08:");
			   			    	    	         }
			   			    	    	         else
			   			    	    	         {
			   			    	    	        	DataOutputStream udos=userList.get(i).getDos();          
			   					                    udos.writeUTF("06:");
			   			    	    	         }
			   			    	              }
			   	                       	   
				        	         }
				               }  
	        	             else if(type.equals("07"))
			                  {		  
	        	            	 user.isReady=false;
	        	            	 sendtoOpp(send);
			                	  
				              } 
	        	             else if(type.equals("09"))
			                  {		
	        	            	 user.isReady=false;
	        	            	 sendtoOpp(send);				                    				              			                	  
				              } 
	        	             else if(type.equals("88"))
			                  {		
	        	            	 for(int i=0;i<userList.size();i++)
	            	                {
	            	                 	 if(userList.get(i).getName().equals(name)) 
	            	                 	 {		
	            	                 		    System.out.println(name+"退出了游戏。");
	            	                 		    userList.remove(i);
	            	                 		    run=false;
	            	                 	 }
	            	                 	 
	            	                 }
				              }  
	        	             else if(type.equals("10"))
			                  {		
	        	            	 sendtoOpp(send);				                    				              			                	  
				              } 
	        	             else if(type.equals("11"))
			                  {		
	        	            	 sendtoOpp(send);				                    				              			                	  
				              }
	        	             else if(type.equals("12"))
			                  {		
	        	            	 send=send+":"+user.name;
	        	            	 sendtoOpp(send);				                    				              			                	  
				              }
	        	             else if(type.equals("13"))
			                  {		
	        	            	 sendtoMe(send);				                    				              			                	  
				              }
	        	             else if(type.equals("14"))
			                  {		
	        	            	 sendtoAllnoMe(send);				                    				              			                	  
				              }
				                  
				    }
			          dis.close();
			          dos.close();
				    }
			catch(Exception e){
				e.printStackTrace();
			}
		}
		void sendtoAlluser(String msg)
		{ 
			try {
			       for(int i=0;i<userList.size();i++)
			       {
	                   DataOutputStream udos=userList.get(i).getDos();          
					     udos.writeUTF(msg);				
	                }	
			    } catch (IOException e) {
		  		// TODO 自动生成的 catch 块
				e.printStackTrace();
			    }
		}
		void sendtoAllnoMe(String msg)
		{ 
			try {
			       for(int i=0;i<userList.size();i++)
			       {
			    	   if(!userList.get(i).getName().equals(name))
			    	   {
	                   DataOutputStream udos=userList.get(i).getDos();          
					     udos.writeUTF(msg);
			    	   }
	                }	
			    } catch (IOException e) {
		  		// TODO 自动生成的 catch 块
				e.printStackTrace();
			    }
		}
		void sendtoMe(String msg)
		{ 
			try {
			       for(int i=0;i<userList.size();i++)
			       {
			    	   if(userList.get(i).getName().equals(name))
			    	   {
	                    DataOutputStream udos=userList.get(i).getDos();          
					     udos.writeUTF(msg);	
			    	   }
	                }	
			    } catch (IOException e) {
		  		// TODO 自动生成的 catch 块
				e.printStackTrace();
			    }
		}
		void sendtoMeAndOpp(String msg)
		{ 
			try {
			       for(int i=0;i<userList.size();i++)
			       {
			    	   if(userList.get(i).getName().equals(name)||userList.get(i).getName().equals(user.oppname))
			    	   {
	                     DataOutputStream udos=userList.get(i).getDos();          
					     udos.writeUTF(msg);	
			    	   }
	                }	
			    } catch (IOException e) {
		  		// TODO 自动生成的 catch 块
				e.printStackTrace();
			    }
		}
		void sendtoOpp(String msg)
		{ 
			try {
			       for(int i=0;i<userList.size();i++)
			       {
			    	   if(userList.get(i).getName().equals(user.oppname))
			    	   {
	                       DataOutputStream udos=userList.get(i).getDos();          
					       udos.writeUTF(msg);	
			    	   }
	                }	
			    } catch (IOException e) {
		  		// TODO 自动生成的 catch 块
				e.printStackTrace();
			    }
		}
		void sendtoOne(String msg,String name)
		{ 
			try {
			       for(int i=0;i<userList.size();i++)
			       {
			    	   if(userList.get(i).getName().equals(name))
			    	   {
	                     DataOutputStream udos=userList.get(i).getDos();          
					     udos.writeUTF(msg);	
			    	   }
	                }	
			    } catch (IOException e) {
		  		// TODO 自动生成的 catch 块
				e.printStackTrace();
			    }
		}
  }
}
