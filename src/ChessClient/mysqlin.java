package ChessClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

   public class mysqlin {
	static public void usesql (String sql)
	{
		Connection conn;
	      String driver = "com.mysql.jdbc.Driver";
	      String url = "jdbc:mysql://localhost:3306/chess";
	      String user = "root";
	      String password = "feng";
	      try
	      {
	      Class.forName(driver);
	      conn = DriverManager.getConnection(url,user,password);
	      java.sql.Statement stmt = conn.createStatement();
	      stmt.execute(sql);
	      }
	      catch(ClassNotFoundException e) 
	      {   
	      System.out.println("Sorry,can`t find the Driver!");  
	     e.printStackTrace();   
	          } 
	      catch(SQLException e)
	      {
	          e.printStackTrace();  
	     }
	      catch (Exception e)
	      {
	          e.printStackTrace();
	     }
	}
}