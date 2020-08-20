package ChessServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class User {
	
    String name="",oppname="",imgnum="",level="";
    boolean isReady=false;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public User(String name,String imgnum,String level,DataInputStream dis,DataOutputStream dos)
	{
		isReady=false;
		this.name=name;
		this.imgnum=imgnum;
		this.level=level;
		this.dis=dis;
		this.dos=dos;			
	}
	DataInputStream getDis() 
	{
		return this.dis;
	}
	DataOutputStream getDos() 
	{
		return this.dos;
	}
	String getName()
	{
		return this.name;
	}
	void setOpp(String oppname)
	{
		this.oppname=oppname;
	}

}
