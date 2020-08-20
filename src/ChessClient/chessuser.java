package ChessClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class chessuser {
	
	     String id,name,imgnum,playside="",oppname="",level;
	     DataInputStream dis;
	     DataOutputStream dos;
	    
	    public chessuser(String id,String name,String imgnum,DataInputStream dis,DataOutputStream dos,String level)
	    {
	    	super();
	    	this.id=id;
	    	this.name=name;
	    	this.imgnum=imgnum;
	    	this.dis=dis;
	    	this.dos=dos;
	    	this.level=level;
	   
	    }	    
	    String getName()
	    {
	    	return name;
	    }	    
	    String getid()
	    {
	    	return id;
	    }	    
	    String getimgnum()
	    {
	    	return imgnum;
	    }	    
	    String getside()
	    {
	    	return playside;
	    }
	    String getoppname()
	    {
	    	return oppname;
	    }
	    void setid(String id)
	    {
	    	this.id=id;
	    }
	    void setname(String name)
	    {
	    	this.name=name;
	    }
	    void setimgnum(String imgnum)
	    {
	    	this.imgnum=imgnum;
	    }
	    void setplayside(String playside)
	    {
	    	this.playside=playside;
	    }
	    void setoppname(String OpponentName)
	    {
	    	this.oppname=OpponentName;
	    }
	    void setDis(DataInputStream dis)
	    {
	    	this.dis=dis;
	    }
	    void setDos(DataOutputStream dos)
	    {
	    	this.dos=dos;
	    }
	    
}
