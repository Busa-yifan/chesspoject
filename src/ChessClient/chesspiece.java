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
		/**����Ƶ�����Ϸ���ʱ�¼�������.**/}
		public void mouseExited(MouseEvent e) {
		/**����ƿ����ʱ�¼�������.**/}
		public void mousePressed(MouseEvent e) {
		/**���������ϰ���(��û����)ʱ�¼�������.**/}
		public void mouseReleased(MouseEvent e) {
		/**���������ϵ����¼�������.**/}
		}
	
	
	public chesspiece(String name,String getside)
	{   
		myside=getside;
		String str=null;
		this.name=name;
	if(myside.equals("black"))
	{
		if(name.equals("�쳵1"))
		{
			side="red";
			x=xlu-30;
			y=ylu-30;
			boardx=(x-21)/xjiange;//x-21��x+30-51,+30�ǻص�ʵ��λ�ã�-51�Ǽ�ȥ���̱�Ե
			boardy=(y-17)/yjiange;
			str="image\\qizi\\1.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����1"))
		{
			side="red";
			x=xlu-30+xjiange;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\2.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����1"))
		{
			side="red";
			x=xlu-30+xjiange*2;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\3.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����1"))
		{
			side="red";
			x=xlu-30+xjiange*3;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\4.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("��˧"))
		{
			side="red";
			x=xlu-30+xjiange*4;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\5.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����2"))
		{
			side="red";
			x=xlu-30+xjiange*5;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\6.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����2"))
		{
			side="red";
			x=xlu-30+xjiange*6;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\7.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����2"))
		{
			side="red";
			x=xlu-30+xjiange*7;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\8.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�쳵2"))
		{
			side="red";
			x=xlu-30+xjiange*8;
			y=ylu-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\9.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����1"))
		{
			side="red";
			x=xlu-30+xjiange;
			y=ylu-30+yjiange*2;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\10.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����2"))
		{
			side="red";
			x=xlu-30+xjiange*7;
			y=ylu-30+yjiange*2;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\11.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("���1"))
		{
			side="red";
			x=xlu-30;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("���2"))
		{
			side="red";
			x=xlu-30+xjiange*2;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("���3"))
		{
			side="red";
			x=xlu-30+xjiange*4;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("���4"))
		{
			side="red";
			x=xlu-30+xjiange*6;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("���5"))
		{
			side="red";
			x=xlu-30+xjiange*8;
			y=ylu-30+yjiange*3;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\12.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�ڳ�1"))
		{
			side="black";
			x=xld-30;
			y=yld-30;
			boardx=(x-21)/xjiange;//x-21��x+30-51,+30�ǻص�ʵ��λ�ã�-51�Ǽ�ȥ���̱�Ե
			boardy=(y-17)/yjiange;
			str="image\\qizi\\17.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����1"))
		{
			side="black";
			x=xld-30+xjiange;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\18.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����1"))
		{
			side="black";
			x=xld-30+xjiange*2;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\19.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("��ʿ1"))
		{
			side="black";
			x=xld-30+xjiange*3;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\20.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�ڽ�"))
		{
			side="black";
			x=xld-30+xjiange*4;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\21.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("��ʿ2"))
		{
			side="black";
			x=xld-30+xjiange*5;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\22.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����2"))
		{
			side="black";
			x=xld-30+xjiange*6;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\23.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����2"))
		{
			side="black";
			x=xld-30+xjiange*7;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\24.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�ڳ�2"))
		{
			side="black";
			x=xld-30+xjiange*8;
			y=yld-30;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\25.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����1"))
		{
			side="black";
			x=xld-30+xjiange;
			y=yld-30-yjiange*2;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\26.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("����2"))
		{
			side="black";
			x=xld-30+xjiange*7;
			y=yld-30-yjiange*2;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\27.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�ڱ�1"))
		{
			side="black";
			x=xlu-30;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�ڱ�2"))
		{
			side="black";
			x=xlu-30+xjiange*2;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�ڱ�3"))
		{
			side="black";
			x=xlu-30+xjiange*4;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�ڱ�4"))
		{
			side="black";
			x=xlu-30+xjiange*6;
			y=ylu-30+yjiange*6;
			boardx=(x-21)/xjiange;
			boardy=(y-17)/yjiange;
			str="image\\qizi\\28.gif";
			this.setBounds(x,y, 60,60);
		}
		else if(name.equals("�ڱ�5"))
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
		 if(name.equals("�ڳ�2"))
			{
				side="black";
				x=xlu-30;
				y=ylu-30;
				boardx=(x-21)/xjiange;//x-21��x+30-51,+30�ǻص�ʵ��λ�ã�-51�Ǽ�ȥ���̱�Ե
				boardy=(y-17)/yjiange;
				str="image\\qizi\\17.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����2"))
			{
				side="black";
				x=xlu-30+xjiange;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\18.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����2"))
			{
				side="black";
				x=xlu-30+xjiange*2;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\19.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("��ʿ2"))
			{
				side="black";
				x=xlu-30+xjiange*3;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\20.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�ڽ�"))
			{
				side="black";
				x=xlu-30+xjiange*4;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\21.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("��ʿ1"))
			{
				side="black";
				x=xlu-30+xjiange*5;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\22.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����1"))
			{
				side="black";
				x=xlu-30+xjiange*6;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\23.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����1"))
			{
				side="black";
				x=xlu-30+xjiange*7;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\24.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�ڳ�1"))
			{
				side="black";
				x=xlu-30+xjiange*8;
				y=ylu-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\25.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����2"))
			{
				side="black";
				x=xlu-30+xjiange;
				y=ylu-30+yjiange*2;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\26.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����1"))
			{
				side="black";
				x=xlu-30+xjiange*7;
				y=ylu-30+yjiange*2;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\27.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�ڱ�5"))
			{
				side="black";
				x=xlu-30;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�ڱ�4"))
			{
				side="black";
				x=xlu-30+xjiange*2;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�ڱ�3"))
			{
				side="black";
				x=xlu-30+xjiange*4;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�ڱ�2"))
			{
				side="black";
				x=xlu-30+xjiange*6;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�ڱ�1"))
			{
				side="black";
				x=xlu-30+xjiange*8;
				y=ylu-30+yjiange*3;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\28.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�쳵2"))
			{
				side="red";
				x=xld-30;
				y=yld-30;
				boardx=(x-21)/xjiange;//x-21��x+30-51,+30�ǻص�ʵ��λ�ã�-51�Ǽ�ȥ���̱�Ե
				boardy=(y-17)/yjiange;
				str="image\\qizi\\1.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����2"))
			{
				side="red";
				x=xld-30+xjiange;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\2.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����2"))
			{
				side="red";
				x=xld-30+xjiange*2;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\3.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����2"))
			{
				side="red";
				x=xld-30+xjiange*3;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\4.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("��˧"))
			{
				side="red";
				x=xld-30+xjiange*4;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\5.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����1"))
			{
				side="red";
				x=xld-30+xjiange*5;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\6.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����1"))
			{
				side="red";
				x=xld-30+xjiange*6;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\7.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����1"))
			{
				side="red";
				x=xld-30+xjiange*7;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\8.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("�쳵1"))
			{
				side="red";
				x=xld-30+xjiange*8;
				y=yld-30;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\9.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����2"))
			{
				side="red";
				x=xld-30+xjiange;
				y=yld-30-yjiange*2;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\10.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("����1"))
			{
				side="red";
				x=xld-30+xjiange*7;
				y=yld-30-yjiange*2;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\10.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("���5"))
			{
				side="red";
				x=xlu-30;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("���4"))
			{
				side="red";
				x=xlu-30+xjiange*2;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("���3"))
			{
				side="red";
				x=xlu-30+xjiange*4;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("���2"))
			{
				side="red";
				x=xlu-30+xjiange*6;
				y=ylu-30+yjiange*6;
				boardx=(x-21)/xjiange;
				boardy=(y-17)/yjiange;
				str="image\\qizi\\12.gif";
				this.setBounds(x,y, 60,60);
			}
			else if(name.equals("���1"))
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
