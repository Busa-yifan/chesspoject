package ChessTest;

public class chessrules {
	boolean canwalk=false;
	boolean isBUSA=false;

	
	chessrules(chesspoint point[][],String name,int startx,int starty,int endx,int endy,String myside,boolean isBUSA)
	{	
        this.isBUSA=isBUSA;
		int chax,chay;
		String str="";
		if(myside.equals("black"))str="��";
		if(myside.equals("red"))str="��";

	if(isBUSA)canwalk=true;
	else
	{
      if(name.equals(str+"��1")||name.equals(str+"��2")||name.equals(str+"��3")||name.equals(str+"��4")||name.equals(str+"��5"))	
		{
			
			chax=Math.abs(startx-endx);
			chay=starty-endy;
			if(endy>4)
			{
				if(chax==0&&chay>=0&&chay<=1&&chax!=chay)
				  {
					  canwalk=true;
				  }
			}
			if(endy<=4)
			{
			  if(chax>=0&&chax<=1&&chay>=0&&chay<=1&&chax!=chay)
			  {
				  canwalk=true;
			  }
			}
		}
		if(name.equals(str+"��1")||name.equals(str+"��2"))
		{
			chax=startx-endx;
			chay=starty-endy;
			int count=0;
			  if((chax==0||chay==0)&&!(chax==0&&chay==0))
			  {
				  if(chax==0)
				  {
				       if(chay>0)
				       {
				    	   for(int i=starty-1;i>endy;i--)
				    	   {
				    		   if(point[startx][i].havechess)
				    		   {
				    			   count++;//canwalkΪfalse
				    		   }				    		   
				    	   }
				    	   if(count==0)canwalk=true;//�����������һ����û���ˣ��ڶ������ез�����
				       }
				       if(chay<0)
				       {
				    	   for(int i=starty+1;i<endy;i++)
				    	   {
				    		   if(point[startx][i].havechess)
				    		   {
				    			   count++;//canwalkΪfalse
				    		   }				    		   
				    	   }
				    	   if(count==0)canwalk=true;//�����������һ����û���ˣ��ڶ������ез�����
				       }
				  }
				  if(chay==0)
				  {
				       if(chax>0)
				       {
				    	   for(int i=startx-1;i>endx;i--)
				    	   {
				    		   if(point[i][starty].havechess)
				    		   {
				    			   count++;//canwalkΪfalse
				    		   }				    		   
				    	   }
				    	   if(count==0)canwalk=true;//�����������һ����û���ˣ��ڶ������ез�����
				       }
				       if(chax<0)
				       {
				    	   for(int i=startx+1;i<endx;i++)
				    	   {
				    		   if(point[i][starty].havechess)
				    		   {
				    			   count++;//canwalkΪfalse
				    		   }				    		   
				    	   }
				    	   if(count==0)canwalk=true;//�����������һ����û���ˣ��ڶ������ез�����
				       }
				  }
			  }
		  }
		  if(name.equals(str+"��1")||name.equals(str+"��2"))
		  {
			  chax=Math.abs(startx-endx);
			  chay=Math.abs(starty-endy);
			     if(chax==2*chay||2*chax==chay)
			     {
			    	 if(chax==2*chay)
			    	 {
			    	     chax=startx-endx;
			    	     if(!point[startx-chax/2][starty].havechess)canwalk=true;
			    	 }   
			    	 if(2*chax==chay)
			    	 {
			    	     chay=starty-endy;
			    	     if(!point[startx][starty-chay/2].havechess)canwalk=true;
			    	 }   
			     }
			   }
		    if(name.equals(str+"��1")||name.equals(str+"��2")||name.equals(str+"��1")||name.equals(str+"��2"))
		    {
		    	  chax=Math.abs(startx-endx);
				  chay=Math.abs(starty-endy);
				  if(chax==2&&chay==2&&endy>=5)
				  {
					  chax=startx-endx;
					  chay=starty-endy;
					  if(!point[startx-chax/2][starty-chay/2].havechess&&endy>=5)canwalk=true;
				  }
		    }
		    if(name.equals(str+"��1")||name.equals(str+"��2")||name.equals(str+"ʿ1")||name.equals(str+"ʿ2"))
		    {
		          if(endy>=7&&endy<=9&&endx>=3&&endx<=5)
		          {	  
		        	  chax=Math.abs(startx-endx);
					  chay=Math.abs(starty-endy);
					     if(chax==1&chay==1)canwalk=true;
		          }
		    	
		    }
		    if(name.equals(str+"˧")||name.equals(str+"��"))
		    {
		    	if(endy>=7&&endy<=9&&endx>=3&&endx<=5)
		          {	  
		        	  chax=Math.abs(startx-endx);
					  chay=Math.abs(starty-endy);
					     if(chax+chay==1)canwalk=true;
		          }
		    }
		    if(name.equals(str+"��1")||name.equals(str+"��2")||name.equals(str+"��1")||name.equals(str+"��2"))
		    {
		    	chax=startx-endx;
				chay=starty-endy;
				int count=0;
				  if((chax==0||chay==0)&&!(chax==0&&chay==0))
				  {
					  if(chax==0)
					  {
					       if(chay>0)
					       {
					    	   for(int i=starty-1;i>endy;i--)
					    	   {
					    		   if(point[startx][i].havechess)
					    		   {
					    			   count++;//canwalkΪfalse
					    		   }				    		   
					    	   }
					    	   if(count==0&&!point[startx][endy].havechess)canwalk=true;//ǰ�����˵����
					    	   if(count==1&&point[startx][endy].havechess)canwalk=true;//ǰ����һ���ϰ�����������ǵ���
					       }
					       if(chay<0)
					       {
					    	   for(int i=starty+1;i<endy;i++)
					    	   {
					    		   if(point[startx][i].havechess)
					    		   {
					    			   count++;//canwalkΪfalse
					    		   }				    		   
					    	   }
					    	   if(count==0&&!point[startx][endy].havechess)canwalk=true;//ǰ�����˵����
					    	   if(count==1&&point[startx][endy].havechess)canwalk=true;//ǰ����һ���ϰ�����������ǵ���
					       }
					  }
					  if(chay==0)
					  {
					       if(chax>0)
					       {
					    	   for(int i=startx-1;i>endx;i--)
					    	   {
					    		   if(point[i][starty].havechess)
					    		   {
					    			   count++;//canwalkΪfalse
					    		   }				    		   
					    	   }
					    	   if(count==0&&!point[endx][starty].havechess)canwalk=true;//ǰ�����˵����
					    	   if(count==1&&point[endx][starty].havechess)canwalk=true;//ǰ����һ���ϰ�����������ǵ���
					       }
					       if(chax<0)
					       {
					    	   for(int i=startx+1;i<endx;i++)
					    	   {
					    		   if(point[i][starty].havechess)
					    		   {
					    			   count++;//canwalkΪfalse
					    		   }				    		   
					    	   }
					    	   if(count==0&&!point[endx][starty].havechess)canwalk=true;//ǰ�����˵����
					    	   if(count==1&&point[endx][starty].havechess)canwalk=true;//ǰ����һ���ϰ�����������ǵ���
					       }
					  }
				  }
			  }
		    }
	}
 }
		
		



