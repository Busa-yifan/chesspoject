package ChessClient;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class chesspiece extends JLabel{
	
	String name;
	int xbian=51,ybian=47;
	int xjiange=598/8,yjiange=606/9;
	int xld=51,yld=653,xlu=51,ylu=47,xrd=649,yrd=653,xru=649,yru=47;
	int x,y;
	int boardx=0,boardy=0;
	String side;
	String myside;
	
	public class MouseAdp implements MouseListener{
		public MouseAdp(){}
		public void mouseClicked(MouseEvent e) {
		
			
			
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
	
	
	public chesspiece(String name,String getside)
	{   
		myside=getside;
		String str=null;
		this.name=name;
	if(myside.equals("black"))
	{
		if(name.equals("红车1"))
		{
			side="red";
			x=xlu-30;
			y=ylu-30;
			boardx=(x-21)/xjiange;//x-21是x+30-51,+30是回到实际位置，-51是减去棋盘边缘
			boardy=(y-17)/yjiange;
			str="image\\qizi\\1.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红马1"))
		{
			side="red";
			x=xlu-30+xjiange;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\2.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红相1"))
		{
			side="red";
			x=xlu-30+xjiange*2;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\3.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红仕1"))
		{
			side="red";
			x=xlu-30+xjiange*3;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\4.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红帅"))
		{
			side="red";
			x=xlu-30+xjiange*4;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\5.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红仕2"))
		{
			side="red";
			x=xlu-30+xjiange*5;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\6.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红相2"))
		{
			side="red";
			x=xlu-30+xjiange*6;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\7.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红马2"))
		{
			side="red";
			x=xlu-30+xjiange*7;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\8.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红车2"))
		{
			side="red";
			x=xlu-30+xjiange*8;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\9.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红炮1"))
		{
			side="red";
			x=xlu-30+xjiange;
			y=ylu-30+yjiange*2;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\10.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红炮2"))
		{
			side="red";
			x=xlu-30+xjiange*7;
			y=ylu-30+yjiange*2;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\11.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红兵1"))
		{
			side="red";
			x=xlu-30;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红兵2"))
		{
			side="red";
			x=xlu-30+xjiange*2;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红兵3"))
		{
			side="red";
			x=xlu-30+xjiange*4;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红兵4"))
		{
			side="red";
			x=xlu-30+xjiange*6;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("红兵5"))
		{
			side="red";
			x=xlu-30+xjiange*8;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑车1"))
		{
			side="black";
			x=xld-30;
			y=yld-30;
			boardx=(x-21)/xjiange;//x-21是x+30-51,+30是回到实际位置，-51是减去棋盘边缘
			boardy=(y-17)/yjiange;
			str="image\\qizi\\17.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑马1"))
		{
			side="black";
			x=xld-30+xjiange;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\18.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑象1"))
		{
			side="black";
			x=xld-30+xjiange*2;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\19.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑士1"))
		{
			side="black";
			x=xld-30+xjiange*3;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\20.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑将"))
		{
			side="black";
			x=xld-30+xjiange*4;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\21.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑士2"))
		{
			side="black";
			x=xld-30+xjiange*5;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\22.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑象2"))
		{
			side="black";
			x=xld-30+xjiange*6;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\23.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑马2"))
		{
			side="black";
			x=xld-30+xjiange*7;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\24.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑车2"))
		{
			side="black";
			x=xld-30+xjiange*8;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\25.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑炮1"))
		{
			side="black";
			x=xld-30+xjiange;
			y=yld-30-yjiange*2;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\26.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑炮2"))
		{
			side="black";
			x=xld-30+xjiange*7;
			y=yld-30-yjiange*2;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\27.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑兵1"))
		{
			side="black";
			x=xlu-30;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑兵2"))
		{
			side="black";
			x=xlu-30+xjiange*2;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑兵3"))
		{
			side="black";
			x=xlu-30+xjiange*4;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑兵4"))
		{
			side="black";
			x=xlu-30+xjiange*6;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("黑兵5"))
		{
			side="black";
			x=xlu-30+xjiange*8;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		ImageIcon image = new ImageIcon(str);
		image.setImage(image.getImage().getScaledInstance(60, 60,Image.SCALE_DEFAULT ));
		this.setIcon(image);
	 }
	else
	 {
		 if(name.equals("黑车2"))
			{
				side="black";
				x=xlu-30;
				y=ylu-30;
				boardx=(x-21)/xjiange;//x-21是x+30-51,+30是回到实际位置，-51是减去棋盘边缘
				boardy=(y-17)/yjiange;
				str="image\\qizi\\17.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑马2"))
			{
				side="black";
				x=xlu-30+xjiange;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\18.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑象2"))
			{
				side="black";
				x=xlu-30+xjiange*2;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\19.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑士2"))
			{
				side="black";
				x=xlu-30+xjiange*3;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\20.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑将"))
			{
				side="black";
				x=xlu-30+xjiange*4;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\21.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑士1"))
			{
				side="black";
				x=xlu-30+xjiange*5;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\22.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑象1"))
			{
				side="black";
				x=xlu-30+xjiange*6;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\23.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑马1"))
			{
				side="black";
				x=xlu-30+xjiange*7;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\24.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑车1"))
			{
				side="black";
				x=xlu-30+xjiange*8;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\25.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑炮2"))
			{
				side="black";
				x=xlu-30+xjiange;
				y=ylu-30+yjiange*2;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\26.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑炮1"))
			{
				side="black";
				x=xlu-30+xjiange*7;
				y=ylu-30+yjiange*2;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\27.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑兵5"))
			{
				side="black";
				x=xlu-30;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑兵4"))
			{
				side="black";
				x=xlu-30+xjiange*2;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑兵3"))
			{
				side="black";
				x=xlu-30+xjiange*4;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑兵2"))
			{
				side="black";
				x=xlu-30+xjiange*6;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("黑兵1"))
			{
				side="black";
				x=xlu-30+xjiange*8;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红车2"))
			{
				side="red";
				x=xld-30;
				y=yld-30;
				boardx=(x-21)/xjiange;//x-21是x+30-51,+30是回到实际位置，-51是减去棋盘边缘
				boardy=(y-17)/yjiange;
				str="image\\qizi\\1.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红马2"))
			{
				side="red";
				x=xld-30+xjiange;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\2.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红相2"))
			{
				side="red";
				x=xld-30+xjiange*2;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\3.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红仕2"))
			{
				side="red";
				x=xld-30+xjiange*3;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\4.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红帅"))
			{
				side="red";
				x=xld-30+xjiange*4;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\5.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红仕1"))
			{
				side="red";
				x=xld-30+xjiange*5;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\6.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红相1"))
			{
				side="red";
				x=xld-30+xjiange*6;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\7.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红马1"))
			{
				side="red";
				x=xld-30+xjiange*7;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\8.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红车1"))
			{
				side="red";
				x=xld-30+xjiange*8;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\9.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红炮2"))
			{
				side="red";
				x=xld-30+xjiange;
				y=yld-30-yjiange*2;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\10.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红炮1"))
			{
				side="red";
				x=xld-30+xjiange*7;
				y=yld-30-yjiange*2;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\10.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红兵5"))
			{
				side="red";
				x=xlu-30;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红兵4"))
			{
				side="red";
				x=xlu-30+xjiange*2;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红兵3"))
			{
				side="red";
				x=xlu-30+xjiange*4;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红兵2"))
			{
				side="red";
				x=xlu-30+xjiange*6;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("红兵1"))
			{
				side="red";
				x=xlu-30+xjiange*8;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			ImageIcon image = new ImageIcon(str);
			image.setImage(image.getImage().getScaledInstance(60, 60,Image.SCALE_DEFAULT ));
			this.setIcon(image);
	 }
	}
	

     public int getx()
     {
    	 return x;
     }
     public int gety()
     {
    	 return y;
     }
     public String getname()
     {
    	 return name;
     }

	

}
