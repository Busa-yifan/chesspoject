package ChessTest;

public class chessrules {
	boolean canwalk=false;
	boolean isBUSA=false;

	
	chessrules(chesspoint point[][],String name,int startx,int starty,int endx,int endy,String myside,boolean isBUSA)
	{	
        this.isBUSA=isBUSA;
		int chax,chay;
		String str="";
		if(myside.equals("black"))str="黑";
		if(myside.equals("red"))str="红";

	if(isBUSA)canwalk=true;
	else
	{
      if(name.equals(str+"兵1")||name.equals(str+"兵2")||name.equals(str+"兵3")||name.equals(str+"兵4")||name.equals(str+"兵5"))	
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
		if(name.equals(str+"车1")||name.equals(str+"车2"))
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
				    			   count++;//canwalk为false
				    		   }				    		   
				    	   }
				    	   if(count==0)canwalk=true;//两种情况，第一种是没有人，第二种是有敌方棋子
				       }
				       if(chay<0)
				       {
				    	   for(int i=starty+1;i<endy;i++)
				    	   {
				    		   if(point[startx][i].havechess)
				    		   {
				    			   count++;//canwalk为false
				    		   }				    		   
				    	   }
				    	   if(count==0)canwalk=true;//两种情况，第一种是没有人，第二种是有敌方棋子
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
				    			   count++;//canwalk为false
				    		   }				    		   
				    	   }
				    	   if(count==0)canwalk=true;//两种情况，第一种是没有人，第二种是有敌方棋子
				       }
				       if(chax<0)
				       {
				    	   for(int i=startx+1;i<endx;i++)
				    	   {
				    		   if(point[i][starty].havechess)
				    		   {
				    			   count++;//canwalk为false
				    		   }				    		   
				    	   }
				    	   if(count==0)canwalk=true;//两种情况，第一种是没有人，第二种是有敌方棋子
				       }
				  }
			  }
		  }
		  if(name.equals(str+"马1")||name.equals(str+"马2"))
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
		    if(name.equals(str+"相1")||name.equals(str+"相2")||name.equals(str+"象1")||name.equals(str+"象2"))
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
		    if(name.equals(str+"仕1")||name.equals(str+"仕2")||name.equals(str+"士1")||name.equals(str+"士2"))
		    {
		          if(endy>=7&&endy<=9&&endx>=3&&endx<=5)
		          {	  
		        	  chax=Math.abs(startx-endx);
					  chay=Math.abs(starty-endy);
					     if(chax==1&chay==1)canwalk=true;
		          }
		    	
		    }
		    if(name.equals(str+"帅")||name.equals(str+"将"))
		    {
		    	if(endy>=7&&endy<=9&&endx>=3&&endx<=5)
		          {	  
		        	  chax=Math.abs(startx-endx);
					  chay=Math.abs(starty-endy);
					     if(chax+chay==1)canwalk=true;
		          }
		    }
		    if(name.equals(str+"炮1")||name.equals(str+"炮2")||name.equals(str+"炮1")||name.equals(str+"炮2"))
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
					    			   count++;//canwalk为false
					    		   }				    		   
					    	   }
					    	   if(count==0&&!point[startx][endy].havechess)canwalk=true;//前方无人的情况
					    	   if(count==1&&point[startx][endy].havechess)canwalk=true;//前方有一个障碍且正好落点是敌人
					       }
					       if(chay<0)
					       {
					    	   for(int i=starty+1;i<endy;i++)
					    	   {
					    		   if(point[startx][i].havechess)
					    		   {
					    			   count++;//canwalk为false
					    		   }				    		   
					    	   }
					    	   if(count==0&&!point[startx][endy].havechess)canwalk=true;//前方无人的情况
					    	   if(count==1&&point[startx][endy].havechess)canwalk=true;//前方有一个障碍且正好落点是敌人
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
					    			   count++;//canwalk为false
					    		   }				    		   
					    	   }
					    	   if(count==0&&!point[endx][starty].havechess)canwalk=true;//前方无人的情况
					    	   if(count==1&&point[endx][starty].havechess)canwalk=true;//前方有一个障碍且正好落点是敌人
					       }
					       if(chax<0)
					       {
					    	   for(int i=startx+1;i<endx;i++)
					    	   {
					    		   if(point[i][starty].havechess)
					    		   {
					    			   count++;//canwalk为false
					    		   }				    		   
					    	   }
					    	   if(count==0&&!point[endx][starty].havechess)canwalk=true;//前方无人的情况
					    	   if(count==1&&point[endx][starty].havechess)canwalk=true;//前方有一个障碍且正好落点是敌人
					       }
					  }
				  }
			  }
		    }
	}
 }
		
		



