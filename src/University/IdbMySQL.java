package University;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public interface IdbMySQL {
	
	public static final Connection myConn = null;
	public static final Statement myStmt = null;
	
	public default void dbConnection()
	{

		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
	
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		
	}

	
	void insertIntoDB();
	void dropFromDB();
	
	


}
